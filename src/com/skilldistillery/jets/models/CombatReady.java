package com.skilldistillery.jets.models;

public interface CombatReady {
	
	boolean readyForCombat();

	public void munitionsLoading();

	public void munitionsOnboard();
	
	boolean engagedInDogfight();
	
	public void attack();
	
	public void disengage();

}
