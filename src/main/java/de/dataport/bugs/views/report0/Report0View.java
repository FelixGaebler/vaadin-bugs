package de.dataport.bugs.views.report0;

import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import de.dataport.bugs.views.MainLayout;
import de.dataport.bugs.views.shared.Data;
import de.dataport.bugs.views.shared.DataCollection;
import de.dataport.bugs.views.shared.DataForm;
import de.dataport.bugs.views.shared.DataRepository;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * Crud instant-validating inside CustomField.
 *
 * @see <a href="https://github.com/vaadin/flow-components/issues/5364">Github Issue</a>
 */
@PageTitle("Report 0")
@Route(value = "report-0", layout = MainLayout.class)
public class Report0View extends Main {

    public Report0View() {
        // Create components
        CrudEditor<Data> crudEditor = DataForm.editor();
        CrudField<Data> crudField = new CrudField<>(Data.class, crudEditor);
        crudField.setWidthFull();
        add(crudField);

        // Create binder
        Binder<DataCollection> binder = new Binder<>(DataCollection.class);
        binder.forField(crudField)
                .bind(DataCollection::getDataList, DataCollection::setDataList);

        // Read data into binder
        DataCollection dataCollection = new DataCollection();
        dataCollection.setDataList(DataRepository.mockData0());
        binder.readBean(dataCollection);
    }

}
