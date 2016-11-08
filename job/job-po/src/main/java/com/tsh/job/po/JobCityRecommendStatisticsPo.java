package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "job_city_recommend_statistics")
public class JobCityRecommendStatisticsPo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		/**  主键ID*/
	private Long id;
		/**  推荐职位数*/
	private Long recommendCount;
		/**  省份ID*/
	private String proviceId;
		/**  省份名称*/
	private String proviceName;
		/**  城市ID*/
	private String cityId;
		/**  城市名称*/
	private String cityName;
		/**  类型。0：城市，1：省份*/
	private Long type;
		
			@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =id;
	}
				@Column(name = "recommend_count")
	public Long getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(Long recommendCount) {
		this.recommendCount =recommendCount;
	}
				@Column(name = "provice_id")
	public String getProviceId() {
		return proviceId;
	}

	public void setProviceId(String proviceId) {
		this.proviceId =proviceId;
	}
				@Column(name = "provice_name")
	public String getProviceName() {
		return proviceName;
	}

	public void setProviceName(String proviceName) {
		this.proviceName =proviceName;
	}
				@Column(name = "city_id")
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId =cityId;
	}
				@Column(name = "city_name")
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName =cityName;
	}
				@Column(name = "type")
	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type =type;
	}
		}
