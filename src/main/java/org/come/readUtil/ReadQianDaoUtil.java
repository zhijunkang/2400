package org.come.readUtil;

import org.come.handler.MainServerHandler;
import org.come.model.QianDao;
import org.come.readBean.AllQianDao;
import org.come.servlet.UpXlsAndTxtFile;
import org.come.tool.ReadExelTool;
import org.come.tool.SettModelMemberTool;
import org.come.until.GsonUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReadQianDaoUtil
{
	/**扫描文件，获得全部npc信息*/
	public static ConcurrentHashMap<Integer, QianDao> selectQianDao(String path, StringBuffer buffer){
		ConcurrentHashMap<Integer, QianDao> qianDaoConcurrentHashMap= new ConcurrentHashMap<>();
		String[][] result = ReadExelTool.getResult("config/"+path+".xls");
		for (int i = 2; i < result.length; i++) {
			if (result[i][0].equals(""))continue;
			QianDao scheme=new QianDao();
			for (int j = 0; j < result[i].length; j++) {
				try {
                    SettModelMemberTool.setReflectRelative(scheme, result[i][j], j);
                } catch (Exception e) {
                    UpXlsAndTxtFile.addStringBufferMessage(buffer, i, j, result[i][j], MainServerHandler.getErrorMessage(e));
                    return null;
                }
			}
			qianDaoConcurrentHashMap.put(scheme.getId(),scheme);

		}

		return qianDaoConcurrentHashMap;
	}
	public static String createQianDao(ConcurrentHashMap<Integer, QianDao> map) {
		AllQianDao allTalent = new AllQianDao();
		Map<BigDecimal, QianDao> allMap=new HashMap<>();
		for (org.come.model.QianDao QianDao:map.values()) {
			allMap.put(BigDecimal.valueOf(QianDao.getId()), QianDao);
		}
		allTalent.setAllTalent(allMap);
		String msgString = GsonUtil.getGsonUtil().getgson().toJson(allTalent);
		return msgString;
	}
}
