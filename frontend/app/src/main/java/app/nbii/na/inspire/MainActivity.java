package app.nbii.na.inspire;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise ad
        //mAdView = (AdView)findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        //if(connectionStatusCode == ConnectionResult.SUCCESS){

        //}else{
        //Toast.makeText(getApplicationContext(),R.string.google,Toast.LENGTH_SHORT).show();
        // }

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (position == 0) {

            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                    .commit();

        } else if (position == 1) {

            Intent i = new Intent(this,NewsEventsTab.class);
            startActivity(i);

        } else if (position == 2) {

            Intent i = new Intent(this,MainTabActivity.class);
            startActivity(i);

        }else if (position == 5) {

            // Create new fragment and transaction
            Fragment newFragment = new AboutFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(PlaceholderFragment.ARG_SECTION_NUMBER);

            // Commit the transaction
            transaction.commit();

        }else if (position == 6) {

            Intent i = new Intent(this,ContactUs.class);
            startActivity(i);

        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
            case 6:
                mTitle = getString(R.string.title_section6);
                break;
            case 7:
                mTitle = getString(R.string.title_section7);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.global, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_nbii){
            return true;
        }else if(id == R.id.action_share){
            return true;
        }else if(id == R.id.action_search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements OnClickListener {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        ImageView imageView1;
        Button button;
        int tophone;
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }

        public void onActivityCreated(Bundle savedInstanceState) {

            super.onActivityCreated(savedInstanceState);
            // get the button view
            imageView1=(ImageView) getView().findViewById(R.id.imageView1);
            tophone=R.drawable.ic_launcher;
            ImageView imageView2=(ImageView) getView().findViewById(R.id.imageView2);
            ImageView imageView3=(ImageView) getView().findViewById(R.id.imageView3);
            ImageView imageView4=(ImageView) getView().findViewById(R.id.imageView4);
            ImageView imageView5=(ImageView) getView().findViewById(R.id.imageView5);

            //fashionImg = (ImageView) getView().findViewById(R.id.selectone);
            // set a onclick listener for when the button gets clicked

            button=(Button)getView().findViewById(R.id.button);
            imageView2.setOnClickListener(this);
            imageView3.setOnClickListener(this);
            imageView4.setOnClickListener(this);
            imageView5.setOnClickListener(this);
            imageView2.setOnClickListener( this);

            button.setOnClickListener(this);

        }
        @Override
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.imageView2:
                    imageView1.setImageResource(R.drawable.news);
                    ImageView iv = (ImageView) getView().findViewById(R.id.imageView1);
                    tophone=R.drawable.ic_newsevent;

                    // iv.setBackgroundResource(R.drawable.new_arrivals_animation);

                    // AnimationDrawable frameAnimation = (AnimationDrawable) iv.getBackground();
                    // Start the animation (looped playback by default).
                    //frameAnimation.start();
                    iv.setOnClickListener(new OnClickListener() {
                        // Start new list activity
                        public void onClick(View v) {
                            Intent mainIntent = new Intent(getActivity(),NewsEventsTab.class);
                            startActivity(mainIntent);
                        }
                    });
                    break;

                case R.id.imageView3:
                    imageView1.setImageResource(R.drawable.game);
                    tophone=R.drawable.ic_game;
                    ImageView iv1 = (ImageView) getView().findViewById(R.id.imageView1);
                    tophone=R.drawable.ic_newsevent;
                    iv1.setOnClickListener(new OnClickListener() {
                        // Start new list activity
                        public void onClick(View v) {
                            Intent mainIntent = new Intent(getActivity(),NewsEventsTab.class);
                            startActivity(mainIntent);
                        }
                    });
                    break;

                case R.id.imageView4:
                    imageView1.setImageResource(R.drawable.chat);
                    tophone=R.drawable.ic_launcher;
                    ImageView iv2 = (ImageView) getView().findViewById(R.id.imageView1);
                    tophone=R.drawable.ic_newsevent;
                    iv2.setOnClickListener(new OnClickListener() {
                        // Start new list activity
                        public void onClick(View v) {
                            Intent mainIntent = new Intent(getActivity(),NewsEventsTab.class);
                            startActivity(mainIntent);
                        }
                    });
                    break;

                case R.id.imageView5:
                    imageView1.setImageResource(R.drawable.tips);
                    tophone=R.drawable.ic_launcher;
                    ImageView iv3 = (ImageView) getView().findViewById(R.id.imageView1);
                    tophone=R.drawable.ic_newsevent;
                    iv3.setOnClickListener(new OnClickListener() {
                        // Start new list activity
                        public void onClick(View v) {
                            Intent mainIntent = new Intent(getActivity(),NewsEventsTab.class);
                            startActivity(mainIntent);
                        }
                    });
                    break;

                case R.id.button:
                    InputStream a=getResources().openRawResource(tophone);
                    Bitmap whatever= BitmapFactory.decodeStream(a);

                    break;

            }
        }


        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
