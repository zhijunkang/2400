package gl.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.come.tool.NewAESUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Test {


	// 存放物品，ID，物品名称
	public static Map<String, String> getItems(File file) throws BiffException, IOException, RowsExceededException, WriteException {
		Map<String, String> item = new HashMap<String, String>();
		Workbook items = Workbook.getWorkbook(file);
		Cell cell1, cell2;
		// 获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
		Sheet isheet = items.getSheet(0);
		// 获取左上角的单元格
		cell1 = isheet.getCell(0, 0);
		System.out.println("标题：" + cell1.getContents());

		for (int i = 1; i < 3142; i++) {
			// 获取每一行的单元格
			cell1 = isheet.getCell(0, i);// （列，行）
			cell2 = isheet.getCell(1, i);
			if ("".equals(cell1.getContents()) == true) // 如果读取的数据为空
				continue;
			item.put(cell1.getContents(), cell2.getContents());
		}
		items.close();

		
		return item;
	}
	
	// 写excel
	public static void writeXls(File file,List<List<String>> excel) throws IOException, RowsExceededException, WriteException {
		// 创建文件
		file.createNewFile();
		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		// 创建sheet
		WritableSheet sheet = workbook.createSheet("sheet1", 0);
		// 添加数据
		String[] title = { "id", "name", "items", "itemgoods" };
		Label label = null;
		// 写标题
		for (int j = 0; j < title.length; j++) {
			label = new Label(j, 0, title[j]);
			sheet.addCell(label);
		}
		// 写数据
		for(int i = 0 ; i < excel.size() ; i++) {
			for(int j = 0 ; j < excel.get(i).size(); j++) {
				//for (int m = 0; m < title.length; m++) {
					label = new Label(j, i, excel.get(i).get(j));
					sheet.addCell(label);
				//}
			}
		}
		workbook.write();
		workbook.close();
	}
	
	public static List<List<String>> getExcelData(Map<String,String> item,File file){
		Cell cell1, cell2, cell3;
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			// 创建sheet
			Workbook book = Workbook.getWorkbook(file);
			// 获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
			Sheet sheet = book.getSheet(0);
			// 获取左上角的单元格
			cell1 = sheet.getCell(0, 0);
			System.out.println("标题：" + cell1.getContents());

			for (int i = 1; i < 320; i++) {
				List<String> list2 = new ArrayList<String>();
				// 获取每一行的单元格
				cell1 = sheet.getCell(0, i);// （列，行）
				cell2 = sheet.getCell(1, i);
				cell3 = sheet.getCell(8, i);
				if ("".equals(cell1.getContents()) == true) // 如果读取的数据为空
					continue;

				String itemName = cell3.getContents();
				String[] names = itemName.split("\\|");
				StringBuffer sb = new StringBuffer();
				for (String name : names) {
					if (name.startsWith("物品")) {
						String[] n = name.split("&");
						for (String nn : n) {
							if (nn.startsWith("物品")) {
								continue;
							}
							sb.append("【获得】");
							String[] m = nn.split("\\$");
							String[] ids = m[0].split("-"); // 物品ID
							for (String id : ids) {
								sb.append(id + "(" + item.get(id) + ")");
							}
							sb.append("数量" + m[1]);
							if (m.length > 2) {
								sb.append("几率" + m[2]);
							}
							sb.append("\r\n");
						}
					}
				}
				list2.add(cell1.getContents());
				list2.add(cell2.getContents());
				list2.add(cell3.getContents());
				list2.add(sb.toString());
				list.add(list2);
				System.out.println(cell1.getContents() + "\t" + cell2.getContents() + "\t" + cell3.getContents());
			}
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<List<String>> fanxie(File file){
		Cell cell1, cell2, cell3;
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			// 创建sheet
			Workbook book = Workbook.getWorkbook(file);
			// 获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
			Sheet sheet = book.getSheet(0);
			// 获取左上角的单元格
			cell1 = sheet.getCell(0, 0);
			System.out.println("标题：" + cell1.getContents());
			
			String regex1 = "【获得】";
			String regex2 = "数量";
			String regex3 = "\\(.*?\\)";
			String regex4 = "几率";
			
			for (int i = 1; i < 317; i++) {
				List<String> list2 = new ArrayList<String>();
				// 获取每一行的单元格
				cell1 = sheet.getCell(0, i);// （列，行）
				cell2 = sheet.getCell(1, i);
				cell3 = sheet.getCell(3, i);
				if ("".equals(cell1.getContents()) == true) // 如果读取的数据为空
					continue;
				String str = cell3.getContents();
				
				str = str.replaceAll(regex1, "&");
				str = str.replaceAll(regex2, "\\$");
				str = str.replaceAll(regex3, "-");
				str = str.replaceAll(regex4, "\\$");
				str = str.replaceAll("-\\$", "\\$");
				str = str.replaceAll("\n", "");
				System.out.println(str);
				
				list2.add(cell1.getContents());
				list2.add(cell2.getContents());
				list2.add(cell3.getContents());
				list2.add(str);
				list.add(list2);
			}
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		
		try {
//			Map<String, String> map = getItems(new File("E:\\workspace\\GameServer\\src\\main\\resources\\config\\item.xls"));
//			List<List<String>> list = getExcelData(map,new File("E:\\workspace\\GameServer\\src\\main\\resources\\config\\robots.xls"));
//			writeXls(new File("D:/game/txt/test.xls"),list);
			
			Map<String, String> map = getItems(new File("E:\\workspace\\GameServer\\src\\main\\resources\\config\\item.xls"));
//			List<List<String>> list = fanxie(new File("D:/game/txt/test.xls"));
//			writeXls(new File("D:/game/txt/test2.xls"),list);
//			writeXls(new File("D:/game/txt/test.xls"),list);
//			901-80168-80167$1$1
//			309-772-80042-80031$1$5
			
			String str = "81144-81145-81146-81147$2$100" + 
					"";
			StringBuffer sb = new StringBuffer();
			
			String[] n = str.split("&");
			for (String nn : n) {
				if (nn.startsWith("物品")) {
					continue;
				}
				sb.append("【获得】");
				String[] m = nn.split("\\$");
				String[] ids = m[0].split("-"); // 物品ID
				for (String id : ids) {
					sb.append(id + "(" + map.get(id) + ")");
				}
				sb.append("数量" + m[1]);
				if (m.length > 2) {
					sb.append("几率" + m[2]);
				}
				sb.append("\r\n");
			}
			
			System.out.println(sb);
			
			
			str = "【获得】80059(指南录)数量1几率5\r\n" + 
					"【获得】901(神兽碎片)80167(珍稀神兽碎片)80168(鎏金宝鉴碎片)81096(奇异石)80163(化形丹（神）)80027(随机高级灵宝)81023(圣兽要诀)数量1几率1\r\n" + 
					"【获得】544(北冥龙君礼盒)80132(千年灵狐)80134(护山大神)80136(蟹将军)80137(黄巾力士)80138(百花之灵)80140(霹雳手)80143(火麒麟)80145(符咒女娲)80146(女贼之灵)80148(复活女娲)80150(金身罗汉)80151(净坛使者)81182(地威星)81183(地壮星)81184(地藏星)81185(地速星)81186(地走星)81187(地暗星)81067(浪淘沙封印卡)81068(五叶封印卡)数量1几率0.1\r\n" + 
					"【获得】7065(四阶仙器礼盒)数量1几率0.5\r\n" + 
					"【获得】80168(鎏金宝鉴碎片)901(神兽碎片)81251(一级宝石袋)数量5几率5\r\n" + 
					"【获得】80026(随机低级灵宝)81170(地劣星)11005(人物修正卡)616(返老还童丹-孩子用品)81252(四级宝石袋)数量1几率2.5\r\n" + 
					"【获得】188(龙之骨)748(筋骨提气丹)80028(伐骨洗髓丹)80124(秘制亲密丹)731(亲密丹)10081(改名卡)80163(化形丹（神）)数量1几率8\r\n" + 
					"【获得】80042(随机神兵)615(琼浆玉液)数量1几率6.3\r\n" + 
					"【获得】7050(一阶仙器礼盒)81172(演星册)81173(易象符)80023(隐身药)80024(火眼金睛)80025(澄霜)80038(太乙玄黄丹)80039(华韵流光)数量10几率10.1\r\n" + 
					"【获得】80010(神兵石)80070(终极修炼丹)数量5几率9.1\r\n" + 
					"【获得】7051(一阶仙器礼盒)数量10几率2.1\r\n" + 
					"【获得】80036(金风玉露)80037(杜若无心)80049(乾灵聚元丹)81255(帮贡手册)数量20几率16\r\n" + 
					"【获得】167(神兽丹)数量20几率80\r\n" + 
					"【获得】10079(灵宝天威印)10080(灵宝技能书)数量5几率90\r\n" + 
					"【获得】310(六魂之玉)311(无量琉璃)309(补天神石)数量10几率90\r\n" + 
					"【获得】749(武帝袍)750(云罗帐)751(雪蟾蜍)753(五溪散)755(霄汉鼎)756(沧海珠)757(蓝田玉)758(盘古石)727(亲密丹)728(亲密丹)729(亲密丹)730(亲密丹)81228(等级突破丹)81230(成长进阶丹)80059(指南录)数量1几率100\r\n" + 
					""; 
					
			String regex1 = "【获得】";
			String regex2 = "数量";
			String regex3 = "\\(.*?\\)";
			String regex4 = "几率";
			str = str.replaceAll(regex1, "&");
			str = str.replaceAll(regex2, "\\$");
			str = str.replaceAll(regex3, "-");
			str = str.replaceAll(regex4, "\\$");
			str = str.replaceAll("-\\$", "\\$");
			str = str.replaceAll("\r\n", "");
			System.out.println(str);
			
			Date d = new Date();
			d.setTime(1623444801000l);
			System.out.println(d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();

		// 控制法术命中率
		
		// 基数
		double jishu = 71;
		double jishu4 = 86;
		// 熟练度
		double shulian = 30000;
		// 成长
		double chengzhang = 3.6;
		// 忽视
		double hushi = 45;
		// 强法
		double qiangfa = 60;
		// 对方抗性
		double kangxing = 140;
		
		double jichu = jishu + chengzhang * Math.pow(shulian, 0.3);
		
		System.out.println("基础等于" + jichu);
		
		double mingzhong = (jichu + (hushi/1.5) - kangxing) * (1 + (qiangfa/2.5) / 100);
		
		double jichu4 = jishu4 + chengzhang * Math.pow(shulian, 0.3);
		
		System.out.println("基础等于" + jichu4);
		
		double mingzhong4 = (jichu4 + (hushi/1.5) - kangxing) * (1 + (qiangfa/2.5) / 100);
		
		System.out.println("对方抗性为 " + kangxing + " ,我方忽视 " + hushi + " , 强法 " + qiangfa + " 时，5法技能率为" + new BigDecimal(mingzhong).setScale(2,BigDecimal.ROUND_HALF_UP) + "/108");
		System.out.println("对方抗性为 " + kangxing + " ,我方忽视 " + hushi + " , 强法 " + qiangfa + " 时，4法技能率为" + new BigDecimal(mingzhong4).setScale(2,BigDecimal.ROUND_HALF_UP) + "/108");
		
    }
	
	
	    
	    

}

