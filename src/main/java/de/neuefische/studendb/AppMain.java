package de.neuefische.studendb;

import de.neuefische.studendb.db.StudentDb;
import de.neuefische.studendb.model.RocketScienceStudent;
import de.neuefische.studendb.model.Student;

public class AppMain {

    public static void main(String[] args) {
        RocketScienceStudent[] students = new RocketScienceStudent[]{
                new RocketScienceStudent("Jane", "42", "Haskell"),
                new RocketScienceStudent("Klaus", "13", "Java"),
                new RocketScienceStudent("Franky", "100", "Python");
        };
        StudentDb studentDb = new StudentDb(students);

        for(int i=0; i < 5; i++){
            System.out.println(studentDb.randomStudent());
        }

    }

}
