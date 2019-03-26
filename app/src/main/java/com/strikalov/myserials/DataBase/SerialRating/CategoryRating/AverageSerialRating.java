package com.strikalov.myserials.DataBase.SerialRating.CategoryRating;

import com.strikalov.myserials.DataBase.SerialRating.AbstractSerialRating;

public class AverageSerialRating extends AbstractSerialRating {

    public AverageSerialRating(CategoryRating... categoryRatingsArray){
        super(categoryRatingsArray);
    }

    public Double AverageSerialRatingValue(){

        Double avg = 0.0;

        for(CategoryRating categoryRating : categoryRatings){
            avg += categoryRating.getValue();
        }

        avg /= categoryRatings.size();

        return avg;
    }

}
