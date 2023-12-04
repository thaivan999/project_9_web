package hcmute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.entity.MilkTeaTypeEntity;

public interface IMilkTeaTypeService {

	List<MilkTeaTypeEntity> findAllByColumn(Integer id_category);


}
