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

import app.nbii.na.inspire.DataModel.Parser;
import app.nbii.na.inspire.DataModel.StoryCollection;

/**
 * Created by Lameck on 24/03/2015.
 */
public class NewsFragment extends Fragment implements AdapterView.OnItemClickListener {
    private StoryCollection stories = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        stories = Parser.loadAsset(getActivity(), "news_feed.json");

        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(
                this.getActivity(),
                android.R.layout.simple_list_item_1,
                stories.titles());

        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        ListView newsStoryList = (ListView) rootView.findViewById(android.R.id.list);
        newsStoryList.setAdapter(objAdapter);
        newsStoryList.setOnItemClickListener(this);

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getActivity(), Single_News_Story.class);
        i.putExtra(Single_News_Story.CONTENT, stories.get(position).content);
        i.putExtra(Single_News_Story.HEADER, stories.get(position).title);
        i.putExtra(Single_News_Story.CREATE_DATE, stories.get(position).date_added);
        startActivity(i);
    }
}