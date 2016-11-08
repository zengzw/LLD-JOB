package com.tsh.job.service;

import java.util.List;
import java.util.ArrayList;
import com.dtds.platform.util.bean.Result;
import org.springframework.stereotype.Service;
import com.dtds.platform.util.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtds.platform.util.bean.Page;
import com.tsh.job.po.CompanyPo;
import com.tsh.job.vo.CompanyVo;
import com.tsh.job.dao.CompanyDao;


@Service
@SuppressWarnings("all")
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;

    /**
     * 新增招工接口对象
     * @param result
     * @param company
     * @return
     */
    public Result addCompany(Result result,CompanyVo companyVo)throws Exception{
        CompanyPo companyPo = new CompanyPo();

        if (companyVo != null) {
            copyProjectValue(companyVo, companyPo);
        }

        result = companyDao.addCompany(result,companyPo);
        return result;
    }

    /**
     * 保存企业接口对象
     * @param result
     * @return
     */
    public Result saveOrUpdateCompany(Result result,CompanyVo companyVo){
        if(companyVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }
        result = companyDao.getCompanyByCompId(result, companyVo.getCompId());
        CompanyPo companyPo  = (CompanyPo)result.getData();

        if (companyPo != null) {
            copyProjectValue(companyVo, companyPo);
            companyDao.update(companyPo);
        }
        else{
            companyPo = new CompanyPo();
            copyProjectValue(companyVo, companyPo);
            result = companyDao.addCompany(result,companyPo);
        }
        return result;
    }



    /**
     * 对象值的设置
     * 
     * @param companyVo
     * @param companyPo
     */
    private void copyProjectValue(CompanyVo companyVo, CompanyPo companyPo) {
        if(companyVo.getName()!=null){
            companyPo.setName(companyVo.getName());
        }
        if(companyVo.getCompId()!=null){
            companyPo.setCompId(companyVo.getCompId());
        }
    }


    /**
     * 批量新增招工接口对象
     * @param result
     * @param company
     * @return
     */
    public Result batchSaveCompany(Result result, List<CompanyVo> company_list) throws Exception {
        List<CompanyPo> list = new ArrayList<CompanyPo>();
        result = companyDao.batchSaveCompany(result,list);
        return result;
    }

    /**
     * 删除招工接口对象
     * @param id企业接口对象标识
     * @return
     */
    public Result deleteCompany(Result result, Long id) throws Exception {
        result = companyDao.deleteCompany(result,id);
        return result;
    }


    /**
     * 批量删除招工接口对象
     * @param result
     * @param company
     * @return
     */
    public Result batchDelCompany(Result result, List<CompanyVo> company_list)throws Exception{
        List<CompanyPo> list = new ArrayList<CompanyPo>(); 
        companyDao.batchDelete(list);
        return result;
    }


    /**
     * 批量删除招工接口对象ByIds
     * @param result
     * @param company
     * @return
     */
    public Result batchDelCompanyByIds(Result result,Long[] ids)throws Exception{
        companyDao.batchDelCompanyByIds(result,ids);
        return result;
    }


    /**
     * 根据条件获取企业接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryCompanyList(Result result,Page page,CompanyVo companyVo){
        CompanyPo companyPo = new CompanyPo();
        result = companyDao.queryCompanyList(result,page,companyPo);
        return result;
    }


    /**
     * 根据条件获取企业接口对象列表 带User
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryCompanyList(Result result,Page page,CompanyVo companyVo,UserInfo user){
        CompanyPo companyPo = new CompanyPo();
        /**
         *自行匹配需要查询的字段及值
         **/
        result = companyDao.queryCompanyList(result,page,companyPo);
        return result;
    }


    /**
     * 根据ID获取企业接口对象 带User对象
     * @param result
     * @return
     */
    public Result getCompanyById(Result result,Long id,UserInfo user) throws Exception{
        result = companyDao.getCompanyById(result,id);
        return result;
    }


    /**
     * 根据ID获取企业接口对象
     * @param result
     * @return
     */
    public Result getCompanyByComId(Result result,Long compId){
        result = companyDao.getCompanyByCompId(result, compId);
        return result;
    }


    /**
     * 更新企业接口对象
     * @param result
     * @return
     */
    public Result updateCompany(Result result,CompanyVo companyVo) throws Exception {
        Long id = companyVo.getId();
        result = companyDao.getCompanyById(result,id);
        CompanyPo companyPo  = (CompanyPo)result.getData();
        if (companyPo != null) {
            copyProjectValue(companyVo, companyPo);
        }
        return result;
    }


}
