package com.cst2335examples.w21;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cookbook {

    private static Cookbook sContactLab;
    private List<Contact> mContacts;

    public static Cookbook get(Context context) {
        if (sContactLab == null) {
            sContactLab = new Cookbook(context);
        }
        return sContactLab;
    }


    private Cookbook(Context context) {
        mContacts = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Contact crime = new Contact();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Every other one
            mContacts.add(crime);
        }
    }

    public List<Contact> getContacts() {
        return mContacts;
    }

    public Contact getContact(UUID id) {
        for (Contact Contact : mContacts) {
            if (Contact.getId().equals(id)) {
                return Contact;
            }
        }

        return null;
    }
}
