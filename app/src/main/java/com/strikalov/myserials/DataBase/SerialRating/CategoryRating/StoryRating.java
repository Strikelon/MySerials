package com.strikalov.myserials.DataBase.SerialRating.CategoryRating;

import com.strikalov.myserials.DataBase.SerialRating.CategoryRating.CategoryRating;

public class StoryRating implements CategoryRating {

    private static final String categoryName = "Рейтинг сюжета";
    private Double value;
    private String comment;

    public StoryRating(Double value){
        this.value = value;
        this.comment = "";
    }

    public StoryRating(Double value, String comment){
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
