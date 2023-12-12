package com.example.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher {

    public String share() {
        return "Facebook";
    }
}
