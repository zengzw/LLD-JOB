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
@Table(name = "job_info_log")
public class JobInfoLogPo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		/**  */
	private Long id;
		/**  up:商家：down:下架*/
	private String action;
		/**  操作人*/
	private Long createId;
		/**  操作时间*/
	private Date createTime;
		/**  职位Id*/
	private Long jobInfoId;
		
			@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =id;
	}
				@Column(name = "action")
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action =action;
	}
				@Column(name = "create_id")
	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId =createId;
	}
				@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime =createTime;
	}
				@Column(name = "job_info_id")
	public Long getJobInfoId() {
		return jobInfoId;
	}

	public void setJobInfoId(Long jobInfoId) {
		this.jobInfoId =jobInfoId;
	}
		}
