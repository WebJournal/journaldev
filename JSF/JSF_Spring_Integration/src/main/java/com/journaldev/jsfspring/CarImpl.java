package com.journaldev.jsfspring;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarImpl implements CarDao {

	@Override
	public List<String> getCarDetails() {

		List<String> cars = new ArrayList<String>();

		cars.add(0, "Santro");
		cars.add(1, "Zen");
		cars.add(2, "Alto");
		cars.add(3, "Qualis");
		cars.add(4, "Innova");

		for (String c : cars) {
			System.out.println(c);
		}

		return cars;

	}

}
