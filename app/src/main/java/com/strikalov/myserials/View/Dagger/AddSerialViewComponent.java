package com.strikalov.myserials.View.Dagger;

import com.strikalov.myserials.View.AddSerialActivity;
import com.strikalov.myserials.View.AddSerialView;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = AddSerialViewModule.class)
public interface AddSerialViewComponent {

    void injectAddSerialView(AddSerialActivity activity);

}
