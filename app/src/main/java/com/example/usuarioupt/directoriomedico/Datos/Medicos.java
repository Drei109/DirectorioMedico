package com.example.usuarioupt.directoriomedico.Datos;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

/**
 * Created by USUARIOUPT on 29-04-2017.
 */

public class Medicos {
    private String id;
    private String name;
    private String speciality;
    private String phoneNumber;
    private String bio;
    private String avatarUri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public Medicos(String id, String name, String speciality, String phoneNumber, String bio, String avatarUri) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.avatarUri = avatarUri;
    }

    public Medicos(String name, String speciality, String phoneNumber, String bio, String avatarUri) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.avatarUri = avatarUri;
    }

    public Medicos(Cursor cursor) {
        id = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicoEntry.ID));
        name = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicoEntry.NAME));
        speciality = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicoEntry.SPECIALTY));
        phoneNumber = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicoEntry.PHONE_NUMBER));
        bio = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicoEntry.BIO));
        avatarUri = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicoEntry.AVATAR_URI));
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(MedicosContract.MedicoEntry.ID,id);
        values.put(MedicosContract.MedicoEntry.NAME,name);
        values.put(MedicosContract.MedicoEntry.SPECIALTY,speciality);
        values.put(MedicosContract.MedicoEntry.PHONE_NUMBER,phoneNumber);
        values.put(MedicosContract.MedicoEntry.BIO,bio);
        values.put(MedicosContract.MedicoEntry.AVATAR_URI,avatarUri);
        return values;
    }

}

