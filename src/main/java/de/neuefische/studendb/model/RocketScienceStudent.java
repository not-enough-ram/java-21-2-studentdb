package de.neuefische.studendb.model;

public class RocketScienceStudent extends Student {

    public RocketScienceStudent(String name, String id) {
        super(name, id);
    }

    @Override
    public String getSpecialSkill() {
        return "Can hack every device in line of sight.";
    }
}