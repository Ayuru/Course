package com.example.patterns.strategy.social;

public class YGeneration extends User {

    public YGeneration(String name) {
        super(name);
        this.socialPublisher = new SnapchatPublisher();
    }
}
