package de.dataport.bugs.views.report3;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.dataport.bugs.views.MainLayout;

/**
 * Checkboxgroup is showing required indicator if new bean is read.
 */
@PageTitle("Report 3")
@Route(value = "report-3", layout = MainLayout.class)
public class Report3View extends Main {

	private final Binder<TestModel> binder = new Binder<>();

	public Report3View() {
		CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
		checkboxGroup.setLabel("Working days");
		checkboxGroup.setItems("Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday", "Sunday");
		checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		add(checkboxGroup);

		this.binder.forField(checkboxGroup)
				.asRequired("Required!")
				.bind(TestModel::getTestSet, TestModel::setTestSet);

		RadioButtonGroup<String> radioButtonGroup = new RadioButtonGroup<>();
		radioButtonGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
		radioButtonGroup.setLabel("Travel class");
		radioButtonGroup.setItems("Economy", "Business", "First Class");
		add(radioButtonGroup);

		this.binder.forField(radioButtonGroup)
				.asRequired("Required!")
				.bind(TestModel::getTestString, TestModel::setTestString);

		Button setButton = new Button("Set Bean");
		add(setButton);
		setButton.addClickListener(listener -> this.binder.setBean(new TestModel()));

		Button readButton = new Button("Read Bean");
		add(readButton);
		readButton.addClickListener(listener -> this.binder.readBean(null));

		setHeightFull();
	}

}
