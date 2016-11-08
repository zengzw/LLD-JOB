package com.tsh.job.service;

import java.util.List;
import java.util.Date;

import com.dtds.platform.util.bean.Result;
import org.springframework.stereotype.Service;
import com.dtds.platform.util.security.UserInfo;
import com.job.util.StringUtils;

import org.apache.lucene.codecs.blocktree.Stats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.tsh.job.po.JobRecommendPo;
import com.tsh.job.vo.CustomerJobRecommendListVo;
import com.tsh.job.vo.JobRecommendVo;
import com.tsh.job.vo.RecommendQueryVo;
import com.tsh.commons.exceptions.BusinessException;
import com.tsh.commons.exceptions.BusinessRuntimeException;
import com.tsh.job.dao.JobRecommendDao;


@Service
public class JobRecommendService {

    private static Logger logger = LoggerFactory.getLogger(JobRecommendService.class);

    @Autowired
    private JobRecommendDao jobRecommendDao;

    @Autowired
    private CommomAreaService commomAreaService;

    @Autowired
    private CommomCategoryService commomCategoryService;



    /**
     * 新增职位推荐
     * 
     * @param result
     * @param jobRecommend
     * @return
     */
    public Result addJobRecommend(Result result,JobRecommendVo jobRecommendVo)throws Exception{
        JobRecommendPo jobRecommendPo = new JobRecommendPo();

        if (jobRecommendVo != null) {
            copyProperties(jobRecommendVo, jobRecommendPo);
        }

        //校验
        Long countryValue = validateRecommendCount(jobRecommendVo);

        JobRecommendVo queryVO = new JobRecommendVo();
        queryVO.setCityId(jobRecommendVo.getCityId());
        queryVO.setCountry(jobRecommendVo.getCountry());
        queryVO.setProvinceId(jobRecommendVo.getProvinceId());
        queryVO.setJobInfoId(jobRecommendVo.getJobInfoId());
        queryVO.setStatus(1L);

        // 判断职位是否存在
        Long existsCount = checkExistsJobExits(result, queryVO).getData();
        logger.info("check count size:----"+existsCount);
        if(existsCount.intValue() > 0){
            throw new BusinessException("", "当前推荐的职位已经存在");
        }

        jobRecommendPo.setCountry(countryValue);
        result = jobRecommendDao.addJobRecommend(result,jobRecommendPo);
        return result;
    }



    /**
     *  判断是否超过三个推荐职位数
     *  
     * @param jobRecommendVo
     * @param jobRecommendPo
     * @throws BusinessException
     */
    private Long validateRecommendCount(JobRecommendVo jobRecommendVo)
            throws BusinessException {
        Result result = new Result();
        //根据城市判断是否大于3
        int count = 0;
        String msg = "";
        boolean check = false;
        Long countryValue = 0L;

        if(jobRecommendVo.getCityId() != null){
            Long v  = jobRecommendDao.getRecommendCountByCityId(result, jobRecommendVo.getCityId()).getData();
            count = v.intValue();
            msg = jobRecommendVo.getCityName();
            check = true;
        }
        else if(jobRecommendVo.getProvinceId() !=null && !check){
            Long v = jobRecommendDao.getRecommendCountByProvinceId(result, jobRecommendVo.getProvinceId()).getData();
            count = v.intValue();
            msg = jobRecommendVo.getProvinceName();
            check = true;
        }
        else if(jobRecommendVo.getCountry() != null && !check){
            Long v = jobRecommendDao.getRecommendCountByCoutry(result).getData();
            count = v.intValue();
            msg = "全国";
            countryValue = jobRecommendVo.getCountry();
        }

        logger.info("-----count:"+count);
        if(count >=3){
            throw new BusinessException("", msg+"推荐数不能大于3");
        }

        return countryValue;
    }



    /**
     * @param jobRecommendVo
     * @param jobRecommendPo
     */
    private void copyProperties(JobRecommendVo jobRecommendVo, JobRecommendPo jobRecommendPo) {
        if(jobRecommendVo.getJobInfoId()!=null){
            jobRecommendPo.setJobInfoId(jobRecommendVo.getJobInfoId());
        }
        if(jobRecommendVo.getCountry()!=null){
            jobRecommendPo.setCountry(jobRecommendVo.getCountry());
        }
        if(jobRecommendVo.getProvinceId()!=null){
            jobRecommendPo.setProvinceId(jobRecommendVo.getProvinceId());
        }
        if(jobRecommendVo.getProvinceName()!=null){
            jobRecommendPo.setProvinceName(jobRecommendVo.getProvinceName());
        }
        if(jobRecommendVo.getCityId()!=null){
            jobRecommendPo.setCityId(jobRecommendVo.getCityId());
        }
        if(jobRecommendVo.getCityName()!=null){
            jobRecommendPo.setCityName(jobRecommendVo.getCityName());
        }
        if(jobRecommendVo.getStatus()!=null){
            jobRecommendPo.setStatus(jobRecommendVo.getStatus());
        }
        if(jobRecommendVo.getCreateTime()!=null){
            jobRecommendPo.setCreateTime(jobRecommendVo.getCreateTime());
        }
        if(jobRecommendVo.getCreateId()!=null){
            jobRecommendPo.setCreateId(jobRecommendVo.getCreateId());
        }
        if(jobRecommendVo.getType()!=null){
            jobRecommendPo.setType(jobRecommendVo.getType());
        }
    }



    /**
     * 保存 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result saveJobRecommend(Result result,JobRecommendVo jobRecommendVo,UserInfo user) throws Exception {
        if(jobRecommendVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }

        Long id = jobRecommendVo.getId();
        result = jobRecommendDao.getJobRecommendById(result,id);
        JobRecommendPo jobRecommendPo  = (JobRecommendPo)result.getData();

        if (jobRecommendPo != null) {
            copyProperties(jobRecommendVo, jobRecommendPo);
        }else{
            jobRecommendPo = new JobRecommendPo();
            copyProperties(jobRecommendVo, jobRecommendPo);
            result = jobRecommendDao.addJobRecommend(result,jobRecommendPo);
        }
        return result;
    }



    /**
     * 保存 招工接口对象
     * @param result
     * @return
     */
    public Result saveJobRecommend(Result result,JobRecommendVo jobRecommendVo) throws Exception {
        if(jobRecommendVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }

        Long id = jobRecommendVo.getId();
        result = jobRecommendDao.getJobRecommendById(result,id);
        JobRecommendPo jobRecommendPo  = (JobRecommendPo)result.getData();

        if (jobRecommendPo != null) {
            copyProperties(jobRecommendVo, jobRecommendPo);
        }else{
            jobRecommendPo = new JobRecommendPo();
            copyProperties(jobRecommendVo, jobRecommendPo);
            result = jobRecommendDao.addJobRecommend(result,jobRecommendPo);
        }
        return result;
    }





    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryJobRecommendList(Result result,Page page,JobRecommendVo jobRecommendVo){
        JobRecommendPo jobRecommendPo = new JobRecommendPo();
        result = jobRecommendDao.queryJobRecommendList(result,page,jobRecommendPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表 带User
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryJobRecommendList(Result result,Page page,JobRecommendVo jobRecommendVo,UserInfo user){
        JobRecommendPo jobRecommendPo = new JobRecommendPo();
        /**
         *自行匹配需要查询的字段及值
         **/
        result = jobRecommendDao.queryJobRecommendList(result,page,jobRecommendPo);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result getJobRecommendById(Result result,Long id,UserInfo user) throws Exception{
        result = jobRecommendDao.getJobRecommendById(result,id);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getJobRecommendById(Result result,Long id) throws Exception{
        result = jobRecommendDao.getJobRecommendById(result,id);
        return result;
    }


    /**
     * 更新 招工接口对象
     * @param result
     * @return
     */
    public Result updateJobRecommend(Result result,Long id,Long status) throws Exception {
        result = jobRecommendDao.getJobRecommendById(result,id);
        JobRecommendPo jobRecommendPo  = (JobRecommendPo)result.getData();
        if(jobRecommendPo == null){
            logger.error("找不到相关对象！id：{}",id);
            throw new BusinessRuntimeException("","找不到相关数据");
        }

        JobRecommendVo jobRecommendVo = new JobRecommendVo();
        BeanUtils.copyProperties(jobRecommendPo, jobRecommendVo);


        //上架的时候进行判断上架数目
        if(status == 1){
            validateRecommendCount(jobRecommendVo);
            jobRecommendPo.setCreateTime(new Date());
        }

        jobRecommendPo.setStatus(status);
        

        return result;
    }



    /**
     * 检查当前job是否 存在
     * @param result
     * @param jobRecommendVo
     * @return
     */
    public Result checkExistsJobExits(Result result,JobRecommendVo jobRecommendVo){
        jobRecommendDao.checkExistsJob(result,jobRecommendVo);
        return result;
    }

    /**
     * 获取推荐列表
     * 
     * 
     * @param result
     * @param page
     * @param q
     * @return
     */
    public Result queryListRecommendInfo(Result result,Page page,RecommendQueryVo q){
        jobRecommendDao.queryListRecommendInfo(result, page, q);

        Pagination pagination = result.getData();
        if(CollectionUtils.isNotEmpty(pagination.getRows())){
            List<CustomerJobRecommendListVo> list = (List<CustomerJobRecommendListVo>) pagination.getRows();
            for(CustomerJobRecommendListVo vo:list){
                //查找地区
                String[] areas=commomAreaService.queryAllAddress(vo.getZoneId());
                vo.setJobAddress(StringUtils.arraysToString(areas, ""));
                //查找职位分类
                String[] categorys = commomCategoryService.queryAllAddress(vo.getcCid());
                vo.setCategoryPName(categorys[0]);
                vo.setCategoryCname(categorys[1]);

                //设置推荐地区显示
                String address = "";
                if(vo.getCountry() == 1){
                    address = "全国";
                }
                if(StringUtils.isNotEmpty(vo.getProvinceName())){
                    address = vo.getProvinceName();
                }
                if(StringUtils.isNotEmpty(vo.getCityName())){
                    address += vo.getCityName();
                }
                vo.setRecomdAddress(address);

            }

            pagination.setRows(list);

        }

        return result;
    }
}
