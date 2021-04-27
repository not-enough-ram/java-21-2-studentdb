package de.neuefische.studendb.model;

public class ChemistryStudent extends Student {

    public ChemistryStudent(String name, String id) {
        super(name, id);
    }

    public String getSpecialSkill() {
        return "Can create bombs from fertilizer.";
    }

}