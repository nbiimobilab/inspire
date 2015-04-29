package app.nbii.na.inspire.DataModel;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import app.nbii.na.inspire.Debug;

/**
 * Created by abrie on 4/27/15.
 */
public class StoryCollection {
    private final ArrayList<Story> stories = new ArrayList<>();

    public static StoryCollection fromJSON(JSONArray json)  {
        ArrayList<Story> list = new ArrayList<>();
        try {
            for (int i = 0; i < json.length(); i++) {
                list.add(Story.fromJSON(json.getJSONObject(i)));
            }
        } catch(JSONException e) {
            Log.e(Debug.TAG, "Exception while parsing story:" + e);
        }
        return new StoryCollection(list);
    }

    public static StoryCollection fromString(String string) {
        try {
            JSONArray array = new JSONArray(string);
            return fromJSON(array);
        }
        catch(JSONException e) {
            Log.e(Debug.TAG, "Exception parsing JSON array:" + e);
            return StoryCollection.none();
        }
    }

    public static StoryCollection fromURL(URL url) {
        try {
            Log.i(Debug.TAG, "Loading story collection from:" + url.toExternalForm());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            return fromString(Loader.inputStreamToString(conn.getInputStream()));
        }
        catch(IOException e) {
            Log.e(Debug.TAG, "IOException", e);
            return StoryCollection.none();
        }
    }

    public static StoryCollection none() {
        ArrayList<Story> list = new ArrayList<>();
        return new StoryCollection(list);
    }

    public StoryCollection(ArrayList<Story> list) {
        stories.addAll(list);
    }

    public int length() {
        return stories.size();
    }

    public Story get(int index) {
        return stories.get(index);
    }

    public ArrayList<String> titles() {
        ArrayList<String> result = new ArrayList<>();
        for(Story story : stories) {
            result.add(story.title);
        }
        return result;
    }
}