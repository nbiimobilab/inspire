package app.nbii.na.inspire.DataModel;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

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
}