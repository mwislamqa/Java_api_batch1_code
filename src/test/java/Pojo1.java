

import java.util.Random;

public class Pojo1 {
	//variable
	Random rn= new Random();
	private int id;
	private String name;
	private int salary;
	
	//pojo method
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
