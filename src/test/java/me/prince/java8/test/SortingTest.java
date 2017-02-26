package me.prince.java8.test;

import java.util.*;
import java.util.stream.Collectors;

import me.prince.java8.Invoice;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yhjhoo
 * @since 1.0 date : 19 Mar, 2016
 */

public class SortingTest {
    private List<Invoice> invoices = new ArrayList<Invoice>();

    @Before
    public void setup() {
        {
            Invoice invoice = new Invoice();
            invoice.setTitle("test1");
            invoice.setAmount(1111.0);
            invoices.add(invoice);
        }

        {
            Invoice invoice = new Invoice();
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
            invoice.setAmount(Double.valueOf(i));
            invoice.setId(Long.valueOf(i));
            invoices.add(invoice);
        }
    }

    @Test
    public void sortingTest() {
        for (Invoice inv : invoices) {
            System.out.println(inv);
        }

        Collections.sort(invoices, new Comparator<Invoice>() {
            public int compare(Invoice inv1, Invoice inv2) {
                return Double.compare(inv2.getAmount(), inv1.getAmount());
            }
        });

        System.out.println("----------------------");

        for (Invoice inv : invoices) {
            System.out.println(inv);
        }
    }


    @Test
    public void testSortingJava8() {
        for (Invoice inv : invoices) {
            System.out.println(inv);
        }

        invoices.sort(Comparator.comparingDouble(Invoice::getAmount).reversed());

        System.out.println("----------------------");

        for (Invoice inv : invoices) {
            System.out.println(inv);
        }
    }


    @Test
    public void testStreamJava8() {
        List<Long> ids = invoices.stream()
                .filter(inv -> inv.getAmount() > 9_890)
                .map(Invoice::getId)
                .collect(Collectors.toList());

        for (Long id : ids) {
            System.out.println(id);
        }

    }


    @Test
    public void testParalleStreamJava8() {
        List<Long> ids = invoices.parallelStream()
                .filter(inv -> inv.getAmount() > 9_890)
                .map(Invoice::getId)
                .collect(Collectors.toList());

        for (Long id : ids) {
            System.out.println(id);
        }
    }


}
