package de.dataport.bugs.views.report0rep;

import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.ArrayList;
import java.util.List;

public class CrudField extends CustomField<List<Person>> {

    private final List<Person> value;

    private final Crud<Person> crud;

    public CrudField() {
        this.value = new ArrayList<>();

        this.crud = new Crud<>(Person.class, createEditor());
        this.crud.setEditOnClick(true);
        this.crud.setDataProvider(new PersonDataProvider());

        this.crud.addSaveListener(e -> {
            this.value.remove(e.getItem());
            this.value.add(e.getItem());
            updateValue();
        });

        this.crud.addDeleteListener(e -> {
            this.value.remove(e.getItem());
            updateValue();
        });

        setHeightFull();
        addClassName(LumoUtility.Display.BLOCK);
        add(this.crud);
    }

    private CrudEditor<Person> createEditor() {
        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        FormLayout form = new FormLayout(firstName, lastName);

        Binder<Person> binder = new Binder<>(Person.class);
        binder.forField(firstName).asRequired().bind(Person::getFirstName, Person::setFirstName);
        binder.forField(lastName).asRequired().bind(Person::getLastName, Person::setLastName);

        return new BinderCrudEditor<>(binder, form);
    }

    @Override
    protected List<Person> generateModelValue() {
        return new ArrayList<>(this.value);
    }

    @Override
    protected void setPresentationValue(List<Person> items) {
        this.value.clear();
        this.value.addAll(items);
    }
}
