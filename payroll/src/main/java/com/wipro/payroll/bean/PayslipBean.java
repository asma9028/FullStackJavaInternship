package com.wipro.payroll.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PAYSLIP_TB")
public class PayslipBean {
	@Id
	private String empid;
	private String month;
	private String year;
	
	@Column(name="BASIC", columnDefinition="NUMBER(10,2)")
	private double basic;
	
	@Column(name="COMMUTATION", columnDefinition="NUMBER(10,2)")
	private double commutation;
	
	@Column(name="HRALLOWANCE", columnDefinition="NUMBER(10,2)")
	private double hrAllowance;
	
	@Column(name="PROVIDENTFUND", columnDefinition="NUMBER(10,2)")
	private double providentFund;
	
	@Column(name="TOTAL_SALARY", columnDefinition="NUMBER(10,2)")
	private double totalSalary;
	
	@Column(name="INCOME_TAX", columnDefinition="NUMBER(10,2)")
	private double incomeTax;
	
	@Column(name="PAYABLE_AMOUNT", columnDefinition="NUMBER(10,2)")
	private double payableAmount;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getCommutation() {
		return commutation;
	}

	public void setCommutation(double commutation) {
		this.commutation = commutation;
	}

	public double getHrAllowance() {
		return hrAllowance;
	}

	public void setHrAllowance(double hrAllowance) {
		this.hrAllowance = hrAllowance;
	}

	public double getProvidentFund() {
		return providentFund;
	}

	public void setProvidentFund(double providentFund) {
		this.providentFund = providentFund;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public double getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}
	
	
}
