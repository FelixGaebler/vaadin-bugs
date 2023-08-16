package de.dataport.bugs.views.report0;

import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.ArrayList;
import java.util.List;

public class CrudField<E> extends CustomField<List<E>> {

	private final List<E> value;

	private final CrudListDataProvider<E> dataProvider;

	public CrudField(Class<E> clazz, CrudEditor<E> editor) {
		this.value = new ArrayList<>();

		this.dataProvider = new CrudListDataProvider<>(this.value);

		Crud<E> crud = new Crud<>(clazz, editor);
		crud.setEditOnClick(true);
		crud.setDataProvider(this.dataProvider);

		crud.addSaveListener(e -> {
			this.value.remove(e.getItem());
			this.value.add(e.getItem());
			updateValue();
		});

		crud.addDeleteListener(e -> {
			this.value.remove(e.getItem());
			updateValue();
		});

		add(crud);
	}

	@Override
	protected List<E> generateModelValue() {
		return new ArrayList<>(this.value);
	}

	@Override
	protected void setPresentationValue(List<E> items) {
		this.value.clear();
		this.value.addAll(items);
	}

}
