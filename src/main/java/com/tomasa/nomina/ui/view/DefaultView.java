package com.tomasa.nomina.ui.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
@Route(DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout {

	public static final String VIEW_NAME = "nomina";
	private static final long serialVersionUID = 3600517630040771693L;

	public DefaultView() {
		add(new Label("Default view"));
	}

}
