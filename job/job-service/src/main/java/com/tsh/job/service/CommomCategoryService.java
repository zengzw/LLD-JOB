package com.tsh.job.service;

import java.util.List;
import java.util.ArrayList;
import com.dtds.platform.util.bean.Result;
import org.springframework.stereotype.Service;
import com.dtds.platform.util.security.UserInfo;
import com.job.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import com.dtds.platform.util.bean.Page;
import com.tsh.job.po.CommomAreaPo;
import com.tsh.job.po.CommomCategoryPo;
import com.tsh.job.vo.CommomCategoryVo;
import com.tsh.job.dao.CommomCategoryDao;


@Service
@SuppressWarnings("all")
public class CommomCategoryService {
    @Autowired
    private CommomCategoryDao commomCategoryDao;



    /**
     * @param commomCategoryVo
     * @param commomCategoryPo
     */
    private void copyProperties(CommomCategoryVo commomCategoryVo, CommomCategoryPo commomCategoryPo) {
        if(commomCategoryVo.getPid()!=null){
            commomCategoryPo.setPid(commomCategoryVo.getPid());
        }
        if(commomCategoryVo.getName()!=null){
            commomCategoryPo.setName(commomCategoryVo.getName());
        }
        if(commomCategoryVo.getGrade()!=null){
            commomCategoryPo.setGrade(commomCategoryVo.getGrade());
        }
        if(commomCategoryVo.getSorting()!=null){
            commomCategoryPo.setSorting(commomCategoryVo.getSorting());
        }
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getCommomCategoryById(Result result,String id){
        result = commomCategoryDao.getCommomCategoryById(result,id);
        return result;
    }

    
    
    /**
     * 根据城市Idd获取职位分类Id
     * 
     * @param result
     * @return
     */
    public Result getExitListCommomCategoryByCityId(Result result,Long cityId) throws Exception{
        return commomCategoryDao.queryExitListCategoryPidByCityId(result, cityId);
    }
    
    /**
     * 根据父类Id 获取已存在的子类信息
     * 
     * @param result
     * @return
     */
    public Result getExitListCommomCategoryByPid(Result result,Long pid,Long cityId) throws Exception{
        return commomCategoryDao.queryExitListCategoryCidByPid(result, pid,cityId);
    }
    
    
    /**
     * 根据父Id获取职位分类Id
     * 
     * @param result
     * @return
     */
    public Result getListCommomCategoryByPid(Result result,String pid) throws Exception{
        return commomCategoryDao.getListCommomCategoryByPid(result, pid);
    }
    

    
    
    /**
     * 根据条件获取 招工接口对象列表 带User
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryCommomCategoryList(Result result,Page page,CommomCategoryVo commomCategoryVo,UserInfo user){
        CommomCategoryPo commomCategoryPo = new CommomCategoryPo();
        /**
         *自行匹配需要查询的字段及值
         **/
        result = commomCategoryDao.queryCommomCategoryList(result,page,commomCategoryPo);
        return result;
    }

    
    /**
     * 根据职位ID 获取到网站完整名称
     * @param categoryId 职位Id 
     * @return 完整地址
     */
    public String[] queryAllAddress(Long caegoryId){
        String disId = caegoryId.toString();
        String[] address = new String[3];
        Result result = new Result();
        CommomCategoryPo commomCategoryPo = getCommomCategoryById(result, disId).getData();
        if(commomCategoryPo != null){
            address[0] = commomCategoryPo.getName();
        }

        Long parentId = StringUtils.parseLong(commomCategoryPo.getPid());
        int i = 1;
        while(parentId > 0 ){
            commomCategoryPo = getCommomCategoryById(result, parentId.toString()).getData();
            if(commomCategoryPo != null){
                address[i] = commomCategoryPo.getName();
                parentId =  StringUtils.parseLong(commomCategoryPo.getPid());
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



}
