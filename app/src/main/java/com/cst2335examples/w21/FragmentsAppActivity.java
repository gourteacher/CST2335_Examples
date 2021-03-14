package com.cst2335examples.w21;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

public class FragmentsAppActivity extends Activity {
    private static final String FRAG1 = "1";
    private static final String FRAG2 = "2";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_app);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            fragmentTransaction.add(R.id.fragment1, new Fragment1Activity(), FRAG1);
            fragmentTransaction.add(R.id.fragment2, new Fragment2Activity(), FRAG2);
        }
        else {
            if(null!=fragmentManager.findFragmentByTag(FRAG2)) {
                fragmentTransaction.remove(fragmentManager.findFragmentByTag(FRAG2));
            }
            fragmentTransaction.add(R.id.fragment1, new Fragment1Activity(), FRAG1);
        }
        fragmentTransaction.commit();
    }
}
