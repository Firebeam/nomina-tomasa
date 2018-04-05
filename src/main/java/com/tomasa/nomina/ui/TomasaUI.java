package com.tomasa.nomina.ui;

import com.tomasa.nomina.ui.view.DefaultView;
import com.tomasa.nomina.ui.view.EmpleadosAdminView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@HtmlImport("styles/shared-styles.html")
@Route("")
@Theme(Lumo.class)
@BodySize(height = "100vh", width = "100vw")
public class TomasaUI extends VerticalLayout {

	public TomasaUI() {
		final VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		add(root);

		final HorizontalLayout navigationBar = new HorizontalLayout();
		//navigationBar.addClassName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		navigationBar.add(createNavigationButton("Nómina",
				DefaultView.VIEW_NAME));
		navigationBar.add(createNavigationButton("Empleados",
				EmpleadosAdminView.VIEW_NAME));
		root.add(navigationBar);

		HorizontalLayout springViewDisplay = new HorizontalLayout();
		springViewDisplay.setSizeFull();
		root.add(springViewDisplay);
	}

	private Button createNavigationButton(String caption, final String viewName) {
		Button button = new Button(caption);
		//button.addStyleName(ValoTheme.BUTTON_SMALL);
		button.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate(viewName)));
		return button;
	}
}
