var jobRecommendList = jobRecommendList ? jobRecommendList : {};
jobRecommendList.URL = {
		list:"/jobRecommend/list",
		updateStatus:"/jobRecommend/updateStatus",
}

/*
 *页面自动加载
 */
$(function() {
	platformCommend.init();  
});

var platformCommend={
		
			
		/*
		 *初始化数据
		 */
		init:function(){
			this.initProvince("contactProvince");
			this.initColumns();
			this.search();
			this.bindEven();
			
			commomData.config.initFullAddress('jobProvince','jobCity');
			commomData.config.initFullCategory('categoryPid','categoryCid');
		},
		
		
		/*
		 *加载省
		 */
		initProvince:function(province_name) {
			$.ajax({
				url:WebHelper.GetAddress(),
				data:{cid:0},
				dataType:'jsonp',
				async:false,
				success:function(res){
					$('#'+province_name).combobox({
						data:res,
						valueField:'id',
						textField:'name',
						editable:false,
						onChange:function(){
							var provinceId = $('#'+province_name).combobox('getValue');
							platformCommend.initCity(provinceId,"contactCity");
						}
					});

				}
			});
		},
		

		/*
		 *加载市
		 */
		initCity:function(provinceId,city_name){
			$.ajax({
				url:WebHelper.GetAddress(),
				data:{cid:provinceId},
				dataType:'jsonp',
				async:false,
				success:function(res){
				/*	var data = $.merge([{
						id: -1,
						name: '选择市'
					}], res.data);*/
					
					$('#'+city_name).combobox({
						data:res,
						valueField:'id',
						textField:'name',
						editable:false,
						onChange:function(){
							//var cityId =  $('#'+city_name).combobox('getValue');
							//initArea(cityId);
						}
					});
				}
			});
		},

		
		/*
		 *初始化报表表头
		 */
		initColumns:function(){			
			var columns=[
			             //{field:'registerNo',title:'报名编号',width:100,align:'left',checkbox:true}//如果需要复选框时需要增加checkbox:true
			             {field:'recomdAddress',title:'推荐地区',width:100,align:'left'}
			             ,{field:'code',title:'职位编号',width:200,align:'left'}
			             ,{field:'sources',title:'职位来源',width:80,align:'left',
			            	 formatter: function (value, rec, rowIndex) {
			            		 return  "蓝领带";
			            	 }
			             }
			             ,{field:'jobAddress',title:'职位地区',width:200,align:'left'}
			             ,{field:'compName',title:'公司名称',width:200,align:'left'}
			             ,{field:'categoryPName',title:'职位分类',width:120,align:'left'}
			             ,{field:'categoryCname',title:'职位名称',width:80,align:'left'}
			             ,{field:'jobName',title:'招工标题',width:140,align:'left'}
			             ,{field:'applyCount',title:'报名人数',width:50,align:'left'}
			             ,{field:'pushTime',title:'发布时间',width:150,align:'left', formatter: function (value, rec, rowIndex) {
			            		 return DateTools.formatDate(value,"yyyy-MM-dd hh:mm:ss");
			            	 }}
			             ,{field:'status',title:'职位上架状态',width:100,align:'left',
			            	 formatter: function (value, rec, rowIndex) {
			            		 var msg = "未上架";
			            		 if(value == 1){
			            			 msg = "已上架";
			            		 }
			            		 if(value == 2){
			            			 msg = "已下架";
			            		 }
			            		 return msg;
			            	 }}
			             ,{field:'operateion',title:'操作',width:80,align:'center',
			            	 formatter: function (value, data, rowIndex) {
			            		 var recId = data.recomId;
			            		 var operationButton = "";
			            		 if(data.status == 1){
			            			 if(data.recStatus == 0 || data.recStatus == 2){
				            			  operationButton= "<a class='btn btn-l' href='#' onClick='platformCommend.pushStatus("+recId+",1);'><i class='i-op i-op-up'></i>推荐</a>";
				            		 }else{
				            			 operationButton ="<a class='btn btn-l' href='#' onClick='platformCommend.pushStatus("+recId+",2);'><i class='i-op i-op-down'></i>取消推荐</a>";
				            		 }
			            		 }else{
			            			 operationButton = '-';
			            		 }
			            		 
			            		
			            	
			            		 return  operationButton;
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
			$('#dataGrid').datagrid({
				url: jobRecommendList.URL.list,
//				queryParams:params,
//				rownumbers: true, //显示行号
				singleSelect: false, //是否单选
				pagination: true, //分页控件
				pageNumber:1,
				pageSize:10,
				pageList:[6,3,1],
				autoRowHeight: true,
				fit: true,
				striped: false, //设置为true将交替显示行背景
				fitColumns: true,//设置是否滚动条  		
				nowrap: false,
				remotesort: true,
				checkOnSelect: true,
				selectOnCheck:true,
				method: "get", //请求数据的方法
				loadMsg: '数据加载中,请稍候......',
				idField:'id',
				columns:[ this.initColumns()],			  		
				//异常处理（备注：因方便调试，后台功能正常后请把代码体copy到方法onLoadSuccess ）
				onLoadError: function() {

				},
				//成功处理
				onLoadSuccess:function(data){

				},		  	
				toolbar:'#tb'
			});
			pageopt = $('#dataGrid').datagrid('getPager').data("pagination").options;					  		
		},

		/**
		 *修改状态
		 */        
		pushStatus:function(recId,status){
			console.log(recId,status)

			$.ajax({
				url:jobRecommendList.URL.updateStatus,
				data:{id:recId,status:status},
				dataType:'json',
				async:false,
				success:function(data){
					if(data.status == "200"){
						commonTools.successMsgDialog("操作成功");
						$('#dataGrid').datagrid('reload')
					}else{
						commonTools.errorMsgDialog("操作失败!"+data.msg);
					}
				}
			});
		},

		
		/*
		 *导出EXCEL功能
		 */
		outExcel:function(){
			alert("导出EXCEL报表");
		},
		
		
		
		/**
		 * 绑定事件
		 */
		bindEven:function(){
			//search
			$("#searchId").on('click',function(){
					var searchFormData = JSONTools.arrayToJson($("#searchForm").serializeArray());
					$("#dataGrid").datagrid("load", {"recJson" : JSON.stringify(searchFormData)});
			})	
			
			//clear
			$("#reset").on('click',function(){
				$("#searchForm").form('reset');
				$("#dataGrid").datagrid('load',{});
			});
		}

}


