package de.dataport.bugs.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import de.dataport.bugs.views.workaround0.Workaround0View;
import de.dataport.bugs.views.overview.OverviewView;
import de.dataport.bugs.views.report0.Report0View;
import de.dataport.bugs.views.report1.Report1View;
import de.dataport.bugs.views.report2.Report2View;
import de.dataport.bugs.views.report3.Report3View;
import de.dataport.bugs.views.report4.Report4View;
import de.dataport.bugs.views.report5.Report5View;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

	private H2 viewTitle;

	public MainLayout() {
		setPrimarySection(Section.DRAWER);
		addDrawerContent();
		addHeaderContent();
	}

	private void addHeaderContent() {
		DrawerToggle toggle = new DrawerToggle();
		toggle.setAriaLabel("Menu toggle");

		viewTitle = new H2();
		viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

		addToNavbar(true, toggle, viewTitle);
	}

	private void addDrawerContent() {
		H1 appName = new H1("Bugs");
		appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
		Header header = new Header(appName);

		Scroller scroller = new Scroller(createNavigation());

		addToDrawer(header, scroller, createFooter());
	}

	private SideNav createNavigation() {
		SideNav nav = new SideNav();

		nav.addItem(new SideNavItem("Overview", OverviewView.class, LineAwesomeIcon.TOOLBOX_SOLID.create()));
		nav.addItem(new SideNavItem("Report 0", Report0View.class, LineAwesomeIcon.FILE.create()));
		nav.addItem(new SideNavItem("Report 1", Report1View.class, LineAwesomeIcon.FILE.create()));
		nav.addItem(new SideNavItem("Report 2", Report2View.class, LineAwesomeIcon.FILE.create()));
		nav.addItem(new SideNavItem("Report 3", Report3View.class, LineAwesomeIcon.FILE.create()));
		nav.addItem(new SideNavItem("Report 4", Report4View.class, LineAwesomeIcon.FILE.create()));
		nav.addItem(new SideNavItem("Report 5", Report5View.class, LineAwesomeIcon.FILE.create()));
		nav.addItem(new SideNavItem("Workaround 0", Workaround0View.class, LineAwesomeIcon.FILE.create()));

		return nav;
	}

	private Footer createFooter() {
		Footer layout = new Footer();

		return layout;
	}

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		viewTitle.setText(getCurrentPageTitle());
	}

	private String getCurrentPageTitle() {
		PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
		return title == null ? "" : title.value();
	}
}
