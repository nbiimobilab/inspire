package app.nbii.na.inspire;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import app.nbii.na.inspire.DataModel.EventCollection;
import app.nbii.na.inspire.DataModel.Loader;


public class EventsFragment
        extends Fragment
        implements Loader.EventCollectionListener
{
    private EventCollection events;
    private ListView eventsListView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.events_fragment, container, false);

        eventsListView = (ListView) rootView.findViewById(android.R.id.list);

        Loader loader = new Loader();
        loader.asyncLoadRemoteEventCollection(getActivity(), "events_feed.json", this);

        return rootView;
    }

    private void applyEventCollection(EventCollection eventCollection) {
        events = eventCollection;

        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(
                this.getActivity(),
                android.R.layout.simple_list_item_1,
                events.titles());

        eventsListView.setAdapter(objAdapter);
    }

    @Override
    public void onEventCollection(final EventCollection eventCollection) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                applyEventCollection(eventCollection);
            }
        });
    }
}