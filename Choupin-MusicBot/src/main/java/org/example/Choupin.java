package org.example;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import events.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.audio.AudioSendHandler;
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
                .addEventListeners(new ReadyListener(), new MessageEventListener(), new InteractionEventListener())
                .build();

        jda.awaitReady();

        jda.upsertCommand("test", "This is a testing").setGuildOnly(true).queue();

        VoiceChannel vC = jda.getVoiceChannelById("1137129817586802811");


        AudioManager audioManager = vC.getGuild().getAudioManager();
        System.out.println(3);
        DefaultAudioPlayerManager playerManager = new DefaultAudioPlayerManager();

        AudioPlayer audioPlayer = playerManager.createPlayer();
        AudioSendHandler n = new NotePlayer();
        audioManager.setSendingHandler(n);
        audioManager.openAudioConnection(vC);
        boolean isC = audioManager.isConnected();
        System.out.println(isC);}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
