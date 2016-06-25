package com.rajesh.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajesh.model.WeatherModel;
import com.rajesh.repository.WeatherDao;

/**
*
* @author Rajesh Kumar
* @version 1.0, June 15,2016
* @since 1.0
*/

@Service
public class WeatherService {

	Logger log = LoggerFactory.getLogger(WeatherService.class);
	
	@Autowired
	private WeatherDao weatherDao;
	
	/**
	 * This method is used to get the weather details.
	 * 
	 * @param id
	 *            represents the data that will be passed to Weather Repository.
	 * @return WeatherModel Object.
	 */
	public WeatherModel getWeather(int id){
		log.info("Invoking Dao fetch method ");
		return weatherDao.fetchWeather(id);
		
	}
	
	/**
	 * This method is used to send the weather details to Weather Repository.
	 * 
	 * @param WeatherModel
	 *            represents the data that will be passed to Weather Repository.
	 * 
	 * @return a Weather Model Object.
	 */
	public WeatherModel insertWeather(WeatherModel weather){
		log.info("Invoking Dao insert method for city {} ", weather.getCityName());
		return weatherDao.insertWeather(weather);
		
	}
	
	/**
	 * This method is used to update the weather details to Weather Repository.
	 * 
	 * @param WeatherModel
	 *            represents the data that will be passed to Weather Repository.
	 * 
	 * @return an updated Weather Model Object.
	 */
	public WeatherModel updateWeather(WeatherModel weather){
		log.info("Invoking Dao update method for city {} ", weather.getCityName());
		return weatherDao.updateWeather(weather);
		
	}
	
	/**
	 * This method is used to delete weather details.
	 * 
	 * @param id
	 *            represents the data that will be passed to Weather Repository.
	 * 
	 * @return a Boolean value.
	 */
	public Boolean deleteWeather(int id){
		log.info("Invoking Dao delete method with id {}",id);
		 weatherDao.deleteWeather(id);
		 return true;	
	}
	
	/**
	 * This method is used to get the list of weather details.
	 * 
	 * @param null
	 * 
	 * @return a list of Weather Model Objects.
	 */
	public List<WeatherModel> getAllWeather(){
		List<WeatherModel> weatherList = new ArrayList<WeatherModel>();
		weatherList = weatherDao.fetchAll();
		return weatherList;
	}
}
