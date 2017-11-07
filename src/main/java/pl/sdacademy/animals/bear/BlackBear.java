package pl.sdacademy.animals.bear;

import pl.sdacademy.clock.Clock;

import java.time.LocalDate;

public class BlackBear extends Bear {
    public BlackBear(int weight, Clock clock) {
        super(weight, clock);
    }

    public BlackBear(int weight) {
        super(weight);
    }

    public boolean isHibernating() {
        LocalDate nov20 = LocalDate.of(LocalDate.now().getYear(), 11, 20);
        LocalDate mar15 = LocalDate.of(LocalDate.now().getYear()+1, 3, 15);
        return LocalDate.now().isAfter(nov20) && LocalDate.now().isBefore(mar15);
    }
}