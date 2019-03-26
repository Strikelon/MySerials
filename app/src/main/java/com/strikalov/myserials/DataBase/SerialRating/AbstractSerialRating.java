package com.strikalov.myserials.DataBase.SerialRating;

import com.strikalov.myserials.DataBase.SerialRating.CategoryRating.CategoryRating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractSerialRating {

    protected List<CategoryRating> categoryRatings = new ArrayList<>();

    public AbstractSerialRating(CategoryRating ... categoryRatingsArray){

        Collections.addAll(this.categoryRatings, categoryRatingsArray);

    }

}
