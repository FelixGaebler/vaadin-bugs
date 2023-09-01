package de.dataport.bugs.views.workaround0;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.*;
import de.dataport.bugs.views.MainLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Workaround for report 4 and 5.
 */
@PageTitle("Lab 0")
@Route(value = "workaround-0")
@ParentLayout(MainLayout.class)
public class Workaround0View extends Main implements RouterLayout, BeforeEnterObserver, BeforeLeaveObserver {

	private static class CustomTabs extends Tabs implements BeforeEnterObserver {

		private final Map<Tab, Class<? extends Component>> tabRouteMap;

		private final Map<Class<? extends Component>, Tab> routeTabMap;

		public CustomTabs() {
			this.tabRouteMap = new HashMap<>();
			this.routeTabMap = new HashMap<>();

			this.addSelectedChangeListener(event -> {
				if(!event.isFromClient()) {
					return;
				}

				UI.getCurrent().navigate(this.tabRouteMap.get(event.getSelectedTab()));
				setSelectedTab(event.getPreviousTab());
			});
		}

		public void add(String label, Class<? extends Component> navigationTarget) {
			Tab tab = new Tab();
			tab.setLabel(label);
			add(tab);

			this.tabRouteMap.put(tab, navigationTarget);
			this.routeTabMap.put(navigationTarget, tab);

		}

		/**
		 * Set active tab to route.
		 * @param event event
		 */
		@Override
		public void beforeEnter(BeforeEnterEvent event) {
			setSelectedTab(this.routeTabMap.get(event.getNavigationTarget()));
		}
	}

	public Workaround0View() {
		CustomTabs customTabs = new CustomTabs();
		customTabs.add("Tab 0", Workaround0Tab0View.class);
		customTabs.add("Tab 1", Workaround0Tab1View.class);
		customTabs.add("Tab 2", Workaround0Tab2View.class);
		add(customTabs);
	}

	/**
	 * Set default route.
	 * @param event event
	 */
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (event.getNavigationTarget() == Workaround0View.class) {
			event.forwardTo(Workaround0Tab0View.class);
		}
	}

	@Override
	public void beforeLeave(BeforeLeaveEvent event) {
		BeforeLeaveEvent.ContinueNavigationAction action = event.postpone();
		ConfirmDialog confirmDialog = new ConfirmDialog();
		confirmDialog.setText("Sure?");
		confirmDialog.setCancelable(true);
		confirmDialog.setCancelText("No");
		confirmDialog.setConfirmButton("Yes", e -> action.proceed());
		confirmDialog.open();
	}

}
