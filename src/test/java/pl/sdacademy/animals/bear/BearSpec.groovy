package pl.sdacademy.animals.bear

import org.joda.time.DateTime
import org.joda.time.Duration
import pl.sdacademy.clock.Clock
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

    def "Black bear should be hibernating if it is after 20 november"() {
        given:
        Clock clock = Mock(Clock)
        clock.getCurrentTime() >> new DateTime(2017, 12, 01, 14, 0)
        BlackBear bear = new BlackBear(1, clock)

        when:
        boolean result = bear.isHibernating()

        then:
        assertThat(result).isTrue()
    }

}
