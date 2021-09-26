package com.grim.bot;

import com.grim.events.EStatGenarator;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        String token = System.getenv("DISCORD_BOT_TOKEN");
        JDA jda = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES).build();
        jda.addEventListener(new EStatGenarator());
        //jda.addEventListener(new ELastGameGenerator());
        //Disabled since SteamAPı doesn't provide right values.
    }


}
