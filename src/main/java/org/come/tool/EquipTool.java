package org.come.tool;

import java.util.List;


/**
 * 判断是否为可叠加
 * @author 叶豪芳
 * @date 2017年12月24日 下午12:31:36
 *
 */
public class EquipTool {
	static List<Long> strings = SplitStringTool.splitLong("66666|0-1|8|49-52|88|99|100|111|112|118|119|120|123-127|189|190" +
			"|191|212|492-505|507|513-515|521-524|715|716|721|901-910|2040-2043|2053|2070-2079|2080|2113-2116|" +
			"7005|7010|801-802|1002|1003|1005|1006|1008|2323|2324|728|556|557|889|888|891|744|8889-8893|" +
			"60003|7500-7502|7511|28955|915|918|10086|919|667|923|932|935|936|938|9002|8002|8004|118|8003|2118|2120|739|2124|2127|2128|2129|2119|1101-1103|666|8899");
	public static boolean canSuper( long goodstype ){// 可重叠返回true
		return strings.contains(goodstype);
	}
	public static boolean contains(String[] vs,String key){
		if (vs!=null) {
			for (int i = 0; i < vs.length; i++) {
				if (vs[i].equals(key)) {
					return true;
				}
			}
		}
		return false;
	}
}
