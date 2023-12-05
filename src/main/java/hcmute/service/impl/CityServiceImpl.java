package hcmute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.entity.CityEntity;
import hcmute.repository.CityRepository;
import hcmute.service.ICityService;

@Service
public class CityServiceImpl implements ICityService{
	@Autowired
	CityRepository cityRepository;
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	@Override
	public List<CityEntity> findAll() {
		return cityRepository.findAll();
	}
	
	
}
