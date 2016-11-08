package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "job_recommend_statistics")
public class JobRecommendStatisticsPo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		/**  主键ID*/
	private Long id;
		/**  身份/城市Code。
-1 是全国。 >1 是省或市*/
	private String code;
		/**  推荐职位数*/
	private Long recommendCount;
		/**  已下架数*/
	private Long downCount;
		
			@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =id;
	}
				@Column(name = "code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code =code;
	}
				@Column(name = "recommend_count")
	public Long getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(Long recommendCount) {
		this.recommendCount =recommendCount;
	}
				@Column(name = "down_count")
	public Long getDownCount() {
		return downCount;
	}

	public void setDownCount(Long downCount) {
		this.downCount =downCount;
	}
		}
