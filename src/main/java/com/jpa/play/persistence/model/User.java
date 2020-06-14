package com.jpa.play.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id ;
	private String name ;
	private String teamName ;
	private Integer salary ;

	public User() {
	}


	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public Integer getSalary() {
		return this.salary;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof User)) return false;
		final User other = (User) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
		final Object this$name = this.getName();
		final Object other$name = other.getName();
		if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
		final Object this$teamName = this.getTeamName();
		final Object other$teamName = other.getTeamName();
		if (this$teamName == null ? other$teamName != null : !this$teamName.equals(other$teamName))
			return false;
		final Object this$salary = this.getSalary();
		final Object other$salary = other.getSalary();
		if (this$salary == null ? other$salary != null : !this$salary.equals(other$salary))
			return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof User;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $name = this.getName();
		result = result * PRIME + ($name == null ? 43 : $name.hashCode());
		final Object $teamName = this.getTeamName();
		result = result * PRIME + ($teamName == null ? 43 : $teamName.hashCode());
		final Object $salary = this.getSalary();
		result = result * PRIME + ($salary == null ? 43 : $salary.hashCode());
		return result;
	}

	public String toString() {
		return "User(id=" + this.getId() + ", name=" + this.getName() + ", teamName=" + this.getTeamName() + ", salary=" + this.getSalary() + ")";
	}
}
