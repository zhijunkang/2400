package com.gl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.come.entity.RoleTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.model.Param;
import com.gl.model.Result;
import com.gl.service.PlayerService;
import com.gl.service.ResultFactory;
import com.gl.token.UserToken;
/**
 * 
 * @author Big Green
 * @mail sinmahod@qq.com
 */
@RestController
public class PlayerController {

	/**
	 * 查询所有玩家角色
	 * @param param
	 * @return
	 */
//	//@UserToken
    @PostMapping(value = "/api/role")
    public Result roles(Param param) {
    	PlayerService service = new PlayerService();
        return ResultFactory.success(service.getRole(param));
    }
	/**
	 * 查询所有玩家角色（新）
	 * @param param
	 * @return
	 */
	//@UserToken
	@PostMapping(value = "/api/roleList")
	public Result roleList(@RequestBody Map<String, Object> params) {
		Param param = new Param();
		param.setPageNum(Integer.parseInt(params.get("PageNum").toString()));
		param.setPageSize(Integer.parseInt(params.get("PageSize").toString()));
		param.setValue1(params.get("Value1").toString());
		param.setValue2(params.get("Value2").toString());
		PlayerService service = new PlayerService();
		return ResultFactory.success(service.getRole(param));
	}
	  /**
     ** 修改解锁码(新)
     * @param param
     * @return
     */
	//@UserToken
	@PostMapping(value = "/api/updatelockpwd")
    public Result updatelockpwd(@RequestBody Map<String, Object> params) {
		Param param = new Param();
		param.setValue1(params.get("value1").toString());
		param.setValue2(params.get("value2").toString());
		
    	PlayerService service = new PlayerService();
    	if (service.editLockPassword(param)) {
    		return ResultFactory.success(null);	
    	}
    	return ResultFactory.fail("操作失败");
    }
	/**
	 * 服务器清档
	 * @param param
	 * @return
	 */
	//@UserToken
    @PostMapping(value = "/api/deleteSQL")
    public Result deleteSQL(Param param) {
    	PlayerService service = new PlayerService();
    	RoleTable s = new RoleTable();
        return ResultFactory.success(service.deleteSQL(s));
    }
	
    /**
     * 修改解锁码
     * @param param
     * @return
     */
	//@UserToken
	@PostMapping(value = "/api/lockpwd")
    public Result lockpwd(Param param) {
    	PlayerService service = new PlayerService();
    	if (service.editLockPassword(param)) {
    		return ResultFactory.success(null);	
    	}
    	return ResultFactory.fail("操作失败");
    }
	/**
	 * 设置GM特权
	 * @param param
	 * @return
	 */
	//@UserToken
	@PostMapping(value = "/api/updateGMRole")
	public Result updateGMRole(Param param) {
		PlayerService service = new PlayerService();
		if (service.updateGMRole(param)) {
			return ResultFactory.success(null);	
		}
		return ResultFactory.fail("操作失败");
	}
	/**
	 * 删除角色
	 * @param param 
	 * @return
	 */
	//@UserToken
	@PostMapping(value = "/api/deleterole")
	public Result deleterole(Param param) {
		PlayerService service = new PlayerService();
		if (service.deleteRolePwdForRid(param)) {
			return ResultFactory.success(null);	
		}
		return ResultFactory.fail("操作失败");
	}
	
	/**
	 * 修改密码
	 * @param param 
	 * @return
	 */
	//@UserToken
	@PostMapping(value = "/api/updatePwdUser")
	public Result updatePwdUser(Param param) {
		PlayerService service = new PlayerService();
		if (service.updatePwdUserForRid(param)) {
			return ResultFactory.success(null);	
		}
		return ResultFactory.fail("操作失败");
	}
	
	/**
	 * 修改角色坐骑
	 * @param param 
	 * @return
	 */
//	//@UserToken
	@PostMapping(value = "/api/updateMount")
	public Result updateMount(Param param) {
		PlayerService service = new PlayerService();
		if (service.updateMountForRid(param)) {
			return ResultFactory.success(null);	
		}
		return ResultFactory.fail("操作失败");
	}
	
	/**
	 * 查询交易记录
	 * @param param 
	 * @return
	 */
	//@UserToken
	@PostMapping(value = "/api/selectGoodsRecord")
	public Result selectGoodsRecord(Param param) {
		PlayerService service = new PlayerService();
		return ResultFactory.success(service.selectGoodsRecord(param));
	}
	
    /**
     * 对玩家进行操作：禁言/解禁   封号/开启   踢下线
     * @param param
     * @return
     */
	//@UserToken
	@PostMapping(value = "/api/roleoperation")
    public Result operation(Param param) {
    	PlayerService service = new PlayerService();
    	if (service.operation(param)) {
    		return ResultFactory.success(null);	
    	}
    	return ResultFactory.fail("操作失败，请确认该玩家是否存在");
    }
	
	/**
     * 充值
     * @param param
     * @return
     */
	//@UserToken
	@PostMapping(value = "/api/recharge")
    public Result recharge(Param param) {
    	PlayerService service = new PlayerService();
    	if (service.rechargeCallBack(param)) {
    		return ResultFactory.success(null);	
    	}
    	return ResultFactory.fail("操作失败");
    }
	
	/**
     * 授权充值
     * @param param
     * @return
     */
	//@UserToken
	@PostMapping(value = "/api/userAdminRecharge")
    public Result userAdminRecharge(Param param) {
    	PlayerService service = new PlayerService();
    	if (service.userAdminRechargeCallBack(param)) {
    		return ResultFactory.success(null);	
    	}
    	return ResultFactory.fail("操作失败");
    }
	
	/**
	 * 发卡人员列表管理
	 * @param param
	 * @return
	 */
	//@UserToken
    @PostMapping(value = "/api/adminUserList")
    public Result adminUserList(Param param) {
    	PlayerService service = new PlayerService();
        return ResultFactory.success(service.adminUserList(param));
    }
	/**
	 * 发卡人员添加
	 * @param param
	 * @return
	 */
	//@UserToken
    @PostMapping(value = "/api/insertUser")
    public Result insertUser(Param param) {
    	PlayerService service = new PlayerService();
        return ResultFactory.success(service.insertUser(param));
    }
	/**
	 * 发卡人员删除
	 * @param param
	 * @return
	 */
	//@UserToken
    @PostMapping(value = "/api/deleteUser")
    public Result deleteUser(Param param) {
		Map<String, Object> params = new HashMap<>();
		params.put("ACCOUNT", param.getValue1());
    	PlayerService service = new PlayerService();
        return ResultFactory.success(service.deleteUser(params));
    }
	/**
	 * 额度修改
	 * @param param
	 * @return
	 */
	//@UserToken
    @PostMapping(value = "/api/updateUserAmount")
    public Result updateUserAmount(Param param) {
    	PlayerService service = new PlayerService();
        return ResultFactory.success(service.updateUserAmount(param));
    }
	
	
	/**
	 * 查询充值记录
	 * @param param
	 * @return
	 */
	//@UserToken
    @PostMapping(value = "/api/rechargeinfo")
    public Result rechargeinfo(Param param) {
    	PlayerService service = new PlayerService();
        return ResultFactory.success(service.getReceipts(param));
    }
	
	
	/**
	 * 查询配置数据库
	 * @param param
	 * @return
	 */
	//@UserToken
    @PostMapping(value = "/api/selectConfigure")
    public Result selectConfigure(Param param) {
    	PlayerService service = new PlayerService();
        return ResultFactory.success(service.selectConfigure());
    }
	
	/**
	 * 查询配置数据库
	 * @param param
	 * @return
	 */
	//@UserToken
    @PostMapping(value = "/api/updateConfigure")
    public Result updateConfigure(HttpServletRequest request,Param param) {
		String fsd = request.getParameter("fsd");
		String cjlzg = request.getParameter("cjlzg");
		if(fsd!=null &&fsd!="") {
			param.setValue1(fsd);
		}
		if(cjlzg!=null &&cjlzg!="") {
			param.setValue2(cjlzg);
		}
    	PlayerService service = new PlayerService();
        return ResultFactory.success(service.updateConfigure(param));
    }
	
}
