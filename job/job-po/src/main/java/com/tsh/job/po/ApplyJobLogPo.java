package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "apply_job_log")
public class ApplyJobLogPo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		/**  自增ID*/
	private Long id;
		/**  推送参数*/
	private String params;
		/**  推送时间*/
	private Date createTime;
		/**  推送状态。
0：失败，1：成功*/
	private Long state;
		/**  用户ID*/
	private Long appJobId;
		
			@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =id;
	}
				@Column(name = "params")
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params =params;
	}
				@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime =createTime;
	}
				@Column(name = "state")
	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state =state;
	}
				@Column(name = "app_job_id")
	public Long getAppJobId() {
		return appJobId;
	}

	public void setAppJobId(Long appJobId) {
		this.appJobId =appJobId;
	}
		}
