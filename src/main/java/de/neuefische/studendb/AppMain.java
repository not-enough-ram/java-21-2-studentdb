package de.neuefische.studendb;

import de.neuefische.studendb.db.StudentDb;
import de.neuefische.studendb.model.ChemistryStudent;
import de.neuefische.studendb.model.RocketScienceStudent;
import de.neuefische.studendb.model.Student;

public class AppMain {

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new RocketScienceStudent("Jane", "42"),
                new ChemistryStudent("Klaus", "13"),
                new RocketScienceStudent("Franky", "100"),
                new Student("Holliday", "200")
        };
        StudentDb studentDb = new StudentDb(students);

        for (Student student : studentDb.list()) {
            System.out.println(student.getSpecialSkill());
        }

    }

}
