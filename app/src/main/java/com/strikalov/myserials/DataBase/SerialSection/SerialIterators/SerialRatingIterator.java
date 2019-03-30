package com.strikalov.myserials.DataBase.SerialSection.SerialIterators;

import com.strikalov.myserials.DataBase.Entity.Serial;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SerialRatingIterator implements SerialIterator {

    private List<Serial> serialsSortByRating;
    private Integer currentPosition;

    public SerialRatingIterator(List<Serial> serials){

        Collections.sort(serials, new Comparator<Serial>() {
            @Override
            public int compare(Serial o1, Serial o2) {
                return Double.compare(o1.getRating(), o2.getRating());
            }
        });

        serialsSortByRating = serials;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < serialsSortByRating.size();
    }

    @Override
    public Serial next() {
        if(hasNext()) {
            Serial serial = serialsSortByRating.get(currentPosition);
            currentPosition++;
            return serial;
        }else {
            throw new IndexOutOfBoundsException("Элементы в списке закончились");
        }
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
