package com.wipro.payroll.service;

import java.time.LocalDate;

import com.wipro.payroll.bean.PayslipBean;
import com.wipro.payroll.dao.PayslipDAO;
import com.wipro.payroll.util.InvalidInputException;

public class Administrator {
	private PayslipDAO payslipDAO;
	public String addPayslip(PayslipBean payslipBean) throws InvalidInputException {
		payslipDAO = new PayslipDAO();
		if(payslipBean != null && payslipBean.getEmpid()!= null && payslipBean.getMonth() != null && payslipBean.getBasic()> 0 && payslipBean.getCommutation()>0 && payslipBean.getHrAllowance()>0) {
			if(payslipBean.getMonth().equals(LocalDate.now().getMonth().name().substring(0,3)) && payslipBean.getYear().equals(String.valueOf(LocalDate.now().getYear()))) {
				if(payslipDAO.payslipExists(payslipBean.getEmpid())) {
					return "ALREADY EXISTS";
				}
				else {
					double basic = payslipBean.getBasic();
					payslipBean.setProvidentFund(0.12*basic);
					if(basic > 84000) {
						payslipBean.setIncomeTax(0.3 * basic);
					}
					else if(basic >=42001 && basic <= 84000) {
						payslipBean.setIncomeTax(0.2*basic);
					}
					else if(basic>=21001 && basic<=42000) {
						payslipBean.setIncomeTax(0.1 * basic);
					}
					else if(basic>=1 && basic<=21000){
						payslipBean.setIncomeTax(0);
					}
					double total = payslipBean.getBasic() + payslipBean.getCommutation() + payslipBean.getHrAllowance() + payslipBean.getProvidentFund();
					double payAmount = total - payslipBean.getIncomeTax() - payslipBean.getProvidentFund();
					payslipBean.setTotalSalary(total);
					payslipBean.setPayableAmount(payAmount);
					return payslipDAO.createPayslip(payslipBean);
				}
			}else {
				throw new InvalidInputException("INVALID MONTH OR YEAR");
			}
		}
		else {
			throw new InvalidInputException("INVALID INPUT");
		}
	}
	
	public PayslipBean viewPayslip(String empID) {
		payslipDAO = new PayslipDAO();
		return payslipDAO.fetchPayslip(empID);
	}
}
