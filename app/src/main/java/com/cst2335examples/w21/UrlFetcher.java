package com.cst2335examples.w21;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlFetcher {

    private final static String TAG = "UrlFetcher";

    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() +
                        ": with " +
                        urlSpec);
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        }
        catch(MalformedURLException mfe){
            Log.i(TAG, "Malformed URL exception");
        }
        catch(IOException ioe) {
            Log.i(TAG, "IO Exception." + ioe.getMessage());
        }
        finally {
            connection.disconnect();
        }
        return null;
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }


    public String fetchItems(String url, String cur) {

        String res = null;

        try {

            String jsonString = getUrlString(url);
            Log.i(TAG, "Received JSON: " + jsonString);

            JSONObject jsonBody = new JSONObject(jsonString);
            JSONObject ratesJsonObject = jsonBody.getJSONObject("rates");
            res = ratesJsonObject.getString(cur);

        } catch (JSONException je){
            res = "Failed to parse JSON";

        } catch (IOException e) {
            res = "Failed to fetch items";
        }
        return res;
    }

}