package com.jpa.play.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = {"id"})
public class Users {

	@Id
	@GeneratedValue
	private Long id ;
	private String name ;
	private String teamName ;
	private Integer salary ;


}
