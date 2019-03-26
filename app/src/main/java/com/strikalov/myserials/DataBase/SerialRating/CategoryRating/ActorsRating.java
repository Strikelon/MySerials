package com.strikalov.myserials.DataBase.SerialRating.CategoryRating;

import com.strikalov.myserials.DataBase.SerialRating.CategoryRating.CategoryRating;

public class ActorsRating implements CategoryRating {

    private static final String categoryName = "Рейтинг актеров";
    private Double value;
    private String comment;

    public ActorsRating(Double value){
        this.value = value;
        this.comment = "";
    }

    public ActorsRating(Double value, String comment){
        this.value = value;
        this.comment = comment;
    }

    @Override
    public String getName() {
        return categoryName;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String getComment() {
        return comment;
    }
}
