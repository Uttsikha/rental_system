package com.example.rentalsystem.Database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class person extends RealmObject {
    @PrimaryKey
    private int person_id;
    @Required
    private String person_name;

    private int person_contactNumber;

    private int person_citizenshipNumber;

    private int person_familySize;

    private String person_tAddress;

    private String person_joinDate;

    public room person_room;

    public int getPersonId() {
        return person_id;
    }

    public void setPersonId(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return  person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name =  person_name;
    }

    public int getPerson_contactNumber() {
        return person_contactNumber;
    }

    public void setPerson_contactNumber(int person_contactNumber) {
        this.person_contactNumber = person_contactNumber;
    }

    public int getPerson_citizenshipNumber() {
        return person_citizenshipNumber;
    }

    public void setPerson_citizenshipNumber(int person_citizenshipNumber) {
        this.person_citizenshipNumber = person_citizenshipNumber;
    }

    public int getPerson_familySize()
    {
        return person_familySize;
    }

    public void setPerson_familySize(int person_familySize) {
        this.person_familySize = person_familySize;
    }

    public String getPerson_tAddress() {
        return person_tAddress;
    }

    public void setPerson_tAddress(String person_tAddress) {
        this.person_tAddress = person_tAddress;
    }

    public String getPerson_joinDate() {
        return person_joinDate;
    }

    public void setPerson_joinDate(String person_joinDate) {
        this.person_joinDate = person_joinDate;
    }

    public room getPerson_room() {
        return person_room;
    }

    public void setPerson_room(room person_room) {
        this.person_room = person_room;
    }
}
