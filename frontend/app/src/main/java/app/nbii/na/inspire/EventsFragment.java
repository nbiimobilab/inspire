package app.nbii.na.inspire;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class EventsFragment extends Fragment {
    private ListView eventsStoryList;
    private String[] strListView = new String[] {"nothing here"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.events_fragment, container, false);

        eventsStoryList = (ListView) rootView.findViewById(android.R.id.list);
        //strListView = getResources().getStringArray(R.array.news_data_list);

        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, strListView);

        eventsStoryList.setAdapter(objAdapter);

        return rootView;
    }
}