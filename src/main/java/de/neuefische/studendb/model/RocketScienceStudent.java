package de.neuefische.studendb.model;

public class RocketScienceStudent extends Student {

    private String codingSkills;

    public RocketScienceStudent(String name, String id, String specialSkill) {
        super(name, id, specialSkill);
        this.codingSkills = specialSkill;
    }

    @Override
    public String getSpecialSkill() {
        return codingSkills;
    }

    public void setCodingSkills(String codingSkills) {
        this.codingSkills = codingSkills;
    }

    public RocketScienceStudent(String name, String id, String codingSkills) {
        super(name, id);
        this.codingSkills = codingSkills;
    }
}