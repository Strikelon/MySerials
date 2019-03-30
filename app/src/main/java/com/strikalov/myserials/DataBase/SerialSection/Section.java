package com.strikalov.myserials.DataBase.SerialSection;

import com.strikalov.myserials.DataBase.SerialSection.SerialIterators.SerialIteratorImpl;
import com.strikalov.myserials.DataBase.SerialSection.SerialIterators.SerialRatingIterator;

public interface Section {

    void setSectionName(String name);
    String getSectionName();
    void setImageId(Integer id);
    Integer getImageId();

    SerialIteratorImpl createSerialIterator();
    SerialRatingIterator createSerialRatingIterator();

}
