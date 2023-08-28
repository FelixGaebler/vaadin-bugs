package de.dataport.bugs.views.shared;

import com.vaadin.flow.component.crud.CrudFilter;
import com.vaadin.flow.data.provider.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Optional;
import java.util.stream.Stream;

@Log4j2
public class AbstractRepositoryImpl<E> extends SimpleJpaRepository<E, Long> implements AbstractRepository<E> {

	private final EntityManager entityManager;

	private final Class<E> entityClass;

	public AbstractRepositoryImpl(JpaEntityInformation<E, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
		this.entityClass = entityInformation.getJavaType();
	}

	public Stream<E> fetch(Query<E, String> query, CrudFilter filter) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<E> criteriaQuery = builder.createQuery(this.entityClass);
		Root<E> root = criteriaQuery.from(this.entityClass);
		criteriaQuery.select(root);

		query.getFilter().ifPresent(queryFilter -> {
			//TODO apply query filter
		});

		Optional.ofNullable(filter).ifPresent(crudFilter -> {
			//TODO apply crud filter
		});

		return this.entityManager.createQuery(criteriaQuery)
				.setFirstResult(query.getOffset())
				.setMaxResults(query.getLimit())
				.getResultList().stream();
	}

	public int count(Query<E, String> query, CrudFilter filter) {
		return (int) fetch(query, filter).count();
	}

}