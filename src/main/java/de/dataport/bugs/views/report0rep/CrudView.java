package de.dataport.bugs.views.report0rep;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("crud")
public class CrudView extends Div {

    public CrudView() {
        add(new de.dataport.bugs.views.report0rep.CrudField());
    }
}
