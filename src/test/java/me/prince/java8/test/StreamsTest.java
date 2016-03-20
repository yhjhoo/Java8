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

public class StreamsTest {
	private List<Invoice> invoices = new ArrayList<Invoice>();

	@Before
	public void setup() {
		{
			Invoice invoice = new Invoice();
			invoice.setId(11L);
			invoice.setTitle("Training");
			invoice.setAmount(1111.0);
			invoices.add(invoice);
		}

		{
			Invoice invoice = new Invoice();
			invoice.setId(22L);
			invoice.setTitle("test1");
			invoice.setAmount(3333.0);
			invoices.add(invoice);
		}

		{
			Invoice invoice = new Invoice();
			invoice.setTitle("test1");
			invoice.setAmount(2222.0);
			invoices.add(invoice);
		}

		for (int i = 0; i < 100_000; i++) {
			Invoice invoice = new Invoice();
			invoice.setTitle("test_" + i);
			if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0 && i % 4 == 0) {
				invoice.setTitle("Training_" + i);
			}
			invoice.setAmount(Double.valueOf(i));
			invoice.setId(Long.valueOf(i));
			invoices.add(invoice);
		}
	}

	@Test
	public void testFind() {
		List<Invoice> trainingInvoices = new ArrayList<>();
		for (Invoice inv : invoices) {
			if (inv.getTitle().contains("Training")) {
				trainingInvoices.add(inv);
			}
		}
		Collections.sort(trainingInvoices, new Comparator<Invoice>() {
			@Override
			public int compare(Invoice inv1, Invoice inv2) {
				return inv2.getAmount().compareTo(inv1.getAmount());
			}

		});
		List<Long> invoiceIds = new ArrayList<>();
		for (Invoice inv : trainingInvoices) {
			invoiceIds.add(inv.getId());
		}

		for (Long id : invoiceIds) {
			System.out.println(id);
		}
	}

	@Test
	public void testFindJava8() {
		List<Long> invoiceIds = invoices
				.stream()
				.filter(inv -> inv.getTitle().contains("Training"))
				.sorted(Comparator.comparingDouble(Invoice::getAmount).reversed()).map(Invoice::getId)
				.collect(Collectors.toList());

		for (Long id : invoiceIds) {
			System.out.println(id);
		}
	}

}
