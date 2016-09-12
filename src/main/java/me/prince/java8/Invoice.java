package me.prince.java8;
/**
 * @author yhjhoo
 * @since 1.0
 * date : 19 Mar, 2016
 *
 */

public class Invoice {
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(Long id, String title, Double amount) {
		super();
		this.id = id;
		this.title = title;
		this.amount = amount;
	}
	private Long id;
	private String title;
	private Double amount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", title=" + title + ", amount=" + amount
				+ "]";
	}
}
