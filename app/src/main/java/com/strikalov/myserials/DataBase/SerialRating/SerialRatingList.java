package com.strikalov.myserials.DataBase.SerialRating;

import com.strikalov.myserials.DataBase.SerialRating.CategoryRating.CategoryRating;

import java.util.ArrayList;
import java.util.List;

public class SerialRatingList extends AbstractSerialRating{

    List<String> ratingList;

    public SerialRatingList(CategoryRating... categoryRatingsArray){
        super(categoryRatingsArray);
        ratingList = new ArrayList<>();
    }

    private String getRatingInformation(CategoryRating categoryRating) {
        return categoryRating.getName() + ": " + categoryRating.getValue() + " Комментарий: " + categoryRating.getComment() + "\n";
    }

    public void refreshRatingList(){
        ratingList.clear();
        for(CategoryRating categoryRating: categoryRatings){
            ratingList.add(getRatingInformation(categoryRating));
        }
    }

    public List<String> getRatingList(){
        return ratingList;
    }

}
