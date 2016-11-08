var jobInfoList = jobInfoList ? jobInfoList : {};
jobInfoList.URL = {
		list:"/jobInfo/queryJobInfoPage",
		batchUpdateTshStatus:"/jobInfo/batch/updateTshStatus",
		updateTshStatus:"/jobInfo/updateTshStatus",
		jobDetail:"/views/jobInfo/job_detail.html"
}
jobInfoList.data={};


$(function() {

	commomData.config.initFullAddress('provinceId','cityId');
	commomData.config.initFullCategory('jobCategoryPid','jobCategoryCid');

	initPage();

	//点击搜索事件
	$("#search_btn").click(function(){
		var searchFormData = JSONTools.arrayToJson($("#searchForm").serializeArray());
		$("#dataGrid").datagrid("load", {"jobInfoJson" : JSON.stringify(searchFormData)});

	});

	//clear
	$("#clearId").on('click',function(){
		$("#searchForm").form('reset');
		$("#dataGrid").datagrid('load',{});
	});


	//全选，反选
	$("#allCheck").on('click',function(){
		$("input[name='jobId']").prop("checked",true);
	})
	$("#removeCheck").bind('click',function(){
		$("input[name='jobId']").prop("checked", false);
	})

	//批量上架
	$("#bath_up").on('click',function(){
		if($("input[name='jobId']:checked").size() == 0){
			commonTools.errorMsgDialog("请选择要操作的数据！");
			return;
		}
		
		var selectError = false;
		$("input[name='jobId']:checked").each(function(){
			var status = $(this).data('status');
			if(status != 2){
//				$(this).prop('checked',false);
				selectError = true;
			}
		})
		
		if(selectError){
			commonTools.errorMsgDialog("不是招聘中的职位不能上架！");
			return;
		}
		
		

		commonTools.confirmDialog("确认要把已选择的职位批量上架吗？",function(p){
			if(p == true){
				batchUpdateReqeuest(1);
			}
		});

	});


	//批量下架
	$("#bath_down").on('click',function(){
		if($("input[name='jobId']:checked").size() == 0){
			commonTools.errorMsgDialog("请选择要操作的数据！");
			return;
		}

		commonTools.confirmDialog("确认要把已选择的职位批量下架吗？",function(p){
			if(p == true){
				batchUpdateReqeuest(2);
			}
		});

	});

});


/**
 * 批量上下架后台请求
 * @param params
 * @param status
 */
function batchUpdateReqeuest(status){
	var checkValue = [];
	$("input[name='jobId']:checked").each(function(){
		checkValue.push($(this).val());
	})

	$.ajax({
		type: "post",
		url: jobInfoList.URL.batchUpdateTshStatus,
		data:{"jobIds":checkValue,"status":status},
		dataType:"json",
		cache: false,
		async: false,
		success: function(resp) {
			if(resp.status == "200"){
				commonTools.successMsgDialog("操作成功");
				$('#dataGrid').datagrid('reload')
			}else{
				commonTools.errorMsgDialog(resp.msg);
			}
		}
	});
}

//初始化下拉框
jobInfoList.selectInit = function (comboxId,initData) {
	$(comboxId).combobox({
		valueField: 'value',
		textField: 'label',
		data: initData,
		onLoadSuccess: function () {
			$(this).combobox('select', initData[0].value);
		}
	});
};


/**
 * 初始化页面元素
 */
function initPage(){
	//获取当前用户角色
	//getRoleByUserInfo();

	//初始化状态
	var createStatus=[
	                  {label: '全部',value: '-1'},
	                  {label: '招聘中',value: '2'},
	                  {label: '已暂停',value: '4'},
	                  {label: '已结束',value: '5'},
	                  {label: '已删除',value: '6'}];
	jobInfoList.selectInit("#status",createStatus);

	//初始化上下架状态
	var createTshStatus=[
	                     {label: '全部',value: '-1'},
	                     {label: '未上架',value: '0'},
	                     {label: '已上架',value: '1'},
	                     {label: '已下架',value: '2'}];
	jobInfoList.selectInit("#tshStatus",createTshStatus);

	//进行搜索请求，渲染数据
	search(jobInfoList.URL.list,null);
}


/**
 * 格式上下架状态
 * @param value
 * @param row
 * @param index
 * @returns {String}
 */
function getTshStatus(value, row, index){
	var message="未上架";
	if(value == 1){
		message = "已上架";
	}else if(value == 2){
		message = "已下架";
	}
	return message;
}

/**
 * 格式化状态
 * @param value
 * @param row
 * @param index
 * @returns {String}
 */
function getStatus(value, row, index){
	var message="审核中";
	if(value == 2){
		message = "招聘中";
	}else if(value == 4){
		message = "已暂停";
	}else if(value == 5){
		message = "<span style='color:red'>已结束</span>";
	}
	else if(value == 6){
		message = "已删除";
	}
	return message;
}


/**
 * 搜索
 * 
 * @param url
 * @param data
 */
function search(url, data) {
	$('#dataGrid').datagrid(
			{
				url : url,
				queryParams : data,
				striped:false,
				fitColumns:true,
				fixed:true,
//				singleSelect:true,
//				rownumbers:false,
				pagination:true,
				method: "POST",
				nowrap:false,
				fitColumns:true,//true只适应列宽，防止出现水平滚动条；默认为false
				//rownumbers:true,
				//pageList: [10, 20, 50],
				pageSize: 10,
				method : "get", // 请求数据的方法
				loadMsg : '数据加载中,请稍候......',
				idField : 'id',
				columns : [ [
				             {field: 'check', title: '选择', width: 100, align: 'center',formatter:function(value,row,index){
				            	 return "<input type=\"checkbox\" data-status="+row.status+" name=\"jobId\" value=\"" + row.jobId + "\" >";
				             }}, 
				             {field: 'code', title: '职位编号', width: 230, align: 'center'}, 
				             {field: 'sources',title: '职位来源',width: 200,align: 'center',formatter:function(value,row,index){
				            	 return "蓝领带";
				             }},
				             {field: 'adress',title: '职位地区',width: 200,align: 'center',formatter:function(value,row,index){
				            	 return row.proviceName + row.cityName + row.zoneName;
				             }},
				             {field: 'compName',title: '公司名称',width: 200,align: 'center',formatter:function(value,row,index){
				            	 return row.companyVo.name;
				             }},
				             {field: 'ctNameOne',title: '职位分类（岗位）',width: 150,align: 'center'},
				             {field: 'ctNameTwo',title: '职位名称（详细分类)',width: 150,align: 'center'},
				             {field: 'jobName', title: '招工标题', width: 200, align: 'center'},
				             {field: 'applyNumCount', title: '报名人数', width: 200, align: 'center'},
				             {field: 'pushTime',title: '上架时间',width: 200,align: 'center',formatter:function(value,data,index){
				            	 return DateTools.formatDate(value,"yyyy-MM-dd hh:mm:ss");
				             }
				             },
				             {field: 'status', title: '职位状态', width: 100, align: 'center',formatter:function(value,data,index){
				            	 return getStatus(value,data,index);
				             }
				             },
				             {field: 'tshStatus', title: '上架状态', width: 100, align: 'center',formatter:function(value,data,index){
				            	 return getTshStatus(value,data,index);
				             }
				             },
				             {field:'oper',title:'操作',align:'center',width:200,fitColumns :true,formatter: function(value,data,index) {
				            	 var jobId = data.jobId;
				            	 var html =  '<a class="btn btn-l" id="id_view" href="javascript:;" onclick="jobInfoList.view('+jobId+')"><i class="i-op i-op-view-1"></i> 查看</a>';
				            	 if(data.tshStatus == 0
				            			 || data.tshStatus == 2){
				            		 html += '<a class="btn btn-l" href="javascript:;" id="id_down")" onclick="jobInfoList.updateStatus('+jobId+',1)"><i class="i-op i.i-op-up"></i>上架</a>';
				            	 }else{
				            		 html += '<a class="btn btn-l" href="javascript:;" id="id_down")" onclick="jobInfoList.updateStatus('+jobId+',2)"><i class="i-op i.i-op-down"></i>下架</a>';	
				            	 }

				            	 return html;
				             }
				             }
				             ]
				],
				onLoadError : function() {
					$.messager.alert('操作提示', '获取信息失败...请联系管理员!', 'error');
				},
				onLoadSuccess : function(data) {
					$("#query_form").form("load",jobInfoList.data);
				},
				toolbar : '#tb'
			});
	pageopt = $('#dataGrid').datagrid('getPager').data("pagination").options;
}

/**
 * 查看调整
 */
jobInfoList.view = function (id) { 
	location.href=jobInfoList.URL.jobDetail+"?jobId="+id+"&callbackurl=/views/jobInfo/job_info_list.html";
};


/**
 * 上下架操作 
 */
jobInfoList.updateStatus = function (id,status) { 

	$.ajax({
		type: "post",
		url: jobInfoList.URL.updateTshStatus,
		data:{"jobId":id,"status":status},
		dataType:"json",
		cache: false,
		async: false,
		success: function(resp) {
			if(resp.status == "200"){
				commonTools.successMsgDialog("操作成功");
				$('#dataGrid').datagrid('reload')
			}else{
				commonTools.errorMsgDialog(resp.msg);
			}
		}
	});
};

