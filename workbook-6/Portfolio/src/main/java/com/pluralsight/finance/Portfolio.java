package com.pluralsight.finance;
import java.util.*;

public class Portfolio {
    /*---------------VARIABLES---------------*/

    private String name;
    private String owner;
    private List<IValuable> assets;

    /*--------------CONSTRUCTORS-------------*/

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        assets = new LinkedList<>();
    }

    /*------------GETTERS/SETTERS------------*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<IValuable> getAssets() {
        return assets;
    }

    public void setAssets(List<IValuable> assets) {
        this.assets = assets;
    }

    /*---------------FUNCTIONS---------------*/

    public void add(IValuable asset){
        assets.add(asset);
    }

    public IValuable getMostValuable(){
        IValuable mostValuable = assets.get(0);

        for (IValuable asset:assets){
            if(asset.getValue() > mostValuable.getValue()){
                mostValuable = asset;
            }
        }

        return mostValuable;
    }

    public IValuable getLeastValuable(){
        IValuable mostValuable = assets.get(0);

        for (IValuable asset:assets){
            if(asset.getValue() < mostValuable.getValue()){
                mostValuable = asset;
            }
        }

        return mostValuable;
    }

    public double getValue(){
        double total = 0.0;

        for (IValuable asset : assets){
            total += asset.getValue();
        }

        return total;
    }
}
