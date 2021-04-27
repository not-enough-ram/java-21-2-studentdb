package de.neuefische.studendb.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChemistryStudentTest {

    @Test
    @DisplayName("Very useful skill during Z apocalypse")
    void getSpecialSkill() {
        // GIVEN
        String bombs = "Can create bombs from fertilizer.";
        Student chemistryStudent = new ChemistryStudent("William", "190");

        //WHEN
        String actual = chemistryStudent.getSpecialSkill();

        //THEN
        assertEquals(bombs, actual);
    }
}