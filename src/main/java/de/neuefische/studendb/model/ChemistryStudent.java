package de.neuefische.studendb.model;

public class ChemistryStudent extends Student {

    private String createChemicals;

    public ChemistryStudent(String name, String id) {
        super(name, id);
    }

    @Override
    public String getSpecialSkill() {
        return "Can create bombs from fertilizer.";
    }

    public void setCreateChemicals(String createChemicals) {
        this.createChemicals = createChemicals;
    }
}