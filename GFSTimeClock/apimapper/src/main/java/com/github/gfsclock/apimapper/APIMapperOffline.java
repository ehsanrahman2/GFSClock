package com.github.gfsclock.apimapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


public class APIMapperOffline {
    private static Realm realm;
    /**
     * Initializes the database
     * @return boolean success
     */
    public static boolean init_db() {
        realmSetup();

        // Query to see if initialize has already happened
        RealmResults<PunchModel> results = realm.where(PunchModel.class).findAll();

        // if we already have punches in the system
        // init already happened/persisted
        if(results.size() > 0) {
            realmSetdown();
            return true;
        }

        // initialize punches with mocked up data
        realm.beginTransaction();
        PunchModel punch1 = realm.createObject(PunchModel.class);
        punch1.setId(29313);
        punch1.setDocket("F1");
        punch1.setTimeStamp(new Date());
        realm.commitTransaction();

        realmSetdown();
        return true;

    }

    public static ArrayList<PunchModel> getPunchesID(int eID) {
        // TODO Fail on invalid id

        realmSetup();

        RealmQuery query = realm.where(PunchModel.class);
        query.equalTo("id", eID);
        RealmResults<PunchModel> results = realm.where(PunchModel.class).equalTo("id", eID).findAll();

        ArrayList<PunchModel> output = new ArrayList<>();
        output.addAll(realm.copyFromRealm(results));
        realmSetdown();
        return output;
    }

    public static void punch(int eID, String docket, Date time) {
        // TODO Fail on Invalid ID not already in DB

        realmSetup();

        realm.beginTransaction();
        PunchModel n = realm.createObject(PunchModel.class);
        n.setId(eID);
        n.setDocket(docket);
        n.setTimeStamp(time);
        realm.commitTransaction();

        realmSetdown();
    }

    private static void realmSetup() {
        realm = Realm.getDefaultInstance();
    };

    private static void realmSetdown() {
        realm.close();
    }
}
