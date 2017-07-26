package com.gwt.startpoint.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddEvent extends GwtEvent<AddEventHandler> {

	public static Type<AddEventHandler> TYPE = new Type<AddEventHandler>();
	
	@Override
	protected void dispatch(AddEventHandler handler) {
		handler.add(this);
	}

	@Override
	public Type<AddEventHandler> getAssociatedType() {
		return TYPE;
	}


}
