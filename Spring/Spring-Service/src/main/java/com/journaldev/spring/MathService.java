package com.journaldev.spring;

import org.springframework.stereotype.Service;

@Service("ms")
public class MathService {

	public int add(int x, int y) {
		return x + y;
	}
	
	public int subtract(int x, int y) {
		return x - y;
	}
}
