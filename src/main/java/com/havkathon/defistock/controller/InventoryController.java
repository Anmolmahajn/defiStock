package com.havkathon.defistock.controller;

import com.havkathon.defistock.model.Inventory;
import com.havkathon.defistock.model.Vote;
import com.havkathon.defistock.repository.InventoryRepository;
import com.havkathon.defistock.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepo;

    @Autowired
    private VoteRepository voteRepo;

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("inventoryList", inventoryRepo.findAll());
        model.addAttribute("voteTotals", voteRepo.findVoteTotalsByItem());
        return "dashboard";
    }

    @PostMapping("/fund")
    public String fundItem(@RequestParam Long itemId, @RequestParam double points) {
        Inventory item = inventoryRepo.findById(itemId).orElse(null);
        if (item != null) {
            item.addFunding(points);
            inventoryRepo.save(item);
        }
        return "redirect:/dashboard";
    }

    @PostMapping("/vote")
    public String voteItem(@RequestParam String itemName, @RequestParam double points) {
        Vote vote = new Vote(1L, itemName, points); // Hardcoded userId=1 for demo
        voteRepo.save(vote);
        return "redirect:/dashboard";
    }
}