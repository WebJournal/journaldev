package com.journaldev.spring;

import org.springframework.stereotype.Component;

@Component
//@Service
public class MathComponent {

	public int add(int x, int y) {
		return x + y;
	}
}
