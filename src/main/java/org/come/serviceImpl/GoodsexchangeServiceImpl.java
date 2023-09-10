package org.come.serviceImpl;

import java.util.List;

import org.come.entity.Goodsexchange;
import org.come.entity.GoodsexchangeExample;
import org.come.mapper.GoodsexchangeMapper;
import org.come.service.IGoodsExchangeService;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;

public class GoodsexchangeServiceImpl implements IGoodsExchangeService {

	private GoodsexchangeMapper goodsexchangeMapper;

	public GoodsexchangeServiceImpl() {

		ApplicationContext ctx = MybatisUntil.getApplicationContext();
		this.goodsexchangeMapper = ctx.getBean("goodsexchangeMapper",GoodsexchangeMapper.class);
	}

	@Override
	public int countByExample(GoodsexchangeExample example) {
		// TODO Auto-generated method stub
		return this.goodsexchangeMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(GoodsexchangeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String goodsguid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Goodsexchange record) {
		this.goodsexchangeMapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(Goodsexchange record) {
		this.goodsexchangeMapper.insertSelective(record);
		return 0;
	}

	@Override
	public List<Goodsexchange> selectByExample(GoodsexchangeExample example) {
		// TODO Auto-generated method stub
		return this.goodsexchangeMapper.selectByExample(example);
	}

	@Override
	public Goodsexchange selectByPrimaryKey(String goodsguid) {
		return this.goodsexchangeMapper.selectByPrimaryKey(goodsguid);
	}

	@Override
	public int updateByExampleSelective(Goodsexchange record, GoodsexchangeExample example) {
		this.goodsexchangeMapper.updateByExampleSelective(record, example);
		return 0;
	}

	@Override
	public int updateByExample(Goodsexchange record, GoodsexchangeExample example) {
		this.goodsexchangeMapper.updateByExample(record, example);
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Goodsexchange record) {
		this.goodsexchangeMapper.updateByPrimaryKeySelective(record);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Goodsexchange record) {
		this.goodsexchangeMapper.updateByPrimaryKey(record);
		return 0;
	}
	/**查询所有兑换码 */
	@Override
	public List<Goodsexchange> selectListAll() {
		return this.goodsexchangeMapper.selectListAll();
	}


}
