package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.sdacademy.clock.Clock;

import static org.assertj.core.api.Assertions.assertThat;

class BlackBearTest {

    @Test
    void blackBearShouldBeHibernatingAfterNov20() {
        Clock clock = Mockito.mock(Clock.class);
        Mockito.when(clock.getCurrentTime()).thenReturn(new DateTime(2017, 12, 01, 14, 0));
        Bear bear = new BlackBear(10, clock);

        boolean result = bear.isHibernating();

        assertThat(result).isTrue();
    }

    @Test
    void blackBearShouldSleepBeforeMar15() {
        Clock clock = Mockito.mock(Clock.class);
        Mockito.when(clock.getCurrentTime()).thenReturn(new DateTime(2017, 2, 10, 14, 0));
        Bear bear = new BlackBear(10, clock);

        boolean result = bear.isHibernating();

        assertThat(result).isTrue();
    }

    /**
     * tabelka groovy
     * where:
     * date << [new DateTime(), new DateTime(), ... ]
     */

    /**
     * dwa w jednym
     * where:
     * date | expected
     * newDate(...) | false
     */

    @Test
    void blackBearShouldNotSleepAfterMar15AndBeforeNov20() {
        Clock clock = Mockito.mock(Clock.class);
        Mockito.when(clock.getCurrentTime()).thenReturn(new DateTime(2017, 4, 10, 14, 0));
        Bear bear = new BlackBear(10, clock);

        boolean result = bear.isHibernating();

        assertThat(result).isTrue();
    }
}
