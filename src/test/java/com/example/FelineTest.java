package com.example;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void shouldEatMeat() {
        // Arrange
        Feline feline = new Feline();
        List<String> result = List.of("");
        // Act
        try {
            result = feline.eatMeat();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        // Assert
        MatcherAssert.assertThat(
                "Кошачьи должны есть мясо.",
                result,
                is(List.of("Животные", "Птицы", "Рыба"))
        );
    }

    @Test
    public void shouldBeFeline() {
        // Arrange
        Feline feline = new Feline();
        // Act
        String result = feline.getFamily();
        // Assert
        MatcherAssert.assertThat("Feline, это семейство кошачьих.", result, is("Кошачьи"));
    }

    @Test
    public void shouldHaveOneKittenByDefault() {
        //Arrange
        Feline feline = new Feline();
        //Act
        int result = feline.getKittens();
        //Assert
        MatcherAssert.assertThat("У кошачьих по умолчанию 1 котёнок.", result, is(1));
    }

    @Test
    public void shouldHaveGivenNumberOfKittens() {
        //Arrange
        Feline feline = new Feline();
        int expectedResult = 7;
        //Act
        int result = feline.getKittens(expectedResult);
        //Assert
        MatcherAssert.assertThat(String.format("Котят должно быть %d.", expectedResult), result, is(expectedResult));
    }
}
