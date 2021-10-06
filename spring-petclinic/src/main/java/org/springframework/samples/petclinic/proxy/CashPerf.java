package org.springframework.samples.petclinic.proxy;

import org.springframework.util.StopWatch;

public class CashPerf implements Payment { // 프록시코드구현
	//payment라는 인터페이스를 쓰지만 알아서 현금을 쓸지 카드를 쓸지 자동으로 판단하는 프록시
	//현금이 없다면 / 문제가 생기면 자동으로 카드로 넘어가기
	//	Spring AOP 에선 자동으로 프록시 제공
	Payment cash = new Cash();

	@Override
	public void pay(int amount) {
		//
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
			cash.pay(amount);

			stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());

	}
}
