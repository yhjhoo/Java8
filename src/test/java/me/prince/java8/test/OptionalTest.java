package me.prince.java8.test;

import java.util.Optional;

import org.junit.Test;

import me.prince.java8.Invoice;

public class OptionalTest {
	public Optional<Invoice> getInvoice(Long invoiceId){
//		Invoice in = null;
		
		Invoice in = new Invoice(1L, "Title", 111.0);
		return Optional.ofNullable(in);
	}
	
	@Test
	public void testOption(){
		Optional<Invoice> in = getInvoice(1L);
		in.ifPresent(i -> System.out.println(i.getId() ));
		
		in.orElse(null);
		in.orElseThrow(null);
	}
}
