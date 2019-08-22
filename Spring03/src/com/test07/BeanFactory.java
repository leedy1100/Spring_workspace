package com.test07;

public class BeanFactory {

	Object getBean(String beanName) {

		if (beanName.equals("Samsong")) {
			return new SamsongTV();
		} else if (beanName.equals("Lz")) {
			return new LzTV();
		}

		return null;
	}
}
