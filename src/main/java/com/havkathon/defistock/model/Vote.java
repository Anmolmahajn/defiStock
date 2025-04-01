package com.havkathon.defistock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId; // Simulates a customer voting
    private String itemName; // Item being voted for
    private double pointsSpent; // Points used to vote

    // Default constructor for JPA
    public Vote() {}

    // Constructor for convenience
    public Vote(Long userId, String itemName, double pointsSpent) {
        this.userId = userId;
        this.itemName = itemName;
        this.pointsSpent = pointsSpent;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public double getPointsSpent() { return pointsSpent; }
    public void setPointsSpent(double pointsSpent) { this.pointsSpent = pointsSpent; }
}
