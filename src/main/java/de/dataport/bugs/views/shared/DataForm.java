package de.dataport.bugs.views.shared;

import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DataForm {

	public static CrudEditor<Data> editor() {
		TextField value = new TextField("Value");
		FormLayout form = new FormLayout(value);

		Binder<Data> binder = new Binder<>(Data.class);
		binder.forField(value)
				.asRequired("Please enter a value")
				.bind(Data::getValue, Data::setValue);

		return new BinderCrudEditor<>(binder, form);
	}

}
