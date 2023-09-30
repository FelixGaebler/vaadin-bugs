package de.dataport.bugs.views.report0rep;

import com.vaadin.flow.component.crud.CrudFilter;
import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;

import java.util.List;
import java.util.stream.Stream;

public class PersonDataProvider extends AbstractBackEndDataProvider<Person, CrudFilter> {

    // A real app should hook up something like JPA
    final List<Person> DATABASE = List.of(new Person(0, "Sergey", "Vinogradov"));

    @Override
    protected Stream<Person> fetchFromBackEnd(Query<Person, CrudFilter> query) {
        int offset = query.getOffset();
        int limit = query.getLimit();

        Stream<Person> stream = DATABASE.stream();
        return stream.skip(offset).limit(limit);
    }

    @Override
    protected int sizeInBackEnd(Query<Person, CrudFilter> query) {
        long count = fetchFromBackEnd(query).count();
        return (int) count;
    }
}
