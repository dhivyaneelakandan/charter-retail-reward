package com.charter.retail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.retail.services.CustRewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    @Autowired
    private CustRewardService rewardService;

    @PostMapping("/calculate/{transactionId}")
    public ResponseEntity<Integer> calculateRewardPoints(@PathVariable Long transactionId) {
        int points = rewardService.calculateAndSaveRewardPoints(transactionId);
        return ResponseEntity.ok(points);
    }
}
