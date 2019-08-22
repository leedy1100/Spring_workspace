package com.test02;

public class JobAddress {

	private Address addr;
	private String jobName;

	public JobAddress() {
		this.addr = new Address("홍길동", "서울시 강남구", "010-1111-1111");
		this.jobName = "웹 개발자";
	}

	public JobAddress(Address addr, String jobName) {
		super();
		this.addr = addr;
		this.jobName = jobName;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return addr.toString() + " \t 직업 : " + jobName;
	}

}
