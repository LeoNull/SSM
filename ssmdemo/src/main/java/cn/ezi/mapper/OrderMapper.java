package cn.ezi.mapper;

import java.util.List;

import cn.ezi.pojo.Orders;

public interface OrderMapper {
	
	public List<Orders> findOrderUserList() throws Exception;
	
	public List<Orders> findOrderAndOrderdetails() throws Exception;
}
