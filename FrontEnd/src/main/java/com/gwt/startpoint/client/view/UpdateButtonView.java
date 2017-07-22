package com.gwt.startpoint.client.view;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.gwt.startpoint.client.event.UpdateEvent;

public class UpdateButtonView extends Button {

	@Inject
	public UpdateButtonView(final EventBus eventBus) {
		setText("Update table");

		addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new UpdateEvent());
			}
		});
	}
}
