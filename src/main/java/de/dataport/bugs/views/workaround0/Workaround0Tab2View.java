package de.dataport.bugs.views.workaround0;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Workaround 0 | Tab 2")
@Route(value = "workaround-0/tab-2", layout = Workaround0View.class)
public class Workaround0Tab2View extends FormLayout {

	public Workaround0Tab2View() {
		add("Tab 2");
	}

}
