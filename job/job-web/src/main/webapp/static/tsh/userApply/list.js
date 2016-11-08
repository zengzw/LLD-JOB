var userApplyList = userApplyList ? userApplyList : {};
userApplyList.roleType="";
userApplyList.data={};
userApplyList.areaId="";
var varify = true;//用于查询验证,验证开始时间是否小于结束时间 
/*
 *页面自动加载
 */
$(function() {
	platformRegisterReport.init();  
});
var platformRegisterReport={
		getRoleByUserInfo:function(){
			//初始化页面
			commonTools.getByAjax("/server/getServerInfo.do",function(data){
				userApplyList.roleType = data.userInfo.roleType;
				userApplyList.areaId = data.userInfo.bizId;
			});
		},



//		初始化下拉框
		selectInit:function (comboxId,initData) {
			$(comboxId).combobox({
				valueField: 'value',
				textField: 'label',
				data: initData,
				onLoadSuccess: function () {
					$(this).combobox('select', initData[0].value);
				}
			});
		},

		/*
		 *初始化数据
		 */
		init:function(){
			this.getRoleByUserInfo();		
			this.initDefaultValue();
			this.search();
			this.bindEven();
			commomData.config.initFullAddress("provinceId","cityId");
		},

		initDefaultValue:function(){

			//初始化性别控件
			var createSex=[{label: '全部',value: '-1'},{label: '男',value: '1'},{label: '女',value: '0'}];
			this.selectInit("#sex",createSex);

			//初始化状态
			var createStatus=[
			                  {label: '全部',value: '-100'},
			                  {label: '无关系',value: '0'},
			                  {label: '已报名',value: '1'},
			                  {label: '已面试',value: '2'},
			                  {label: '已入职',value: '3'},
			                  {label: '取消报名',value: '-1'},
			                  {label: '面试失效',value: '-2'},
			                  {label: '已入职',value: '-3'},
			                  {label: '已离职',value: '-4'},
			                  {label: '报名异常',value: '7'},
			                  {label: '报名截止',value: '8'},

			                  ];
			this.selectInit("#jobStatus",createStatus);

			commomData.config.initFullAddress("proviceId","cityId");
			commomData.config.initFullCategory('categoryPid','categoryCid');

		},
		getJobStatus:function(v){
			var message="-";
			if(v == 0){
				message="无关系";
			}else if(v == 1){
				message = "已报名";
			}
			else if(v == 2){
				message = "已面试";
			}
			else if(v == 3){
				message = "已入职";
			}
			else if(v == -1){
				message = "取消报名";
			}
			else if(v == -2){
				message = "面试失效";
			}
			else if(v == -3){
				message = "已入职";
			}
			else if(v == -4){
				message = "已离职";
			}
			else if(v == 7){
				message = "报名异常";
			}
			else if(v == 8){
				message = "报名截止";
			}
			return message;

		},
		getSex:function(value){
			var message="-";
			if(value == 1){
				message = "男";
			}else if(value == 0){
				message = "女";
			}
			return message;
		},

		/*
		 *初始化报表表头
		 */
		initColumns:function(){			
			var columns=[
			             //{field:'registerNo',title:'报名编号',width:100,align:'left',checkbox:true}//如果需要复选框时需要增加checkbox:true
			             {field:'code',title:'报名编号',width:200,align:'left'}
			             ,{field:'areaName',title:'所属区域',width:200,align:'left',formatter:function(value,data,index){
			            	 var address = "";
			            	 if(data.pvName != null){
			            		 address +=data.pvName;
			            	 }
			            	 if(data.areaName != null){
			            		 address +=data.areaName;
			            	 }
			            	 if(data.shopName != null){
			            		 address +=data.shopName;
			            	 }
			            	 return address
			             }}
			             ,{field:'shopName',title:'报名网点',width:150,align:'left',formatter:function(value,data,index){
			            	 var address = "";
			            	 if(data.shopName != null){
			            		 address +=data.shopName;
			            	 }
			            	 return address
			             }}
			             ,{field:'name',title:'姓名',width:80,align:'left'}
			             ,{field:'sex',title:'性别',width:40,align:'left',formatter:function(value,data,index){
			            	 return platformRegisterReport.getSex(value);
			             }}
			             ,{field:'phone',title:'电话',width:100,align:'left'}
			             ,{field:'idCard',title:'身份证',width:120,align:'left'}
			             ,{field:'createTime',title:'报名时间',width:120,align:'left',formatter:function(value,data,index){
			            	 return DateTools.formatDate(value,"yyyy-MM-dd hh:mm:ss");
			             }}
			             ,{field:'jobArea',title:'职位地区',width:140,align:'left',formatter:function(value,data,index){
			            	return data.proviceName+data.cityName+data.zoneName;
			             }}
			             ,{field:'compName',title:'公司名称',width:200,align:'left'}
			             ,{field:'ctNameOne',title:'职位分类',width:100,align:'left',}
			             ,{field:'ctNameTwo',title:'职位名称',width:140,align:'left'}
			             ,{field:'status',title:'工友状态',width:80,align:'left',formatter:function(value,data,index){
			            	 return platformRegisterReport.getJobStatus(value);
			             }}
			             ,{field:'operateion',title:'操作',width:80,align:'center',
			            	 formatter: function (value, data, rowIndex) {
			            		 var jobId = data.jobInfoId;
			            		 var userId = data.userId;
//			            		 return "<a href='#' onClick='platformRegisterReport.jobDetailView("+jobId+","+userId+");'><i class='i-op i-op-view'></i>查看</a>";
			            		 return "<a  class='btn btn-l' href='/views/userApply/detail.html?jobId="+jobId+"&userId="+userId+"&callbackurl=/views/userApply/apply_list.html'><i class='i-op i-op-view'></i>查看</a>";
			            	 }
			             }
			             ]
			return columns;
		},

		/*
		 *搜索功能
		 */
		search:function(){
			//请求URL
			var url="testData.json";
			$('#dataGrid').datagrid({
				url: "/applyJob/list",
//				rownumbers: true, //显示行号
				pagination: true, //分页控件
				pageNumber:1,
				pageSize:15,
				fit: true,
				striped: false, //设置为true将交替显示行背景
				fitColumns: true,//设置是否滚动条  		
				nowrap: false,
				method: "get", //请求数据的方法
				loadMsg: '数据加载中,请稍候......',
				idField:'id',
				columns:[ this.initColumns()],			  		
				//异常处理（备注：因方便调试，后台功能正常后请把代码体copy到方法onLoadSuccess ）
				onLoadError: function() {

				},
				//成功处理
				onLoadSuccess:function(data){
					//如果是平台
					if(userApplyList.roleType==3){
						$('#dataGrid').datagrid("hideColumn","areaName"); 
					}else{
						$('#dataGrid').datagrid("hideColumn","shopName"); 
					}
					
					
					$("#query_form").form("load",data);
				},		  	
				toolbar:'#tb'
			});
			pageopt = $('#dataGrid').datagrid('getPager').data("pagination").options;					  		
		},

		/**
		 * 绑定
		 */
		bindEven:function(){
			$("#search_btn").on("click",function(){
				var varify = $("#query_form").form('validate')
				if(!varify){ 
					$.messager.alert('警告','搜索条件有误','warning'); 
					return;
				} 
				var searchFormData = JSONTools.arrayToJson($("#query_form").serializeArray());
				$("#dataGrid").datagrid("load", {"applyJobJson" : JSON.stringify(searchFormData)});
			})

			$("#clean").on("click",function(){
				$("#query_form").form('reset');
				$("#dataGrid").datagrid('load',{});
			})
		},

		/*
		 *跳至职位详情页
		 */        
		jobDetailView:function(jobId,userId){
			location.href="/views/userApply/detail.html?jobId="+jobId+"&userId="+userId+"&callbackurl=/views/userApply/apply_list.html";
		},

		/*
		 *导出EXCEL功能
		 */
		outExcel:function(){
			alert("导出EXCEL报表");
		}

}

//验证开始时间小于结束时间 
$.extend($.fn.validatebox.defaults.rules, {
	md: { 
		validator: function(value, param){ 
			startTime = $(param[0]).datetimebox('getValue'); 
			var d1 = $.fn.datebox.defaults.parser(startTime); 
			var d2 = $.fn.datebox.defaults.parser(value); 
			varify = d2 >= d1; 
			return varify; 

		}, 
		message: '结束时间要大于开始时间！' 
	} 
}) 


