package hcmute.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hcmute.entity.MilkTeaEntity;


public interface IMilkTeaService {
	List<MilkTeaEntity> findAllByColumn(Integer typeId);

}
