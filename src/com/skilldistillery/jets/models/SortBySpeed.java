package com.skilldistillery.jets.models;

import java.util.Comparator;

public class SortBySpeed  implements Comparator<Jet>{

	@Override
	public int compare(Jet o1, Jet o2) {
		return (int) (o2.getSpeed() - o1.getSpeed()); 
	}

}
