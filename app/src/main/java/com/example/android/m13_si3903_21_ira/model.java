package com.example.android.m13_si3903_21_ira;

/**
 * Created by Syafirah on 19/04/2018.
 */
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by USER on 19/04/2018.
 */

@IgnoreExtraProperties
public class model {
    String nama, id;

    public model(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public model() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}