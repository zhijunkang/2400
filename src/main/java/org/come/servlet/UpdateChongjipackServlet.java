package org.come.servlet;


import org.come.bean.managerTable;
import org.come.entity.ChongjipackBean;
import org.come.server.GameServer;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.come.server.GameServer;
import java.util.HashMap;
import java.util.Map;


public class UpdateChongjipackServlet extends HttpServlet {

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

		String chongjipack = request.getParameter("chongjipack");
		String type = request.getParameter("type");
		ChongjipackBean chongjipackBean = GsonUtil.getGsonUtil().getgson().fromJson(chongjipack, ChongjipackBean.class);
		if(type.equals("insert")){
			AllServiceUtil.getChongjipackServeice().insertChongjipack(chongjipackBean);
		}else if(type.equals("del")){
			String id = request.getParameter("id");
			AllServiceUtil.getChongjipackServeice().deleteChongjipack(Integer.parseInt(id));
		} else{
			AllServiceUtil.getChongjipackServeice().updateChongjipack(chongjipackBean);
		}
		GameServer.refreshBean();
		returnData.put("status", 200);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(GsonUtil.getGsonUtil().getgson().toJson(returnData));
		printWriter.flush();
		printWriter.close();

	}


}
