package com.strikalov.myserials.DataBase.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Serial {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String section = "";
    private String name;
    private Integer season = 1;
    private Integer series = 1;
    private String link = "";
    private String status = "";
    private String note ="";
    private Double rating = 0.0;

    public Serial(String name){
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Serial{" +
                "id=" + id +
                ", section='" + section + '\'' +
                ", name='" + name + '\'' +
                ", season=" + season +
                ", series=" + series +
                ", link='" + link + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", rating=" + rating +
                '}';
    }
}
