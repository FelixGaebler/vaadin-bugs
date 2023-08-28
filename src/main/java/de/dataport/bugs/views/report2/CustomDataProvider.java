package de.dataport.bugs.views.report2;

import com.vaadin.flow.component.crud.CrudFilter;
import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.provider.Query;
import de.dataport.bugs.views.shared.AbstractRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

public class CustomDataProvider<E, R extends AbstractRepository<E>>
		extends AbstractBackEndDataProvider<E, String>
		implements ConfigurableFilterDataProvider<E, String, CrudFilter> {

	private final R repository;

	@Getter
	@Setter
	private CrudFilter filter;

	public CustomDataProvider(R repository) {
		this.repository = repository;
	}

	@Override
	protected Stream<E> fetchFromBackEnd(Query<E, String> query) {
		return this.repository.fetch(query, this.filter);
	}

	@Override
	protected int sizeInBackEnd(Query<E, String> query) {
		return this.repository.count(query, this.filter);
	}

}
