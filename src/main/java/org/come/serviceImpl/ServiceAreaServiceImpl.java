package org.come.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.come.bean.ServiceArea;
import org.come.mapper.ServiceAreaMapper;
import org.come.service.ServiceAreaService;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;



@Service
public class ServiceAreaServiceImpl  implements ServiceAreaService{
	//实例化
	private ServiceAreaMapper serviceAreaMapper;
     public ServiceAreaServiceImpl() {
    		ApplicationContext ctx = MybatisUntil.getApplicationContext();
    		// id为类名且首字母小写才能被自动扫描扫到
    		this.serviceAreaMapper = (ServiceAreaMapper)ctx.getBean("serviceAreaMapper");
	}
	@Override
	public int deleteByPrimaryKey(BigDecimal sid) {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(ServiceArea record) {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.insert(record);
	}

	@Override
	public int insertSelective(ServiceArea record) {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.insertSelective(record);
	}

	@Override
	public ServiceArea selectByPrimaryKey(BigDecimal sid) {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.selectByPrimaryKey(sid);
	}

	@Override
	public int updateByPrimaryKeySelective(ServiceArea record) {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ServiceArea record) {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public List<BigDecimal> selectServiceAreaid(ServiceArea record) {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.selectServiceAreaid(record);
	}

	@Override
	public List<ServiceArea> selectAllService() {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.selectAllService();
	}

	@Override
	public List<ServiceArea> selectListAreaForUid(BigDecimal manageid) {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.selectListAreaForUid(manageid);
	}

	@Override
	public List<ServiceArea> selectServiceForPage(int pageNumber) {
		// TODO Auto-generated method stub
		return this.serviceAreaMapper.selectServiceForPage(pageNumber);
	}
		
}