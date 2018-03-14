package com.tomasa.nomina.ui;

import com.tomasa.nomina.ui.view.DefaultView;
import com.tomasa.nomina.ui.view.EmpleadosAdminView;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Title("Multiservicios Tomasa, C.A.")
@SpringViewDisplay
public class TomasaUI extends UI implements ViewDisplay {

	private Panel springViewDisplay;
	private static final long serialVersionUID = -5326618953003021331L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		setContent(root);

		final CssLayout navigationBar = new CssLayout();
		navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		navigationBar.addComponent(createNavigationButton("Nómina",
				DefaultView.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("Empleados",
				EmpleadosAdminView.VIEW_NAME));
		root.addComponent(navigationBar);

		springViewDisplay = new Panel();
		springViewDisplay.setSizeFull();
		root.addComponent(springViewDisplay);
		root.setExpandRatio(springViewDisplay, 1.0f);
	}

	private Button createNavigationButton(String caption, final String viewName) {
		Button button = new Button(caption);
		button.addStyleName(ValoTheme.BUTTON_SMALL);
		// If you didn't choose Java 8 when creating the project, convert this
		// to an anonymous listener class
		button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
		return button;
	}

	@Override
	public void showView(View view) {
		springViewDisplay.setContent((Component) view);
	}
}
