package com.strikalov.myserials.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.strikalov.myserials.App;
import com.strikalov.myserials.Model.ModelDatabase;
import com.strikalov.myserials.Presenter.AddSerialActivityPresenter;
import com.strikalov.myserials.Presenter.AddSerialViewPresenter;
import com.strikalov.myserials.R;
import com.strikalov.myserials.View.Dagger.AddSerialViewComponent;

import javax.inject.Inject;

public class AddSerialActivity extends AppCompatActivity implements AddSerialView{

    private AppCompatEditText serialName;
    private AppCompatEditText serialSection;
    private AppCompatEditText serialSeason;
    private AppCompatEditText serialSeries;
    private AppCompatEditText serialLink;
    private AppCompatEditText serialStatus;
    private AppCompatEditText serialNote;
    private AppCompatEditText serialRating;

    private Button saveSerialButton;

    @Inject
    AddSerialViewPresenter addSerialViewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_serial);

        serialName = findViewById(R.id.add_serial_name);
        serialSection = findViewById(R.id.add_serial_section);
        serialSeason = findViewById(R.id.add_serial_season);
        serialSeries = findViewById(R.id.add_serial_series);
        serialLink = findViewById(R.id.add_serial_link);
        serialStatus = findViewById(R.id.add_serial_status);
        serialNote = findViewById(R.id.add_serial_note);
        serialRating = findViewById(R.id.add_serial_rating);

        saveSerialButton = findViewById(R.id.add_serial_button_save);

        AddSerialViewComponent addSerialViewComponent = App.getInstance().getAppComponent().createAddSerialViewComponent();
        addSerialViewComponent.injectAddSerialView(this);

        addSerialViewPresenter.onViewCreate(this);

        saveSerialButton.setOnClickListener((view) -> addSerialViewPresenter.onClickSaveSerial());
    }

    @Override
    public String getSerialName() {
        return serialName.getText().toString();
    }

    @Override
    public String getSerialSection() {
        return serialSection.getText().toString();
    }

    @Override
    public String getSerialSeason() {
        return serialSeason.getText().toString();
    }

    @Override
    public String getSerialSeries() {
        return serialSeries.getText().toString();
    }

    @Override
    public String getSerialLink() {
        return serialLink.getText().toString();
    }

    @Override
    public String getSerialStatus() {
        return serialStatus.getText().toString();
    }

    @Override
    public String getSerialNote() {
        return serialNote.getText().toString();
    }

    @Override
    public String getSerialRating() {
        return serialRating.getText().toString();
    }

    @Override
    public void showToast(ToastMessage toastMessage) {

        switch (toastMessage){
            case SERIAL_NAME_IS_EMPTY:
                Toast.makeText(this, getString(R.string.serial_name_is_empty), Toast.LENGTH_SHORT).show();
                break;
            case SERIAL_SEASON_IS_NOT_DIGIT:
                Toast.makeText(this, getString(R.string.serial_season_is_not_digit), Toast.LENGTH_SHORT).show();
                break;
            case SERIAL_SERIES_IS_NOT_DIGIT:
                Toast.makeText(this, getString(R.string.serial_series_is_not_digit), Toast.LENGTH_SHORT).show();
                break;
            case SERIAL_RATING_IS_NOT_DIGIT:
                Toast.makeText(this, getString(R.string.serial_rating_is_not_digit), Toast.LENGTH_SHORT).show();
                break;
            case SERIAL_SUCCESSFULLY_SAVED:
                Toast.makeText(this, getString(R.string.serial_successfully_saved), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void clearEditTextFields() {

        serialName.setText("");
        serialSection.setText("");
        serialSeason.setText("");
        serialSeries.setText("");
        serialLink.setText("");
        serialStatus.setText("");
        serialNote.setText("");
        serialRating.setText("");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        addSerialViewPresenter.onViewDestroy();
    }
}
