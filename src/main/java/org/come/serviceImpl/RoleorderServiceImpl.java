package org.come.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.come.entity.Roleorder;
import org.come.entity.RoleorderExample;
import org.come.mapper.RoleorderMapper;
import org.come.service.IRoleorderService;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;

public class RoleorderServiceImpl implements IRoleorderService {
	
	private RoleorderMapper mapper;
	
	public RoleorderServiceImpl() {
		ApplicationContext ctx = MybatisUntil.getApplicationContext();
		this.mapper = ctx.getBean("roleorderMapper",RoleorderMapper.class);
	}

	@Override
	public int countByExample(RoleorderExample example) {
		
		return this.mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RoleorderExample example) {
		this.mapper.deleteByExample(example);
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(BigDecimal saleid) {
		this.mapper.deleteByPrimaryKey(saleid);
		return 0;
	}

	@Override
	public int insert(Roleorder record) {
		this.mapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(Roleorder record) {
		this.mapper.insertSelective(record);
		return 0;
	}

	@Override
	public List<Roleorder> selectByExample(RoleorderExample example) {
		// TODO Auto-generated method stub
		return this.mapper.selectByExample(example);
	}

	@Override
	public Roleorder selectByPrimaryKey(BigDecimal saleid) {
		// TODO Auto-generated method stub
		return this.mapper.selectByPrimaryKey(saleid);
	}

	@Override
	public int updateByExampleSelective(Roleorder record, RoleorderExample example) {
		this.mapper.updateByExampleSelective(record, example);
		return 0;
	}

	@Override
	public int updateByExample(Roleorder record, RoleorderExample example) {
		this.mapper.updateByExample(record, example);
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Roleorder record) {
		this.mapper.updateByPrimaryKeySelective(record);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Roleorder record) {
		this.mapper.updateByPrimaryKey(record);
		return 0;
	}

	@Override
	public Roleorder selectBySaleId(BigDecimal saleid) {
		return this.mapper.selectBySaleId(saleid);
	}

	@Override
	public List<Roleorder> selectRoleOrders(BigDecimal roleid) {
		
		return this.mapper.selectRoleOrders(roleid);
	}

}
