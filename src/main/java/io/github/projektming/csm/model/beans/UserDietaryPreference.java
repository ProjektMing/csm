package io.github.projektming.csm.model.beans;

public class UserDietaryPreference {
    private int preferenceId;
    private int userId;
    private int preferenceTypeId;
    private short preferenceLevel;

    // Getters and Setters
    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPreferenceTypeId() {
        return preferenceTypeId;
    }

    public void setPreferenceTypeId(int preferenceTypeId) {
        this.preferenceTypeId = preferenceTypeId;
    }

    public short getPreferenceLevel() {
        return preferenceLevel;
    }

    public void setPreferenceLevel(short preferenceLevel) {
        this.preferenceLevel = preferenceLevel;
    }
}

