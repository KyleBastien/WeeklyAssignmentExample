package com.example.ad340kylebastienweeklyassignments;

public class ProfileData {
    String name;
    int age;
    String occupation;
    String description;

    public ProfileData(String name, int age, String occupation, String description) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getDescription() {
        return description;
    }
}
