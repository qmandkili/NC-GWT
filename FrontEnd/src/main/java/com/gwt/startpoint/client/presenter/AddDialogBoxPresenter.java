package com.gwt.startpoint.client.presenter;

import javax.inject.Inject;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.gwt.startpoint.client.WorkerClient;
import com.model.shared.Device;

public class AddDialogBoxPresenter {
	
	@Inject
	public AddDialogBoxPresenter(final EventBus bus) {
		
	}
	
	private final WorkerClient client = GWT.create(WorkerClient.class);
	
	public void sendPost(String name, String description) {
		client.post(new Device(null, name, description), new MethodCallback<String>() {			
			@Override
			public void onSuccess(Method method, String response) {
				// TODO Auto-generated method stub
				Window.alert(response + " Device with name: " + name + " and description: "
						+ description + " was added");
			}
			@Override
			public void onFailure(Method method, Throwable exception) {
				// TODO Auto-generated method stub
				Window.alert(exception.toString());
			}
		});
	}

}
