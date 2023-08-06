package org.example;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import events.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.audio.AudioSendHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Choupin {
    static final Dotenv config= Dotenv.configure().load();


    public static void main(String[] args) {
        JDABuilder jdaBuilder = JDABuilder.createDefault(config.get("TOKEN"));


        JDA jda = null;
        try{
            jda = jdaBuilder
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                    .addEventListeners(new ReadyListener(), new MessageEventListener(), new ButtonListener(), new ButtonKeys(), new InteractionEventListener())
                    .build();

            jda.awaitReady();

            jda.upsertCommand("test", "This is a testing").setGuildOnly(true).queue();

            VoiceChannel vC = jda.getVoiceChannelById("1137129817586802811");

            AudioManager audioManager = vC.getGuild().getAudioManager();
            DefaultAudioPlayerManager playerManager = new DefaultAudioPlayerManager();
            AudioPlayer audioPlayer = playerManager.createPlayer();
            audioManager.openAudioConnection(vC);


            ButtonListener buttonListener = new ButtonListener();AudioSendHandler n = null;
            int count = 0;
            while(count<20000000){
                Thread.sleep(100);
                if(!buttonListener.isB()){count++;}
                else {
                    count = 0;
                    buttonListener.getB(false);
                    if (buttonListener.getButtonChoice().equals("C")) {
                        n = new NotePlayer(83000, 440);
                        audioManager.setSendingHandler(n);

                    } else if (buttonListener.getButtonChoice().equals("C#")) {
                        n = new NotePlayer(78000, 440);
                        audioManager.setSendingHandler(n);
                    }else if (buttonListener.getButtonChoice().equals("D")) {
                        n = new NotePlayer(73000, 440);audioManager.setSendingHandler(n);
                    }else if (buttonListener.getButtonChoice().equals("D#")) {

                        if(InteractionEventListener.oct.equals(3))
                            n = new NotePlayer(155000, 440);
                        else n = new NotePlayer(68000, 440);audioManager.setSendingHandler(n);
                    }else if (buttonListener.getButtonChoice().equals("E")) {
                        n = new NotePlayer(63000, 440);audioManager.setSendingHandler(n);
                    }else if (buttonListener.getButtonChoice().equals("F")) {
                        n = new NotePlayer(61000, 440);audioManager.setSendingHandler(n);
                    }else if (buttonListener.getButtonChoice().equals("F#")) {
                        n = new NotePlayer(59000, 440);audioManager.setSendingHandler(n);
                    }else if (buttonListener.getButtonChoice().equals("G")) {
                        n = new NotePlayer(54000, 440);audioManager.setSendingHandler(n);
                    }else if (buttonListener.getButtonChoice().equals("G#")) {
                        n = new NotePlayer(53000, 440);audioManager.setSendingHandler(n);
                    }else if (buttonListener.getButtonChoice().equals("A")) {
                        n = new NotePlayer(49000, 440);audioManager.setSendingHandler(n);
                    }else if (buttonListener.getButtonChoice().equals("A#")) {
                        n = new NotePlayer(48000, 440);audioManager.setSendingHandler(n);
                    }else {
                        n = new NotePlayer(45000, 440);
                        audioManager.setSendingHandler(n);
                    }
                }
            }



        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    }

