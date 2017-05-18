package com.net.lnk.spring.jdbc;

import java.util.Date;

/**
 * @author Ben
 * @memo 2017年4月12日
 */
public class IdCardEntity {

	private Long id;
	private String memberNo;
	private String name;
	private String idNo;
	private Integer gender;
	private String idAddr;
	private Date birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getIdAddr() {
		return idAddr;
	}

	public void setIdAddr(String idAddr) {
		this.idAddr = idAddr;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
