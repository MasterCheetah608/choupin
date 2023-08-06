package events;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.dv8tion.jda.api.utils.SplitUtil;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;


public class ButtonKeys extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
        if (event.getName().equals("play")) {
            event.reply("Click the letter buttons to play notes and use drop-down menu to SELECT OCTAVE. Click on red buttons for full songs. type /help for tutorial")
                    .addActionRow(
                            Button.primary("C", "C"),
                            Button.success("C#", "C#/Db"),
                            Button.primary("D", "D"),
                            Button.success("D#", "D#/Eb"),
                            Button.primary("E", "E"))
                    .addActionRow(
                            Button.primary("F", "F"),
                            Button.success("F#", "F#/Gb"),
                            Button.primary("G", "G"),
                            Button.success("G#", "G#/Ab"),
                            Button.primary("A", "A"))
                    .addActionRow(
                            Button.success("A#", "A#/Bb"),
                            Button.primary("B", "B"))
                    .setEphemeral(true).queue();
        }
    }
}