package org.example;
import events.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
public class Choupin {
    static final Dotenv config= Dotenv.configure().load();
    public Dotenv getConfig(){
        return config;
    }

    public static void main(String args[]) {
        JDABuilder jdaBuilder = JDABuilder.createDefault(config.get("TOKEN"));
        JDA jda = jdaBuilder
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new Ready())
                .build();
    }

}
