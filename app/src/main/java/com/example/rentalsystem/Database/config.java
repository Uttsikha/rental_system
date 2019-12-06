package com.example.rentalsystem.Database;
import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class config extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name("Realm.DEFAULT_REALM_NAME")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}