package com.cst2335examples.w21;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ContactListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private ContactAdapter mAdapter;

    ArrayList<String> source = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four"));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.contact_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //updateUI();

        ArrayAdapter<String> theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, source);
        theList.setAdapter(theAdapter);
        return view;
    }

    private void updateUI() {
        Cookbook crimeLab = Cookbook.get(getActivity());
        List<Contact> crimes = crimeLab.getContacts();

        mAdapter = new ContactAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    private class ContactHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private Contact mCrime;

        public ContactHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_contact, parent, false));

            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
        }

        public void bind(Contact crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate().toString());
        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {

        private List<Contact> mCrimes;

        public ContactAdapter(List<Contact> crimes) {
            mCrimes = crimes;
        }

        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new ContactHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ContactHolder holder, int position) {
            Contact crime = mCrimes.get(position);
            holder.bind(crime);

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}
