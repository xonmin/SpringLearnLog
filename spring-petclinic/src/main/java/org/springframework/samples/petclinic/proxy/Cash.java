package org.springframework.samples.petclinic.proxy;

public class Cash implements Payment {
	// 현금결제

	@Override
	public void pay(int amount) {
		System.out.println(amount + "현금결제");
	}
}
