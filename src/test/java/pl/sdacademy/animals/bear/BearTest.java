package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.jupiter.api.Test;

import pl.sdacademy.clock.Clock;

import static org.assertj.core.api.Assertions.assertThat;

import pl.sdacademy.exception.BearHibernatingException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BearTest {

    @Test
    void bearShouldBeAliveIfHasEatenWithin10Days() {
        Bear bear = new BlackBear(1);
        bear.eat();

        assertThat(bear.isAlive()).isTrue();
    }

    @Test
    void feedingBearShouldSetTheDateOfTheLastMealForNow() {
        Bear bear = new BlackBear(1);
        bear.eat();

        assertThat(new Duration(bear.getLastMealTime(), DateTime.now()).isShorterThan(Duration.standardSeconds(1)))
                .isTrue();
    }

    @Test
    void bearShouldNotBeAliveIfItHasNotEatenForMoreThan10Days() {
        Bear bear = new BlackBear(1, new TestClock());

        boolean result = bear.isAlive();

        assertThat(result).isFalse();
    }

    @Test
    void bearShouldWeighMoreAfterEating() {
        Bear bear = new BlackBear(10);
        int oldWeight = bear.getWeight();
        bear.eat(1);

        int newWeight = bear.getWeight();

        assertThat(newWeight > oldWeight).isTrue();
    }

    @Test
    void bearShouldWeighMoreAfterDrinkingWater() {
        Bear bear = new BlackBear(10);
        int oldWeight = bear.getWeight();
        bear.drink(4);

        int newWeight = bear.getWeight();

        assertThat(newWeight > oldWeight).isTrue();
    }

    @Test
    void bearShouldWeighLessAfterDoingPoop() {
        Bear bear = new BlackBear(100);
        int oldWeight = bear.getWeight();
        bear.poop();

        int newWeight = bear.getWeight();

        assertThat(newWeight < oldWeight).isTrue();
    }
    @Test
    void blackBearShouldBeHibernatingIfItIsAfter20November() {
        Clock clock = mock(Clock.class);
        when(clock.getCurrentTime()).thenReturn(new DateTime(2017, 12, 01, 14, 0));
        BlackBear bear = new BlackBear(1, clock);

        boolean result = bear.isHibernating();

        assertThat(result).isTrue();
    }

    @Test
    void shouldThrowExceptionIfTryingToFeedAHibernatingBear() {
        Clock clock = mock(Clock.class);
        when(clock.getCurrentTime()).thenReturn(new DateTime(2017, 12, 01, 14, 0));
        BlackBear bear = new BlackBear(1, clock);
        assert bear.isHibernating();

        boolean result = bear.isHibernating();

        assertThrows(BearHibernatingException.class, () -> bear.eat());
    }
}