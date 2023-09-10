package com.gl.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.come.action.sys.LoginAction;
import org.come.action.sys.enterGameAction;
import org.come.bean.AdminUserInfo;
import org.come.tool.ReadExelTool;
import org.come.until.ReadTxtUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.util.StringUtil;
import com.gl.model.Param;
import com.gl.model.Result;
import com.gl.model.User;
import com.gl.service.PlayerService;
import com.gl.service.ResultFactory;
import com.gl.service.TokenService;
import com.gl.service.UserService;
import com.gl.token.UserToken;
import com.gl.util.RandomValidateCode;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import sun.misc.BASE64Decoder;

/**
 * 
 * @author Big Green
 * @mail sinmahod@qq.com
 */
@RestController
public class UserController {

	// 存放登录失败的用户IP，五分钟内不允许登录
	public static Map<String, Date> errorUser = new HashMap<String, Date>();


	/**
	 * 处理登录功能
	 */
	@PostMapping(value = "/api/login")
	public Result login(User user, HttpSession session) {
		// 获取用户名密码格式为 用户名|&|密码
		String up = ReadTxtUtil.readFile1(ReadExelTool.class.getResource("/").getPath() + "administrator.db");
		String[] nameAndPwd = up.split("\\|&\\|");
		if (nameAndPwd[0].equals(user.getUserName()) && nameAndPwd[1].equals(user.getPassword())) {
			TokenService tokenService = new TokenService();
			String token = tokenService.getToken(user);
			session.setAttribute("manger",user.getUserName());
			session.setAttribute(UserService.USERNAME, user);
			return ResultFactory.success(token);
		}
		String up2 = ReadTxtUtil.readFile1(ReadExelTool.class.getResource("/").getPath() + "verdd.db");
		String[] nameAndPwd2 = up2.split("\\|VERSION\\|");
		if (nameAndPwd2[0].equals(user.getUserName()) && nameAndPwd2[1].equals(user.getPassword())) {
			TokenService tokenService = new TokenService();
			String token = tokenService.getToken(user);
			session.setAttribute("manger",user.getUserName());
			session.setAttribute(UserService.USERNAME, user);
			return ResultFactory.success(token);
		}
		return ResultFactory.fail("用户名或密码错误，请重新登录！ ");
	}
	
	
	
	/**
	 * 处理登录功能
	 */
	@PostMapping(value = "/api/adminUserlogin")
	public Result adminUserlogin(User user, HttpSession session) {
		// 获取用户名密码格式为 用户名|&|密码
		PlayerService service = new PlayerService();
		Param param = new Param();
		param.setValue2(user.getUserName());
		AdminUserInfo s = service.adminUserList(param);
		List<Map<String, Object>> userList = s.getList();
		System.out.println(userList.get(0).get("ACCOUNT").toString()+"="+user.getUserName());
		System.out.println(userList.get(0).get("PWD").toString()+"="+user.getPassword());
		if(userList!=null && userList.size()>0) {
			if (userList.get(0).get("ACCOUNT").toString().equals(user.getUserName()) && userList.get(0).get("PWD").toString().equals(user.getPassword())) {
				TokenService tokenService = new TokenService();
				String token = tokenService.getToken(user);
				session.setAttribute("manger",user.getUserName());
				session.setAttribute(UserService.USERNAME, user);
				return ResultFactory.success(token);
			}else {
				return ResultFactory.fail("用户名或密码错误，请重新登录！ ");
			}
		}
		return ResultFactory.fail("用户名或密码错误，请重新登录！ ");
	}
	
	
	
	
	
	

	
	  
	@PostMapping(value = "/api/newLogin")
	public Result newLogin(User user, HttpSession session, @RequestBody Map<String, Object> params) {
	    String up = ReadTxtUtil.readFile1(ReadExelTool.class.getResource("/").getPath() + "administrator.db");
	    String[] nameAndPwd = up.split("\\|&\\|");
	    if ((nameAndPwd[0].equals(params.get("userName").toString())) && (nameAndPwd[1].equals(params.get("password").toString()))) {
	      user.setUserName(params.get("userName").toString());
	      user.setPassword(params.get("password").toString());
	      TokenService tokenService = new TokenService();
	      String token = tokenService.getToken(user);
	      session.setAttribute("manger", user.getUserName());
	      session.setAttribute(UserService.USERNAME, user);
	      return ResultFactory.success(token);
	    }
	    return ResultFactory.fail("用户名或密码错误，请重新登录！ ");
	}
	
	
	
	
	@RequestMapping(value = "/api/checkcode")
	public void checkCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置相应类型,告诉浏览器输出的内容为图片
		response.setContentType("image/jpeg");
		// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);

		RandomValidateCode randomValidateCode = new RandomValidateCode();
		try {
			randomValidateCode.getRandcode(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 处理注册功能
	 */
	@PostMapping(value = "/api/register")
	public Result register(User user, HttpServletRequest request, HttpServletResponse res) {
		
		String code = user.getCode();
		if (StringUtils.isEmpty(code)) {
			return ResultFactory.fail("验证码不可为空");
		}

		HttpSession sesion = request.getSession();

		if (!code.equals(sesion.getAttribute(RandomValidateCode.RANDOMCODEKEY))) {
			// 避免一个验证码被多次使用暴力破解验证一次自动删除
			sesion.removeAttribute(RandomValidateCode.RANDOMCODEKEY);
			return ResultFactory.fail("验证码不正确");
		}

		// 验证通过也要马上删除掉验证码
		sesion.removeAttribute(RandomValidateCode.RANDOMCODEKEY);

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		UserService service = new UserService();
		String msg = service.register(user, ip);
		if (StringUtil.isEmpty(msg)) {
			return ResultFactory.success("注册成功");
		}
		return ResultFactory.fail(msg);
	}

	/**
	 * 退出登录
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/api/logout")
	public Result logout(HttpSession session) {
		// 清除 session
		session.invalidate();
		return ResultFactory.success(null);
	}

	/**
	 * 首页基础统计
	 */
//	@UserToken
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/api/stat")
	public Result stat(HttpSession session) {
		UserService service = new UserService();
		return ResultFactory.success(service.getData());
	}
	

	public static String m() throws Exception {
		// 获取网卡，获取地址
		InetAddress ia = InetAddress.getLocalHost();
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			// 字节转换为整数
			int temp = mac[i] & 0xff;
			String str = Integer.toHexString(temp);
			if (str.length() == 1) {
				sb.append("0" + str);
			} else {
				sb.append(str);
			}
		}
		return sb.toString().toUpperCase();
	}
    
	 public static final String publicKeyStr = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAr61/xJKFtJqguGtCLTv0\r\n" + 
	    		"cDqpv6cHdfmXC4cU8RthVx0PrMS86wOZbChexl5yldeFQQuCPuN65eNhCTmIm/Ow\r\n" + 
	    		"HREi80JfOf0fJrvjeav3AwwEx8b4N9Su5kCIZzzAOtGdmDcWX2IyKs2B3WYsx2Wa\r\n" + 
	    		"uSoR3Ve3UduOkPKQtD+205VwferSACHRyUaK2hXNlezVYxclqySNW6y4TUIKb5tE\r\n" + 
	    		"DnsWFevMr9AD1gPpQQRUi0SppKrAYQGqrqfJ6HddZdghMtYdoNTzywy6m12bVMCu\r\n" + 
	    		"Q6FmQQebgVdpeZLIUu9Lnh0EDKO742wIhvdlv2SLcMasphJ+rusq5yk915eei3mM\r\n" + 
	    		"fskBzC5vRZfdE7L5C73Pzhkcdx4DcFtL3nAYodssr47ltAyrimR+n/t6tpu4ml9x\r\n" + 
	    		"Wunrp+/Jtl2G/fViBJ3fQtxgwr00so3L0Gn9S/YF13t0niC4j4QTz0u0rxOjLflJ\r\n" + 
	    		"J7Lgn0IzGubOLEWMzLW8KE3J+LyRZmzGnIxDnzY7HHcwBk+C3GWgtpU9b5N3aVXu\r\n" + 
	    		"p+GHry2L+H+VYmxlxjRgL1z160ZnZJ6C2EdpsB1O3YzW4SIEO7vcurM9hv5lq7DY\r\n" + 
	    		"jw8jsjy1xof5lahT1A2PTBAFFOt+wHxKRCpkQ0l3lOM9i2+HwhihGKGBYdyOqhyu\r\n" + 
	    		"7RibyDz91vF6NltYVBpmHhkCAwEAAQ==";

	    private static PublicKey getPublicKey(String publicKey) throws Exception {
			byte[] keyBytes = new BASE64Decoder().decodeBuffer(publicKey);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			return keyFactory.generatePublic(keySpec);
		}

		public static String decryptByPublicKey(String content) throws Exception {
			// 获取公钥
			PublicKey publicKey = getPublicKey(publicKeyStr);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			byte[] cipherText = new BASE64Decoder().decodeBuffer(content);
			byte[] decryptText = cipher.doFinal(cipherText);
			return new String(decryptText);
		}

		
	}