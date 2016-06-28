package com.rajesh.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.model.WeatherModel;
import com.rajesh.model.WeatherDataModel;

import com.rajesh.service.WeatherService;

/**
*
* @author Rajesh Kumar
* @version 1.0, June 15,2016
* @since 1.0
*/

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

	Logger log = LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherService weatherService;

	/**
	 * This method is used to get the weather details.
	 * 
	 * @param id
	 *            represents the data that will be passed to WeatherService.
	 * 
	 * @return a Weather Model Object.
	 */
	
	@RequestMapping(value="/fetchWeather/{id}", method=RequestMethod.GET)
	public WeatherModel getWeather(@PathVariable(value="id") int id){
		log.info("Invoking Weather Service to Get City::{}",id);
		return weatherService.getWeather(id);
	}

	/**
	 * This method is used to insert the weather details into MySQL DB.
	 * 
	 * @param WeatherModel
	 *            represents the data that will be passed to WeatherService.
	 * 
	 * @return a Weather Model Object.
	 */
	@RequestMapping(value="/insertWeather", method= RequestMethod.POST)
	public WeatherModel insertWeather(@RequestBody WeatherModel weather){
		log.info("Invoking Weather Service to Save City::{}",weather.getCityName());
		
		Set<WeatherDataModel> dataModel = new HashSet<WeatherDataModel>();
		for(WeatherDataModel w : weather.getWeatherData()){
			w.setWeatherModel(weather);
			dataModel.add(w);
		}
		
		//weather.setWeatherData(dataModel);
		
		return weatherService.insertWeather(weather);	
	}

	/**
	 * This method is used to update the weather details.
	 * 
	 * @param WeatherModel
	 *            represents the data that will be passed to WeatherService.
	 * 
	 * @return an updated Weather Model Object.
	 */
	@RequestMapping(value="/updateWeather", method= RequestMethod.PUT)
	public WeatherModel updateWeather(@RequestBody WeatherModel weather){
		log.info("Invoking Weather Service to Update City::{}",weather.getCityName());
		
		Set<WeatherDataModel> dataModel = new HashSet<WeatherDataModel>();
		for(WeatherDataModel w : weather.getWeatherData()){
			w.setWeatherModel(weather);
			dataModel.add(w);
		}
		
		weather.setWeatherData(dataModel);
		
		return weatherService.updateWeather(weather);
		
	}

	/**
	 * This method is used to delete weather details.
	 * 
	 * @param id
	 *            represents the data that will be passed to WeatherService.
	 * 
	 * @return a Boolean value.
	 */
	@RequestMapping(value="/deleteWeather/{id}", method= RequestMethod.DELETE)
	public Boolean deleteWeather(@PathVariable(value= "id") int id){
		log.info("Invoking Weather Service to Delete City::{}",id);
		return weatherService.deleteWeather(id);
		
	}

	/**
	 * This method is used to get the list of weather details.
	 * 
	 * @param null
	 * 
	 * @return an Array of Weather Model Objects.
	 */
	@RequestMapping(value="/getAllWeather", method= RequestMethod.GET)
	public List<WeatherModel> getAllWeather(){
		return weatherService.getAllWeather();
		
		
	}

}
