package model;

public class Category {

    private int idCaetgory;
    private String nameCategory;

    public Category() {
    }

    public Category(int idCaetgory, String nameCategory) {
        this.idCaetgory = idCaetgory;
        this.nameCategory = nameCategory;
    }

    public int getIdCaetgory() {
        return idCaetgory;
    }

    public void setIdCaetgory(int idCaetgory) {
        this.idCaetgory = idCaetgory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
