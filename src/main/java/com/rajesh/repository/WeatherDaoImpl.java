package com.rajesh.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rajesh.model.WeatherModel;

/**
*
* @author Rajesh Kumar
* @version 1.0, June 17,2016
* @since 1.0
*/

@Repository("weatherDao")
@Transactional(propagation = Propagation.REQUIRED)
public class WeatherDaoImpl implements WeatherDao {

	Logger log = LoggerFactory.getLogger(WeatherDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rajesh.repository.WeatherDao#fetchWeather(com.rajesh.model.WeatherModel)
	 */
	@Override
	public WeatherModel fetchWeather(int id) {
		log.info("weather data fetch using Entity manager with id {}",id);
		return entityManager.find(WeatherModel.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rajesh.repository.WeatherDao#insertWeather(com.rajesh.model.WeatherModel)
	 */
	@Override
	public WeatherModel insertWeather(WeatherModel weather) {
		log.info("weather data persisted using entity for {}",weather.getCityName());
		entityManager.persist(weather);
		entityManager.flush();
		return weather;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rajesh.repository.WeatherDao#updateWeather(com.rajesh.model.WeatherModel)
	 */
	@Override
	public WeatherModel updateWeather(WeatherModel weather) {
		log.info("weather data updated using entity for {}",weather.getCityName());
		WeatherModel weatherResult = entityManager.find(WeatherModel.class, weather.getId());
		weatherResult.setCityName(weather.getCityName());
		weatherResult.setState(weather.getState());
		weatherResult.setZipcode(weather.getZipcode());
		weatherResult.setWeatherData(weather.getWeatherData());
		entityManager.merge(weatherResult);
		entityManager.flush();
		return weatherResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rajesh.repository.WeatherDao#deleteWeather(com.rajesh.model.WeatherModel)
	 */
	@Override
	public int deleteWeather(int id) {
		log.info("weather data removed using entity for id {}",id);
		WeatherModel weatherM = entityManager.find(WeatherModel.class, id);
		entityManager.remove(weatherM);
        return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rajesh.repository.WeatherDao#fetchAll(com.rajesh.model.WeatherModel)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WeatherModel> fetchAll() {
		List<WeatherModel> weatherList = entityManager.createQuery("from WeatherModel").getResultList();
		return weatherList;
	}



}
