package com.gwt.startpoint.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.gwt.startpoint.client.presenter.AddDialogBoxPresenter;
import com.gwt.startpoint.client.presenter.DeviceTableManagerImpl;
import com.gwt.startpoint.client.view.AddButtonView;
import com.gwt.startpoint.client.view.AddDialogBoxView;
import com.gwt.startpoint.client.view.DeviceTable;

//  С injector ом я еще не до конца разобрался, но как я понимаю он заменяет собой EventBus

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    public static final Injector INSTANCE = GWT.create(Injector.class);

    public EventBus getEventBus();
    
    public DeviceTable getDeviceTable();
    
    public DeviceTableManagerImpl getDeviceTableManager();
    
    public AddDialogBoxView getAddDialogBoxView();
    
    public AddButtonView getButtonView();
    
    public AddDialogBoxPresenter getAddDialogBoxPresenter();
}