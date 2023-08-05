package org.example;

import net.dv8tion.jda.api.audio.AudioSendHandler;

import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
public class NotePlayer implements AudioSendHandler {

    private class StopPlaybackTask extends TimerTask{
        public void run(){
            stopPlayback();
        }
    }
    private final ByteBuffer b;
    boolean p;
    private final Timer timer;

    public NotePlayer(){
        int sampleRate = 44100;
        double frequency = 256;
        double duration = 5.0;
        int numSamples = (int) (duration * sampleRate);
        double[] buffer = new double[numSamples];
        double amplitude = .5;
        double twoPiF = 2.0 * Math.PI * frequency;
        for (int i = 0; i < numSamples; i++) {
            buffer[i] = amplitude * Math.sin(twoPiF * i / sampleRate);
        }


        b = ByteBuffer.allocate(numSamples * 2);
        for (int i = 0; i < numSamples; i++) {
            short sampleValue = (short) (buffer[i] * Short.MAX_VALUE);
            b.putShort(sampleValue);
        }
        b.flip();
        timer = new Timer();
        timer.schedule(new StopPlaybackTask(), (long) (duration * 1000));
        p = true;
    }

    public void stopPlayback() {
        if (p) {
            p = false;
            timer.cancel(); // Stop the timer when audio playback is complete
            b.clear(); // Clear the buffer
        }
    }

    @Override
    public ByteBuffer provide20MsAudio() {
        if (p&&b.hasRemaining()) {
            // Create a new ByteBuffer with remaining audio data to return
            int remainingBytes = b.remaining();
            byte[] remainingData = new byte[remainingBytes];
            b.get(remainingData);
            b.rewind(); // Rewind the buffer to the beginning

            return ByteBuffer.wrap(remainingData);
        } else {
            stopPlayback();
            return null; // Return null to indicate that no more audio data will be provided
        }
    }


    public boolean canProvide(){
        return p;
    }

    @Override
    public boolean isOpus() {
        return false;
    }
}
