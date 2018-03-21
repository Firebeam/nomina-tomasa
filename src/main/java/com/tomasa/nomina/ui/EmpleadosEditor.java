package com.tomasa.nomina.ui;

import com.tomasa.nomina.model.Empleado;
import com.tomasa.nomina.repository.EmpleadoRepository;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@SpringComponent
@ViewScope
public class EmpleadosEditor extends VerticalLayout implements Serializable {
	private static final long serialVersionUID = -1468030563720051051L;
	private final EmpleadoRepository empleadoRepository;

	private Empleado empleado;

	private TextField nombre = new TextField("Nombre de empleado");
	private TextField cedula = new TextField("Cédula de empleado");

	private Button save = new Button("Guardar", VaadinIcons.CHECK);
	private Button cancel = new Button("Cancelar");
	private Button delete = new Button("Eliminar", VaadinIcons.TRASH);

	private Binder<Empleado> binder = new Binder<>(Empleado.class);

	@Autowired
	public EmpleadosEditor(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;

		CssLayout actions = new CssLayout(save, cancel, delete);
		addComponents(nombre, cedula, actions);

		binder.bindInstanceFields(this);

		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		save.addClickListener((Button.ClickListener & Serializable) e -> empleadoRepository.save(empleado));
		delete.addClickListener((Button.ClickListener & Serializable) e -> empleado.setActivo(false));
		cancel.addClickListener((Button.ClickListener & Serializable) e -> editEmpleado(empleado));
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
			empleado = empleadoRepository.findById(e.getId()).get();
		} else {
			empleado = e;
		}
		cancel.setVisible(persisted);

		binder.setBean(empleado);
		setVisible(true);

		save.focus();
		nombre.selectAll();
	}

	public void setChangeHandler(ChangeHandler handler) {
		save.addClickListener((Button.ClickListener & Serializable) e -> handler.onChange());
		delete.addClickListener((Button.ClickListener & Serializable) e -> handler.onChange());
	}
}
