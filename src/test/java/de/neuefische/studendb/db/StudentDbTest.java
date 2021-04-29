package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                expected.add(new Student("Jane", "42")),
                expected.add(new Student("Klaus", "13")),
                expected.add(new Student("Franky", "100"))
        };
        assertArrayEquals(expected, actual);
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
}