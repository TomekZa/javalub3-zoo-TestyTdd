package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.clock.Clock;
import java.time.LocalDate;
import java.util.Date;

public class BlackBear extends Bear {
    public BlackBear(int weight, Clock clock) {
        super(weight, clock);
    }

    public BlackBear(int weight) {
        super(weight);
    }


    /*public boolean isHibernatingAfterNov20() {
        DateTime nov20 = new DateTime();
        nov20.dayOfMonth().setCopy(20);
        nov20.monthOfYear().setCopy(11);
        return DateTime.now().isAfter(nov20);
    }

    public boolean isHibernatingBeforeMar15() {
        DateTime mar15 = new DateTime();
        mar15.dayOfMonth().setCopy(15);
        mar15.monthOfYear().setCopy(3);
        return DateTime.now().isBefore(mar15);
    }*/
}