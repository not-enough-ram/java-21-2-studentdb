package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;

import java.util.ArrayList;

public class StudentDb {

    private ArrayList<Student> students;

    public StudentDb(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> list() {
        return students;
    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < students.size(); i++) {
            result += students.get(i) + "\n";
        }
        return result;
    }

    public Student randomStudent() {
        int index = (int) Math.floor(Math.random() * students.size());
        return students.get(index);
    }

    public void add(Student student) {
        students.add(student);
    }

    public void remove(Student student) {
        students.remove(student);
        }
}
