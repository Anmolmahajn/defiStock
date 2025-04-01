package com.havkathon.defistock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory {
    @Id
    private Long id;
    private String itemName;
    private int quantity;
    private Long retailerId;
    private double fundingGoal;
    private double currentFunding;

    // Default constructor for JPA
    public Inventory() {}

    // Business logic for funding
    public void addFunding(double amount) {
        this.currentFunding += amount;
        if (this.currentFunding >= this.fundingGoal) {
            this.quantity += 50; // Auto-restock 50 units
            this.currentFunding = 0; // Reset funding
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Long getRetailerId() { return retailerId; }
    public void setRetailerId(Long retailerId) { this.retailerId = retailerId; }
    public double getFundingGoal() { return fundingGoal; }
    public void setFundingGoal(double fundingGoal) { this.fundingGoal = fundingGoal; }
    public double getCurrentFunding() { return currentFunding; }
    public void setCurrentFunding(double currentFunding) { this.currentFunding = currentFunding; }
}