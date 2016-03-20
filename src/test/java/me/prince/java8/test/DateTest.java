package me.prince.java8.test;

import static org.junit.Assert.*;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yhjhoo
 * @since 1.0
 * date : 19 Mar, 2016
 *
 */

public class DateTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
	    LocalDateTime coffeeBreak = LocalDateTime.now()
	                                               .plusHours(2)
	                                               .plusMinutes(30);
	    System.out.println(coffeeBreak);
	}

}
