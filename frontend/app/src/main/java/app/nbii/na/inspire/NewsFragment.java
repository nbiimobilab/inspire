package app.nbii.na.inspire;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import app.nbii.na.inspire.DataModel.Parser;
import app.nbii.na.inspire.DataModel.StoryCollection;

/**
 * Created by Lameck on 24/03/2015.
 */
public class NewsFragment extends Fragment {

//    private ProgressDialog progressDialog;
//    // List for the news items
////    List<HashMap<String, String>> newsList;
//
//
//    // Url data resource pointer.
//    private static final String NBII_NEWS_URL = "http://nbiimobilab.com/nbii_android_api/include/nbii_news_feeds.php?a=";
//
//    // JSON array to store matching data items.
//    JSONArray matchingNewsItems = null;
//    ArrayList<HashMap<String, String>> newsList;
//    // All news fields you wish to present in the application from the JSON data.
//    private static final String TAG_SUCCESS = "success";
//
//    private static final String TAG_NEWS_ID = "id";
//    private static final String TAG_NEWS_HEADER = "title";
//    private static final String TAG_NEWS_CONTENT = "content";
//    private static final String TAG_NEWS_EXPIRY_DATE = "expiry";
//    private static final String TAG_NEWS_ALBUM_ID = "album_id";
//    private static final String TAG_NEWS_CREATOR_ID = "user_id";
//    private static final String TAG_NEWS_CREATION_DATE = "date_added";

    // List view
    private ListView newsStoryList;
    // Array adapter.
//    ArrayAdapter<String> adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        // News news list object.
//        newsList = new ArrayList<HashMap<String, String>>();

        StoryCollection stories = Parser.loadAsset((Context) getActivity(), "news_feed.json");
        ArrayList<String> titleList = stories.titles();
        newsStoryList = (ListView) rootView.findViewById(android.R.id.list);
        //strListView = getResources().getStringArray(R.array.news_data_list);

        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(
                this.getActivity(),
                android.R.layout.simple_list_item_1,
                titleList);

        newsStoryList.setAdapter(objAdapter);

//        // detect whether there is internet connectivity
//        // no internet causes the app to crash
//        if (hasInternet() == false) {
//
//            Toast.makeText(
//                    getActivity(),
//                    "No internet connection detected. Please restart app, we are working on smarter ways to reload...PATIENCE",
//                    Toast.LENGTH_SHORT).show();
//            Log.e("Internet", "No / slow internet connection detected");
//            return rootView;
//        }
//
//        try {
//            // Load news items.
//            new LoadNews().execute();
//        }
//        catch (Exception e){
//            Toast.makeText(getActivity(),
//                    "Connectivity problem: " + e.toString(), Toast.LENGTH_LONG)
//                    .show();
//            Log.e("GetContacts()", "Error while executing");
//        }
        return rootView;
    }

//    // Determine whether device has internet capabilities.
//    private boolean hasInternet() {
//
//        ConnectivityManager cm = (ConnectivityManager) getActivity()
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo netInfo = cm.getActiveNetworkInfo();
//        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        // TODO Auto-generated method stub
//        super.onCreate(savedInstanceState);
//
//    }
//
//    // method to detect clicked item
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        try {
//            JSONObject singleNewsStory = matchingNewsItems.getJSONObject(position);
//
//            String newsHeader = singleNewsStory.getString(TAG_NEWS_HEADER);
//            String newsDescription = singleNewsStory.getString(TAG_NEWS_CONTENT);
//            String newsCreationDate = singleNewsStory.getString(TAG_NEWS_CREATION_DATE);
//
//            Intent i = new Intent(getActivity(), Single_News_Story.class);
//            i.putExtra(TAG_NEWS_HEADER, newsCreationDate);
//            i.putExtra(TAG_NEWS_CONTENT, newsDescription);
//            i.putExtra(TAG_NEWS_CREATION_DATE, newsCreationDate);
//            startActivity(i);
//
//        } catch (JSONException e) {
//            Toast.makeText(getActivity(),
//                    "Data Retrieval error: " + e.toString(), Toast.LENGTH_LONG)
//                    .show();
//            Log.e("OnListItemClick", "Cannot retrieve JSON data");
//        }// End try catch block
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        // keep screen rotation at portrait
//        super.onConfigurationChanged(newConfig);
//        getActivity().setRequestedOrientation(
//                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//    }
//
//    // News loader using async task class.
//    private class LoadNews extends AsyncTask<Void, Void, Void>{
//        /**
//         * Before starting background thread, show progress dialog.
//         */
//
//        @Override
//        protected void onPreExecute(){
//            super.onPreExecute();
//            progressDialog = new ProgressDialog(getActivity());
//            progressDialog.setMessage("Loading NBII News...");
//            // progressDialog.setIndeterminate(false);
//            progressDialog.setCancelable(false);
//            progressDialog.show();
//        }
//
//        @TargetApi(Build.VERSION_CODES.KITKAT)
//        @Override
//        protected Void doInBackground(Void... params) {
//            // Building Parameters.
//            // List<NameValuePair> params = new ArrayList<NameValuePair>();
//            // params.add(new BasicNameValuePair("version", "apps"));
//            // Getting JSON string from URL.
//            // JSON Parser initiation.
//            JsonParser jsonParser = new JsonParser();
//            String jsonStr = "";
//
//            try {
//                // array of first day of events i.e. current day
//                jsonStr = jsonParser.makeServiceCall(NBII_NEWS_URL, JsonParser.GET);
//            } catch (Exception e) {
//
//                Toast.makeText(getActivity(),
//                        "Data Retrieval error: " + e.toString(),
//                        Toast.LENGTH_LONG).show();
//                Log.e("First service call", "Service call error");
//            }
//
//            // Check log cat.
//            Log.d("NEWS JSON: ", "> " + jsonStr);
//            try{
////                matchingNewsItems = new JSONArray(json);
//                // Check if any news items in the JSON data are matching.
//                if(jsonStr !=  null){
//                    // Loop through all the JSON data returned.
//                    for (int i = 0; i < matchingNewsItems.length(); i ++){
//                        JSONObject news = matchingNewsItems.getJSONObject(i);
//                        // Store each JSON item values in variable.
//                        String news_id = news.getString(TAG_NEWS_ID);
//                        String news_header = news.getString(TAG_NEWS_HEADER);
//                        String news_content = news.getString(TAG_NEWS_CONTENT);
//                        String news_expiry_date = news.getString(TAG_NEWS_EXPIRY_DATE);
//                        String album_id = news.getString(TAG_NEWS_ALBUM_ID);
//                        String creator_id = news.getString(TAG_NEWS_CREATOR_ID);
//                        String creation_date = news.getString(TAG_NEWS_CREATION_DATE);
//
//                        // Create a new HashMap.
//                        HashMap<String, String> map = new HashMap<String, String>();
//                        // Add each child node to a HashMap key => value.
//                        map.put(TAG_NEWS_ID, news_id);
//                        map.put(TAG_NEWS_HEADER, news_header);
//                        map.put(TAG_NEWS_CONTENT, news_content);
//                        map.put(TAG_NEWS_EXPIRY_DATE, news_expiry_date);
//                        map.put(TAG_NEWS_ALBUM_ID, album_id);
//                        map.put(TAG_NEWS_CREATOR_ID, creator_id);
//                        map.put(TAG_NEWS_CREATION_DATE, creation_date);
//
//                        // Add the HashList to an ArrayList
//                        newsList.add(map);
//                    }
//                }
//                else {
////                    Log.d("News: ", "null");
//                    Log.e("News: ", "Couldn't get any data from the url");
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//       @Override
//        protected void onPostExecute(Void results){
//           super.onPostExecute(results);
//           // Dismiss the dialog after getting all the news records.
//           if(progressDialog.isShowing()){
//               progressDialog.dismiss();
//           }
//            // Updating UI from background thread, parsed data into json
//           try{
//               /**
//                * Updating parsed JSON data into ListView.
//                */
//               ListAdapter adapter = new SimpleAdapter(
//                       getActivity().getBaseContext(), newsList,
//                       R.layout.list_item_news, new String[] { TAG_NEWS_HEADER, TAG_NEWS_CREATION_DATE },
//                       new int[] { R.id.newsHeader, R.id.newsCreationDateId });
////               setListAdapter(adapter);
//           }
//           catch(Exception e){
//               Log.e("onPostExecute()", "Error setting news list adapter");
//               Toast.makeText(getActivity(),
//                       "ListAdapter Error: " + e.toString(), Toast.LENGTH_LONG)
//                       .show();
//           }
//                            // Set the data adapter.
////                            setListAdapter(adapter);
//        }
//
////        private void runOnUiThread (Runnable runnable){
////            // TODO Auto-generated method stub
////        }
//    }
}
