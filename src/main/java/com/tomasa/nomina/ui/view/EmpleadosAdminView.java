package com.tomasa.nomina.ui.view;

import com.tomasa.nomina.model.Empleado;
import com.tomasa.nomina.repository.EmpleadoRepository;
import com.tomasa.nomina.ui.EmpleadosEditor;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@SpringView(name = EmpleadosAdminView.VIEW_NAME)
public class EmpleadosAdminView extends VerticalLayout implements View {

	public static final String VIEW_NAME = "empleados";
	private static final long serialVersionUID = 3344332615518673282L;

	private final EmpleadoRepository empleadoRepository;
	private final EmpleadosEditor empleadosEditor;

	private final Grid<Empleado> grid;

	private final TextField filter;

	private final Button addNewEmpleado;

	@Autowired
	public EmpleadosAdminView(EmpleadoRepository empleadoRepository, EmpleadosEditor empleadosEditor) {
		this.empleadoRepository = empleadoRepository;
		this.empleadosEditor = empleadosEditor;
		this.grid = new Grid<>(Empleado.class);
		this.filter = new TextField();
		this.addNewEmpleado = new Button("Agregar nuevo empleado", VaadinIcons.PLUS);
	}

	/*@PostConstruct
	void init() {
		HorizontalLayout actions = new HorizontalLayout(filter, addNewEmpleado);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, empleadosEditor);
		addComponent(mainLayout);

		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id", "nombre", "cedula");

		filter.setPlaceholder("Filtrar por nombre");

		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listEmpleados(e.getValue()));

		grid.asSingleSelect().addValueChangeListener(e ->
			empleadosEditor.editEmpleado(e.getValue())
		);

		addNewEmpleado.addClickListener(e -> empleadosEditor.editEmpleado(new Empleado()));

		empleadosEditor.setChangeHandler(() -> {
			empleadosEditor.setVisible(false);
			listEmpleados(filter.getValue());
		});
		
		listEmpleados(null);
	}*/

	private void listEmpleados(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems(empleadoRepository.findAll());
		} else {
			grid.setItems(empleadoRepository.findByNombreIgnoreCase(filterText));
		}
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		HorizontalLayout actions = new HorizontalLayout(filter, addNewEmpleado);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, empleadosEditor);
		addComponent(mainLayout);

		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id", "nombre", "cedula");

		filter.setPlaceholder("Filtrar por nombre");

		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listEmpleados(e.getValue()));

		grid.asSingleSelect().addValueChangeListener(e ->
				empleadosEditor.editEmpleado(e.getValue())
		);

		addNewEmpleado.addClickListener(e -> empleadosEditor.editEmpleado(new Empleado()));

		empleadosEditor.setChangeHandler(() -> {
			empleadosEditor.setVisible(false);
			listEmpleados(filter.getValue());
		});

		listEmpleados(null);
	}
}
