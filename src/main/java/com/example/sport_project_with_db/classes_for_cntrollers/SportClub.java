package com.example.sport_project_with_db.classes_for_cntrollers;

public class SportClub {
    int id;
    String name;

    public SportClub(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
