package com.example.rentalsystem.Database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class room extends RealmObject {
    @PrimaryKey
    private int room_id;
    @Required
    private String room_type;

    private int room_rate;
    private String room_status;

    // Standard getters & setters generated by your IDE…
    public int getRoomId() {
        return room_id;
    }

    public void setRoomId(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_type() {
        return  room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type =  room_type;
    }

    public int getRoom_rate() {
        return room_rate;
    }

    public void setRoom_rate(int room_rate) {

        this.room_rate = room_rate;
    }

    public String getRoom_status() {
        return room_status;
    }
    public void setRoom_status(String room_status) {

        this.room_status = room_status;
    }

}
