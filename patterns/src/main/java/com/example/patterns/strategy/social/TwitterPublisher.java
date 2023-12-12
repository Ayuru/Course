package com.example.patterns.strategy.social;

public class TwitterPublisher implements SocialPublisher {
    public String share() {
        return "Twitter (or X)";
    }
}
