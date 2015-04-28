package app.nbii.na.inspire.DataModel;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import app.nbii.na.inspire.Debug;

/**
 * Created by abrie on 4/27/15.
 */
public class EventCollection {
    private final ArrayList<Event> events = new ArrayList<>();

    public static EventCollection fromJSON(JSONArray json)  {
        ArrayList<Event> list = new ArrayList<>();
        try {
            for (int i = 0; i < json.length(); i++) {
                list.add(Event.fromJSON(json.getJSONObject(i)));
            }
        } catch(JSONException e) {
            Log.e(Debug.TAG, "Exception while parsing event:" + e);
        }
        return new EventCollection(list);
    }

    public static EventCollection fromString(String string) {
        try {
            JSONArray array = new JSONArray(string);
            return fromJSON(array);
        }
        catch(JSONException e) {
            Log.e(Debug.TAG, "Exception parsing JSON array:" + e);
            return EventCollection.none();
        }
    }

    public static EventCollection none() {
        ArrayList<Event> list = new ArrayList<>();
        return new EventCollection(list);
    }

    public EventCollection(ArrayList<Event> list) {
        events.addAll(list);
    }

    public int length() {
        return events.size();
    }

    public Event get(int index) {
        return events.get(index);
    }

    public ArrayList<String> titles() {
        ArrayList<String> result = new ArrayList<>();
        for(Event event : events) {
            result.add(event.name);
        }
        return result;
    }
}