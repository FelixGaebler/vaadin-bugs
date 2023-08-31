package de.dataport.bugs.views.report4;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.*;
import de.dataport.bugs.views.MainLayout;

/**
 * BeforeLeaveEvent.postpone()
 */
@PageTitle("Report 4")
@RouteAlias(value = "report-4", layout = MainLayout.class)
@Route(value = "report-4/:test", layout = MainLayout.class)
public class Report4View extends Main implements BeforeEnterObserver, BeforeLeaveObserver {

	private final Button button;

	public Report4View() {
		this.button = new Button("initial");
		this.button.addClickListener(event -> UI.getCurrent().navigate("report-4/test-" + System.currentTimeMillis()));
		add(this.button);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		String parameter = event.getRouteParameters().get("test").orElse(null);
		if(parameter == null) {
			event.rerouteTo("report-4/test-" + System.currentTimeMillis());
		} else {
			this.button.setText(parameter);
		}
	}

	@Override
	public void beforeLeave(BeforeLeaveEvent event) {
		BeforeLeaveEvent.ContinueNavigationAction action = event.postpone();

		ConfirmDialog dialog = new ConfirmDialog();
		dialog.setText("Navigate?");
		dialog.setConfirmButton("Yes", e -> action.proceed());
		dialog.setCancelText("No");
		dialog.setCancelable(true);
		dialog.open();
	}

}
