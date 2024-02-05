package com.cg.WasherService.service;

import java.util.List;

import com.cg.WasherService.entity.WasherModel;
import com.cg.WasherService.exception.WasherException;

public interface WasherService {
	public WasherModel insertWasherInfo(WasherModel washerInfo) throws WasherException;
    public List<WasherModel> getAllWashers();

   // public WasherModel findByEmail(String washerEmail) throws WasherException;

    public WasherModel updateWasherInfo(WasherModel washerInfo, int washerId) throws WasherException;

    public void deleteWasherInfo(int washerId);

    public WasherModel getById(int washerId) throws WasherException;
	//Optional<WasherModel> findByEmail(String washerEmail) throws WasherException;

}
