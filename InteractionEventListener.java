package events;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class InteractionEventListener extends ListenerAdapter {
   String oct;
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        super.onButtonInteraction(event);
        switch(event.getButton().getId()){
            case "Chopin":
                event.reply("Now Playing music by Chopin").setEphemeral(true).queue();
                break;
            case "Jazz":
                event.reply("Now Playing Jazz").setEphemeral(true).queue();
                break;
            case "Schubert":
                event.reply("Now Playing music by Schubert").setEphemeral(true).queue();
                break;
            case "Soothe":
                event.reply("Now Playing Soothe Music").setEphemeral(true).queue();
                break;
        }
        if (oct.equals("Zero")) {
            if(!event.getButton().getId().equals("A")&& !event.getButton().getId().equals("A#")&&!event.getButton().getId().equals("B")){
                event.reply("Invalid input for this octave").setEphemeral(true).queue();
            }
            if (event.getButton().getId().equals("A")) {
                event.reply("Now Playing A").setEphemeral(true).queue();
            }

            if (event.getButton().getId().equals("A#")) {
                event.reply("Now Playing A#/Bb").setEphemeral(true).queue();
            }

            if (event.getButton().getId().equals("B")) {
                event.reply("Now Playing B").setEphemeral(true).queue();
            }
        }

        else if (oct.equals("Eight")) {
            if(!event.getButton().getId().equals("C")){
                event.reply("Invalid input for this octave").setEphemeral(true).queue();
            }else {
                event.reply("Now Playing C").setEphemeral(true).queue();
            }
        }

        else {
            switch(event.getButton().getId()){
                case "C":
                    event.reply("Now Playing C").setEphemeral(true).queue();
                    break;
                case "C#":
                    event.reply("Now Playing C#/Db").setEphemeral(true).queue();
                    break;
                case "D":
                    event.reply("Now Playing D").setEphemeral(true).queue();
                    break;
                case "D#":
                    event.reply("Now Playing D#/Eb").setEphemeral(true).queue();
                    break;
                case "E":
                    event.reply("Now Playing E").setEphemeral(true).queue();
                    break;
                case "F":
                    event.reply("Now Playing F").setEphemeral(true).queue();
                    break;
                case "F#":
                    event.reply("Now Playing F#/Gb").setEphemeral(true).queue();
                    break;
                case "G":
                    event.reply("Now Playing G").setEphemeral(true).queue();
                    break;
                case "G#":
                    event.reply("Now Playing G#/Ab").setEphemeral(true).queue();
                    break;
                case "A":
                    event.reply("Now Playing A").setEphemeral(true).queue();
                    break;
                case "A#":
                    event.reply("Now Playing A#/Bb").setEphemeral(true).queue();
                    break;
                case "B":
                    event.reply("Now Playing B").setEphemeral(true).queue();
                    break;
            }
        }

    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        super.onStringSelectInteraction(event);
        if(event.getComponentId().equals("Choose octave")){
            event.reply("You chose octave: "+event.getValues().get(0)).setEphemeral(true).queue();
        }
        oct = event.getValues().get(0);
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
        if(event.getName().equals("help")){
            event.reply("This is an image of a piano keyboard from the Music and Theory website: https://www.musicandtheory.com/wp-content/uploads/2022/01/piano-full-keyboard-SPN-768x113.jpgit. The Zeroth Octave only has the A, A#, and B keys, while the Eighth Octave only has the C key. The rest of the octaves have all of the keys.").queue();
        }
    }
}
