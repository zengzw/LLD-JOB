/*
 *全国报名报表
 *author:jeese huang
 *createTime:2016-10-10 19:21:00
 */
var pageopt;

var checkArray=[];
Array.prototype.indexOf = function(val) {
	for (var i = 0; i < this.length; i++) {
		if (this[i].jobId == val) return i;
	}
	return -1;
};
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};
/*
 *页面自动加载
 */
$(function() {
	platformCommendDetail.init();  
});
var platformCommendDetail={
		/*
		 *初始化数据
		 */
		init:function(){
			this.initProvince("province","city");
			this.initColumns();
			commomData.config.initAddress(this.clearData);
			this.search();
			this.bindEvn();
		},


		/*
		 *加载省
		 */
		initProvince:function(province_name,city_name) {
			$.ajax({
				url:WebHelper.GetAddress(),
				data:{cid:0},
				dataType:'jsonp',
				async:false,
				success:function(data){
					var data = $.merge([{
						id: 0,
						name: '选择省'
					}], data);

					$('#'+province_name).combobox({
						data:data,
						valueField:'id',
						textField:'name',
						editable:false,
						onChange:function(){
							$("#city").combobox("setValue", '');
							$("#city").combobox("loadData", {});

							var provinceId = $('#'+province_name).combobox('getValue');
							if(provinceId != 0){
								platformCommendDetail.initCity(provinceId,city_name);
							}
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
				success:function(data){
					var data = $.merge([{
						id: 0,
						name: '选择市'
					}], data);

					$('#'+city_name).combobox({
						data:data,
						valueField:'id',
						textField:'name',
						editable:false,
						onChange:function(){
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
			             {field:'jobId',title:'职位ID',width:100,align:'left',checkbox:true}
			             ,{field:'jobName',title:'职位名称',width:450,align:'left'}
			             ]
			return columns;
		},




		/*
		 *搜索功能
		 */
		search:function(url){
			//请求URL
			$('#dataGrid').datagrid({
				url: url,
				rownumbers: false, //显示行号
				singleSelect: false, //是否单选
				checkOnSelect: true,
				selectOnCheck:true,
				method: "get", //请求数据的方法
				loadMsg: '数据加载中,请稍候......',
				idField:'id',
				loadFilter:function(data){
					var value={total:data.total,rows:[]};
					var x=0;
					for (var i = 0; i < data.data.length; i++) {  
						value.rows[x++]=data.data[i];
					}
					return value;
				},
				columns:[ this.initColumns()],			  		
				//异常处理（备注：因方便调试，后台功能正常后请把代码体copy到方法onLoadSuccess ）
				onLoadError: function(data) {

				},
				//成功处理
				onLoadSuccess:function(data){
					$('#dataGrid').datagrid('clearChecked');
				}
			});				  		
		},


		/*
		 *确认推荐地区
		 */
		confirmArea:function(){
			var city=$.trim($('#city').combobox('getText'));
			var province=$.trim($('#province').combobox('getText'));
			var country=$.trim($('#country').combobox('getValue'));
			var selectValue=country;

			var provinceValue = $('#province').combobox('getValue');
			var cityValue = $('#city').combobox('getValue')
			var countryValue = $('#country').combobox('getValue')

			if(cityValue != 0 ){
				selectValue=province+" - "+city;
			}else if(provinceValue != 0){
				selectValue=province;
			}

			$('#lab_area').text(selectValue);

		},



		/*
		 *确认推荐职位
		 */
		confirmJob:function(){
			var pName = $("#provinceId").combobox('getText')
			var cName = $("#cityId").combobox('getText')
			var cpName = $("#categoryPid").combobox('getText')
			var ccName = $("#categoryCid").combobox('getText')


			if(checkArray.length >= 3){
				commonTools.errorMsgDialog("选择职位数不能大于3！");
				return;
			}

			var address = pName +' - '+cName +' - '+cpName+' - '+ccName;
			var checkedItems = $('#dataGrid').datagrid('getChecked');
			$.each(checkedItems, function(index, item){
				//判断是否已经添加了职位，不重复添加
				var jobId =item.jobId;
				for(var i = 0; i<checkArray.length; i++){
					var data = checkArray[i];
					if(data.jobId == jobId){
						return;
					}
				}

				var selectHtml = "<span id="+jobId+">"+address+' - '+item.jobName 
				+"<a onclick=platformCommendDetail.removeSelect("+jobId+")  style=\"padding-left: 20px\">删除</a></span></br>";

				var vlaue = {jobId:jobId,html:selectHtml};
				checkArray.push(vlaue)
			});      

			//显示内容
			var htmlValue = "";
			for(var i = 0; i<checkArray.length; i++){
				var data = checkArray[i];
				htmlValue += data.html;
			}
			$("#selected_area").html(htmlValue); 

		},


		/**
		 * 删除选项
		 * @param v
		 */
		removeSelect:function(v){

			try{
				var rowIndex= $("input[name='jobId'][value="+v+"]").parents(".datagrid-row").attr("datagrid-row-index");
				$("#dataGrid").datagrid("unselectRow", rowIndex);//取消选择
			}catch(e){
				console.log(e)
			}

			//根据内容删除数组
			checkArray.remove(v);

			//获取到rowIdex
			$("span[id="+v+"]").remove() //移除显示
		},


		/*
		 *保存推荐职位
		 */
		saveJob:function(){
			if(checkArray.length ==0){
				commonTools.errorMsgDialog("请选择要推荐的职位！");
				return;
			}


			//得到选中职位Id
			var jobIds = [];
			for(var i = 0; i<checkArray.length; i++){
				var data = checkArray[i];
				jobIds.push(data.jobId);
			}    
			var formValue ={};
			formValue.jobIds = jobIds.join(",");

			//拼装保存参数。
			var provinceValue = $('#province').combobox('getValue');
			var cityValue = $('#city').combobox('getValue')
			var countryValue = $('#country').combobox('getValue')
			formValue.country = countryValue;
			formValue.province = provinceValue;
			formValue.city=cityValue;	
			if(provinceValue != 0 ){
				formValue.provinceName=$('#province').combobox('getText');
			}
			if(cityValue != 0){
				formValue.cityName=$('#city').combobox('getText');
			}

			console.log(formValue);

			$.ajax({
				url:"/jobRecommend/save",
				data:{"paramJson":JSON.stringify(formValue)},
				dataType:'json',
				async:false,
				success:function(data){
					if(data.status == 200){
						commonTools.successMsgDialog("保存成功！");
						location.href="/views/recommend/list.html";
					}else{
						commonTools.errorMsgDialog(data.msg);
					}
				}
			});
		},
		
		/**
		 * 清空表格数据。单城市联动变化时
		 */
		clearData:function(){
			var item = $('#dataGrid').datagrid('getRows');  
            if (item) {  
                for (var i = item.length - 1; i >= 0; i--) {  
                    var index = $('#dataGrid').datagrid('getRowIndex', item[i]);  
                    $('#dataGrid').datagrid('deleteRow', index);  
                }  
            }  
		},
		
		
		/**
		 * 绑定
		 */
		bindEvn:function(){
			$("#back").on('click',function(){
				location.href="/views/recommend/list.html";
			})
		}

}



