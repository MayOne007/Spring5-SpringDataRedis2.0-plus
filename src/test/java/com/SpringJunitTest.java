package com;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.service.DictService;

/** 声明用的是Spring的测试类 **/
@RunWith(SpringJUnit4ClassRunner.class)
/** 声明spring主配置文件位置 **/
@ContextConfiguration(locations={"classpath*:applicationContext*.xml"})
/** 事务自动回滚  **/
/*@Rollback*/
public class SpringJunitTest {

	private static Logger logger = Logger.getLogger(SpringJunitTest.class);
	
	@Autowired
	private DictService dictService;
	
	@Test
	public void test() {
		logger.error("test");
		System.out.println("test");
	}
	
	@Test
	public void testJdkAaop() {
		dictService.txOne();
	}
	
	public static void main(String[] args) {
		logger.error("main");
		System.out.println("main");
	}
}
