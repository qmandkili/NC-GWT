package com.gwt.startpoint.client.view;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.gwt.startpoint.client.event.AddEvent;

public class AddButtonView extends Button {

	@Inject
	public AddButtonView(final EventBus eventBus) {
		setText("Add");

		addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new AddEvent());
			}
		});
	}
}
