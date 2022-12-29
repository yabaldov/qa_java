package com.example;

import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionManeTest {

    private final String sex;
    private final boolean expectedResult;

    public LionManeTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Predator predator;

    @Test
    public void doesHaveManeSexOnlyMaleHasMane() throws Exception {
        //Arrange
        Lion lion = new Lion(predator, sex);
        //Act
        boolean result = lion.doesHaveMane();
        //Assert
        MatcherAssert.assertThat(
                String.format("У льва самца есть грива, у самки нет. Пол этого льва: \"%s\".", sex),
                result,
                is(expectedResult)
        );
    }
}
