package com.skilldistillery.jets.models;

import java.util.Comparator;

public class SortByRange  implements Comparator<Jet>{

	@Override
	public int compare(Jet o1, Jet o2) {
		return (o2.getRange() - o1.getRange()); 
	}

}
