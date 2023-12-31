package org.come.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.come.entity.Message;
import org.come.entity.MessageExample;
import org.come.mapper.MessageMapper;
import org.come.service.IMessageService;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;

public class MessageServiceImpl implements IMessageService {
	
	private MessageMapper mapper;
	
	public MessageServiceImpl() {
		ApplicationContext ctx = MybatisUntil.getApplicationContext();
		this.mapper = ctx.getBean("messageMapper",MessageMapper.class);
	}

	@Override
	public int countByExample(MessageExample example) {
		
		return this.mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MessageExample example) {
		this.mapper.deleteByExample(example);
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(BigDecimal saleid) {
		this.mapper.deleteByPrimaryKey(saleid);
		return 0;
	}

	@Override
	public int insert(Message record) {
		this.mapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(Message record) {
		this.mapper.insertSelective(record);
		return 0;
	}

	@Override
	public List<Message> selectByExample(MessageExample example) {
		// TODO Auto-generated method stub
		return this.mapper.selectByExample(example);
	}

	@Override
	public Message selectByPrimaryKey(BigDecimal saleid) {
		// TODO Auto-generated method stub
		return this.mapper.selectByPrimaryKey(saleid);
	}

	@Override
	public int updateByExampleSelective(Message record, MessageExample example) {
		this.mapper.updateByExampleSelective(record, example);
		return 0;
	}

	@Override
	public int updateByExample(Message record, MessageExample example) {
		this.mapper.updateByExample(record, example);
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Message record) {
		this.mapper.updateByPrimaryKeySelective(record);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Message record) {
		this.mapper.updateByPrimaryKey(record);
		return 0;
	}

}
