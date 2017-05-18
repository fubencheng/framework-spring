package com.net.lnk.spring.jdbc;

/**
 * @author Ben
 * @memo 2017年4月13日
 */
public class IdCardHandleTask implements Runnable {

	private IdCardEntity idCard;

	public IdCardHandleTask(IdCardEntity idCard) {
		this.idCard = idCard;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + ", id = " + idCard.getId() + ", name = "
				+ idCard.getName() + ", idNo = " + idCard.getIdNo() + ", memberNo = " + idCard.getMemberNo()
				+ ", gender = " + idCard.getGender() + ", idAddr = " + idCard.getIdAddr() + ", birthday = "
				+ idCard.getBirthday());
	}

}
