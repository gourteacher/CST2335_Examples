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


public class Fragment1Activity extends Fragment {

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context c = getActivity().getApplicationContext();

        View vw = inflater.inflate(R.layout.fragment_1, container, false);

        final String[] items ={"item 1", "item 2", "item 3", "item 4", "item 5"};

        ListView fruitsList = (ListView) vw.findViewById(R.id.theList);

        ArrayAdapter<String> arrayAdpt= new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1, items);

        fruitsList.setAdapter(arrayAdpt);

        fruitsList.setOnItemClickListener( (parent, v, position, id)  ->{

            TextView selectedOpt = getActivity().findViewById(R.id.selectedopt);

            selectedOpt.setText("You have selected "+((TextView) v).getText().toString());
        });

        return vw;

    }

}