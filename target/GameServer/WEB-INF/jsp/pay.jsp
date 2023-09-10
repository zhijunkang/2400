<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="org.come.servlet.PayModifyServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<!-- BEGIN PAGE -->

		<div class="page-content-model">


			<!-- BEGIN PAGE CONTAINER-->        

			<div class="container-fluid">


				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue" style="border: 0px;">
							<div class="portlet-title">
								<div class="caption"><i class="icon-edit"></i>充值</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="javascript:;" class="reload"></a>
								</div>
							</div>
							<div class="portlet-body">
								

								
									<div class="clearfix" style="margin-top: 30px;">
										
										<div class="btn-group">
											<span style="margin:20px 0px 5px 50px;font-size:18px;font-weight: 600;">角色编号:</span>
											<input type="text" class="form-control" id="roleid" placeholder="角色编号是纯数字" style="height: 30px; font-size: 16px; margin: 0 10px 0 10px;" />
											<span style="margin:20px 0px 5px 20px;font-size:18px;font-weight: 600;">人民币:</span>
											<input type="text" class="form-control" id="recharge" placeholder="充值金额或者月卡天数" style="height: 30px; font-size: 16px; margin: 0 10px 0 10px;" />
											<!-- // 支付类型 1仙玉充值 2周月卡充值 3小资冲级礼包充值 4土豪冲级礼包字段 -->
											<select id="type" class="form-control">
												<option value="1">仙玉充值</option>
												<option value="2">周月卡充值</option>
												<option value="3">小资冲级礼包充值</option>
												<option value="4">土豪冲级礼包充值</option>
											</select>
											<button  class="btn blue" style="margin-left: 10px; width: 80px; font-size: 16px;" onclick="pay()">
											确定
											</button>
										</div>

								<br></br>
										<div class="btn-group">
											<span style="margin:20px 0px 5px 50px;font-size:18px;font-weight: 600;">充值比例:</span>
											<input type="text" class="form-control" id="pay" value="<%=PayModifyServlet.get_pay() %>" placeholder="游戏币跟|RMB比例" style="height: 30px; font-size: 16px; margin: 0 10px 0 10px;" />
											<button  class="btn blue" style="margin-left: 10px; width: 80px; font-size: 16px;" onclick="pay_modify()">
											确定
											</button>
										</div>
																		
									</div>
								
								
								<table class="table" style="width: 85%; margin: 40px 0px 0px 35px;" id="">
									<thead>
										<tr style="height: 40px; background-color: #f5f7fb; color: #87898b;">
											<th style="width: 8%; font-size: 16px; font-weight: 300;">序号</th>
											<th style="width: 12%; font-size: 16px; font-weight: 300;">账号</th>
											<th style="width: 10%; font-size: 16px; font-weight: 300;">密码</th>
											<th style="width: 15%; font-size: 16px; font-weight: 300;">管理员姓名</th>
											<th style="width: 15%; font-size: 16px; font-weight: 300;">管理员ID(区域ID)</th>
											<th style="width: 20%; font-size: 16px; font-weight: 300;">操作时间</th>
											<th style="width: 20%; font-size: 16px; font-weight: 300;">操作</th>
										</tr>
									</thead>
									<tbody id="tb">
										
									</tbody>
								</table>
								<div class="tablepages-switch" style="margin: 40px 0px 20px 40%;">
									<button class="button-css1" id="prePage">上 一 页</button>
									<div class="pagenumber-css" id="rowPage">1/1</div>
									<button class="button-css1" id="nextPage">下 一 页</button>
								</div>
							</div>
						<!-- END EXAMPLE TABLE PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT -->
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->
	</div>
<script src="js/pay.js" type="text/javascript"></script> 