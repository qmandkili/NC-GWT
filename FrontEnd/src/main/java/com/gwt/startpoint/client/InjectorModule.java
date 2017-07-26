package com.gwt.startpoint.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.gwt.startpoint.client.presenter.AddDialogBoxPresenter;
import com.gwt.startpoint.client.presenter.DeviceTableManagerImpl;
import com.gwt.startpoint.client.view.AddButtonView;
import com.gwt.startpoint.client.view.AddDialogBoxView;
import com.gwt.startpoint.client.view.DeviceTable;

public class InjectorModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(DeviceTable.class).in(Singleton.class);
        bind(DeviceTableManagerImpl.class).in(Singleton.class);
        bind(AddDialogBoxView.class).in(Singleton.class);
        bind(AddButtonView.class).in(Singleton.class);
        bind(AddDialogBoxPresenter.class).in(Singleton.class);
    }
}