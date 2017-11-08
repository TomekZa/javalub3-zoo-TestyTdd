package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pl.sdacademy.clock.Clock;


public class BlackBear extends Bear {
    public BlackBear(int weight, Clock clock) {
        super(weight, clock);
    }

    @Override
    public boolean isHibernating() {
        LocalDate twentiethNovember = new LocalDate(clock.getCurrentTime().getYear(), 11, 20);
        LocalDate fifteenth = new LocalDate(clock.getCurrentTime().getYear(), 3, 15);
        return clock.getCurrentTime().toLocalDate().isAfter(twentiethNovember)
                || clock.getCurrentTime().toLocalDate().isBefore(fifteenth);
    }

    public BlackBear(int weight) {
        super(weight);
    }
}