package com.strikalov.myserials;

import com.strikalov.myserials.View.Dagger.AddSerialViewComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

    AddSerialViewComponent createAddSerialViewComponent();

}
