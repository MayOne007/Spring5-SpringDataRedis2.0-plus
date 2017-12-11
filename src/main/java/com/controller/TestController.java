package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Dict;
import com.service.DictService;

import core.util.RedisUtil;

@Controller("testController")
@RequestMapping("/test")
public class TestController {

	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	@Qualifier("redisCacheManager")
	private CacheManager cacheManager;
	
	@RequestMapping(value="index", method = RequestMethod.GET)
	public Object index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/test");
		Cache cache = cacheManager.getCache("user");
		cache.put("key", "value");
		System.out.println(cache.get("key"));

		Dict d = dictService.loadById(1);
		//List<Dict> dl = d.getChildDicts();
		//System.out.print(dl.size());
		mv.addObject("o", d);
		return mv;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="json", method = RequestMethod.GET)
	public Object json(HttpServletRequest request) {
		Map m = new HashMap();
		Dict d = dictService.getById(1);
		m.put("queryObject", d);
		Dict rd = cacheManager.getCache("user").get("1",Dict.class);
		m.put("cacheObject",  rd);
		redisUtil.setCacheMap("m", m);
		return redisUtil.getCacheMap("m");
	}
	
}