var commomData = commomData ? commomData : {};
commomData.URL = {
		listHavaDataProvince:"/commom/area/getListProvice", //查询有职位数据的所有省份
		listHaveDataCity:"/commom/area/getListCityByPid",//根据省份Id查询有职位数据的所有城市
		listCategory:"/commom/category/getListCategory",
		listArea:"/commom/area/getListArea", //加载所有城市数据
		listExitCategoryByCityId:"/commom/category/getListCategoryByCityId",
		listExitCategoryByPid:"/commom/category/getListCategoryByPid",
		listJobInfoByCategoryCid:"/jobInfo/queryJobByCategoryCid",
}
commomData.config = {
		/**
		 * 加载有职位的城市数据
		 */
		initAddress:function(clearData){
			var city = $('#cityId').combobox({ 
				valueField:'id', 
				textField:'name', 
				editable:false, 
				onChange:function(v){ 
						clearData();
						commomData.config.getCategoryAddressByCity(v);
				} 
			}); 

			$('#provinceId').combobox({ 
				valueField:'id', 
				textField:'name', 
				editable:false, 
				onChange:function(v){ 
					//级联记载城市
					$.ajax({
						type: "GET",
						url: commomData.URL.listHaveDataCity + "?provinceId="+v,
						cache: false,
						async: false,
						success: function(resp) {
							var data = $.merge([{
								id: -1,
								name: '选择市'
							}], resp.data);
							$("#cityId").combobox("clear");
							$("#cityId").combobox("loadData", data);
						}
					});
				} 
			}); 

			//加载省
			$.ajax({
				type: "GET",
				url: commomData.URL.listHavaDataProvince,
				cache: false,
				async: false,
				success: function(resp) {
					var data = $.merge([{
						id: -1,
						name: '选择省'
					}], resp.data);
					$("#provinceId").combobox("loadData", data);
					clearData();
				}
			});
		},
		
		
		/**
		 * 加载所有城市数据
		 * @param initCagegory
		 */
		initFullAddress:function(pName,cName){
			var city = $('#'+cName).combobox({ 
				valueField:'id', 
				textField:'name', 
				editable:false, 
				onChange:function(v){ 
				} 
			}); 
			
			$('#'+pName).combobox({ 
				valueField:'id', 
				textField:'name', 
				editable:false, 
				onChange:function(v){ 
					//级联记载城市
					$.ajax({
						type: "GET",
						url: commomData.URL.listArea + "?pid="+v,
						cache: false,
						async: false,
						success: function(resp) {
							var data = $.merge([{
								id: -1,
								name: '选择市'
							}], resp.data);
							$("#"+cName).combobox("clear");
							$("#"+cName).combobox("loadData", data);
						}
					});
				} 
			}); 
			
			//加载省
			$.ajax({
				type: "GET",
				url: commomData.URL.listArea+ "?pid=0",
				cache: false,
				async: false,
				success: function(resp) {
					var data = $.merge([{
						id: -1,
						name: '选择省'
					}], resp.data);
					$("#"+pName).combobox("loadData", data);
				}
			});
		},
		
		

		/**
		 * 根据城市 加载有职位分类
		 * 
		 * @param v
		 */
		getCategoryAddressByCity:function(v){
			var $categoryCid =  $('#categoryCid');
			var $categoryPid =  $('#categoryPid');
			var cityId = v;
			
			$categoryCid.combobox({ 
				valueField:'id', 
				textField:'name', 
				editable:false,
				onChange:function(v){
					//根据城市加载职位
					console.log('----'+v)
					if(v==null || v.length == 0){return}
					var reqUrl = commomData.URL.listJobInfoByCategoryCid+"?categoryCid="+v+"&cityId="+cityId;
					platformCommendDetail.search(reqUrl)
				}
			}); 

			$categoryPid.combobox({ 
				valueField:'id', 
				textField:'name', 
				editable:false, 
				onChange:function(data){ 
					//加载子分类
					$.ajax({
						type: "GET",
						url: commomData.URL.listExitCategoryByPid + "?categoryPid="+data+"&cityId="+cityId,
						cache: false,
						async: false,
						success: function(resp) {
							var data = $.merge([{
								id: -1,
								name: '请选择'
							}], resp.data);
							$categoryCid.combobox("clear");
							$categoryCid.combobox("loadData", data);
						}
					});
				} 
			}); 

			//根据城市ID获取职位分类
			$.ajax({
				type: "GET",
				url: commomData.URL.listExitCategoryByCityId + "?cityId="+v,
				cache: false,
				async: false,
				success: function(resp) {
					var data = $.merge([{
						id: -1,
						name: '请选择'
					}], resp.data);
					$categoryPid.combobox("loadData", data);
				}
			});

		},

		
		
		/**
		 * 加载所有分类【包括没有数据】 
		 */
		initFullCategory:function(pName,cName){
			$('#'+cName).combobox({ 
				valueField:'id', 
				textField:'name', 
				editable:false
			}); 

			$('#'+pName).combobox({ 
				valueField:'id', 
				textField:'name', 
				editable:false, 
				onChange:function(v){ 
					$.ajax({
						type: "GET",
						url: commomData.URL.listCategory + "?pid="+v,
						cache: false,
						async: false,
						success: function(resp) {
							var data = $.merge([{
								id: -1,
								name: '请选择'
							}], resp.data);
							$("#"+cName).combobox("clear");
							$("#"+cName).combobox("loadData", data);
						}
					});
				} 
			}); 

			$.ajax({
				type: "GET",
				url: commomData.URL.listCategory + "?pid=0",
				cache: false,
				async: false,
				success: function(resp) {
					var data = $.merge([{
						id: -1,
						name: '请选择'
					}], resp.data);
					$('#'+pName).combobox("loadData", data);
				}
			});

		},


}

