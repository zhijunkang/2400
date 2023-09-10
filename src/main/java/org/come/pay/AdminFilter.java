package org.come.pay;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.come.bean.RequestReturnBean;
import org.come.bean.managerTable;
import org.come.until.GsonUtil;

public class AdminFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// chain.doFilter(request, response);//通过Filter链式的调用进行过滤
		HttpServletRequest q1 = (HttpServletRequest) request;
		//HttpServletResponse res = (HttpServletResponse) response;
		// System.out.println(response);
		// System.out.println(11);
		String path = q1.getRequestURI();
		//System.out.println(path);
		//q1.getSession().getAttribute("manger");
		if (q1.getSession().getAttribute("manger") == null) {
			if (path.endsWith("/nishishabiwocaosinimade") || path.endsWith("/login.js") || path.contains("/GetTXT/")
					|| path.contains("/js/") || path.contains("media")|| path.contains("/META-INF/")|| path.contains("/classes/")|| path.contains("/lib/")) {
				chain.doFilter(request, response);
			} else if (path.endsWith("/GameServer/api/login") || path.endsWith("/GameServer/api/newLogin") || path.endsWith("/GameServer/api/adminUserlogin")) {
				//String condition = request.getParameter("Service");
				//RequestReturnBean bean = GsonUtil.getGsonUtil().getgson().fromJson(condition, RequestReturnBean.class);
				//managerTable manege = GsonUtil.getGsonUtil().getgson().fromJson(bean.getContent(), managerTable.class);
				//if (bean.getRequresHeader().equals("10006") && manege.getControlStyle() == 6666) {
					chain.doFilter(request, response);
				//}
			}
			return;
		}else {
			if (path.endsWith("/nishishabiwocaosinimade")) {
//				HttpServletRequest q1 = (HttpServletRequest) request;
//				res.sendRedirect("/index");
				request.getRequestDispatcher("index").forward(request, response);
				return;
			}
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
	}

}
