package shop;

import org.apache.ibatis.io.Resources;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.ezi.mapper.OrderMapper;
import cn.ezi.mapper.UserMapper;
import cn.ezi.pojo.Orders;
import cn.ezi.pojo.User_t;

import java.io.Reader;
import java.util.List;

public class TestMybatis {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	@Test
	public void test() {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			UserMapper userOperater = session.getMapper(UserMapper.class);
			User_t user_t = userOperater.selectByPrimaryKey(1);
			System.out.println(user_t.toString());

		} finally {
			session.close();
		}
	}

	@Test
	public void testfindOrderUserList() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		try {

			OrderMapper userOperater = session.getMapper(OrderMapper.class);
			List<Orders> list= userOperater.findOrderUserList();
			list.forEach(order->System.out.println(order.toString()));

		} finally {
			session.close();
		}
	}
	@Test
	public void testorderAndOrderdetails() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			OrderMapper userOperater = session.getMapper(OrderMapper.class);
			List<Orders> list = userOperater.findOrderAndOrderdetails();
			list.forEach(order -> System.out.println(order.toString()));
			
		} finally {
		}
	}
}
