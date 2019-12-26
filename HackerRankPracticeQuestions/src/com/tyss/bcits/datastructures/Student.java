package com.tyss.bcits.datastructures;

public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private double marks;

	public Student(int id, String name, double marks) {

		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getMarks() {
		return marks;
	}

	@Override
	public int compareTo(Student o) {

		return this.name.compareTo(o.name);
	}

}
