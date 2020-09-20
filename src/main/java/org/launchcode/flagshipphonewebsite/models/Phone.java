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
    private String colors;
    private String size;
    private String build;
    private String resistance;
    private String processor;
    private String os;
    private String ram;
    private String camera;
    private String battery;
    private String storage;
    private String speakers;
    
    public Phone() {
    }

    // Initialize the id and value fields.
    public Phone(String aName, String aModel, String aPrice, String aColors, String aSize, String aBuild, String aResistance, String aProcessor, String aOs, String aRam, String aCamera, String aBattery, String aStorage, String aSpeakers) {
        super();
        this.name = aName;
        this.model = aModel;
        this.price = aPrice;
        this.colors = aColors;
        this.size = aSize;
        this.build = aBuild;
        this.resistance = aResistance;
        this.processor = aProcessor;
        this.os = aOs;
        this.ram = aRam;
        this.camera = aCamera;
        this.battery = aBattery;
        this.storage = aStorage;
        this.speakers = aSpeakers;
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

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }
    
    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    @Override
    public String toString() {
        return name;
    }

}