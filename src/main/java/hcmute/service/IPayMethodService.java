package hcmute.service;

import java.util.List;

import hcmute.entity.PayMethodEntity;

public interface IPayMethodService {

	List<PayMethodEntity> findAll();

}
