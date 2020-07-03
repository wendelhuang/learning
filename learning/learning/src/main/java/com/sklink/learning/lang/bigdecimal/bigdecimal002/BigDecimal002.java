package com.sklink.learning.lang.bigdecimal.bigdecimal002;

import java.math.BigDecimal;

public class BigDecimal002 {
	public static void main(String[] args) {
		BigDecimal bigDecimal1 = new BigDecimal("100");
		BigDecimal bigDecimal2 = new BigDecimal(100);
		System.out.println(bigDecimal1 == bigDecimal2);
		
		BigDecimal bigDecimal3 = new BigDecimal("0");
		BigDecimal bigDecimal4 = new BigDecimal(0);
		System.out.println(bigDecimal3 == bigDecimal4);
		System.out.println(bigDecimal3 == BigDecimal.ZERO);
		
		
		BigDecimal bigDecimal5 = new BigDecimal("0.99999999");
		BigDecimal bigDecimal6 = new BigDecimal(0.99999999);
		BigDecimal bigDecimal7 = new BigDecimal("0.99999999");
		System.out.println(bigDecimal5.compareTo(bigDecimal6));
		System.out.println(bigDecimal5 == bigDecimal7);
		System.out.println(bigDecimal5.compareTo(bigDecimal7));
	}
}
