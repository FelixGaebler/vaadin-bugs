package de.dataport.bugs.views.report0;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.dataport.bugs.views.MainLayout;
import de.dataport.bugs.views.shared.Collection;
import de.dataport.bugs.views.shared.CollectionRepository;
import de.dataport.bugs.views.shared.Data;
import de.dataport.bugs.views.shared.DataForm;

/**
 * Crud instant-validating inside CustomField.
 *
 * @see <a href="https://github.com/vaadin/flow-components/issues/5364">Github Issue</a>
 */
@PageTitle("Report 0")
@Route(value = "report-0", layout = MainLayout.class)
public class Report0View extends Main {

	public Report0View(CollectionRepository collectionRepository) {
		// Create components
		DataForm form = new DataForm();
		CrudField<Data> crudField = new CrudField<>(Data.class, form.editor());
		crudField.setWidthFull();
		add(crudField);

		// Create binder
		Binder<Collection> binder = new Binder<>(Collection.class);
		binder.forField(crudField)
				.bind(Collection::getList, Collection::setList);

		// Read data into binder
		Collection collection = collectionRepository.findById(1L).orElseThrow();
		binder.readBean(collection);
	}

}
