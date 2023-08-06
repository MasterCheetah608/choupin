package events;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class InteractionEventListener extends ListenerAdapter {
    public static String oct = "";
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        super.onButtonInteraction(event);
            switch(event.getButton().getId()){
                case "C":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing C - Fun Fact! This key has no sharps or flats!").setEphemeral(true).queue();
                    break;
                case "C#":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing C#/Db - Fun Fact! C# is both programming language and a note").setEphemeral(true).queue();
                    break;
                case "D":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing D - Fun Fact! Most orchestra instruments start learning in D major").setEphemeral(true).queue();
                    break;
                case "D#":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing D#/Eb - Fun Fact! Torch of Liberty is a famous band piece in Eb Major").setEphemeral(true).queue();
                    break;
                case "E":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing E - Fun Fact! Rush E starts on E").setEphemeral(true).queue();
                    break;
                case "F":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing F - Fun Fact! Autumn, from Vivaldi's four seasons, is in F major").setEphemeral(true).queue();
                    break;
                case "F#":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing F#/Gb - Fun Fact! All Star, written by the band Smash Mouth, is in F# major").setEphemeral(true).queue();
                    break;
                case "G":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing G - Fun Fact! Music is (G)OOD for your mental health").setEphemeral(true).queue();
                    break;
                case "G#":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing G#/Ab - Fun Fact! What happens when you drop a piano on a military base? A flat major!").setEphemeral(true).queue();
                    break;
                case "A":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing A - Fun Fact! A's the highest string for cellos and violas").setEphemeral(true).queue();
                    break;
                case "A#":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing A#/Bb - Fun Fact! Bohemian Rhapsody by Queen is in Bb Major").setEphemeral(true).queue();
                    break;
                case "B":
                    ButtonListener.onButtonClick(event.getButton().getId());
                    event.reply("Now Playing B - Remember to stay positive and B happy!").setEphemeral(true).queue();
                    break;
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
            event.reply("This is an image of a piano keyboard from the Music and Theory website: https://www.musicandtheory.com/wp-content/uploads/2022/01/piano-full-keyboard-SPN-768x113.jpg. The Zeroth Octave only has the A, A#, and B keys, while the Eighth Octave only has the C key. The rest of the octaves have all of the keys.").queue();
        }
    }
}