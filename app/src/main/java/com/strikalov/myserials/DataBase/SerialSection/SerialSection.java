package com.strikalov.myserials.DataBase.SerialSection;

import com.strikalov.myserials.DataBase.Entity.Serial;
import com.strikalov.myserials.DataBase.SerialSection.SerialIterators.SerialIteratorImpl;
import com.strikalov.myserials.DataBase.SerialSection.SerialIterators.SerialRatingIterator;

import java.util.List;

public class SerialSection implements Section {

    private String sectionName;
    private Integer imageId;
    private List<Serial> serials;

    public SerialSection(String sectionName, Integer imageId, List<Serial> serials){
        this.sectionName = sectionName;
        this.imageId = imageId;
        this.serials = serials;
    }

    @Override
    public void setSectionName(String name) {
        this.sectionName = name;
    }

    @Override
    public String getSectionName() {
        return sectionName;
    }

    @Override
    public void setImageId(Integer id) {
        imageId = id;
    }

    @Override
    public Integer getImageId() {
        return imageId;
    }

    @Override
    public SerialIteratorImpl createSerialIterator() {
        return new SerialIteratorImpl(serials);
    }

    @Override
    public SerialRatingIterator createSerialRatingIterator() {
        return new SerialRatingIterator(serials);
    }
}
