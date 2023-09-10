package org.come.serviceImpl;

import org.come.entity.Record;
import org.come.mapper.RecordMapper;
import org.come.service.RecordService;
import org.come.until.MybatisUntil;
import org.come.until.TimeUntil;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class RecordServiceImpl implements RecordService {
	
	private RecordMapper recordMapper;
	
	public RecordServiceImpl() {
		ApplicationContext ctx = MybatisUntil.getApplicationContext();
		this.recordMapper = ctx.getBean("recordMapper",RecordMapper.class);
	}

	@Override
	public int insert(Record record) {
		// TODO Auto-generated method stub
		record.setRecordTime(TimeUntil.getPastDate());
		return this.recordMapper.insert(record);
	}

	/**查询记录*/
	public List<Record> selectRecordByType(int recordType, int count){
		return this.recordMapper.selectRecordByType(recordType,count);
	}
}
