package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;

import java.util.*;

import static java.util.Set.copyOf;

public class StudentDb {

    private final Map <String, Student> students = new HashMap<>();

    public StudentDb(Map students) {
        students.putAll(students);
    }

    public StudentDb(ArrayList<Student> student){
        for (Student s : student){
            this.students.put(s.getId(), s);
        }
    }

    public StudentDb(Student[] student) {
        for (Student s : student){
            this.students.put(s.getId(), s);
        }
    }

    public StudentDb(Student student) {
            this.students.put(student.getId(), student);
        }

    public StudentDb(){

    }

    public List<Student> list(){
        return List.copyOf(students.values());
    }

    @Override
    public String toString() {
        return "StudentDb{" +
                "students=" + students +
                '}';
    }

    public Student randomStudent() {
        List<Student> studentList = new ArrayList<Student>(students.values());
        int index = (int) Math.floor(Math.random() * studentList.size());
        return studentList.get(index);
    }

    public void add(Student student) {
        students.put(student.getId(), student);
    }

    public void remove(Student student) {
        students.remove(student.getId(), student);
        }

    public Student findById(String id) {
        return students.get(id);
    }

    public void removeById(String id){
        this.remove(findById(id));
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
}
