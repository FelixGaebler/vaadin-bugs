package de.dataport.bugs.views.report1;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import de.dataport.bugs.views.MainLayout;

/**
 * vaadin-form-layout flex is not expanding.
 */
@PageTitle("Report 1")
@Route(value = "report-1", layout = MainLayout.class)
public class Report1View extends Main {

	public Report1View() {
		setHeightFull();

		// FormLayout
		FormLayout formLayout = new FormLayout();
		formLayout.addClassName(LumoUtility.Flex.GROW);
		formLayout.add(create("FormLayout"), 12);

		// Div
		Div div = new Div();
		div.addClassName(LumoUtility.Flex.GROW);
		div.add(create("Div"));

		// Side-by-side comparison
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSpacing(false);
		horizontalLayout.setHeightFull();
		horizontalLayout.add(formLayout);
		horizontalLayout.add(div);
		add(horizontalLayout);
	}

	private HorizontalLayout create(String label) {
		Div left = new Div();
		left.addClassName(LumoUtility.Background.CONTRAST_20);
		left.addClassName(LumoUtility.Flex.GROW);
		left.add(new Text(label + "-Left"));

		Div right = new Div();
		right.addClassName(LumoUtility.Background.CONTRAST_40);
		right.addClassName(LumoUtility.Flex.GROW);
		right.add(new Text(label + "-Right"));

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setHeightFull();
		horizontalLayout.setSpacing(false);
		horizontalLayout.add(left);
		horizontalLayout.add(right);

		return horizontalLayout;
	}

}
