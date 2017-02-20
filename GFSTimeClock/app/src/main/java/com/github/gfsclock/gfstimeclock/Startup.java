package com.github.gfsclock.gfstimeclock;

/**
 * Created by kentkent on 2/19/17.
 */

import android.app.Application;

import io.realm.Realm;

public class Startup extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
    }
}
