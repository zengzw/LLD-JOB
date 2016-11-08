var userApplyView = userApplyView ? userApplyView : {};
var page = {};

page.init = function(){
	var jobId= getUrlParam("jobId");
	var userId= getUrlParam("userId");
	userApplyView.findInfo(jobId,userId);

	userApplyView.callbackurl=getUrlParam("callbackurl");
	$("#view_back").attr("href",encodeURI(unescape(userApplyView.callbackurl)));
};


userApplyView.findInfo=function(jobId,userId){
	var url="/applyJob/detail";
	var param={"jobId":jobId,"userId":userId};
	userApplyView.sendGetRequest(url,param);
};

userApplyView.Format = function (paramDate) { 
	var Y = paramDate.getFullYear() + '-';
	var M = (paramDate.getMonth()+1 < 10 ? '0'+(paramDate.getMonth()+1) : paramDate.getMonth()+1) + '-';
	var D = paramDate.getDate()>9?paramDate.getDate():"0"+paramDate.getDate();
	return Y+M+D;
};


userApplyView.sendGetRequest= function(url,param){
	$.get(url,param,function(returnDTO){
		if(returnDTO.status==200){
			var data = returnDTO.data;
			//格式化时间
		/*	var createTime = userApplyView.Format(new Date(data.createTime));
			data.createTime=createTime;*/
		
			if(data.gender == 0){
				$("#sex").text("女");
			}else{
				$("#sex").text("男");	
			}

			$("#source").text("蓝领带")

			$("#code").text(data.code);
			$("#title").text(data.jobInfoVo.jobName);
			var address = (data.jobInfoVo.provinceName == null ? "": data.jobInfoVo.provinceName)+
			(data.jobInfoVo.cityName == null ? "" : data.jobInfoVo.cityName)+
			(data.jobInfoVo.zoneName == null ? "" : data.jobInfoVo.zoneName);
			$("#address").text(address);
			$("#compName").text(data.jobInfoVo.companyVo.name);
			$("#cpName").text(data.jobInfoVo.ctNameOne);
			$("#ccName").text(data.jobInfoVo.ctNameTwo);

			$("#applyCount").text(data.jobInfoVo.applyNumCount);
			$("#recruit_number").text(data.jobInfoVo.recruitNumber);
			$("#deadline").text(DateTools.formatDate(data.jobInfoVo.deadline,"yyyy-MM-dd hh:mm:ss"));
			$("#jobCode").text(data.jobInfoVo.code);

			var applyaddress = (data.pvName == null ? "": data.pvName)+
			(data.cityName == null ? "" : data.cityName)+
			(data.shopName == null ? "" : data.shopName);
			$("#applyAddress").text(applyaddress);


			$("#jobStatus").text(getJobStatus(data.jobStatus));

			$("#interviewTime").text(data.interviewTime == null ? "-" : DateTools.formatDate(data.interviewTime,"yyyy-MM-dd hh:mm:ss"));
			$("#joinTime").text(data.entryTime == null ? "-" : DateTools.formatDate(data.entryTime,"yyyy-MM-dd hh:mm:ss"));
			$("#leaveTime").text(data.leaveTime == null ? "-" : DateTools.formatDate(data.leaveTime,"yyyy-MM-dd hh:mm:ss"));		

			$("#userName").text(data.applyUserVo.name);
			$("#idCard").text(data.applyUserVo.idCard == null ? "" : data.applyUserVo.idCard);
			$("#phone").text(data.applyUserVo.phone);
			$("#createTime").text(DateTools.formatDate(data.createTime,"yyyy-MM-dd hh:mm:ss"));

		}else{
			$.messager.alert({
				title:'错误提示',
				msg:'<div class="content">'+returnDTO.msg+'</div>',
				ok:'<i class="i-ok"></i> 确定',
				icon:'error'
			});
		}
	});
};
function getJobStatus(v){
var message="-";
			if(v == 0){
				message="无关系";
			}else if(v == 1){
				message = "招聘中";
			}
			else if(v == 2){
				message = "已报名";
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
}
page.init();

//获取url参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r != null) return unescape(r[2]); return null; //返回参数值
}
