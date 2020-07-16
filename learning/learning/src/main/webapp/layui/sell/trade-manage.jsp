<%@ page import="com.hsfund.bhive.common.model.User" %>
<%@ page import="com.hsfund.bhive.web.baseController.LoginAction" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>交易管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/hsfund-ir.css">
    <!--daterangepicker-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/daterangepicker3/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/zTree/css/bootstrapStyle/bootstrapStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/layui-v2.5.6/layui/css/layui.css" media="all">
</head>

<body>
<div id= "main_container" style="width: 98%;">

    <div id="tab_context">
    	<div class="layui-tab layui-tab-card">
    		<ul class="layui-tab-title">
    			<li class="layui-this">交易认购</li>
    			<li>交易申购</li>
    			<li>交易赎回</li>
    			<li>交易驳回修改</li>
    			<li>交易复核</li>
    			<li>交易勾兑</li>
    		</ul>
    		
	    	<div class="layui-tab-content">
	    		<div class="layui-tab-item layui-show">
	    			<table class="layui-hide" id="trade_sub_table" lay-filter="trade_sub_table">
	    			</table>
	    		</div>
	    		<div class="layui-tab-item">
	    			<table id="trade_allot_table" lay-filter="trade_allot_table">
	    			</table>
	    		</div>
	    		<div class="layui-tab-item">
	    			<table id="trade_redeem_table">
	    			</table>
	    		</div>
	    		<div class="layui-tab-item">
	    			<table id="trade_reject_table">
	    			</table>
	    		</div>
	    		<div class="layui-tab-item">
	    			<table id="trade_review_table">
	    			</table>
	    		</div>
	    		<div class="layui-tab-item">
	    			<table id="trade_blend_table">
	    			</table>
	    		</div>
	    	</div>
    	</div>
    </div>
</div>

<script role="v" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layui-v2.5.6/layui/layui.all.js"></script>
<!-------------------------------------- datarangepicker -------------------------------------------------------->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/daterangepicker3/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/daterangepicker/moment-with-locales.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/daterangepicker/knockout-3.4.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/daterangepicker3/daterangepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/zTree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/zTree/jquery.ztree.exhide.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ta/sell/trade-manage.js"></script>

<script type="text/html" id="table_btn">
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="view">查看</a>
	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>
</body>

<div id="trade_sub_form" style="display:none">
	<div class="layui-form layui-form-pane">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">委托方式</label>
				<div class="layui-input-inline">
					<div class="layui-input-inline">
						<select name="way" lay-filter="trade_sub_way">
							<option value="0">传真交易</option>
							<option value="1">邮件交易</option>
						</select>
					</div>
				</div>
			</div>
			
			<div class="layui-inline">
				<label class="layui-form-label">下单时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="trade_sub_time"/>
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">交易账号</label>
				<div class="layui-input-inline">
					<div class="layui-input-inline">
						<input type="text" class="layui-input" id="trade_sub_trade_no"/>
					</div>
				</div>
			</div>
			
			<div class="layui-inline">
				<label class="layui-form-label">下单时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="trade_sub_time"/>
				</div>
			</div>
		</div>
	</div>
</div>
</html>
