package de.dataport.bugs.views.report5;

import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.*;
import de.dataport.bugs.views.MainLayout;

import java.util.UUID;

/**
 * BeforeLeaveEvent.postpone()
 */
@PageTitle("Report 5")
@RouteAlias(value = "report-5", layout = MainLayout.class)
@Route(value = "report-5/:test", layout = MainLayout.class)
public class Report5View extends Main implements BeforeEnterObserver, BeforeLeaveObserver {

	private final RouterLink link;

	public Report5View() {
		this.link = new RouterLink();
		this.link.setText("initial");
		this.link.setRoute(Report5View.class, new RouteParameters(new RouteParam("test", UUID.randomUUID().toString())));
		add(this.link);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		String parameter = event.getRouteParameters().get("test").orElse(null);
		if(parameter == null) {
			event.rerouteTo(Report5View.class, new RouteParameters(new RouteParam("test", UUID.randomUUID().toString())));
		} else {
			this.link.setText(parameter);
			this.link.setRoute(Report5View.class, new RouteParameters(new RouteParam("test", UUID.randomUUID().toString())));
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
