package org.launchcode.flagshipphonewebsite.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Phone extends AbstractEntity{

    @NotNull
    @Size(min=3, max=50)
    private String name;
    private String model;
    private String price;

    public Phone() {
    }

    // Initialize the id and value fields.
    public Phone(String aName, String anEmployer, String someSkill) {
        super();
        this.name = aName;
        this.model = anEmployer;
        this.price = someSkill;
    }

    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}
