package app.nbii.na.inspire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Aluvilu on 4/12/2015.
 */
public class Single_News_Story extends Activity {
    public static String HEADER = "HEADER";
    public static String CREATE_DATE = "CREATE_DATE";
    public static String CONTENT = "CONTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_news_item);

        Intent intent = getIntent();

        String title = intent.getStringExtra(Single_News_Story.HEADER);
        TextView headerView = (TextView)findViewById(R.id.newsHeader);
        headerView.setText(title);

        String creationDate = intent.getStringExtra(Single_News_Story.CREATE_DATE);
        TextView creationDateView = (TextView)findViewById(R.id.newsCreationDate);
        creationDateView.setText(creationDate);

        String content = intent.getStringExtra(Single_News_Story.CONTENT);
        TextView newsContentView = (TextView)findViewById(R.id.newsContent);
        newsContentView.setText(content);
    }
}
