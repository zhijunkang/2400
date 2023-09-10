package org.come.readUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.come.handler.MainServerHandler;
import org.come.model.Alchemy;
import org.come.model.GMshopItem;
import org.come.readBean.AllGMshopItem;
import org.come.readBean.Allalchemy;
import org.come.servlet.UpXlsAndTxtFile;
import org.come.tool.ReadExelTool;
import org.come.tool.SettModelMemberTool;
import org.come.until.GsonUtil;

public class ReadAlchemyUtil
{
	/**扫描文件，获得全部信息*/
	public static ConcurrentHashMap<Integer, Alchemy> selectGMshopItem(String path, StringBuffer buffer){
		ConcurrentHashMap<Integer, Alchemy> alchemyItemConcurrentHashMap= new ConcurrentHashMap<>();
		String[][] result = ReadExelTool.getResult("config/"+path+".xls");
		for (int i = 2; i < result.length; i++) {
			if (result[i][0].equals(""))continue;
			Alchemy scheme=new Alchemy();
			for (int j = 0; j < result[i].length; j++) {
				try {
                    SettModelMemberTool.setReflectRelative(scheme, result[i][j], j);
                } catch (Exception e) {
                    UpXlsAndTxtFile.addStringBufferMessage(buffer, i, j, result[i][j], MainServerHandler.getErrorMessage(e));
                    return null;
                }
			}
			alchemyItemConcurrentHashMap.put(Integer.parseInt(scheme.getAlchemyid()),scheme);

		}

		return alchemyItemConcurrentHashMap;
	}
	public static String createAllalchemy(ConcurrentHashMap<Integer, Alchemy> map) {
		Allalchemy allTalent = new Allalchemy();
		Map<BigDecimal, Alchemy> allMap=new HashMap<>();
		for (Alchemy alchemy:map.values()) {
			allMap.put(BigDecimal.valueOf(Long.parseLong(alchemy.getAlchemyid())), alchemy);
		}
		allTalent.setAllalchemy(allMap);
		String msgString = GsonUtil.getGsonUtil().getgson().toJson(allTalent);
		return msgString;
	}
}
