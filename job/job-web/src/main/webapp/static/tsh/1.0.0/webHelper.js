
WebHelper = {
		//获取物流地址
		GetLogisticAddress:function() {
			return "http://share.tsh365.cn/share/getAddressByName.do";
		},
		//根据id获取地址
		GetAddress:function() {
			return "http://share.tsh365.cn/share/getAddress.do";
		},
		
		// 根据等级获取地址
		getAddressByLevel:function(level){
			var origin = location.origin;
			if (origin.indexOf("tsh365.cn")>0) {
				return "http://share.tsh365.cn/share/getAddressLevel.do?level="+level;
			} else {
				return "http://172.16.1.97:8992/share/getAddressLevel.do?level="+level;
			}
		},
		
		//上传图片路径
		UploadImage:'../../common/uploadimg.do',
		//获取图片验证码
		GetImgCode:'../../verify/code.do',
		//获取手机验证码
		GetVerifyCode:'../../supplier/getVerifyCode.do',
		//供应商注册
		Regist:'../../supplier/regist.do',
		//获取供应商详情
		GetSupplier:'../../supplier/getSupplier.do',
		//根据县市获取县域信息
		GetAreasByProviceAndCity:'../../area/getAreasByProvinceAndCity.do',
		//供应商提交资料
		SubmitSupplierData:'../../supplier/submitSupplierData.do',
		//提交跨区域销售申请
		ApplyCrossSale:'../../supplier/applyCrossSale.do',
		//添加县域
		AddArea:'../../area/addArea.do',
		//根据id获取县域详情
		GetAreaInfoById:'../../area/getAreaInfoById.do',
		//修改县域信息
		UpdateAreaInfo:'../../area/updateAreaInfo.do',
		//县域列表
		AreaList:'../../area/getAreaList.do',
		//导出县域列表
		ExportAreaList:'../../area/exportAreaInfoList.do',
		//根据id获取供应商详情
		GetSupplierById:'../../supplier/getSupplierById.do',
		//操作日志查询
		QueryLog:'../../log/queryLog.do'
};