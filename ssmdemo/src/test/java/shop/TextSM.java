package shop;

import javax.annotation.Resource;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.ezi.pojo.Orders;
import cn.ezi.pojo.User_t;
import cn.ezi.services.impl.UserService;
import cn.ezi.servieces.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})

public class TextSM {
	private static Logger logger = Logger.getLogger(TextSM.class);
	
	@Resource
	private IUserService userService ;
	
	@Test
	public void test1(){
		int key=1;
		User_t user_t=userService.selectByPrimaryKey(key);
		logger.info(JSON.toJSONString(user_t));
	}

}
