package org.springframework.samples.petclinic.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
	@Test
	public void testPay(){
		//Client 코드는 전혀바뀌지 않은 상태
		// cash 도 eclass도 변하지 않음
		//하지만 성능측정을 하는 프록시코드가 완성
		Payment cashPerf = new CashPerf();
		Store store = new Store(cashPerf);
		store.buySomething(100);
	}

}
