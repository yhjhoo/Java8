package me.prince.java8.test;

import static org.junit.Assert.*;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.time.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yhjhoo
 * @since 1.0 date : 19 Mar, 2016
 */

public class DateTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime coffeeBreak = LocalDateTime.now().plusHours(2)
                .plusMinutes(30);
        System.out.println(coffeeBreak);
    }

    //Immutability
    @Test
    public void testJava8Time() {
        ZoneId london = ZoneId.of("Asia/Shanghai");
        LocalDate july4 = LocalDate.of(2014, Month.JULY, 4);
        LocalTime early = LocalTime.parse("08:45");
        ZonedDateTime flightDeparture = ZonedDateTime.of(july4, early, london);
        System.out.println(flightDeparture);
        LocalTime from = LocalTime.from(flightDeparture);
        System.out.println(from);

        ZonedDateTime touchDown = ZonedDateTime.of(july4, LocalTime.of(11, 35),
                ZoneId.of("Europe/Stockholm"));
        Duration flightLength = Duration.between(flightDeparture, touchDown);
        System.out.println(flightLength);
        // How long have I been in continental Europe?
        ZonedDateTime now = ZonedDateTime.now();
        Duration timeHere = Duration.between(touchDown, now);
        System.out.println(timeHere);
    }

}
