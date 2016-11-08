var configCenter = {
		init_platform : function(){
			//服务器参数
			$.ajax({
				type: "POST",
				url: getURL('/config/getUrl.do'),
				cache: false,
				async: false,
				dataType: "jsonp",
				success: function(data) {
					console.log(data)
					initShopAddress(data);
				}
			});
		},
		init_shop : function(areaId){
			//服务器参数
			$.ajax({
				type: "POST",
				url: getURL('/config/getUrl.do'),
				cache: false,
				async: false,
				dataType: "jsonp",
				success: function(data) {
					initAllAddress(data,areaId);
				}
			});
		}
}


/**
 * 初始化网点所有信息
 */
function initAllAddress(urlData,areaId) {
	console.log('areaid:'+areaId)
	$.ajax({
		type: "POST",
		url: urlData.wdUrl_openDialog+"?areaId=" + areaId,
		cache: false,
		async: false,
		dataType: "jsonp",
		success: function(resp) {
			var data = $.merge([{
				id: -1,
				shopName: '选择网点'
			}], resp.rows);
			
			$("#shopId").combobox({
				valueField:'id',
				textField:'shopName'
			}).combobox("loadData", data);
		}
	});
};

function initShopAddress(data) {
	$.ajax({
		type: "POST",
		url: data.shareUrl + "/share/getAddress.do?cid=" + 0,
		cache: false,
		async: false,
		dataType: "jsonp",
		success: function(data) {
			var data = $.merge([{
				id: -1,
				name: '选择省/市'
			}], data);
			$("#contactProvince").combobox("loadData", data);
		}
	});
	$('#contactProvince').combobox({
		cache: false,
		editable: false,
		// panelHeight: 'auto',//自动高度适合
		valueField: 'id',
		textField: 'name',
		onChange: function() {
			$("#contactCity").combobox("setValue", '');
			$("#contactArea").combobox("setValue", '');
			$("#contactCity").combobox("loadData", {});
			$("#contactArea").combobox("loadData", {});
			var province = $('#contactProvince').combobox('getValue');
			if (province != 0) {
				$.ajax({
					type: "POST",
					url: data.shareUrl + "/share/getAddress.do?cid=" + province,
					cache: false,
					dataType: "jsonp",
					success: function(data) {
						var data = $.merge([{
							id: -1,
							name: '选择市/区'
						}], data);
						$("#contactCity").combobox("loadData", data);
					}
				});
			}
		}
	});
	$('#contactCity').combobox({
		editable: false, //不可编辑状态
		cache: false,
		//panelHeight: 'auto',//自动高度适合
		valueField: 'id',
		textField: 'name',
		onChange: function() {
			$("#contactArea").combobox("setValue", '');
			$("#contactArea").combobox("loadData", {});
			var provinceName = $('#contactProvince').combobox('getText');
			var cityName = $('#contactCity').combobox('getText');
			var city = $('#contactCity').combobox('getValue');
			if (city != 0) {
				$.ajax({
					type: "POST",
					url: data.xyUrl_openDialog + "?province={0}&city={1}".format(provinceName,cityName),
					cache: false,
					dataType: "jsonp",
					success: function(response) {
						var data = $.merge([{
							id: -1,
							areaName: '选择运营中心'
						}], response.rows);
						$("#contactArea").combobox("loadData", data);
					}
				});
			}
		}
	});
	$('#contactArea').combobox({
		editable: false, //不可编辑状态
		cache: false,
		// panelHeight: 'auto',//自动高度适合
		valueField: 'id',
		textField: 'areaName'
	});

}



