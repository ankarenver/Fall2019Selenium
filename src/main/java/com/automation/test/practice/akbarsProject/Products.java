package com.automation.test.practice.akbarsProject;



public class Products implements Comparable<Products> {
    public String productName;
    public double price;
    public String link;

    public Products(String productName, double price, String link) {
        this.productName = productName;
        this.price = price;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Products{" + " price='" + price + '\'' +
                ", link='" + link + '\'' +
                '}'+"\n";
    }


    @Override
    public int compareTo(Products o) {
        return Double.compare(this.price,o.price);
    }
}
