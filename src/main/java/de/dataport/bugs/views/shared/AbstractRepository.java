package de.dataport.bugs.views.shared;

import com.vaadin.flow.component.crud.CrudFilter;
import com.vaadin.flow.data.provider.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.stream.Stream;

@NoRepositoryBean
public interface AbstractRepository<E> extends JpaRepository<E, Long> {

	Stream<E> fetch(Query<E, String> query, CrudFilter filter);

	int count(Query<E, String> query, CrudFilter filter);

}