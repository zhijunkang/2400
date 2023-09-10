package org.come.serviceImpl;

import java.util.List;

import org.come.entity.PayvipBean;
import org.come.mapper.PayvipBeanServerMapper;
import org.come.service.PayvipBeanServer;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;

import com.github.pagehelper.PageHelper;

public class PayvipBeanServerImpl implements PayvipBeanServer{
	private PayvipBeanServerMapper payvipBeanServerMapper;
	public static Integer pageNum = 10;
	public PayvipBeanServerImpl() {
		ApplicationContext ctx = MybatisUntil.getApplicationContext();
		this.payvipBeanServerMapper = ctx.getBean("payvipBeanServerMapper",PayvipBeanServerMapper.class);
	}
	@Override
	public List<PayvipBean> selectAllVip() {
		return this.payvipBeanServerMapper.selectAllVip();
	}
	@Override
	public List<PayvipBean> selectVipPage(int page) {
		PageHelper.startPage(page, pageNum);
		return this.payvipBeanServerMapper.selectAllVip();
	}
	@Override
	public int deletePayvioBean(Integer id) {
		return this.payvipBeanServerMapper.deletePayvipBean(id);
	}
	@Override
	public int insertPayvioBean(PayvipBean payvipBean) {
		return this.payvipBeanServerMapper.insertPayvioBean(payvipBean);
	}
	@Override
	public int updatePayvioBean(PayvipBean payvipBean){
		return this.payvipBeanServerMapper.updatePayvioBean(payvipBean);
	}
}
