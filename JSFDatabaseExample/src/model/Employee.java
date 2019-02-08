package model;


public class Employee {

	
	private String name;
	private String surname;
	private int age;
	private int id;
	

	public Employee() {
		super();
	}
	
	public Employee(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public Employee(String name, String surname, int age, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
