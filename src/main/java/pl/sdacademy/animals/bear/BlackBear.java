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
        DateTime currentTime = clock.getCurrentTime();
        LocalDate currentDate = currentTime.toLocalDate();
        int currentYear = currentTime.getYear();

        LocalDate twentiethNovember = new LocalDate(currentYear, 11, 20);
        LocalDate fifteenthMarch = new LocalDate(currentYear, 3, 15);

        return currentDate.isAfter(twentiethNovember) ||
                currentDate.isBefore(fifteenthMarch);
    }

    public BlackBear(int weight) {
        super(weight);
    }
}