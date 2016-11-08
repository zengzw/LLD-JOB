package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "commom_area")
public class CommomAreaPo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		/**  ID*/
	private String id;
		/**  父ID*/
	private String pid;
		/**  名称*/
	private String name;
		/**  城市级别*/
	private Long grade;
		/**  排序*/
	private Long sorting;
		
			@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id =id;
	}
				@Column(name = "pid")
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid =pid;
	}
				@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name =name;
	}
				@Column(name = "grade")
	public Long  getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade =grade;
	}
				@Column(name = "sorting")
	public Long getSorting() {
		return sorting;
	}

	public void setSorting(Long sorting) {
		this.sorting =sorting;
	}
		}
