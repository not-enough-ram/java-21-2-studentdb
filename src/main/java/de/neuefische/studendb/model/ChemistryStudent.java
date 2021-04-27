package de.neuefische.studendb.model;

public class ChemistryStudent extends Student {

    private String createChemicals;

    public ChemistryStudent(String name, String id, String specialSkill) {
        super(name, id, specialSkill);
        this.createChemicals = specialSkill;
    }

    @Override
    public String getSpecialSkill() {
        return createChemicals;
    }

    public void setCreateChemicals(String createChemicals) {
        this.createChemicals = createChemicals;
    }
}
}