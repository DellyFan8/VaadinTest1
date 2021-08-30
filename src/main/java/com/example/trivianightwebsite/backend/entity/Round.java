package com.example.trivianightwebsite.backend.entity;

import javax.persistence.*;


@Entity
@Table(name = "rounds")
public class Round {

	private int id;
	private String name;
	private String is_open;

	public Round() {
		
	}
	public Round(int id, String name, String is_open) {
		super();
		this.id = id;
		this.name = name;
		this.is_open = is_open;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public String getIs_open() {
		return is_open;
	}
	public void setIs_open(String is_open) {
		this.is_open = is_open;
	}
	
	
	
}
