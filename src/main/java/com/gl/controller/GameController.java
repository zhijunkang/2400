package com.gl.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.gl.model.Param;
import com.gl.model.Result;
import com.gl.service.GameService;
import com.gl.service.ResultFactory;
import com.gl.token.UserToken;

/**
 * 
 * @author Big Green
 * @mail sinmahod@qq.com
 */
@RestController
public class GameController {
    
    /**
     * 读取系统公告
     */
    @UserToken
    @GetMapping("/api/gg")
    public Result read() {
    	GameService service = new GameService();
        return ResultFactory.success(service.readGG());
    }
    
    /**
     * 写入系统公告
     */
    @UserToken
    @PostMapping("/api/gg")
    public Result write(Param param) {
    	GameService service = new GameService();
    	if (service.writeGG(param)) {
    		return ResultFactory.success(null);
    	}
    	return ResultFactory.fail("写入游戏公告错误");
    }
    
    /**
     * 发布系统消息
     * @param param
     * @return
     */
    @UserToken
    @PostMapping("/api/sendmsg")
    public Result sendmsg(Param param) {
    	GameService service = new GameService();
    	if (service.sendMsg(param)) {
    		return ResultFactory.success(null);
    	}
    	return ResultFactory.fail("发布系统消息错误");
    }
    
    /**
     * 读取炼化配置
     */
    @UserToken
    @GetMapping("/api/lhpz")
    public Result readLHPZ() {
    	GameService service = new GameService();
        return ResultFactory.success(service.readConfig());
    }
    
    /**
     * 保存炼化配置
     * @return
     */
    @UserToken
    @PostMapping("/api/lhpz")
    public Result saveLHPZ(@RequestBody Map<String,String> map) {
    	if (map.size() > 0) {
    		GameService service = new GameService();
    		if (service.saveConfig(map)) {
    			return ResultFactory.success(null);	
    		} else {
    	 		return ResultFactory.fail("保存失败，配置参数不匹配");
    		}
    	} else {
    		return ResultFactory.fail("没有接收到参数");
    	}
    }
    
    /**
     * 在线配置更新
     * @return
     */
    @UserToken
    @PostMapping("/api/uploadconfig")
    public Result uploadConfig(@RequestParam(value = "file", required = false)MultipartFile file) {
    	if (file != null) {
    		GameService service = new GameService();
    		String msg;
			try {
				msg = service.updateXls(file);
				System.out.println("在线配置更新："+msg);
				if (StringUtils.isEmpty(msg)) {
	    			return ResultFactory.success(null);	
	    		} else {
	    	 		return ResultFactory.fail(msg);
	    		}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	} else {
    		return ResultFactory.fail("没有接收到参数");
    	}
		return ResultFactory.fail("配置文件解析错误");
    }
    
    /**
     * 读取常规配置
     */
    @UserToken
    @GetMapping("/api/readconfig")
    public Result readConfig() {
    	GameService service = new GameService();
        return ResultFactory.success(service.readXls());
    }
    
    /**
     * 下载常规配置文件
     * @throws IOException 
     */
    @UserToken
    @GetMapping("/api/downconfig")
    public Result downConfig(HttpServletResponse res,@RequestParam(value="fileName")String fileName) throws IOException {
    	res.setHeader("Content-type", "application/vnd.ms-excel");
    	res.setCharacterEncoding("UTF-8");
    	res.setHeader("Content-Disposition", "attachment;filename="+fileName);
    	GameService service = new GameService();
    	String msg = service.downloadXls(fileName, res.getOutputStream());
    	if (StringUtils.isEmpty(msg)) {
			return ResultFactory.success(null);	
		} else {
	 		return ResultFactory.fail(msg);
		}
    }
    
    /**
     * 删除常规配置文件
     */
    @UserToken
    @DeleteMapping("/api/delconfig")
    public Result deleteConfig(@RequestParam(value="fileName")String fileName) {
    	GameService service = new GameService();
        String msg = service.deleteXls(fileName);
        if (StringUtils.isEmpty(msg)) {
			return ResultFactory.success(null);	
		} else {
	 		return ResultFactory.fail(msg);
		}
    }
}