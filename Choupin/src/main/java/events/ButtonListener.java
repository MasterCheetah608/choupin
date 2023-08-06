package events;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ButtonListener extends ListenerAdapter {
    private static String buttonChoice = "";
     static boolean b = false;
    public static void onButtonClick(String s) {
        buttonChoice = s; b = true;
    }

    public static boolean isB() {
        return b;
    }

    public  void getB(boolean b) {
        this.b = b;
    }

    public static String getButtonChoice() {
        return buttonChoice;
    }
}