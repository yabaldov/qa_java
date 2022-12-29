package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalType;
    private final List<String> expectedFood;
    private final String expectedExceptionMessage;

    public AnimalTest(String animalType, List<String> expectedFood, String expectedExceptionMessage) {
        this.animalType = animalType;
        this.expectedFood = expectedFood;
        this.expectedExceptionMessage = expectedExceptionMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения"), null},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), null},
                {"Неизвестное", null, "Неизвестный вид животного, используйте значение Травоядное или Хищник"}
        };
    }

    @Test
    public void shouldEatFoodByItsType() {
        Animal animal = new Animal();
        List<String> result = null;
        Exception exception = new Exception();

        try {
            result = animal.getFood(animalType);
        } catch(Exception e) {
            exception = e;
        } finally {
            MatcherAssert.assertThat(
                    "Животное должно есть пищу, соответствующую его виду.",
                    result,
                    is(expectedFood)
            );
            MatcherAssert.assertThat(
                    "Для неизвестного вида должно быть правильное сообщение в исключении.",
                     exception.getMessage(),
                    is(expectedExceptionMessage)
            );
        }
    }
}
