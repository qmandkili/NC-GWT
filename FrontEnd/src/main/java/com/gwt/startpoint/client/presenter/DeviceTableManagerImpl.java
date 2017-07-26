package com.gwt.startpoint.client.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.gwt.startpoint.client.WorkerClient;
import com.model.shared.Device;

public class DeviceTableManagerImpl implements TableManager {

	private final WorkerClient client = GWT.create(WorkerClient.class);
	
	@Inject 
	public DeviceTableManagerImpl(final EventBus bus) {
		
	}
	
	private List<Device> devices = new ArrayList<>();;
	
	public List<Device> getDevices() {
		getResponse();
		return devices;
	}
	
	public void setDevices(List<Device> list) {
		this.devices = list;
	}

	@Override
	public void getResponse() {
		client.getAll(new MethodCallback<List<Device>>() {

			@Override
			public void onSuccess(Method method, List<Device> response) {
				setDevices(response);
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				Window.alert(exception.toString());
			}
		});
	}
}
