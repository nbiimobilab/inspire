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
import java.net.HttpURLConnection;
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

    private StoryCollection loadRemoteStoryCollection( String filename) {
        try {
            URL url = new URL(R.string.news_server+"/"+filename);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            return StoryCollection.fromString(inputStreamToString(conn.getInputStream()));
        }
        catch(MalformedURLException e) {
            Log.e(Debug.TAG, "Malformed URL:", e);
            return StoryCollection.none();
        }
        catch(IOException e) {
            Log.e(Debug.TAG, "IOException", e);
            return StoryCollection.none();
        }
    }

    public void asyncLoadRemoteStoryCollection(
            final Context context,
            final String filename,
            final StoryCollectionListener listener) {

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                StoryCollection storyCollection = loadRemoteStoryCollection(filename);
                listener.onStoryCollection(storyCollection);
                return null;
            }
        };

        asyncTask.execute();
    }

    public interface StoryCollectionListener {
        void onStoryCollection(StoryCollection storyCollection);
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
