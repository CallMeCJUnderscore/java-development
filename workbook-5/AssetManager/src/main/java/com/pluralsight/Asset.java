package com.pluralsight;

import java.util.ArrayList;

public class Asset {

    /*---------------VARIABLES---------------*/

    String description;
    String dateAcquired;
    double originalCost;

    /*--------------CONSTRUCTORS-------------*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(double originalCost) {
        this.originalCost = originalCost;
    }

    /*------------GETTERS/SETTERS------------*/

    public Asset(String description, String dateAcquired, double originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }



    /*---------------FUNCTIONS---------------*/

    public double getValue(){
        return originalCost;
    }


    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(new House("Main home", "Jan 2020", 100000, "Tampa", 1, 700, 1200));
        assets.add(new House("Vacation home", "Jan 2021", 100000, "Acapulco", 1, 1500, 3000));

        assets.add(new Vehicle("Car", "Feb 2023", 50000, "Toyota Somethin", 2023, 5432));
        assets.add(new Vehicle("Moped", "Feb 2023", 10000, "Vespa", 2023, 2000));

        for (Asset asset : assets){
            System.out.println(asset.getDescription());
            System.out.println(asset.getDateAcquired());
            System.out.println(asset.getOriginalCost());
            System.out.println(asset.getValue());
            System.out.println();
            String message = "";
            if (asset instanceof House house) {
                message = "House at " + house.getAddress();
            }
            else if (asset instanceof Vehicle vehicle) {
                message = "Vehicle: " +
                        vehicle.getYear() + " " + vehicle.getMakeModel();
            }
            System.out.println(message);
        }
    }

    }

