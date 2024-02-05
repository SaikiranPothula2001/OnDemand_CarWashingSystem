package com.cg.WashPackService.service;

import java.util.List;

import com.cg.WashPackService.exception.WashPackException;
import com.cg.WashPackService.model.WashPackEntity;

public interface WashPack_Service {
	public WashPackEntity addWashPack(WashPackEntity washpack) throws WashPackException;
	public WashPackEntity updateWashPack(WashPackEntity washpack ,int id) throws WashPackException;
	public WashPackEntity getWashPackById(int id) throws WashPackException;
	public List<WashPackEntity> getWashPackByWasherId(int id);
	public List<WashPackEntity> getAllWashPack();
	public void deleteWashPack(int id);
}
