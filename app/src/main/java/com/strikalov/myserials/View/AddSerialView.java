package com.strikalov.myserials.View;

public interface AddSerialView {

    String getSerialName();
    String getSerialSection();
    String getSerialSeason();
    String getSerialSeries();
    String getSerialLink();
    String getSerialStatus();
    String getSerialNote();
    String getSerialRating();
    void showToast(ToastMessage toastMessage);
    void clearEditTextFields();

    enum ToastMessage{
        SERIAL_NAME_IS_EMPTY,
        SERIAL_SEASON_IS_NOT_DIGIT,
        SERIAL_SERIES_IS_NOT_DIGIT,
        SERIAL_RATING_IS_NOT_DIGIT,
        SERIAL_SUCCESSFULLY_SAVED
    }

}
