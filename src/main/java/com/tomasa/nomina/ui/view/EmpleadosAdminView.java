package com.tomasa.nomina.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

@SpringView(name = EmpleadosAdminView.VIEW_NAME)
public class EmpleadosAdminView extends VerticalLayout implements View {

	public static final String VIEW_NAME = "empleados";
	private static final long serialVersionUID = 3344332615518673282L;

	@PostConstruct
	void init() {
		addComponent(new Label("Vista de empleados"));
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		// This view is constructed in the init() method()
	}
}
