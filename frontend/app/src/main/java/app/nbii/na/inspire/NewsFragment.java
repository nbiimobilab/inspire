package app.nbii.na.inspire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.URL;

import app.nbii.na.inspire.DataModel.Loader;
import app.nbii.na.inspire.DataModel.StoryCollection;

/**
 * Created by Lameck on 24/03/2015.
 */
public class NewsFragment
        extends Fragment
        implements AdapterView.OnItemClickListener, StoryCollection.StoryCollectionListener {

    private StoryCollection stories = null;
    private ListView storyListView = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        storyListView = (ListView) rootView.findViewById(android.R.id.list);

        Loader loader = new Loader();
        URL url = Loader.buildURL(getActivity(), R.string.active_news_feed);
        loader.loadStoryCollectionAsync(url, this);

        return rootView;
    }

    private void applyStoryCollection(StoryCollection storyCollection) {
        stories = storyCollection;

        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(
                this.getActivity(),
                android.R.layout.simple_list_item_1,
                stories.titles());

        storyListView.setAdapter(objAdapter);
        storyListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getActivity(), Single_News_Story.class);
        i.putExtra(Single_News_Story.CONTENT, stories.get(position).content);
        i.putExtra(Single_News_Story.HEADER, stories.get(position).title);
        i.putExtra(Single_News_Story.CREATE_DATE, stories.get(position).date_added);
        startActivity(i);
    }

    @Override
    public void onStoryCollection(final StoryCollection storyCollection) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                applyStoryCollection(storyCollection);
            }
        });
    }
}