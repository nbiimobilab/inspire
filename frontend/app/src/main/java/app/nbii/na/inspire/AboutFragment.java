package app.nbii.na.inspire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class AboutFragment extends Fragment {

    private TextView info;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View v = (FrameLayout) inflater.inflate(R.layout.fragment_about, container, false);

        info = (TextView) v.findViewById(R.id.infoview);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),ContactUs.class);
                startActivity(i);

            }
        });

        return v;
    }


}
