package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class StudentDb {

    private ArrayList<Student> students;

    public StudentDb(ArrayList<Student> student) {
        this.students = student;
    }

    public StudentDb(Student[] student) {
        this.students = new ArrayList<>();
        for (Student s : student){
            this.students.add(s);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDb studentDb = (StudentDb) o;
        return Objects.equals(students, studentDb.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students);
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

    public Student findById(String id) {
        if (id == null) {
            return null;
        }
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public void removeById(String id){
        this.remove(findById(id));
    }
}
