package com.example;

import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.List;

public class AlexTheLionTest {

    @Test
    public void shouldHaveMane() throws Exception {
        AlexTheLion alex = new AlexTheLion();

        MatcherAssert.assertThat("У Алекса должна быть грива.", alex.doesHaveMane(), is(true));
    }

    @Test
    public void shouldHaveNoKittens() throws Exception {
        AlexTheLion alex = new AlexTheLion();

        MatcherAssert.assertThat("У Алекса нет львят.", alex.getKittens(), is(0));
    }

    @Test
    public void shouldHaveRightFriends() throws Exception {
        AlexTheLion alex = new AlexTheLion();

        MatcherAssert.assertThat(
                "У Алекса друзья зебра Марти, бегемотиха Глория и жираф Мелман.",
                alex.getFriends(),
                is(List.of("Марти", "Глория", "Мелман"))
                );
    }

    @Test
    public void shouldHavePlaceOfLiving() throws Exception {
        AlexTheLion alex = new AlexTheLion();

        MatcherAssert.assertThat(
                "Алекс живёт в Нью-Йоркский зоопарке.",
                alex.getPlaceOfLiving(),
                is("Нью-Йоркский зоопарк")
        );
    }

}
