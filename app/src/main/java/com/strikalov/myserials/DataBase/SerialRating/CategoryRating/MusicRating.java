package com.strikalov.myserials.DataBase.SerialRating.CategoryRating;

import com.strikalov.myserials.DataBase.SerialRating.CategoryRating.CategoryRating;

public class MusicRating implements CategoryRating {

    private static final String categoryName = "Рейтинг музыки";
    private Double value;
    private String comment;

    public MusicRating(Double value){
        this.value = value;
        this.comment = "";
    }

    public MusicRating(Double value, String comment){
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
