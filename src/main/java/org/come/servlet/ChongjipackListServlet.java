package org.come.servlet;


import org.come.bean.managerTable;
import org.come.entity.ChongjipackBean;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ChongjipackListServlet extends HttpServlet {

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Map<String,Object> returnData = new HashMap<>();

		List<ChongjipackBean> chongjipackBeanList = AllServiceUtil.getChongjipackServeice().selectAllPack();
		returnData.put("list",chongjipackBeanList);
		returnData.put("status", 200);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(GsonUtil.getGsonUtil().getgson().toJson(returnData));
		printWriter.flush();
		printWriter.close();

	}


}
