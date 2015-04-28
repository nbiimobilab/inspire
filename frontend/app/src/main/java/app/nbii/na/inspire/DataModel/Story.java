package app.nbii.na.inspire.DataModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by abrie on 4/27/15.
 */
public class Story {
    public final String title;
    public final String content;
    public final String date_added;

    public static Story fromJSON(JSONObject json) throws JSONException {
        return new Story(
                json.getString("content"),
                json.getString("title"),
                json.getString("date_added"));
    }

    public Story(String content, String title, String date_added) {
        this.content = content;
        this.title = title;
        this.date_added = date_added;
    }
}
