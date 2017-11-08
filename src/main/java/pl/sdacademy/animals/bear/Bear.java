package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.sdacademy.animals.Animal;
import pl.sdacademy.clock.Clock;
import pl.sdacademy.clock.DateTimeClock;
import pl.sdacademy.exception.BearHibernatingException;


public abstract class Bear implements Animal {

    private int weight;

    private DateTime lastMealTime;
    Clock clock;

    public DateTime getLastMealTime() {
        return lastMealTime;
    }

    public Bear(int weight) {
        this.clock = new DateTimeClock();
        this.lastMealTime = clock.getCurrentTime();
        this.weight = weight;
    }

    public Bear(int weight, Clock clock) {
        this(weight);
        this.clock = clock;
    }

    @Override
    public boolean isAlive() {
        return new Duration(lastMealTime, clock.getCurrentTime()).isShorterThan(Duration.standardDays(10));
    }

    public void eat() {
        if (isHibernating()) {
            throw new BearHibernatingException();
        }

        lastMealTime = clock.getCurrentTime();
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public abstract boolean isHibernating();

}
