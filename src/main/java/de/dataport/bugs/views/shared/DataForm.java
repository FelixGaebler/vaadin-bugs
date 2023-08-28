package de.dataport.bugs.views.shared;

import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DataForm extends FormLayout {

	private final Binder<Data> binder;

	public DataForm() {
		this.binder = new Binder<>(Data.class);

		TextField value = new TextField("Value");
		this.binder.forField(value)
				.asRequired("Please enter a value")
				.bind(Data::getText, Data::setText);
		add(value, 12);
	}

	public CrudEditor<Data> editor() {
		return new BinderCrudEditor<>(this.binder, this);
	}

}
