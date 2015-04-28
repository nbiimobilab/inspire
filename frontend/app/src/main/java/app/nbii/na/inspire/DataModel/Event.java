package app.nbii.na.inspire.DataModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by abrie on 4/28/15.
 */
public class Event {
    public final String name;
    public final String e_date;
    public final String descr;

    public static Event fromJSON(JSONObject json) throws JSONException {
        return new Event(
                json.getString("name"),
                json.getString("e_date"),
                json.getString("descr"));
    }

    public Event(String name, String e_date, String descr) {
        this.name = name;
        this.e_date = e_date;
        this.descr = descr;
    }
}
