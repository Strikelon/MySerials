package com.strikalov.myserials.Presenter;

import com.strikalov.myserials.View.AddSerialView;

public interface AddSerialViewPresenter {

    void onViewCreate(AddSerialView addSerialView);
    void onViewDestroy();
    void onClickSaveSerial();

}
