package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentji")
public class Student {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "St_id")
	private int id;

	@Column(name = "St_Name")
	private String name;

	@Column(name = "St_Email")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
