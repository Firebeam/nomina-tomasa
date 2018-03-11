package com.tomasa.nomina.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SpringUI
public class TomasaUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		setContent(new Label("Hiiiiii"));
	}
}
