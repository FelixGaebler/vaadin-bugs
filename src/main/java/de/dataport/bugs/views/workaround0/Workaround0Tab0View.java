package de.dataport.bugs.views.workaround0;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.router.*;

@PageTitle("Workaround 0 | Tab 0")
@Route(value = "workaround-0/tab-0", layout = Workaround0View.class)
public class Workaround0Tab0View extends FormLayout {

	public Workaround0Tab0View() {
		add("Tab 0");
	}

}
