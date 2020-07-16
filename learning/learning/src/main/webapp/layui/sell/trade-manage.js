/**
 *@author huangww@hsfund.com
 **/

var isSelect = true;
//var isNewAdd='display:none';
var isNewAdd = '';
var forecastSuggest = {
    "-2": "卖出",
    "-1": "减持",
    "0": "中性",
    "1": "增持",
    "2": "买入",
};

$(function () {
	initTabs();
    listTradeSub();
    listTradeAllot();
});

function initTabs() {
	layui.use('element', function() {
		var element = layui.element;
	});
}

function listTradeSub() {
	layui.use('table', function() {
		var table = layui.table;
		
		table.render({
			elem: '#trade_sub_table',
			toolbar: 'default',
			page: true,
			data: [
				{
					subDate:'2020-05-05 10:00:00',
					tradeNo: '1111111111111111111',
					fundCode: '600000',
					money: 12000000,
					customer: '张三',
					certType: '身份证',
					certNo: '888888888888888888'
				}, {
					subDate:'2020-05-05 10:00:00',
					tradeNo: '1111111111111111111',
					fundCode: '600000',
					money: 12000000,
					customer: '张三',
					certType: '身份证',
					certNo: '888888888888888888'
				}
			],
			cols:[[
				{type: 'checkbox', fixed: 'left'},
				{field: 'subDate', title: '下单时间', width: 200},
				{field: 'tradeNo', title: '交易账号', width: 200},
				{field: 'fundCode', title: '基金代码'},
				{field: 'money', title: '认购金额', align: 'right'},
				{field: 'customer', title: '客户名称'},
				{field: 'certType', title: '证件类型'},
				{field: 'certNo', title: '证件号码', width: 200},
				{align: 'center', toolbar: '#table_btn', width: 165, fixed: 'right'}
			]]
		});
		
		table.on('tool(trade_sub_table)', function(obj){
			var row = obj.data;
			var layEvent = obj.event;
			
			layer.open({
				type: 1,
				area: ['800px', '500px'],
				content: $('#trade_sub_form')
			});
		});
		
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			laydate.render({
				elem: '#trade_sub_time',
				type: 'datetime',
				isInitValue: true,
				value: new Date()
			});
		});
		
		layui.use('form', function(){
			var form = layui.form;
			form.render();
		});
	});
}

function listTradeAllot() {
	layui.use('table', function() {
		var table = layui.table;

		table.render({
			elem: '#trade_allot_table',
			toolbar: 'default',
			data: [ {'name':'a', 'age': 3}, {'name':'b', 'age': 4}],
			cols:[[
				{type: 'checkbox', fixed: 'left'},
				{field: 'name', title: 'Name'},
				{field: 'age', title: 'Age'},
				{align: 'center', toolbar: '#table_btn', width: 165}
			]]
		});
		table.on('tool(trade_allot_table)', function(obj){
			var row = obj.data;
			var layEvent = obj.event;
			console.log(row);
			console.log(layEvent);
		});
	});
	
}