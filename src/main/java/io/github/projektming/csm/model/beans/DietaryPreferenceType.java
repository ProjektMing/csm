package io.github.projektming.csm.model.beans;

public class DietaryPreferenceType {
    private int preferenceTypeId;
    private String name;
    private String description;

    // Getters and Setters
    public int getPreferenceTypeId() {
        return preferenceTypeId;
    }

    public void setPreferenceTypeId(int preferenceTypeId) {
        this.preferenceTypeId = preferenceTypeId;
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
}

