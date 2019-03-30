package com.strikalov.myserials.DataBase.SerialSection.SerialIterators;

import com.strikalov.myserials.DataBase.Entity.Serial;

import java.util.List;

public class SerialIteratorImpl implements SerialIterator {

    private List<Serial> serials;
    private Integer currentPosition;

    public SerialIteratorImpl(List<Serial> serials){
        this.serials = serials;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < serials.size();
    }

    @Override
    public Serial next() {
        if(hasNext()) {
            Serial serial = serials.get(currentPosition);
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
