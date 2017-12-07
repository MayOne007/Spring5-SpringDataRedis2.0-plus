package com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Dict;
import com.service.DictService;

import core.service.BaseServiceImpl;


@Transactional
@Service
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void txOne() {
		System.out.println("txOne");
		txTwo();
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void txTwo() {
		System.out.println("txTwo");
	}
	
}
