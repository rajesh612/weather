package com.rajesh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* @author Rajesh Kumar
* @version 1.0, June 15,2016
* @since 1.0
*/

@Entity
@Table(name = "WEATHER")
public class WeatherModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CITYNAME")
	private String cityName;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "ZIPCODE")
	private int zipcode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "weatherModel", cascade = CascadeType.ALL)
	private Set<WeatherDataModel> weatherData = new HashSet<WeatherDataModel>(0);
	
	
	public Set<WeatherDataModel> getWeatherData() {
		return weatherData;
	}
	public void setWeatherData(Set<WeatherDataModel> weatherData) {
		this.weatherData = weatherData;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
