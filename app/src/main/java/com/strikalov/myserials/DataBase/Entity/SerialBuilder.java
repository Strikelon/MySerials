package com.strikalov.myserials.DataBase.Entity;

public class SerialBuilder {

    private final Serial serial;

    public SerialBuilder(String name){
        serial = new Serial(name);
    }

    public SerialBuilder section(String section){
        serial.setSection(section);
        return this;
    }

    public SerialBuilder season(Integer season){
        serial.setSeason(season);
        return this;
    }

    public SerialBuilder series(Integer series){
        serial.setSeries(series);
        return this;
    }

    public SerialBuilder link(String link){
        serial.setLink(link);
        return this;
    }

    public SerialBuilder status(String status){
        serial.setStatus(status);
        return this;
    }

    public SerialBuilder note(String note){
        serial.setNote(note);
        return this;
    }

    public SerialBuilder rating(Double rating){
        serial.setRating(rating);
        return this;
    }

    public Serial build(){
        return serial;
    }

}
