package org.simplebatchframework.example.bean;

import java.math.BigDecimal;

import org.simplebatchframework.core.bean.IBean;
import org.simplebatchframework.core.bean.annotation.Bind;
import org.simplebatchframework.core.bean.annotation.InputDB;
import org.simplebatchframework.core.bean.annotation.OutputFile;

public class EmployeeBean implements IBean {

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", salary=" + salary
				+ ", bossLastName=" + bossLastName + ", grade=" + grade + "]";
	}

	private static final long serialVersionUID = 1L;

	@Bind(1)
	@InputDB("ID")
	@OutputFile(1)
	private Integer id;

	@InputDB("FIRST_NAME")
	@OutputFile(3)
	private String firstName;

	@InputDB("LAST_NAME")
	@OutputFile(2)
	private String lastName;

	@InputDB("SALARY")
	private Integer salary;

	@InputDB("BOSS_LAST_NAME")
	@OutputFile(4)
	private String bossLastName;

	@InputDB("GRADE")
	private BigDecimal grade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getBossLastName() {
		return bossLastName;
	}

	public void setBossLastName(String bossLastName) {
		this.bossLastName = bossLastName;
	}

	public BigDecimal getGrade() {
		return grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
}
