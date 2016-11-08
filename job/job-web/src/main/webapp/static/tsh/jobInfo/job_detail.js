var jobInfoView = jobInfoView ? jobInfoView : {};
var page = {};

page.init = function(){
	var jobInfoId= getUrlParam("jobId");

	jobInfoView.findInfo(jobInfoId);

	jobInfoView.callbackurl=getUrlParam("callbackurl");
	$("#view_back").attr("href",encodeURI(unescape(jobInfoView.callbackurl)));
};

jobInfoView.findInfo=function(id){
	var url="/jobInfo/detail";
	var param={"jobId":id};
	jobInfoView.sendGetRequest(url,param);
};

jobInfoView.Format = function (paramDate) { 
	var Y = paramDate.getFullYear() + '-';
	var M = (paramDate.getMonth()+1 < 10 ? '0'+(paramDate.getMonth()+1) : paramDate.getMonth()+1) + '-';
	var D = paramDate.getDate()>9?paramDate.getDate():"0"+paramDate.getDate();
	return Y+M+D;
};


jobInfoView.sendGetRequest= function(url,param){
	$.get(url,param,function(returnDTO){
		if(returnDTO.status==200){
			var data = returnDTO.data;
			console.log(data)
			//格式化时间
		/*	var createTime = jobInfoView.Format(new Date(data.createTime));
			data.createTime=createTime;*/
		
			
			$("#code").text(data.code);
			var address = (data.proviceName == null ? "": data.proviceName)+
			(data.cityName == null ? "" : data.cityName)+
			(data.zoneName == null ? "" : data.zoneName);
			$("#address").text(address);
			$("#compName").text(data.companyVo.name);
			$("#categoryOne").text(data.ctNameOne);
			$("#categoryTwo").text(data.ctNameTwo);
			$("#jobName").text(data.jobName);
			$("#salary").text(data.salaryMin+'-'+data.salaryMax);
			$("#hightLigets").text(data.hightLigets);
			$("#applyCount").text(data.tshApplyNumber == null ? 0 : data.tshApplyNumber);
			$("#recruitmentNumber").text(data.recruitNumber);
			$("#deadline").text(DateTools.formatDate(data.deadline,"yyyy-MM-dd hh:mm:ss"));
			$("#entryAward").text(data.jobDetailVo.entryAward== null ? "略":data.jobDetailVo.entryAward);
			$("#salaryDesc").text(data.jobDetailVo.salaryDesc== null ? "略":data.jobDetailVo.salaryDesc);
			$("#benefit").text(data.jobDetailVo.benefi== null ? "略":data.jobDetailVo.benefi);
			$("#workContent").text(data.jobDetailVo.workContent== null ? "略":data.jobDetailVo.workContent);
			$("#environment").text(data.jobDetailVo.environment== null ? "略":data.jobDetailVo.environment);
			$("#requirements").text(data.jobDetailVo.requirements == null ? "略":data.jobDetailVo.requirements);
			$("#introduction").text(data.jobDetailVo.introduction == null ? "略":data.jobDetailVo.introduction);
			$("#images").html(getImagesHtml(data.jobDetailVo.images));
			$("#status").text(getStatus(data.status));
			$("#tshStatus").text(getTshStatus(data.tshStatus));

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

page.init();

function getImagesHtml(images){
	if(images == null){
		return "略";
	}
	var imgs = images.split(',');
	var imgHtml = "";
	for(var a = 0; a<=imgs.length; a++){
		imgHtml +="<a class=\"img\" href="+imgs[a]+"><img style=\"width: 150px;height: 150px; padding-right:3px;cursor: -webkit-zoom-in;\" src=\""+imgs[a]+"\"></a>";
//		imgHtml +="<img style=\"width: 150px;height: 150px; padding-right:3px;cursor: -webkit-zoom-in;\" src=\""+imgs[a]+"\">";
	}

	return imgHtml;
	
}
function getTshStatus(value){
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
function getStatus(value){
	var message="审核中";
	if(value == 2){
		message = "招聘中";
	}else if(value == 4){
		message = "已暂停";
	}else if(value == 5){
		message = "已结束";
	}
	else if(value == 6){
		message = "已删除";
	}
	return message;
}


//获取url参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r != null) return unescape(r[2]); return null; //返回参数值
}