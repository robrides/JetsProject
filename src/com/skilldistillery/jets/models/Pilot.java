package com.skilldistillery.jets.models;

public abstract class Pilot {

	private String name;
	private String isHired;
	
	public Pilot() {
		super();	
	}

	public Pilot(String name, String isHired) {
		super();
		this.name = name;
		this.isHired = isHired;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsHired() {
		return isHired;
	}

	public void setIsHired(String isHired) {
		this.isHired = isHired;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isHired == null) ? 0 : isHired.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pilot other = (Pilot) obj;
		if (isHired == null) {
			if (other.isHired != null)
				return false;
		} else if (!isHired.equals(other.isHired))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
