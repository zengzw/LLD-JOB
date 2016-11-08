package com.tsh.job.service;

import java.util.List;
import java.util.ArrayList;
import com.dtds.platform.util.bean.Result;
import org.springframework.stereotype.Service;
import com.dtds.platform.util.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtds.platform.util.bean.Page;
import com.tsh.job.po.ApplyUserPo;
import com.tsh.job.vo.ApplyUserVo;
import com.tsh.job.dao.ApplyUserDao;


@Service
@SuppressWarnings("all")
public class ApplyUserService {
    @Autowired
    private ApplyUserDao applyUserDao;

    /**
     * 新增招工接口对象
     * @param result
     * @param applyUser
     * @return
     */
    public Result addApplyUser(Result result,ApplyUserVo applyUserVo)throws Exception{
        ApplyUserPo applyUserPo = new ApplyUserPo();

        if (applyUserVo != null) {
            copyProperties(applyUserVo, applyUserPo);
        }

        result = applyUserDao.addApplyUser(result,applyUserPo);
        return result;
    }



    /**
     * 保存 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result saveOrUpdate(Result result,ApplyUserVo applyUserVo) throws Exception {
        if(applyUserVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }

        Long id = applyUserVo.getUserId();
        result = applyUserDao.getUserByPhone(result, applyUserVo.getPhone());
        ApplyUserPo applyUserPo  = (ApplyUserPo)result.getData();

        if (applyUserPo != null) {
            copyProperties(applyUserVo, applyUserPo);
        }else{
            applyUserPo = new ApplyUserPo();
            copyProperties(applyUserVo, applyUserPo);
            result = applyUserDao.addApplyUser(result,applyUserPo);
        }
        return result;
    }



    /**
     * @param applyUserVo
     * @param applyUserPo
     */
    private void copyProperties(ApplyUserVo applyUserVo, ApplyUserPo applyUserPo) {
        if(applyUserVo.getUserId()!=null){
            applyUserPo.setUserId(applyUserVo.getUserId());
        }
        if(applyUserVo.getSex()!=null){
            applyUserPo.setSex(applyUserVo.getSex());
        }
        if(applyUserVo.getName()!=null){
            applyUserPo.setName(applyUserVo.getName());
        }
        if(applyUserVo.getPhone()!=null){
            applyUserPo.setPhone(applyUserVo.getPhone());
        }
        if(applyUserVo.getIdCard()!=null){
            applyUserPo.setIdCard(applyUserVo.getIdCard());
        }
        if(applyUserVo.getStatus()!=null){
            applyUserPo.setStatus(applyUserVo.getStatus());
        }
    }



    /**
     * 保存 招工接口对象
     * @param result
     * @return
     */
    public Result saveApplyUser(Result result,ApplyUserVo applyUserVo) throws Exception {
        if(applyUserVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }

        Long id = applyUserVo.getId();
        result = applyUserDao.getApplyUserById(result,id);
        ApplyUserPo applyUserPo  = (ApplyUserPo)result.getData();

        if (applyUserPo != null) {
            copyProperties(applyUserVo, applyUserPo);
        }else{
            applyUserPo = new ApplyUserPo();
            copyProperties(applyUserVo, applyUserPo);
            result = applyUserDao.addApplyUser(result,applyUserPo);
        }
        return result;
    }


    /**
     * 批量新增招工接口对象
     * @param result
     * @param applyUser
     * @return
     */
    public Result batchSaveApplyUser(Result result, List<ApplyUserVo> applyUser_list) throws Exception {
        List<ApplyUserPo> list = new ArrayList<ApplyUserPo>();
        result = applyUserDao.batchSaveApplyUser(result,list);
        return result;
    }

    /**
     * 删除招工接口对象
     * @param id 招工接口对象标识
     * @return
     */
    public Result deleteApplyUser(Result result, Long id) throws Exception {
        result = applyUserDao.deleteApplyUser(result,id);
        return result;
    }


    /**
     * 批量删除招工接口对象
     * @param result
     * @param applyUser
     * @return
     */
    public Result batchDelApplyUser(Result result, List<ApplyUserVo> applyUser_list)throws Exception{
        List<ApplyUserPo> list = new ArrayList<ApplyUserPo>(); 
        applyUserDao.batchDelete(list);
        return result;
    }


    /**
     * 批量删除招工接口对象ByIds
     * @param result
     * @param applyUser
     * @return
     */
    public Result batchDelApplyUserByIds(Result result,Long[] ids)throws Exception{
        applyUserDao.batchDelApplyUserByIds(result,ids);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryApplyUserList(Result result,Page page,ApplyUserVo applyUserVo){
        ApplyUserPo applyUserPo = new ApplyUserPo();
        result = applyUserDao.queryApplyUserList(result,page,applyUserPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表 带User
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryApplyUserList(Result result,Page page,ApplyUserVo applyUserVo,UserInfo user){
        ApplyUserPo applyUserPo = new ApplyUserPo();
        /**
         *自行匹配需要查询的字段及值
         **/
        result = applyUserDao.queryApplyUserList(result,page,applyUserPo);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result getApplyUserById(Result result,Long id){
        result = applyUserDao.getApplyUserById(result, id);
        return result;
    }
    /**
     * 根据ID获取 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result getApplyUserByUserId(Result result,Long userId){
        result = applyUserDao.getUserByUserId(result,userId);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getApplyUserByPhone(Result result,String phone){
        result = applyUserDao.getUserByPhone(result, phone);
        return result;
    }
    
    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getApplyUserByPhoneAIdCard(Result result,String phone,String idCard){
        result = applyUserDao.getUserByPhoneAIdCard(result, phone, idCard);
        return result;
    }


    /**
     * 更新 招工接口对象
     * @param result
     * @return
     */
    public Result updateApplyUser(Result result,ApplyUserVo applyUserVo) throws Exception {
        Long id = applyUserVo.getUserId();
        result = applyUserDao.getUserByUserId(result,id);
        ApplyUserPo applyUserPo  = (ApplyUserPo)result.getData();
        if (applyUserPo != null) {
            copyProperties(applyUserVo, applyUserPo);
        }
        return result;
    }


    /**
     * 批量更新 招工接口对象
     * @param result
     * @return
     */
    public Result test(Result result) throws Exception {
        applyUserDao.test(result);
        return result;
    }


}
