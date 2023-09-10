package org.come.serviceImpl;

import java.util.List;

import org.come.entity.ChongjipackBean;
import org.come.mapper.ChongjipackMapper;
import org.come.service.ChongjipackServeice;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;

import com.github.pagehelper.PageHelper;

public class ChongjipackServeiceImpl implements ChongjipackServeice{
	private ChongjipackMapper chongjipackMapper;
	public static Integer pageNum = 10;
	public ChongjipackServeiceImpl() {
		ApplicationContext ctx = MybatisUntil.getApplicationContext();
		this.chongjipackMapper = ctx.getBean("chongjipackMapper",ChongjipackMapper.class);
	}
	@Override
	public List<ChongjipackBean> selectChongjipack(int type,int page) {
		PageHelper.startPage(page, pageNum);
		return this.chongjipackMapper.selectChongjipack(type);
	}
	@Override
	public int deleteChongjipack(Integer id) {
		return this.chongjipackMapper.deleteChongjipack(id);
	}
	@Override
	public int insertChongjipack(ChongjipackBean chongjipackBean) {
		return this.chongjipackMapper.insertChongjipack(chongjipackBean);
	}
	@Override
	public int updateChongjipack(ChongjipackBean chongjipackBean){
		return this.chongjipackMapper.updateChongjipack(chongjipackBean);
	}
	@Override
	public List<ChongjipackBean> selectAllPack() {
		// TODO Auto-generated method stub
		return this.chongjipackMapper.selectAllPack();
	}

}
