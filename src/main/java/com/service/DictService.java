package com.service;

import com.entity.Dict;

import core.service.BaseService;

public interface DictService extends BaseService<Dict> {
	
	public void txOne();
	
	public void txTwo();
	
	public Object cacheOne(Integer id);
}
