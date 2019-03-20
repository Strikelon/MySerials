package com.strikalov.myserials.View.Dagger;

import com.strikalov.myserials.DataBase.AppDatabase;
import com.strikalov.myserials.Model.Model;
import com.strikalov.myserials.Model.ModelDatabase;
import com.strikalov.myserials.Presenter.AddSerialActivityPresenter;
import com.strikalov.myserials.Presenter.AddSerialViewPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class AddSerialViewModule {

    @ActivityScope
    @Provides
    public Model provideModel(AppDatabase database){
        return new ModelDatabase(database);
    }

    @ActivityScope
    @Provides
    public AddSerialViewPresenter provideAddSerialViewPresenter(Model model){
        return new AddSerialActivityPresenter(model);
    }

}
