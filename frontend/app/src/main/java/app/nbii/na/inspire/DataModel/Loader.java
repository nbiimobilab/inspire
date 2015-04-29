package app.nbii.na.inspire.DataModel;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import app.nbii.na.inspire.Debug;
import app.nbii.na.inspire.R;

/**
 * Created by abrie on 4/27/15.
 */
public class Loader {
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

    public static URL buildURL(Context context, int stringResource) {
        try {
            return new URL(context.getString(R.string.active_url) + context.getString(stringResource));
        } catch( MalformedURLException e) {
            Log.e(Debug.TAG, "Bad url:", e);
            return null;
        }
    }

    public void loadEventCollection(
            Context context,
            String filename,
            EventCollection.EventCollectionListener listener) {
        listener.onEventCollection(EventCollection.fromAssetFile(context, filename));
    }

    public void loadEventCollection(URL url, EventCollection.EventCollectionListener listener) {
        EventCollection eventCollection = EventCollection.fromURL(url);
        listener.onEventCollection(eventCollection);
    }

    public void loadEventCollectionAsync(
            final URL url,
            final EventCollection.EventCollectionListener callback) {

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                loadEventCollection(url, callback);
                return null;
            }
        };

        asyncTask.execute();
    }

    public void loadStoryCollection(URL url, StoryCollection.StoryCollectionListener listener) {
        StoryCollection storyCollection = StoryCollection.fromURL(url);
        listener.onStoryCollection(storyCollection);
    }

    public void loadStoryCollection(
            Context context,
            String filename,
            StoryCollection.StoryCollectionListener listener) {
        listener.onStoryCollection(StoryCollection.fromAssetFile(context, filename));
    }

    public void loadStoryCollectionAsync(
            final URL url,
            final StoryCollection.StoryCollectionListener callback) {

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                loadStoryCollection(url, callback);
                return null;
            }
        };

        asyncTask.execute();
    }

    public void Loader(Context context) {
        enableHttpResponseCache(context);
    }

    /*
    This cache code requires Android 4.0+, as described in:
    http://developer.android.com/training/efficient-downloads/redundant_redundant.html
     */
    private void enableHttpResponseCache(Context context) {
        try {
            long httpCacheSize = 1 * 1024 * 1024; // 1 MiB
            File httpCacheDir = new File(context.getCacheDir(), "http");
            Class.forName("android.net.http.HttpResponseCache")
                    .getMethod("install", File.class, long.class)
                    .invoke(null, httpCacheDir, httpCacheSize);
        } catch (Exception httpResponseCacheNotAvailable) {
            Log.d(Debug.TAG, "HTTP response cache is unavailable.");
        }
    }
}
