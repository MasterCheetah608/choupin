import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Choupin {
    public static void main(String[] args) {
        final String TOKEN = "MTEzNDIxNTA5NTU4NTYwNzY4MA.GDxCJN.i7G1SWEOkc8_5tZuzzzY-XMUVb8q99QYxdfpwg";
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);
        JDA jda = jdaBuilder.build();
    }
}
