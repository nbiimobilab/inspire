package app.nbii.na.inspire;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;


public class MainTabActivity extends ActionBarActivity implements
        TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener  {

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, MainTabActivity.TabInfo>();
    private PagerAdapter mPagerAdapter;

    /**
     *
     * @author mwho Maintains extrinsic info of a tab's construct
     */
    private class TabInfo {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;

        TabInfo(String tag, Class<?> clazz, Bundle args) {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }
    }

    /**
     * A simple factory that returns dummy views to the Tabhost
     *
     * @author mwho
     */
    class TabFactory implements TabHost.TabContentFactory {

        private final Context mContext;

        /**
         * @param context
         */
        public TabFactory(Context context) {
            mContext = context;
        }

        /**
         * (non-Javadoc)
         *
         * @see android.widget.TabHost.TabContentFactory#createTabContent(java.lang.String)
         */
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }
    }

    /**
     * (non-Javadoc)
     *
     * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout
        setContentView(R.layout.activity_main_tab);

        // Initialise the TabHost
        this.initialiseTabHost(savedInstanceState);
        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); // set
            // the
            // tab
            // as
            // per
            // the
            // saved
            // state
        }
        // Intialise ViewPager
        this.intialiseViewPager();

        // enable ActionBar app icon to behave as action to toggle nav drawer
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);


    }

    /**
     * (non-Javadoc)
     *
     * @see android.support.v4.app.FragmentActivity#onSaveInstanceState(android.os.Bundle)
     */
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("tab", mTabHost.getCurrentTabTag()); // save the tab
        // selected
        super.onSaveInstanceState(outState);
    }

    /**
     * Initialise ViewPager
     */
    private void intialiseViewPager() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, MarketFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, MLabFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, TechFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, EntrepreneurshipFragment.class.getName()));
        this.mPagerAdapter = new PagerAdapter(
                super.getSupportFragmentManager(), fragments);
        //
        this.mViewPager = (ViewPager) super.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOnPageChangeListener(this);
    }

    /**
     * Initialise the Tab Host
     */
    private void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;
        MainTabActivity.AddTab(this, this.mTabHost,
                this.mTabHost.newTabSpec("Innovation Marketplace").setIndicator("Innovation Marketplace"),
                (tabInfo = new TabInfo("Innovation Marketplace", MarketFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        MainTabActivity.AddTab(this, this.mTabHost,
                this.mTabHost.newTabSpec("M-Lab").setIndicator("M-Lab"),
                (tabInfo = new TabInfo("M-Lab", MLabFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        MainTabActivity.AddTab(this, this.mTabHost,
                this.mTabHost.newTabSpec("Technology Transfer").setIndicator("Technology Transfer"),
                (tabInfo = new TabInfo("Technology Transfer", TechFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        MainTabActivity.AddTab(this, this.mTabHost,
                this.mTabHost.newTabSpec("Entrepreneurship & Incubation").setIndicator("Entrepreneurship & Incubation"),
                (tabInfo = new TabInfo("Entrepreneurship & Incubation", EntrepreneurshipFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        // Default to first tab
        // this.onTabChanged("Tab1");
        //

        //change font loop

        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        TextView myTabText;
        for(int i=0;i<4;i++){
            //change font

            switch(screenSize){
/*              //for normal screens
                case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                    myTabText=(TextView)mTabHost.getTabWidget().getChildTabViewAt(i).findViewById(android.R.id.title);
                    myTabText.setTextSize(10);
                    break;
*/
                case Configuration.SCREENLAYOUT_SIZE_SMALL:
                    myTabText=(TextView)mTabHost.getTabWidget().getChildTabViewAt(i).findViewById(android.R.id.title);
                    myTabText.setTextSize(10);
                    break;
            }
            //end change font

        }//end for loop


        mTabHost.setOnTabChangedListener(this);
    }

    /**
     * Add Tab content to the Tabhost
     * @param activity
     * @param tabHost
     * @param tabSpec
     */
    private static void AddTab(MainTabActivity activity, TabHost tabHost,
                               TabHost.TabSpec tabSpec, TabInfo tabInfo) {
        // Attach a Tab view factory to the spec
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    /**
     * (non-Javadoc)
     *
     * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
     */
    public void onTabChanged(String tag) {
        // TabInfo newTab = this.mapTabInfo.get(tag);
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrolled
     * (int, float, int)
     */
    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * android.support.v4.view.ViewPager.OnPageChangeListener#onPageSelected
     * (int)
     */
    @Override
    public void onPageSelected(int position) {
        // TODO Auto-generated method stub
        this.mTabHost.setCurrentTab(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.global, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new
                    // task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                                    // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;

            case R.id.action_settings:
                break;

            case R.id.action_search:

                break;

            case  R.id.action_share:

                Intent shareIntent =  new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");

                String sharetext= "Wow, the recently launched NBII app for Namibians is great.";

                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, sharetext);
                //start the chooser for sharing
                startActivity(Intent.createChooser(shareIntent,
                        "Choose how you want to share"));

                return true;

            case R.id.action_nbii:

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.fli-namibia.org"));//load the FLI website
                startActivity(intent);

                return  true;

        }
        return super.onOptionsItemSelected(item);
    }

    /*
     * (non-Javadoc)
     *
     * @see android.support.v4.view.ViewPager.OnPageChangeListener#
     * onPageScrollStateChanged(int)
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        // TODO Auto-generated method stub

    }
}
