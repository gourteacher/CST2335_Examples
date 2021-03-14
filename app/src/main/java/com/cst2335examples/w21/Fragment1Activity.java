package com.cst2335examples.w21;

import android.app.Fragment;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.TextView;
import android.content.Intent;
import android.app.FragmentManager;

public class Fragment1Activity extends Fragment {
    protected static final String FRAG2 = "2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context c = getActivity().getApplicationContext();
        View vw = inflater.inflate(R.layout.fragment_1, container, false);

        final String[] items ={"item 1", "item 2", "item 3", "item 4", "item 5"};
        ListView myList = vw.findViewById(R.id.theList);
        ArrayAdapter<String> arrayAdpt= new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1, items);
        myList.setAdapter(arrayAdpt);

        final FragmentManager fragmentManager = getFragmentManager();

        myList.setOnItemClickListener( (parent, v, position, id)  -> {
            if(null!=fragmentManager.findFragmentByTag(FRAG2)){
                TextView selectedOpt = getActivity().findViewById(R.id.selectedopt);
                selectedOpt.setText("You have selected " + ((TextView) v).getText().toString());
            } else {
                Intent intent = new Intent(getActivity().getApplicationContext(), ShowItemActivity.class);
                intent.putExtra("item", ((TextView) v).getText().toString());
                startActivity(intent);
            }
        });
        return vw;
    }

}