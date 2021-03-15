package com.cst2335examples.w21;


import androidx.fragment.app.Fragment;


public class ContactActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ContactFragment();
    }
}