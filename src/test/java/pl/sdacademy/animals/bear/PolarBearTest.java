package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.sdacademy.clock.Clock;

import static org.assertj.core.api.Assertions.assertThat;

class PolarBearTest {

    @Test
    void polarBearShouldBeHibernatingBeforeOct10() {
        Clock clock = Mockito.mock(Clock.class);
        Mockito.when(clock.getCurrentTime()).thenReturn(new DateTime(2017, 11, 1, 14, 0));
        Bear bear = new PolarBear(10, clock);

        boolean result = bear.isHibernating();

        assertThat(result).isTrue();
    }

    @Test
    void polarBearShouldBeHibernatingAfterMay5() {
        Clock clock = Mockito.mock(Clock.class);
        Mockito.when(clock.getCurrentTime()).thenReturn(new DateTime(2017, 2, 1, 14, 0));
        Bear bear = new PolarBear(10, clock);

        boolean result = bear.isHibernating();

        assertThat(result).isTrue();
    }
}
