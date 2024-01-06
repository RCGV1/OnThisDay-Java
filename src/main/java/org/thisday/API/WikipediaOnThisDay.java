package org.thisday.API;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;

public class WikipediaOnThisDay {
    public static JSONObject getOnThisDayEvents(int month,int day) throws IOException {
        URL url = new URL("https://byabbe.se/on-this-day/"+month+"/"+day+"/events.json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return new JSONObject(response.toString());


        } else {
            return null;
        }
    }
    public static JSONObject getOnThisDayDeaths(int month,int day) throws IOException {
        URL url = new URL("https://byabbe.se/on-this-day/"+month+"/"+day+"/deaths.json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return new JSONObject(response.toString());


        } else {
            return null;
        }
    }
    public static JSONObject getOnThisDayBirths(int month,int day) throws IOException {
        URL url = new URL("https://byabbe.se/on-this-day/"+month+"/"+day+"/births.json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return new JSONObject(response.toString());


        } else {
            return null;
        }
    }
   public static StringBuilder top3Events(JSONObject apiOutput) throws IOException {
       StringBuilder ouputBuilder = new StringBuilder();
       JSONArray eventsArray = apiOutput.getJSONArray("events");
         for (int i = 0; i < 3; i++) {
              JSONObject event = eventsArray.getJSONObject(i);
              ouputBuilder.append((i+1)+". "+event.getString("year") + " " + event.getString("description") + "\n");
              ouputBuilder.append(" - Learn More at: " + event.getJSONArray("wikipedia").getJSONObject(0).getString("wikipedia") + "\n");
            }
        return ouputBuilder;
   }
    public static StringBuilder top3Deaths(JSONObject apiOutput) throws IOException {
        StringBuilder ouputBuilder = new StringBuilder();
        JSONArray eventsArray = apiOutput.getJSONArray("deaths");
        for (int i = 0; i < 3; i++) {
            JSONObject event = eventsArray.getJSONObject(i);
            ouputBuilder.append((i+1)+". "+event.getString("year") + " " + event.getString("description") + "\n");
            ouputBuilder.append(" - Learn More about them at: " + event.getJSONArray("wikipedia").getJSONObject(0).getString("wikipedia") + "\n");
        }
        return ouputBuilder;
    }
    public static StringBuilder top3Births(JSONObject apiOutput) throws IOException {
        StringBuilder ouputBuilder = new StringBuilder();
        JSONArray eventsArray = apiOutput.getJSONArray("births");
        for (int i = 0; i < 3; i++) {
            JSONObject event = eventsArray.getJSONObject(i);
            ouputBuilder.append((i+1)+". "+event.getString("year") + " " + event.getString("description") + "\n");
            ouputBuilder.append(" - Learn More about them at: " + event.getJSONArray("wikipedia").getJSONObject(0).getString("wikipedia") + "\n");
        }
        return ouputBuilder;
    }

}
