package com.associations.manytomany.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
	private Set<Programmer> programmers;

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

	public Set<Programmer> getProgrammers() {
		return programmers;
	}

	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
	public void addProgrammer(Programmer programmer) {
		if (programmer != null) {
			if (programmers == null) {
				programmers = new HashSet<>();
			}
			programmers.add(programmer);
			
			HashSet<Project> projects = new HashSet<>();
			projects.add(this);
			programmer.setProjects(projects);
		}
	}
}
