package com.example.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User rena = new Millenials("Rena");
        User shiori = new YGeneration("Shiori");
        User ichiru = new ZGeneration("Ichiru");

        //When
        String renaShare = rena.sharePost();
        String shioriShare = shiori.sharePost();
        String ichiruShare = ichiru.sharePost();

        //Then
        assertEquals("Facebook", renaShare);
        assertEquals("Snapchat", shioriShare);
        assertEquals("Twitter (or X)", ichiruShare);

    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User rena = new Millenials("Rena");

        //When
        String renaShare = rena.sharePost();
        rena.setSharingStrategy(new SnapchatPublisher());
        renaShare = rena.sharePost();

        //Then
        assertEquals("Snapchat", renaShare);

    }
}
