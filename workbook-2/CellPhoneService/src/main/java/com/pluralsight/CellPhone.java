package com.pluralsight;

public class CellPhone {
    /*-----------VARIABLES---------------*/
    private long serialNumber;
    private String model;
    private String carrier;
    private String phoneNumber;
    private String owner;

    /*------------CONSTRUCTORS-----------*/
    public CellPhone(){ //generic
        serialNumber = 0;
        model = "";
        carrier ="";
        phoneNumber ="";
        owner ="";
    }

    public CellPhone(long serialNumber, String model, String carrier, String phoneNumber, String owner) { //everything
        this.setSerialNumber(serialNumber);
        this.setModel(model);
        this.setCarrier(carrier);
        this.setPhoneNumber(phoneNumber);
        this.setOwner(owner);
    }

    /*----------GETTERS/SETTERS----------*/
    public long getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getCarrier() {
        return carrier;
    }
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /*-------------FUNCTIONS-------------*/
    public void dial(String phoneNumber){ //calls a given phone number
        System.out.println(this.owner + " is calling " + phoneNumber);
    }
    public void dial(CellPhone phone){ //calls a given phone number
        System.out.println(this.owner + " is calling " + phone.getPhoneNumber());
    }
}
