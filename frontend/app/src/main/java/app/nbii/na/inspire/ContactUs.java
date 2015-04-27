package app.nbii.na.inspire;


import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUs extends ActionBarActivity {

    private TextView maplink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus_fragment);

        maplink = (TextView)findViewById(R.id.loctext);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText message = (EditText) findViewById(R.id.message);

        Button send = (Button) findViewById(R.id.SendButton);

        send.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //TODO Auto-generated method stub

                if  ((name.length()== 0) ||  (email.length()==0) ||(message.length() ==0)) {
                    //display message if text field is empty
                    Toast.makeText(getBaseContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                } else {

                    Intent send = new Intent(Intent.ACTION_SEND);

                    send.setType("plain/text");
                    send.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"loveemilysweet@gmail.com"});
                    send.putExtra(android.content.Intent.EXTRA_TEXT, "name:" + name.getText().toString() + "email:" + email.getText().toString() + "message:" + message.getText().toString());

                    startActivity(Intent.createChooser(send, "Send"));
                }
            }
        });


        maplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),ContactUsActivity.class);
                startActivity(i);

            }
        });

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
}

