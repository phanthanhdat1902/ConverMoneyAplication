package com.example.convermoneyaplication;

public class MoneyClass {
    private String name;
    private String logo;
    private float covertUSD;

    public MoneyClass(String name, String logo, float coverUSD) {
        this.name = name;
        this.logo = logo;
        this.covertUSD = coverUSD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public float getCoverUSD() {
        return covertUSD;
    }

    public void setCoverUSD(float coverUSD) {
        this.covertUSD = coverUSD;
    }
}
