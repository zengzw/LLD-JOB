package com.tsh.job.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.dtds.platform.util.bean.Result;
import org.springframework.stereotype.Service;
import com.dtds.platform.util.security.UserInfo;
import com.job.util.StringUtils;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtds.platform.util.bean.Page;
import com.tsh.job.po.CommomAreaPo;
import com.tsh.job.vo.CommomAreaVo;
import com.tsh.job.dao.CommomAreaDao;


@Service
@SuppressWarnings("all")
public class CommomAreaService {
    @Autowired
    private CommomAreaDao commomAreaDao;



    /**
     * @param commomAreaVo
     * @param commomAreaPo
     */
    private void copyProperties(CommomAreaVo commomAreaVo, CommomAreaPo commomAreaPo) {
        if(commomAreaVo.getPid()!=null){
            commomAreaPo.setPid(commomAreaVo.getPid());
        }
        if(commomAreaVo.getName()!=null){
            commomAreaPo.setName(commomAreaVo.getName());
        }
        if(commomAreaVo.getGrade()!=null){
            commomAreaPo.setGrade(commomAreaVo.getGrade());
        }
        if(commomAreaVo.getSorting()!=null){
            commomAreaPo.setSorting(commomAreaVo.getSorting());
        }
    }




    /**
     * 根据父ID获取地区信息
     * 
     * @param result
     * @return
     */
    public Result getListCommomAreaByPid(Result result,String pid) throws Exception{
        return commomAreaDao.getListCommomAreaByPid(result, pid);
    }



    /**
     * 获取所有的城市
     * 
     * @param result
     * @return
     * @throws Exception
     */
    public Result getListCity(Result result) throws Exception{
        return commomAreaDao.getListCommomAreaByLeave(result, 2);
    }




    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryCommomAreaList(Result result,Page page,CommomAreaVo commomAreaVo){
        CommomAreaPo commomAreaPo = new CommomAreaPo();
        result = commomAreaDao.queryCommomAreaList(result,page,commomAreaPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表 带User
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryCommomAreaList(Result result,Page page,CommomAreaVo commomAreaVo,UserInfo user){
        CommomAreaPo commomAreaPo = new CommomAreaPo();
        /**
         *自行匹配需要查询的字段及值
         **/
        result = commomAreaDao.queryCommomAreaList(result,page,commomAreaPo);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result getCommomAreaById(Result result,String id,UserInfo user) throws Exception{
        result = commomAreaDao.getCommomAreaById(result,id);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getCommomAreaById(Result result,String id){
        result = commomAreaDao.getCommomAreaById(result,id);
        return result;
    }




    /**
     * 根据区域Id获取到网站完整名称
     * @param areaId 地区Id
     * @return 完整地址
     */
    public String[] queryAllAddress(Long areaId){
        String disId = areaId.toString();
        String[] address = new String[3];
        Result result = new Result();
        CommomAreaPo commomAreaPo = getCommomAreaById(result, disId).getData();
        if(commomAreaPo != null){
            address[0] = commomAreaPo.getName();
        }

        Long parentId = StringUtils.parseLong(commomAreaPo.getPid());
        int i = 1;
        while(parentId > 0 ){
            commomAreaPo = getCommomAreaById(result, parentId.toString()).getData();
            if(commomAreaPo != null){
                address[i] = commomAreaPo.getName();
                parentId =  StringUtils.parseLong(commomAreaPo.getPid());
                i++;
            }else{
                parentId=0L;
            }
        }


        //反转数据
        String[] res = new String[address.length];
        int v = 0;
        for(int j = address.length-1; j>=0; j--){
            if(StringUtils.isNotEmpty(address[j])){
                res[v]= address[j];
                v++;
            };

        }
        return res;
    }

    /**
     * 查询所有省份有数据的城市
     * 
     * @param result
     * @return
     */
    public Result queryListProvice(Result result){
        return commomAreaDao.queryListProvice(result);
    }



    /**
     * 查询所有有数据的城市
     * 
     * @param result
     * @return
     */
    public Result queryListCity(Result result,Long proviceId){
        commomAreaDao.queryListCity(result, proviceId);
        return result;
    }


}
