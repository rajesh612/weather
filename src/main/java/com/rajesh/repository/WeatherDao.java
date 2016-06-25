package com.rajesh.repository;

import java.util.List;

import com.rajesh.model.WeatherModel;

/**
*
* @author Rajesh Kumar
* @version 1.0, June 15,2016
* @since 1.0
*/
public interface WeatherDao {
	
	/**
	 * This method is used to fetch the weather details.
	 * 
	 * @param id
	 *            represents the data that will be used to find Weather Model.
	 * @return WeatherModel Object.
	 */
	public WeatherModel fetchWeather(int id);
	
	/**
	 * This method is used to persist the weather details.
	 * 
	 * @param WeatherModel
	 *            represents the data that will be passed to Weather Model.
	 * 
	 * @return a Weather Model Object.
	 */
	public WeatherModel insertWeather(WeatherModel weather);
	
	/**
	 * This method is used to update the weather details.
	 * 
	 * @param WeatherModel
	 *            represents the data that will be passed to Weather Model.
	 * 
	 * @return an updated Weather Model Object.
	 */
	public WeatherModel updateWeather(WeatherModel weather);
	
	/**
	 * This method is used to delete the weather details.
	 * 
	 * @param id
	 *            represents the data that will be passed to Weather Model.
	 * 
	 * @return an integer.
	 */
	public int deleteWeather(int id);
	
	/**
	 * This method is used to get the list of weather details.
	 * 
	 * @param null
	 * 
	 * @return a list of Weather Model Objects.
	 */
	public List<WeatherModel> fetchAll();
}
