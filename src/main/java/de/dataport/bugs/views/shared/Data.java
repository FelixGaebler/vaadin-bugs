package de.dataport.bugs.views.shared;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "data")
public class Data {

	@Id
	@GeneratedValue
	private Long id;

	@Setter
	private String text;

}
