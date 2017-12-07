package com.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_dict")
public class Dict implements java.io.Serializable {
	
	private static final long serialVersionUID = -4849733026362330866L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "N_ID", unique = true, nullable = false)
	private Integer id;	
	@Column(name = "C_KEY", nullable = false, length = 50)
	private String key;
	@Column(name = "C_VALUE", nullable = false, length = 50)
	private String value;
	@Column(name = "C_PARENTKEY", length = 50)
	private String parentKey;
	@Column(name = "N_SORT")
	private Integer sort;

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getParentKey() {
		return this.parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}