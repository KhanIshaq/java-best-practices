package chapter6;

import chapter6.Main.Planet;

public class WeightTable {

	public static void main(String[] args) {
		double earthWeight = Double.parseDouble("5.975");
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		
		for(Planet p : Planet.values()) {
			System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
		}
	}

}
