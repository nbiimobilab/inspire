package app.nbii.na.inspire.DataModel;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import app.nbii.na.inspire.Debug;

/**
 * Created by abrie on 4/27/15.
 */
public class Parser {
    public static StoryCollection process(String string) {
        try {
            JSONArray array = new JSONArray(string);
            return StoryCollection.fromJSON(array);
        }
        catch(JSONException e) {
            Log.e(Debug.TAG, "Exception parsing JSON array:" + e);
            return StoryCollection.none();
        }
    }

    public static String inputStreamToString(InputStream stream)
            throws IOException {

        StringBuilder responseStrBuilder = new StringBuilder();
        BufferedReader streamReader = new BufferedReader(
                new InputStreamReader(stream, "UTF-8"));
        String inputStr;

        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);

        return responseStrBuilder.toString();
    }

    public static StoryCollection loadAsset(Context context, String filename) {
        try {
            AssetManager assetManager = context.getAssets();
            InputStream stream = assetManager.open(filename, AssetManager.ACCESS_BUFFER);
            return process(inputStreamToString(stream));
        } catch (IOException e) {
            Log.e(Debug.TAG, "IOException while processing:"+filename);
            return StoryCollection.none();
        }
    }
}
