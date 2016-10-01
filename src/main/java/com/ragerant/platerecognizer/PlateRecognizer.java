package com.ragerant.platerecognizer;
/**
 * Created by ferrerluis on 10/1/16.
 */
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class PlateRecognizer {
    private static String alprUrl = "https://api.openalpr.com/v1/recognize?tasks=plate&country=us&secret_key=sk_cb754bf37e493856189ecd1f";

    public static String recognize(File img) {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.post(alprUrl)
                    .queryString("tasks", "plate")
                    .queryString("country", "us")
                    .queryString("secret_key", "sk_cb754bf37e493856189ecd1f")
                    .field("image", img)
                    .asJson();
            return jsonToString(jsonResponse);
        } catch (UnirestException e) {
            return null;
        }
    }

    private static String jsonToString(HttpResponse<?> jsonResponse) {
        JSONObject jsonObj = new JSONObject(jsonResponse.getBody());
        try {
            String plate = jsonObj
                    .getJSONArray("array").getJSONObject(0) // Gets first item in array, which is the data (because Java is dumb)
                    .getJSONObject("plate") // Gets plate info
                    .getJSONArray("results").getJSONObject(0) // First result
                    .getString("plate"); // Plate number of first result
            return plate;
        } catch (JSONException e) {
            return null;
        }
    }
}
