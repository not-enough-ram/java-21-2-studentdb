package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

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
        StudentDb studentsDb = new StudentDb();
        studentsDb.add(new Student("Jane", "42"));
        studentsDb.add(new Student("Klaus", "13"));
        studentsDb.add(new Student("Franky", "100"));



        // When
        List actual = studentsDb.list();

        // Then
        StudentDb expected = new StudentDb();
        expected.add(new Student("Jane", "42"));
        expected.add(new Student("Klaus", "13"));
        expected.add(new Student("Franky", "100"));

        assertTrue(expected.list().equals(actual));
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
        StudentDb students = new StudentDb();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Kai", "13"));
        students.add(new Student("Kani", "666"));

        Student expected = new Student("Jane", "42");
        String id = "42";

        // WHEN
        Student actual = students.findById(id);

        // THEN
        assertEquals(expected, actual);

    }

    @Test
    void findByIdNoMatchTest() {
        // GIVEN
        StudentDb students = new StudentDb();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Kai", "13"));
        students.add(new Student("Kani", "666"));

        String id = "43";

        // WHEN
        Student actual = students.findById(id);

        // THEN
        assertNull(actual);

    }

    @Test
    void findByIdNoListTest() {
        // GIVEN
        StudentDb students = new StudentDb();

        String id = "43";

        // WHEN
        Student actual = students.findById(id);

        // THEN
        assertNull(actual);

    }

    @Test
    void removeById() {
        // GIVEN
        StudentDb students = new StudentDb();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Kai", "13"));
        students.add(new Student("Kani", "666"));

        StudentDb studentsExpected = new StudentDb();
        studentsExpected.add(new Student("Kai", "13"));
        studentsExpected.add(new Student("Kani", "666"));

        String id = "42";

        // WHEN
        students.removeById(id);

        // THEN
        assertTrue(students.equals(studentsExpected));