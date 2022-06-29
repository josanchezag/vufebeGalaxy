package com.vufebeGalaxy.model.enums;

public enum EnumPlanet {
	FERENGI(1.0,"+",500.0,"KM"),
	BETASOIDE(3.0,"+",2000.0,"KM"),
	VULCANO(5.0,"-",1000.0,"KM");
	
	private double angularVelocity;
	private String orientation;
	private double sunDistance;
	private String mesureSunDistance;

	EnumPlanet(double w, String orient, double sunDistance, String mesureSunDistance) {
		this.angularVelocity=w;
		this.orientation=orient;
		this.sunDistance=sunDistance;
		this.mesureSunDistance=mesureSunDistance;

	}

	public double getAngularVelocity() {
		return angularVelocity;
	}

	public void setAngularVelocity(double angularVelocity) {
		this.angularVelocity = angularVelocity;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public double getSunDistance() {
		return sunDistance;
	}

	public void setSunDistance(double sunDistance) {
		this.sunDistance = sunDistance;
	}

	public String getMesureSunDistance() {
		return mesureSunDistance;
	}

	public void setMesureSunDistance(String mesureSunDistance) {
		this.mesureSunDistance = mesureSunDistance;
	}
	

}
