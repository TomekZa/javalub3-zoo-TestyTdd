package pl.sdacademy.animals.bear

import org.joda.time.DateTime
import org.joda.time.Duration
import pl.sdacademy.clock.Clock
import pl.sdacademy.exception.BearHibernatingException
import spock.lang.Specification

import static org.assertj.core.api.AssertionsForClassTypes.assertThat


class BearSpec extends Specification {

    def "Bear should be alive if has eaten within 10 days"() {
        given:
        Bear bear = testBear
        bear.eat()

        when:
        def result = bear.isAlive()

        then:
        assertThat(result).isTrue()

        where:
        testBear << [new BlackBear(5), new PolarBear(20)]
    }

    def "Feeding bear should set the date of the last meal for now"() {
        given:
        Bear bear = new BlackBear(1)
        bear.eat()

        when:
        def result = bear.getLastMealTime()

        then:
        new Duration(result, DateTime.now()).isShorterThan(Duration.standardSeconds(1))
    }

    def "Bear should not be alive if it has not eaten for more than 10 days"() {
        given:
        Bear bear = new BlackBear(1, new TestClock())

        when:
        def result = bear.isAlive()

        then:
        assertThat(result).isFalse()
    }

    def "Black bear should be hibernating between 20 november and 15 march"() {
        given:
        Clock clock = Mock(Clock)
        clock.getCurrentTime() >> date
        BlackBear bear = new BlackBear(1, clock)

        when:
        boolean result = bear.isHibernating()

        then:
        assertThat(result).isTrue()

        where:
        date << [new DateTime(2017, 12, 01, 14, 0), new DateTime(2017, 11, 21, 14, 0), new DateTime(2018, 01, 04, 14, 0), new DateTime(2017, 03, 14, 14, 0)]
    }

    def "Black bear should not be hibernating if it is after 15 march and before 20 november"() {
        given:
        Clock clock = Mock(Clock)
        clock.getCurrentTime() >> date
        BlackBear bear = new BlackBear(1, clock)

        when:
        boolean result = bear.isHibernating()

        then:
        assertThat(result).isFalse()

        where:
        date << [new DateTime(2017, 05, 01, 14, 0), new DateTime(2017, 11, 19, 14, 0), new DateTime(2018, 07, 04, 14, 0), new DateTime(2017, 03, 16, 14, 0)]

    }

    // I HIGHLY DISCOURAGE MERGING THE TWO TEST METHODS INTO THE TEST BELOW
    // (but it's a decent example for data tables in Spock
    def "Bear should be hibernating between 20th November and 15th March"() {
        given:
        Clock clock = Mock(Clock)
        clock.getCurrentTime() >> date
        BlackBear bear = new BlackBear(1, clock)

        when:
        boolean result = bear.isHibernating()

        then:
        result == expected

        where:
        date | expected
        new DateTime(2017, 05, 01, 14, 0) | false
        new DateTime(2017, 12, 01, 14, 0) | true
    }

    def "Should throw exception when trying to feed a hibernating bear"() {
        given:
        Clock clock = Mock(Clock)
        clock.getCurrentTime() >> new DateTime(2017, 12, 01, 14, 0)
        BlackBear bear = new BlackBear(1, clock)
        assert bear.isHibernating()

        when:
        bear.eat()

        then:
        thrown BearHibernatingException

    }

}
