package com.example;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void shouldMeow() {
        //Arrange
        Cat cat = new Cat(feline);
        //Act
        String result = cat.getSound();
        //Assert
        MatcherAssert.assertThat("Кошка мяукает: \"Мяу\".", result, is("Мяу"));
    }

    @Test
    public void shouldEatMeat() {
        //Arrange
        Cat cat = new Cat(feline);

        try {
            //Act
            cat.getFood();
            //Assert
            Mockito.verify(feline).eatMeat();
        } catch (Exception e) {
            MatcherAssert.assertThat("Здесь не должно быть исключения. ", e, is(nullValue()));
        }
    }
}
