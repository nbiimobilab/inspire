package app.nbii.na.inspire.DataModel;

import android.content.Context;
import android.content.res.AssetManager;
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

    public void loadLocalStoryCollection(
            Context context,
            String filename,
            StoryCollectionListener listener) {

        try {
            InputStream stream = context.getAssets().open(filename, AssetManager.ACCESS_BUFFER);
            listener.onStoryCollection(StoryCollection.fromString(inputStreamToString(stream)));
        } catch (IOException e) {
            Log.e(Debug.TAG, "IOException while processing:" + filename);
        }
    }

    public void loadLocalEventCollection(
            Context context,
            String filename,
            EventCollectionListener listener) {

        try {
            InputStream stream = context.getAssets().open(filename, AssetManager.ACCESS_BUFFER);
            listener.onEventCollection(EventCollection.fromString(inputStreamToString(stream)));
        } catch (IOException e) {
            Log.e(Debug.TAG, "IOException while processing:" + filename);
        }
    }

    public void loadEventCollectionAsync(
            final URL url,
            final EventCollectionListener listener) {

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                EventCollection eventCollection = EventCollection.fromURL(url);
                listener.onEventCollection(eventCollection);
                return null;
            }
        };

        asyncTask.execute();
    }

    public void loadStoryCollectionAsync(
            final URL url,
            final StoryCollectionListener listener) {

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                StoryCollection storyCollection = StoryCollection.fromURL(url);
                listener.onStoryCollection(storyCollection);
                return null;
            }
        };

        asyncTask.execute();
    }

    public interface StoryCollectionListener {
        void onStoryCollection(StoryCollection storyCollection);
    }

    public interface EventCollectionListener {
        void onEventCollection(EventCollection eventCollection);
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
