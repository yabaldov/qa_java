package com.example;

import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Predator predator;

    @Test
    public void shouldThrowExceptionIfSexUndefined() {
        //Arrange
           Exception exception = new Exception();
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        //Act
        try {
            Lion lion = new Lion(predator, "Неопределённый");
        } catch(Exception e) {
            exception = e;
        }
        // Assert
        MatcherAssert.assertThat(
                "Должно выбрасываться исключение, если пол не \"Самец\" или \"Самка\".",
                exception.getMessage(),
                is(expected)
        );
    }

    @Test
    public void shouldGetKittens() throws Exception {
        // Arrange
        Lion lion = new Lion(predator, "Самка");
        int expectedKittens = 1;
        Mockito.when(predator.getKittens()).thenReturn(expectedKittens);
        // Act
        int result = lion.getKittens();
        // Assert
        MatcherAssert.assertThat(
                "Метод должен возвращать такое же число котят, как метод указанной в конструкторе зависимости.",
                result,
                is(expectedKittens)
                );
    }

    @Test
    public void shouldGetFood () throws Exception {
        // Arrange
        Lion lion = new Lion(predator, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(predator.eatMeat()).thenReturn(expectedFood);
        // Act
        List<String> result = lion.getFood();
        // Assert
        MatcherAssert.assertThat(
                "Метод должен возвращать такую же пищу, как метод указанной в конструкторе зависимости.",
                result,
                is(expectedFood)
        );
    }
}
