package com.havkathon.defistock.repository;


import com.havkathon.defistock.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}