package de.dataport.bugs.views.report0;

import com.vaadin.flow.component.crud.CrudFilter;
import com.vaadin.flow.data.provider.AbstractDataProvider;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.provider.Query;

import java.util.List;
import java.util.stream.Stream;

public class CrudListDataProvider<E>
		extends AbstractDataProvider<E, Void>
		implements ConfigurableFilterDataProvider<E, Void, CrudFilter> {

	private final List<E> items;

	public CrudListDataProvider(List<E> items) {
		this.items = items;
	}

	@Override
	public void setFilter(CrudFilter crudFilter) {
		// ignore
	}

	@Override
	public boolean isInMemory() {
		return true;
	}

	@Override
	public int size(Query query) {
		return this.items.size();
	}

	@Override
	public Stream fetch(Query query) {
		return this.items.stream();
	}
}
