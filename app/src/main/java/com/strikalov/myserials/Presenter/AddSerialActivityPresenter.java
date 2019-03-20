package com.strikalov.myserials.Presenter;

import android.text.TextUtils;
import android.util.Log;

import com.strikalov.myserials.View.AddSerialView;
import com.strikalov.myserials.DataBase.Entity.Serial;
import com.strikalov.myserials.DataBase.Entity.SerialBuilder;
import com.strikalov.myserials.Model.Model;

import java.util.List;

import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableMaybeObserver;

public class AddSerialActivityPresenter implements AddSerialViewPresenter {

    private Model model;
    private AddSerialView addSerialView;

    public AddSerialActivityPresenter(Model model){
        this.model = model;
    }

    @Override
    public void onViewCreate(AddSerialView addSerialView) {
        this.addSerialView = addSerialView;
    }

    @Override
    public void onViewDestroy() {
        if(addSerialView != null){
            addSerialView = null;
        }
    }

    @Override
    public void onClickSaveSerial() {

        String serialName = addSerialView.getSerialName();

        if(TextUtils.isEmpty(serialName)){

            addSerialView.showToast(AddSerialView.ToastMessage.SERIAL_NAME_IS_EMPTY);

        }else {

            SerialBuilder serialBuilder = new SerialBuilder(serialName);

            String serialSection = addSerialView.getSerialSection();

            if(!TextUtils.isEmpty(serialSection)){
                serialBuilder.section(serialSection);
            }

            String serialSeason = addSerialView.getSerialSeason();

            if(!TextUtils.isEmpty(serialSeason)){

                if(TextUtils.isDigitsOnly(serialSeason)){

                    serialBuilder.season(Integer.parseInt(serialSeason));

                }else {

                    addSerialView.showToast(AddSerialView.ToastMessage.SERIAL_SEASON_IS_NOT_DIGIT);
                    return;

                }

            }

            String serialSeries = addSerialView.getSerialSeries();

            if(!TextUtils.isEmpty(serialSeries)){

                if(TextUtils.isDigitsOnly(serialSeries)){

                    serialBuilder.series(Integer.parseInt(serialSeries));

                }else {

                    addSerialView.showToast(AddSerialView.ToastMessage.SERIAL_SERIES_IS_NOT_DIGIT);
                    return;

                }

            }

            String serialLink = addSerialView.getSerialLink();

            if(!TextUtils.isEmpty(serialLink)){

                serialBuilder.link(serialLink);

            }

            String serialStatus = addSerialView.getSerialStatus();

            if(!TextUtils.isEmpty(serialStatus)){

                serialBuilder.status(serialStatus);

            }

            String serialNote = addSerialView.getSerialNote();

            if(!TextUtils.isEmpty(serialNote)){

                serialBuilder.note(serialNote);

            }

            String serialRating = addSerialView.getSerialRating();

            if (!TextUtils.isEmpty(serialRating)) {

                Double serialRatingDouble = null;
                try {

                    serialRatingDouble = Double.parseDouble(serialRating);

                } catch (NumberFormatException e) {
                    addSerialView.showToast(AddSerialView.ToastMessage.SERIAL_RATING_IS_NOT_DIGIT);
                    return;
                }

                if(serialRatingDouble != null){
                    serialBuilder.rating(serialRatingDouble);
                }

            }

            Serial serial = serialBuilder.build();

            Log.i("ADD_SERIAL", serial.toString());

            model.add(serial, new DisposableCompletableObserver() {
                @Override
                public void onComplete() {

                    addSerialView.showToast(AddSerialView.ToastMessage.SERIAL_SUCCESSFULLY_SAVED);
                    addSerialView.clearEditTextFields();

                    model.loadData(new DisposableMaybeObserver<List<Serial>>() {
                        @Override
                        public void onSuccess(List<Serial> serials) {
                            Log.i("ADD_SERIAL", "Внутри базы данных:");
                            for(Serial serial1 : serials){
                                Log.i("ADD_SERIAL", serial1.toString());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.i("ADD_SERIAL", e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

                }

                @Override
                public void onError(Throwable e) {

                    Log.i("ADD_SERIAL", e.getMessage());

                }
            });


        }

    }
}
