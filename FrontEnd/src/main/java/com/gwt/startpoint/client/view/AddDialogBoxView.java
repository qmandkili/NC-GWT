package com.gwt.startpoint.client.view;

import java.io.BufferedInputStream;

import javax.inject.Inject;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.startpoint.client.WorkerClient;
import com.gwt.startpoint.client.event.AddEvent;
import com.gwt.startpoint.client.event.AddEventHandler;
import com.gwt.startpoint.client.event.UpdateEvent;
import com.gwt.startpoint.client.event.UpdateEventHandler;
import com.gwt.startpoint.client.presenter.AddDialogBoxPresenter;
import com.model.shared.Device;

public class AddDialogBoxView extends Composite {

	private static AddDialogBoxViewUiBinder uiBinder = GWT.create(AddDialogBoxViewUiBinder.class);

	interface AddDialogBoxViewUiBinder extends UiBinder<Widget, AddDialogBoxView> {
	}
	
	private final WorkerClient client = GWT.create(WorkerClient.class);
	
	private AddDialogBoxPresenter presenter;
	
	private EventBus bus;

	@Inject
	public AddDialogBoxView(final EventBus bus) {
		initWidget(uiBinder.createAndBindUi(this));
		this.bus = bus;
		setActions();
		presenter = new AddDialogBoxPresenter(bus);
	}
	@UiField
	TextBox nameTextBox;

	@UiField
	TextBox descriptionTextBox;
	
	public Device createDevice() {
		return new Device(null, nameTextBox.getText(), descriptionTextBox.getText());
	}

	public void setActions() {
		bus.addHandler(AddEvent.TYPE, new AddEventHandler() {
			@Override
			public void add(AddEvent event) {
				presenter.sendPost(nameTextBox.getText(), descriptionTextBox.getText());
				//updateRows(manager.getDevices());
					/*client.getAll(new MethodCallback<List<Device>>() {

					@Override
					public void onSuccess(Method method, List<Device> response) {
						updateRows(response);
					}

					@Override
					public void onFailure(Method method, Throwable exception) {
						Window.alert(exception.toString());
					}
				});*/
			}
		});
	}
	
	/*@UiHandler("addButton")
	   void doClickAdd(ClickEvent event) {
		client.post(new Device(null, nameTextBox.getText(), descriptionTextBox.getText()), new MethodCallback<String>() {			
			@Override
			public void onSuccess(Method method, String response) {
				// TODO Auto-generated method stub
				Window.alert(response + " Device with name: " + nameTextBox.getText() + " and description: "
						+ descriptionTextBox.getText() + " was added");
			}
			@Override
			public void onFailure(Method method, Throwable exception) {
				// TODO Auto-generated method stub
				Window.alert(exception.toString());
			}
		});
	   }*/

}