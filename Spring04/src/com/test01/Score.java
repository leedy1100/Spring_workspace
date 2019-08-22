package com.test01;

import java.util.List;

public class Score {

	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String grade;

	public Score() {

	}

	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return kor + eng + math;
	}

	public double getAvg() {
		return (double) getSum() / 3;
	}

	public String getGrade() {
		return getAvg()>=90?"A":"B";
	}

	@Override
	public String toString() {
		return "Score [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ getSum()+ ", avg=" + getAvg() + ", grade=" + getGrade() + "]";
	}

	public void setScore(List<Score> score) {
		System.out.println("setScore() 호출");

		for (Score sc : score) {
			System.out.println(sc);
		}
	}

}
