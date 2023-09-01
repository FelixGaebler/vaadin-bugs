package de.dataport.bugs.views.workaround0;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Workaround 0 | Tab 1")
@Route(value = "workaround-0/tab-1", layout = Workaround0View.class)
public class Workaround0Tab1View extends FormLayout {

	public Workaround0Tab1View() {
		add("Tab 1");
	}

}
