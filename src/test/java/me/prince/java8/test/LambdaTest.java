package me.prince.java8.test;

import java.util.*;
import java.util.stream.Collectors;

import me.prince.java8.Invoice;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yhjhoo
 * @since 1.0 date : 19 Mar, 2016
 *
 */

public class LambdaTest {
	private List<Invoice> invoices = new ArrayList<Invoice>();

	@Test
	public void testThread() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hi");
				// System.out.println("Hi2");
			}
		};
		new Thread(runnable).start();

		System.out.println("hello");
	}

	@Test
	public void testThreadJava8() {
		System.out.println("hello1");
		new Thread(() -> System.out.println("Hi 1 1 1  1")).start();
		new Thread(() -> System.out.println("Hi")).start();
		new Thread(() -> System.out.println("Hi 2 2 2  2")).start();
		System.out.println("hello2");
	}

	@Test
	public void testSortingString() {
		List<String> strs = Arrays.asList("C", "a", "A", "b");
		Collections.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		});
		
		for(String str : strs){
			System.out.println(str);
		}
	}
	
	
	@Test
	public void testSortingStringJava8() {
		List<String> strs = Arrays.asList("C", "a", "A", "b");
//		strs.sort(Comparator.comparing(String::compareToIgnoreCase));
		Collections.sort(strs, String::compareToIgnoreCase);
		
		for(String str : strs){
			System.out.println(str);
		}
	}

}
