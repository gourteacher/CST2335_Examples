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

    public String xxx(String urlSpec) throws IOException {

        String result = null;
        try {

            // Connect to the server:
            URL url = new URL(urlSpec);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inStream = urlConnection.getInputStream();

            //Set up the JSON object parser:
            // json is UTF-8 by default
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            result = sb.toString();
        }

        catch(IOException ioe)
        {
            result = "IO Exception. Is the Wifi connected?";
        }
        //What is returned here will be passed as a parameter to onPostExecute:
        return result;

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