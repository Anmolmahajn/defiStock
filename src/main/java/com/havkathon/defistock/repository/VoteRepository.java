package com.havkathon.defistock.repository;

import com.havkathon.defistock.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("SELECT v.itemName, SUM(v.pointsSpent) as totalPoints FROM Vote v GROUP BY v.itemName ORDER BY totalPoints DESC")
    List<Object[]> findVoteTotalsByItem();
}