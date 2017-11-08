package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import pl.sdacademy.clock.Clock;
import pl.sdacademy.clock.DateTimeClock;

import static org.assertj.core.api.Assertions.assertThat;

class BlackBearTest {

    @Test
    void blackBearShouldBeHibernatingAfterNov20() {
        Clock clock = mock(Clock.class);
        when(clock.getCurrentTime()).thenReturn(new DateTime(2017, 12, 01, 14, 0));
        BlackBear bear = new BlackBear(10, new TestClock());

        boolean result = bear.isHibernatingAfterNov20();

        assertThat(result).isTrue();
    }

    @Test
    void blackBearShouldSleepBeforeMar15() {
        BlackBear bear = new BlackBear(10, new TestClock());

        boolean result = bear.isHibernatingBeforeMar15();

        assertThat(result).isTrue();
    }


}
