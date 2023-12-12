package com.example.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame")
                .burgers(1)
                .ingredient("tomato")
                .ingredient("salad")
                .ingredient("vegan cheese")
                .sauce("mayo")
                .build();

        System.out.println(bigmac);

        //When
        String whatBun = bigmac.getBun();
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyBurgers = bigmac.getBurgers();
        String whatSauce = bigmac.getSauce();

        //Then
        assertEquals("sesame", whatBun);
        assertEquals(3, howManyIngredients);
        assertEquals(1, howManyBurgers);
        assertEquals("mayo", whatSauce);
    }
}
