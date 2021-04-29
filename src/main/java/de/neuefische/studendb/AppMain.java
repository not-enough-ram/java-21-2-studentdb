package de.neuefische.studendb;

import de.neuefische.studendb.db.StudentDb;
import de.neuefische.studendb.model.Student;

import java.util.ArrayList;
import java.util.Map;

public class AppMain {

  public static void main(String[] args) {
  StudentDb studentDb = new StudentDb();
  studentDb.add(new Student("Jane", "42"));
  studentDb.add(new Student("Klaus", "13"));
  studentDb.add(new Student("Franky", "100"));

  System.out.println(studentDb);

  studentDb.remove(new Student("Jane", "42"));

  System.out.println(studentDb);

  for(int i=0; i < 5; i++){
      System.out.println(studentDb.randomStudent());
  }

}}
