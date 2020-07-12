package bot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.JDA;

public class bot extends ListenerAdapter {
    public static void main( String[] args ) throws LoginException {
        String token = "";
        JDA jda = JDABuilder.createDefault(token).build();
        jda.addEventListener(new bot());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("Mensagem recebida de: " + 
            event.getAuthor().getName() + ": " + 
            event.getMessage().getContentDisplay());
        if(event.getMessage().getContentRaw().equals("!ping")) {
            event.getChannel().sendMessage("pong").queue();
        }
    }
}
