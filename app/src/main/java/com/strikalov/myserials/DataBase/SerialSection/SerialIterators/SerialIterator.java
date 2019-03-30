package com.strikalov.myserials.DataBase.SerialSection.SerialIterators;

import com.strikalov.myserials.DataBase.Entity.Serial;

public interface SerialIterator {

    boolean hasNext();
    Serial next();
    void reset();

}
