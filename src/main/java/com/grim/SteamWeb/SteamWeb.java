package com.grim.SteamWeb;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SteamWeb {

    /*
    Author's Note:
    This is not an API. This class is a test class. Full form of the project will publish later.
    If you interested in, feel free to join my discord server: https://discord.io/grimthedev
     */

    private String API_KEY;

    /*

    Constructor of the class. Developer needs to provide a SteamAPI key.
    To find steam key, please visit: https://steamcommunity.com/dev/

    */
    public SteamWeb(String API_KEY){
        this.API_KEY = API_KEY;
    }

    /*

    @Author GrimTheDev
    This function gets specified players CS:GO total kills data via sending request to SteamAPI.
    These data are updating almost instantly by Steam.
    After getting data (which formatted of JSON), the function gets "stats" array.
    This array contains lot of stats about player.
    By the request type, array listing may be changed. For-each loop comes handy in that situation.
    After finding the correct JSONObject, lastly function returns the value.

     */
    public String getCsgoTotalKills(String userID){

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            JSONArray arrayList = new JSONArray(formatedString.getJSONArray("stats").toString());

            int kills = 0;

            for (Object o: arrayList) {
                JSONObject object = new JSONObject(o.toString());
                if (object.toMap().containsValue("total_kills")) {
                    kills = Integer.parseInt(object.get("value").toString());
                    break;
                }
            }

            return String.valueOf(kills);


        }catch (Exception e){
            return null;
        }
    }

    /*

    This function gets specified players CS:GO deaths kills data via sending request to SteamAPI.
    These data are updating almost instantly by Steam.

    */
    public String getCsgoTotalDeaths(String userID){

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            JSONArray arrayList = new JSONArray(formatedString.getJSONArray("stats").toString());

            int deaths = 0;

            for (Object o: arrayList) {
                JSONObject object = new JSONObject(o.toString());
                if (object.toMap().containsValue("total_deaths")) {
                    deaths = Integer.parseInt(object.get("value").toString());
                    break;
                }
            }

            return String.valueOf(deaths);


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /*

    This function gets specified players CS:GO wins data via sending request to SteamAPI.
    These data are updating almost instantly by Steam.

    */
    public String getCsgoTotalWins(String userID){

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            JSONArray arrayList = new JSONArray(formatedString.getJSONArray("stats").toString());

            int wins = 0;

            for (Object o: arrayList) {
                JSONObject object = new JSONObject(o.toString());
                if (object.toMap().containsValue("total_wins")) {
                    wins = Integer.parseInt(object.get("value").toString());
                    break;
                }
            }

            return String.valueOf(wins);


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /*

    This function gets specified players game play time data via sending request to SteamAPI.
    These data are updating almost instantly by Steam.

    */
    public String getCsgoTotalTimePlayed(String userID){

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            JSONArray arrayList = new JSONArray(formatedString.getJSONArray("stats").toString());

            int time = 0;

            for (Object o: arrayList) {
                JSONObject object = new JSONObject(o.toString());
                if (object.toMap().containsValue("total_time_played")) {
                    time = Integer.parseInt(object.get("value").toString());
                    break;
                }
            }

            return String.valueOf(time);


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /*

    This function gets specified players CS:GO MVP data via sending request to SteamAPI.
    These data are updating almost instantly by Steam.

    */
    public String getCsgoEarnedMvps(String userID){

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            //0(kill),1(death),2(time played),5(wins)
            JSONArray array = new JSONArray(formatedString.getJSONArray("stats").toString());
            System.out.println(formatedString.getJSONArray("stats").toString());

            JSONArray arrayList = new JSONArray(formatedString.getJSONArray("stats").toString());

            int mvps = 0;

            for (Object o: arrayList) {
                JSONObject object = new JSONObject(o.toString());
                if (object.toMap().containsValue("total_mvps")) {
                    mvps = Integer.parseInt(object.get("value").toString());
                    break;
                }
            }

            return String.valueOf(mvps);


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /*

    This function returns double value of players K/D ratio.

     */
    public double getCsgoKillDeathRatio(String userID){

        double k,d;

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            //0(kill),1(death),2(time played),5(wins)
            JSONArray array = new JSONArray(formatedString.getJSONArray("stats").toString());

            JSONObject kills = new JSONObject(array.get(0).toString());


            k = Integer.parseInt(kills.get("value").toString());


        }catch (Exception e){
            e.printStackTrace();
            k = 1;
        }

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            //0(kill),1(death),2(time played),5(wins)
            JSONArray array = new JSONArray(formatedString.getJSONArray("stats").toString());

            JSONObject kills = new JSONObject(array.get(1).toString());


            d = Integer.parseInt(kills.get("value").toString());


        }catch (Exception e){
            e.printStackTrace();
            d = 1;
        }

        System.out.println(k/d);
        return k/d;
    }

    /*

    Warning!
    This function returns the value of "last_match_mvps".
    As the author, this function not working properly.
    The provided data is not correct. This is not authors fault.
    SteamAPI provides this value.

     */
    public String getLastMatchMvps(String userID){
        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            //0(kill),1(death),2(time played),5(wins)
            JSONArray array = new JSONArray(formatedString.getJSONArray("stats").toString());

            int mvps = 0;


            for(Object object: array){
                JSONObject json = new JSONObject(object.toString());

                if (json.toMap().containsValue("last_match_mvps")){
                    mvps = Integer.parseInt(json.get("value").toString());
                    System.out.println(json);
                    break;
                }
            }

            return String.valueOf(mvps);


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /*

    Warning!
    This function returns the value of "last_match_deaths".
    As the author, this function not working properly.
    The provided data is not correct. This is not authors fault.
    SteamAPI provides this value.

     */
    public String getLastMatchDeaths(String userID){
        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            //0(kill),1(death),2(time played),5(wins)
            JSONArray array = new JSONArray(formatedString.getJSONArray("stats").toString());

            int deaths = 0;


            for(Object object: array){
                JSONObject json = new JSONObject(object.toString());

                if (json.toMap().containsValue("last_match_deaths")){
                    deaths = Integer.parseInt(json.get("value").toString());
                    System.out.println(json);
                    break;
                }
            }


            return String.valueOf(deaths);


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /*

    Warning!
    This function returns the value of "last_match_kills".
    As the author, this function not working properly.
    The provided data is not correct. This is not authors fault.
    SteamAPI provides this value.

     */
    public String getLastMatchKills(String userID){
        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            //0(kill),1(death),2(time played),5(wins)
            JSONArray array = new JSONArray(formatedString.getJSONArray("stats").toString());

            int kills = 0;


            for(Object object: array){
                JSONObject json = new JSONObject(object.toString());

                if (json.toMap().containsValue("last_match_kills")){
                    kills = Integer.parseInt(json.get("value").toString());
                    System.out.println(json);
                    break;
                }
            }


            return String.valueOf(kills);


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /*

    This function decides last matches type.

     */
    public String getLastMatchType(String userID){
        try{
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key="+API_KEY+"&steamid="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("playerstats").toString());

            //0(kill),1(death),2(time played),5(wins)
            JSONArray array = new JSONArray(formatedString.getJSONArray("stats").toString());
            int match_type = 0;


            for(Object object: array){
               JSONObject json = new JSONObject(object.toString());

               if (json.toMap().containsValue("last_match_max_players")){
                   match_type = Integer.parseInt(json.get("value").toString());
                   System.out.println(json);
                   break;
               }
            }

            if (match_type == 4){
                return "Yoldaş";
            }else if (match_type == 10){
                return "Rekabetçi (5V5)";
            }else{
                return "Diğer oyun modları";
            }


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /*

     This function is not working right now. Will be fixed later.

     */
    public String getID(String entry){

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key="+API_KEY+"&vanityurl="+entry);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("response").toString());

            if (formatedString.get("success").toString().equals("1")){
                return formatedString.get("steamid").toString();
            }else{
                return entry;
            }



        }catch (Exception e){
            return e.toString();
        }

    }

    /*

     This function checks form of the ID.
     If provided ID has formatted by the type of steamID64 (Dec), function returns false.
     If provided ID has formatted by the type of steamID, function returns true.
     This function's name will be changed in the next update.

     */
    public boolean isIDValid(String entry){

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key="+API_KEY+"&vanityurl="+entry);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("response").toString());

            if (formatedString.get("success").toString().equals("1")){
                return true;
            }else{
                return false;
            }



        }catch (Exception e){
            return false;
        }

    }

    /*

     This function returns user's profile picture URL.

     */
    public String getProfilePicture(String userID){

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key="+API_KEY+"&steamids="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("response").toString());
            JSONArray array = new JSONArray(formatedString.getJSONArray("players").toString());
            JSONObject object = new JSONObject(array.get(0).toString());

            return object.get("avatarfull").toString();


        }catch (Exception e){
            return e.toString();
        }

    }

    /*

     This function returns user's steam name.

     */
    public String getUserName(String userID){

        try{
            URL url = new URL("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key="+API_KEY+"&steamids="+userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            while ((line = bufferedReader.readLine())!= null){
                response.append(line);
            }

            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject formatedString = new JSONObject (jsonObject.get("response").toString());
            JSONArray array = new JSONArray(formatedString.getJSONArray("players").toString());
            JSONObject object = new JSONObject(array.get(0).toString());

            return object.get("personaname").toString();


        }catch (Exception e){
            return e.toString();
        }

    }

    /*

     This function validates the provided ID.

     */
    public boolean isProfileValid(String userID){
        try {
            URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v2/?appid=730&key=" + API_KEY + "&steamid=" + userID);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            return true;
        }catch (IOException e){
            return false;
        }
    }
}
