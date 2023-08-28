package de.dataport.bugs.views.shared;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Table(name = "data")
public class Collection {

	@Id
	@GeneratedValue
	private Long id;

	@Setter
	@OneToMany(fetch = FetchType.EAGER)
	private List<Data> list;

}
