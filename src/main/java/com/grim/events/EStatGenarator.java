package com.grim.events;

import com.grim.SteamWeb.SteamWeb;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.awt.*;
import java.util.concurrent.TimeUnit;

public class EStatGenarator extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equals("!stat") && message[1].equals("csgo")){
            String auth = System.getenv("STEAM_API_AUTH_KEY");
            SteamWeb steamWeb = new SteamWeb(auth);
            if (steamWeb.isIDValid(message[2])){
                String id = steamWeb.getID(message[2]);
                System.out.println(id);
                if (message.length == 3){
                    if (steamWeb.isProfileValid(id)){
                        try{
                            EmbedBuilder builder = new EmbedBuilder();
                            builder.setColor(Color.RED);
                            builder.setTitle(steamWeb.getUserName(id) + " Oyuncusunun Verileri");
                            builder.setFooter("This bot developed by Grim UwU!",event.getGuild().getIconUrl());
                            builder.setThumbnail(steamWeb.getProfilePicture(id));
                            builder.setDescription("Bu veriler **Steam API** tarafından çekilmiştir. Verilerin güncellenmesi zaman alabilir. Profiliniz gizli ise veriler  yanluş çıkabilir!");
                            builder.addField("Toplam Öldürme:",steamWeb.getCsgoTotalKills(id),false);
                            builder.addField("Toplam Ölme:",steamWeb.getCsgoTotalDeaths(id),false);
                            builder.addField("Toplam Kazanılan Rauntlar:",steamWeb.getCsgoTotalWins(id),false);
                            builder.addField("Kazanılan EDO'lar:",steamWeb.getCsgoEarnedMvps(id),false);
                            builder.addField("Toplam Maçta Geçirilen Zaman:", (Float.parseFloat(steamWeb.getCsgoTotalTimePlayed(id)) / 3600 + " saat"),false);
                            builder.addField("K/D Oranı:", String.valueOf(steamWeb.getCsgoKillDeathRatio(id)),false);

                            event.getChannel().sendMessage(builder.build()).queue();
                        }catch (Exception e){
                            event.getChannel().sendMessage("<:9626nekocatfacepalm:884835344514678794> Bilinmeyen bir ID girdiniz! ID'nizi kontrol edip tekrar deneyin.").queue(message1 -> {
                                message1.delete().queueAfter(10, TimeUnit.SECONDS);
                            });
                        }
                    }else{
                        event.getChannel().sendMessage("<:9626nekocatfacepalm:884835344514678794> Bilinmeyen bir ID girdiniz! ID'nizi kontrol edip tekrar deneyin.").queue(message1 -> {
                            message1.delete().queueAfter(10, TimeUnit.SECONDS);
                        });
                    }

                }

            }else{

                try{
                    EmbedBuilder builder = new EmbedBuilder();

                    builder.setColor(Color.RED);
                    builder.setTitle(steamWeb.getUserName(message[2]) + " Oyuncusunun Verileri");
                    builder.setFooter("This bot developed by Grim UwU!",event.getGuild().getIconUrl());
                    builder.setThumbnail(steamWeb.getProfilePicture(message[2]));
                    builder.setDescription("Bu veriler Steam API tarafından çekilmiştir. Verilerin güncellenmesi zaman alabilir. Profiliniz gizli ise veriler  yanluş çıkabilir!");
                    builder.addField("Toplam Öldürme:",steamWeb.getCsgoTotalKills(message[2]),false);
                    builder.addField("Toplam Ölme:",steamWeb.getCsgoTotalDeaths(message[2]),false);
                    builder.addField("Toplam Kazanma:",steamWeb.getCsgoTotalWins(message[2]),false);
                    builder.addField("Kazanılan EDO'lar:",steamWeb.getCsgoEarnedMvps(message[2]),false);
                    builder.addField("Toplam Maçta Geçirilen Zaman:", (Float.parseFloat(steamWeb.getCsgoTotalTimePlayed(message[2])) / 3600 + " saat"),false);
                    builder.addField("K/D Oranı:", String.valueOf(steamWeb.getCsgoKillDeathRatio(message[2])),false);

                    event.getChannel().sendMessage(builder.build()).queue();
                }catch (Exception e){
                    event.getChannel().sendMessage("<:9626nekocatfacepalm:884835344514678794> Bilinmeyen bir ID girdiniz! ID'nizi kontrol edip tekrar deneyin.").queue(message1 -> {
                        message1.delete().queueAfter(10, TimeUnit.SECONDS);
                    });
                }

            }
        }
    }

}
