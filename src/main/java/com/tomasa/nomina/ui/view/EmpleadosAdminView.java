package com.tomasa.nomina.ui.view;

import com.tomasa.nomina.model.Empleado;
import com.tomasa.nomina.service.EmpleadoService;
import com.tomasa.nomina.ui.EmpleadosEditor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@SpringComponent
@Route(EmpleadosAdminView.VIEW_NAME)
public class EmpleadosAdminView extends VerticalLayout {

	public static final String VIEW_NAME = "empleados";
	private static final long serialVersionUID = 3344332615518673282L;

	private EmpleadoService empleadoService;
	private EmpleadosEditor empleadosEditor;

	private final Grid<Empleado> grid = new Grid<>(Empleado.class);

	private final TextField filter = new TextField();

	private final Button addNewEmpleado = new Button("Agregar nuevo empleado", new Icon(VaadinIcons.PLUS));

	@Autowired
	public EmpleadosAdminView(EmpleadoService empleadoService, EmpleadosEditor empleadosEditor) {
		this.empleadoService = empleadoService;
		this.empleadosEditor = empleadosEditor;

		HorizontalLayout actions = new HorizontalLayout(filter, addNewEmpleado);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, empleadosEditor);
		add(mainLayout);

		grid.setHeight("300");

		filter.setPlaceholder("Filtrar por nombre");

		filter.setValueChangeMode(ValueChangeMode.EAGER);
		filter.addValueChangeListener(e -> listEmpleados(e.getValue()));

		grid.asSingleSelect().addValueChangeListener(e ->
				empleadosEditor.editEmpleado(e.getValue())
		);

		addNewEmpleado.addClickListener(e -> empleadosEditor.editEmpleado(new Empleado()));

		listEmpleados(null);
	}

	private void listEmpleados(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems(empleadoService.findAll());
		} else {
			grid.setItems(empleadoService.findByNombreIgnoreCase(filterText));
		}
	}
}
