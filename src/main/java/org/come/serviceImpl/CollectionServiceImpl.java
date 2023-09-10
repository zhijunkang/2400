package org.come.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.come.entity.Collection;
import org.come.entity.CollectionExample;
import org.come.mapper.CollectionMapper;
import org.come.service.ICollectionService;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;

public class CollectionServiceImpl implements ICollectionService {
	
	private CollectionMapper mapper;
	
	public CollectionServiceImpl() {
		ApplicationContext ctx = MybatisUntil.getApplicationContext();
		this.mapper = ctx.getBean("collectionMapper",CollectionMapper.class);
	}

	@Override
	public int countByExample(CollectionExample example) {
		
		return this.mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CollectionExample example) {
		this.mapper.deleteByExample(example);
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(BigDecimal saleid) {
		this.mapper.deleteByPrimaryKey(saleid);
		return 0;
	}

	@Override
	public int insert(Collection record) {
		this.mapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(Collection record) {
		this.mapper.insertSelective(record);
		return 0;
	}

	@Override
	public List<Collection> selectByExample(CollectionExample example) {
		// TODO Auto-generated method stub
		return this.mapper.selectByExample(example);
	}

	@Override
	public Collection selectByPrimaryKey(BigDecimal saleid) {
		// TODO Auto-generated method stub
		return this.mapper.selectByPrimaryKey(saleid);
	}

	@Override
	public int updateByExampleSelective(Collection record, CollectionExample example) {
		this.mapper.updateByExampleSelective(record, example);
		return 0;
	}

	@Override
	public int updateByExample(Collection record, CollectionExample example) {
		this.mapper.updateByExample(record, example);
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Collection record) {
		this.mapper.updateByPrimaryKeySelective(record);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Collection record) {
		this.mapper.updateByPrimaryKey(record);
		return 0;
	}
	/**
	 * 查询用户的收藏列表
	 */
	@Override
	public List<BigDecimal> selectUserCollection(BigDecimal roleid) {
		return this.mapper.selectUserCollection(roleid);
	}

	@Override
	public List<Collection> selectRoleCollect(BigDecimal roleid) {
		return this.mapper.selectRoleCollect(roleid);
	}
}
