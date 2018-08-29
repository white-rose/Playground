package com.crystal.Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private int currentYearOfStudy;

    public Student(int id, String name, int currentYearOfStudy) {
        this.id = id;
        this.name = name;
        this.currentYearOfStudy = currentYearOfStudy;
    }

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

    public int getCurrentYearOfStudy() {
        return currentYearOfStudy;
    }

    public void setCurrentYearOfStudy(int currentYearOfStudy) {
        this.currentYearOfStudy = currentYearOfStudy;
    }

    @Override
    public int compareTo(Student student) {
        return (this.id - student.id);
    }

    public static Comparator<Student> idComperator = Comparator.comparingInt(Student::getId);

    public static Comparator<Student> currentYearComparator = Comparator.comparingInt(Student::getCurrentYearOfStudy);

    public static void main (String args[]) {

        Student[] studentArray = new Student[3];
        studentArray[0] = new Student(1, "Nikos", 1);
        studentArray[1] = new Student(5, "Ilias", 4);
        studentArray[2] = new Student(4, "Bryson",  5);

        Arrays.sort(studentArray, Student.idComperator);
        System.out.println("Using id as key :"+ Arrays.toString(studentArray));

        Arrays.sort(studentArray, Student.currentYearComparator);
        System.out.println("Using Current Year of Study as key :"+Arrays.toString(studentArray));

    }

}
