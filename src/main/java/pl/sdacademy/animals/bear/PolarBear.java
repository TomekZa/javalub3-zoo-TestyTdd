package pl.sdacademy.animals.bear;

import pl.sdacademy.clock.Clock;

public class PolarBear extends Bear {
    public PolarBear(int weight, Clock clock) {
        super(weight, clock);
    }

    @Override
    public boolean isHibernatingAfter() {
        return false;
    }

    @Override
    public boolean isHibernatingBefore() {
        return false;
    }

    public PolarBear(int weight) {
        super(weight);
    }
}
