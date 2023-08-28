package de.dataport.bugs.views.report2;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.dataport.bugs.views.MainLayout;
import de.dataport.bugs.views.shared.Data;
import de.dataport.bugs.views.shared.DataForm;
import de.dataport.bugs.views.shared.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * DataProvider is switching types in runtime.
 */
@PageTitle("Report 2")
@Route(value = "report-2", layout = MainLayout.class)
public class Report2View extends Main {

	public Report2View(@Autowired DataRepository dataRepository) {
		CustomDataProvider<Data, DataRepository> dataProvider = new CustomDataProvider<>(dataRepository);

		ComboBox<Data> comboBox = new ComboBox<>();
		comboBox.setItems(dataProvider);

		DataForm form = new DataForm();
		Crud<Data> crud = new Crud<>(Data.class, form.editor());
		crud.setDataProvider(dataProvider);

		SplitLayout layout = new SplitLayout();
		layout.addToPrimary(comboBox);
		layout.addToSecondary(crud);

		setHeightFull();
		add(layout);
	}

}
