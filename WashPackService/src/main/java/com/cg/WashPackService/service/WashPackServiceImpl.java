package com.cg.WashPackService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.WashPackService.exception.WashPackException;
import com.cg.WashPackService.model.WashPackEntity;
import com.cg.WashPackService.repository.WashPackRepository;

@Service
public class WashPackServiceImpl implements WashPack_Service {
	@Autowired
	WashPackRepository repo;
	
	@Autowired
	SequenceGeneratorService sequence;

	@Override
	public WashPackEntity addWashPack(WashPackEntity washpack) throws WashPackException {
		washpack.setId(sequence.getSequenceNumber(WashPackEntity.SEQUENCE_NAME));
		return repo.save(washpack);
	}

	@Override
	public WashPackEntity updateWashPack(WashPackEntity washpack, int id) throws WashPackException {
		Optional<WashPackEntity> wash= repo.findById(id);
		if(wash.isPresent()) {
			WashPackEntity entity = wash.get();
			entity.setWashPackCost(washpack.getWashPackCost());
			entity.setWashPackDescription(washpack.getWashPackDescription());
			entity.setWashPackName(washpack.getWashPackName());
			entity.setWasherId(washpack.getWasherId());
			repo.save(entity);
			return entity;
		}
		throw new WashPackException("wash pack with Id: "+ washpack.getId()+" doesn't exist");
	}

	@Override
	public WashPackEntity getWashPackById(int id) throws WashPackException {
		Optional<WashPackEntity> wash= repo.findById(id);
		if(wash.isPresent()) {
			WashPackEntity entity = wash.get();
			return entity;
		}
		throw new WashPackException("wash pack with Id: "+ id+" doesn't exist");
		
	}
	
	@Override
	public List<WashPackEntity> getWashPackByWasherId(int id) {
		List<WashPackEntity> washers = repo.findAll();
		List<WashPackEntity> wash = new ArrayList<>();
		for(WashPackEntity w :washers) {
			if(w.getWasherId()==id) {
				wash.add(w);
			}
		}
		return wash;
	}

	@Override
	public List<WashPackEntity> getAllWashPack() {
		List<WashPackEntity> wash = repo.findAll();
		return wash;
	}

	@Override
	public void deleteWashPack(int id) {
		repo.deleteById(id);
		
	}

}
