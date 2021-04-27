package de.neuefische.studendb.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RocketScienceStudentTest {

    @Test
    @DisplayName("Can literally hack everything in los")
    void getSpecialSkill() {
        // GIVEN
        String canHack = "Can hack every device in line of sight.";
        Student rocketScienceStudent = new RocketScienceStudent("Abe", "404");

        // WHEN
        String actual = rocketScienceStudent.getSpecialSkill();

        // THEN
        assertEquals(canHack, actual);
    }
}