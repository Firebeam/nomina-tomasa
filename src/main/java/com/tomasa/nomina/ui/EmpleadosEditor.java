package com.tomasa.nomina.ui;

import com.tomasa.nomina.model.Empleado;
import com.tomasa.nomina.service.EmpleadoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
public class EmpleadosEditor extends VerticalLayout {
	private static final long serialVersionUID = -1468030563720051051L;

	private EmpleadoService empleadoService;
	//private transient EmpleadoRepository empleadoRepository;

	private Empleado empleado;

	private TextField nombre = new TextField("Nombre de empleado");
	private TextField cedula = new TextField("Cédula de empleado");

	private Button save = new Button("Guardar", new Icon(VaadinIcons.CHECK));
	private Button cancel = new Button("Cancelar");
	private Button delete = new Button("Eliminar", new Icon(VaadinIcons.TRASH));

	private Binder<Empleado> binder = new Binder<>(Empleado.class);

	@Autowired
	public EmpleadosEditor(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;

		HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);
		add(nombre, cedula, actions);

		binder.bindInstanceFields(this);

		setSpacing(true);

		save.addClickListener(e -> empleadoService.save(empleado));
		delete.addClickListener(e -> empleado.setActivo(false));
		cancel.addClickListener(e -> editEmpleado(empleado));
		setVisible(false);
	}

	public interface ChangeHandler {
		void onChange();
	}

	public final void editEmpleado(Empleado e) {
		if (e == null) {
			setVisible(false);
			return;
		}

		final boolean persisted = e.getId() != 0;

		if (persisted) {
			empleado = empleadoService.findById(e.getId()).get();
		} else {
			empleado = e;
		}
		cancel.setVisible(persisted);

		binder.setBean(empleado);
		setVisible(true);

		save.focus();
	}

	public void setChangeHandler(ChangeHandler handler) {
		save.addClickListener(e -> handler.onChange());
		delete.addClickListener(e -> handler.onChange());
	}
}

