package com.cst2335examples.w21;

import androidx.fragment.app.Fragment;

public class ContactListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new ContactListFragment();
    }
}
