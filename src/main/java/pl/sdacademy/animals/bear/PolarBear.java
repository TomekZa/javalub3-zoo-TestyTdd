package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pl.sdacademy.clock.Clock;

public class PolarBear extends Bear {
    public PolarBear(int weight, Clock clock) {
        super(weight, clock);
    }

    @Override
    public boolean isHibernating() {
        LocalDate tenthOctober = new LocalDate(clock.getCurrentTime().getYear(), 10, 10);
        LocalDate fifthMay = new LocalDate(clock.getCurrentTime().getYear(), 5, 5);
        return clock.getCurrentTime().toLocalDate().isBefore(tenthOctober) || clock.getCurrentTime().toLocalDate().isAfter(fifthMay);
    }

    public PolarBear(int weight) {
        super(weight);
    }
}
