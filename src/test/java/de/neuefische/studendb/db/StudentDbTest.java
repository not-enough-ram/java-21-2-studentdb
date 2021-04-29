package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentDbTest {

    private static Arguments[] provideTestAddArguments() {
        return new Arguments[]{
                Arguments.of(
                        new Student[]{
                                new Student("Student 1", "1"),
                                new Student("Student 2", "2")
                        },
                        new Student[]{
                                new Student("Student 1", "1"),
                                new Student("Student 2", "2"),
                                new Student("Jane", "42")
                        }
                ),
                Arguments.of(
                        new Student[]{},
                        new Student[]{new Student("Jane", "42")}
                )
        };
    }

    private static Arguments[] provideTestRemoveArguments() {
        return new Arguments[]{
                Arguments.of(
                        new Student[]{
                                new Student("Hans", "12"),
                                new Student("Jane", "42"),
                                new Student("Peter", "23")
                        },
                        new Student[]{
                                new Student("Hans", "12"),
                                new Student("Peter", "23")
                        }
                ),
                Arguments.of(
                        new Student[]{
                                new Student("Hans", "12"),
                                new Student("Peter", "23")
                        },
                        new Student[]{
                                new Student("Hans", "12"),
                                new Student("Peter", "23")
                        }
                ),
                Arguments.of(
                        new Student[]{
                                new Student("Jane", "42"),
                                new Student("Hans", "12"),
                                new Student("Peter", "23")
                        },
                        new Student[]{
                                new Student("Hans", "12"),
                                new Student("Peter", "23")
                        }
                ),
                Arguments.of(
                        new Student[]{
                                new Student("Hans", "12"),
                                new Student("Peter", "23"),
                                new Student("Jane", "42")
                        },
                        new Student[]{
                                new Student("Hans", "12"),
                                new Student("Peter", "23")
                        }
                ),
                Arguments.of(
                        new Student[]{},
                        new Student[]{}
                ),
                Arguments.of(
                        new Student[]{new Student("Jane", "42")},
                        new Student[]{}
                )
        };
    }

    @Test
    @DisplayName("list() returns all students in the db")
    public void testList() {
        // Given
        ArrayList<Student> students = new ArrayList<>();
               students.add(new Student("Jane", "42"));
               students.add(new Student("Klaus", "13"));
               students.add(new Student("Franky", "100"));

        StudentDb studentDb = new StudentDb(students);

        // When
        ArrayList<Student> actual = studentDb.list();

        // Then
        ArrayList<Student> expected = new ArrayList<>();
                expected.add(new Student("Jane", "42"));
                expected.add(new Student("Klaus", "13"));
                expected.add(new Student("Franky", "100"));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toString() returns a formatted list of all students")
    public void testToString() {
        // Given
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Klaus", "13"));
        students.add(new Student("Franky", "100"));

        StudentDb studentDb = new StudentDb(students);

        // When
        String actual = studentDb.toString();

        // Then
        String expected = "Student{name='Jane', id='42'}\n"
                + "Student{name='Klaus', id='13'}\n"
                + "Student{name='Franky', id='100'}\n";
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideTestAddArguments")
    void add(Student[] given, Student[] expectedArray) {
        // GIVEN
        Student jane = new Student("Jane", "42");
        StudentDb expected= new StudentDb(expectedArray);
        StudentDb actual = new StudentDb(given);

        //WHEN
        actual.add(jane);

        // THEN
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @MethodSource("provideTestRemoveArguments")
    void remove(Student[] givenArray, Student[] expectedArray) {
        // GIVEN
        Student jane = new Student("Jane", "42");
        StudentDb expected= new StudentDb(expectedArray);
        StudentDb actual = new StudentDb(givenArray);

        //WHEN
        actual.remove(jane);

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void findByIdTest() {
        // GIVEN
        ArrayList students = new ArrayList();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Kai", "13"));
        students.add(new Student("Kani", "666"));

        StudentDb studentDb = new StudentDb(students);

        Student expected = new Student("Jane", "42");
        String id = "42";

        // WHEN
        Student actual = studentDb.findById(id);

        // THEN
        assertEquals(expected, actual);

    }

    @Test
    void findByIdNoMatchTest() {
        // GIVEN
        ArrayList students = new ArrayList();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Kai", "13"));
        students.add(new Student("Kani", "666"));

        StudentDb studentDb = new StudentDb(students);

        String id = "43";

        // WHEN
        Student actual = studentDb.findById(id);

        // THEN
        assertNull(actual);

    }

    @Test
    void findByIdNoListTest() {
        // GIVEN
        ArrayList students = new ArrayList();

        StudentDb studentDb = new StudentDb(students);

        String id = "43";

        // WHEN
        Student actual = studentDb.findById(id);

        // THEN
        assertNull(actual);

    }

    @Test
    void removeById() {
        // GIVEN
        ArrayList students = new ArrayList();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Kai", "13"));
        students.add(new Student("Kani", "666"));

        ArrayList studentsExpected = new ArrayList();
        studentsExpected.add(new Student("Kai", "13"));
        studentsExpected.add(new Student("Kani", "666"));

        StudentDb studentDbExpected = new StudentDb(studentsExpected);
        StudentDb studentDb = new StudentDb(students);

        String id = "42";

        // WHEN
        studentDb.removeById(id);

        // THEN
        assertEquals(studentsExpected, studentDb.list());
    }
}