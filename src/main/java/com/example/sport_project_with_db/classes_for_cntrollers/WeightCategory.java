package com.example.sport_project_with_db.classes_for_cntrollers;

public class WeightCategory {
    int id;
    String weight;

    public WeightCategory(int id, String weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
