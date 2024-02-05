package com.cg.WasherService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.WasherService.entity.WasherModel;
import com.cg.WasherService.exception.WasherException;
import com.cg.WasherService.repository.WasherRepository;

@Service
public class WasherServiceImpl implements WasherService {
	
	
	@Autowired
	WasherRepository repo;
	
	@Autowired
	SequenceGeneratorService sequence;
	
	

	@Override
	public WasherModel insertWasherInfo(WasherModel washerInfo) throws WasherException {
		List<WasherModel> washList = repo.findAll();
		boolean flag = false;
		WasherModel washers = null;
		for(WasherModel washer:washList) {
			if( (washer.getWasherEmail().equalsIgnoreCase(washerInfo.getWasherEmail()))) {
				throw new WasherException("Washer with washer id "+washerInfo.getId()+" or email "+washerInfo.getWasherEmail()+" Already Exists");
				
			}else {
				flag = true;
			}
		}
		if(flag) {
			
			washerInfo.setId(sequence.getSequenceNumber(WasherModel.SEQUENCE_NAME));
			washers=repo.save(washerInfo);
		}
		
		return washers;
	}

	@Override
	public List<WasherModel> getAllWashers() {
		List<WasherModel> washList = repo.findAll();
		// TODO Auto-generated method stub
		return washList;
	}

//	@Override
//	public Optional<WasherModel> findByEmail(String washerEmail) throws WasherException {
//		return repo.findBy(washerEmail);
//	}
	@Override
	public WasherModel updateWasherInfo(WasherModel washerInfo, int washerId) throws WasherException {
		Optional<WasherModel> wash = repo.findById(washerId);
		if(wash.isPresent()) {
			//WasherModel washer = wash.get();
			repo.save(washerInfo);
			return washerInfo;
		}else {
			throw new WasherException("Washer with Id "+washerId+" not found");
		}
	}

	@Override
	public void deleteWasherInfo(int washerId) {
		repo.deleteById(washerId);
		
		
	}

	@Override
	public WasherModel getById(int washerId) throws WasherException {
		Optional<WasherModel> wash = repo.findById(washerId);
		if(wash.isPresent()) {
			WasherModel washer = wash.get();
			return washer;
		}else {
			throw new WasherException("washer with id" +washerId+" not found");
		}
	}
	

}
