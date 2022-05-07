package com.example.vsfsotazky;

import android.content.res.Resources;

import java.util.ArrayList;

public class Question {
    private int id;
    public String name;
    public String description;

    public Question(int id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
    }

    //region Get&Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //endregion
}
