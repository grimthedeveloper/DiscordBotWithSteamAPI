package com.grim.events;

import com.grim.SteamWeb.SteamWeb;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ELastGameGenerator extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equals("!stat") && message[1].equals("son_maç")){
            String auth = System.getenv("STEAM_API_AUTH_KEY");
            SteamWeb steamWeb = new SteamWeb(auth);
            if (steamWeb.isIDValid(message[2])){
                String id = steamWeb.getID(message[2]);
                System.out.println(id);
                if (message.length == 3){
                    try{
                        EmbedBuilder builder = new EmbedBuilder();

                        builder.setColor(Color.YELLOW);
                        builder.setTitle(steamWeb.getUserName(id) + " Oyuncusunun Son Maç Verileri");
                        builder.setFooter("This bot developed by Grim UwU!",event.getGuild().getIconUrl());
                        builder.setThumbnail(steamWeb.getProfilePicture(id));
                        builder.setDescription("Bu veriler **Steam API** tarafından çekilmiştir. Verilerin güncellenmesi zaman alabilir. Profiliniz gizli ise veriler  yanluş çıkabilir!");
                        builder.addField("Son Maçtaki Toplam Öldürme:",steamWeb.getLastMatchKills(id),false);
                        builder.addField("Son Maçtaki Toplam Ölme:",steamWeb.getLastMatchDeaths(id),false);
                        builder.addField("Kazanılan EDO'lar:",steamWeb.getLastMatchMvps(id),false);
                        builder.addField("Son Maç Türü:", steamWeb.getLastMatchType(id),false);
                        builder.addField("K/D Oranı:", (Float.parseFloat(steamWeb.getLastMatchKills(id)) / Float.parseFloat(steamWeb.getLastMatchDeaths(id)) + ""),false);

                        event.getChannel().sendMessage(builder.build()).queue();
                    }catch (Exception e){
                        event.getChannel().sendMessage("<:9626nekocatfacepalm:884835344514678794> Bilinmeyen bir ID girdiniz! ID'nizi kontrol edip tekrar deneyin.").queue(message1 -> {
                            message1.delete().queueAfter(10, TimeUnit.SECONDS);
                        });
                    }
                }else{
                    //Do nothing or throw error
                }
            }else {

                try {
                    EmbedBuilder builder = new EmbedBuilder();

                    builder.setColor(Color.YELLOW);
                    builder.setTitle(steamWeb.getUserName(message[2]) + " Oyuncusunun Son Maç Verileri");
                    builder.setFooter("This bot developed by Grim UwU!", event.getGuild().getIconUrl());
                    builder.setThumbnail(steamWeb.getProfilePicture(message[2]));
                    builder.setDescription("Bu veriler **Steam API** tarafından çekilmiştir. Verilerin güncellenmesi zaman alabilir. Profiliniz gizli ise veriler  yanluş çıkabilir!");
                    builder.addField("Son Maçtaki Toplam Öldürme:", steamWeb.getLastMatchKills(message[2]), false);
                    builder.addField("Son Maçtaki Toplam Ölme:", steamWeb.getLastMatchDeaths(message[2]), false);
                    builder.addField("Kazanılan EDO'lar:", steamWeb.getLastMatchMvps(message[2]), false);
                    builder.addField("Son Maç Türü:", steamWeb.getLastMatchType(message[2]), false);
                    builder.addField("K/D Oranı:", (Float.parseFloat(steamWeb.getLastMatchKills(message[2])) / Float.parseFloat(steamWeb.getLastMatchDeaths(message[2])) + ""), false);

                    event.getChannel().sendMessage(builder.build()).queue();
                } catch (Exception e) {
                    event.getChannel().sendMessage("<:9626nekocatfacepalm:884835344514678794> Bilinmeyen bir ID girdiniz! ID'nizi kontrol edip tekrar deneyin.").queue(message1 -> {
                        message1.delete().queueAfter(10, TimeUnit.SECONDS);
                    });
                }
            }
        }
    }
}
