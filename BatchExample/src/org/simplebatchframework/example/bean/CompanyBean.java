package org.simplebatchframework.example.bean;

import java.sql.Date;

import org.simplebatchframework.core.bean.IBean;
import org.simplebatchframework.core.bean.annotation.Bind;
import org.simplebatchframework.core.bean.annotation.InputFile;
import org.simplebatchframework.core.bean.annotation.OutputDB;

public class CompanyBean implements IBean {

	@Override
	public String toString() {
		return "CompanyBean [id=" + id + ", name=" + name + ", location="
				+ location + ", establishedDay=" + establishedDay + "]";
	}

	private static final long serialVersionUID = 1L;
	
	@OutputDB("ID")
	private Integer id;

	@Bind(1)
	@InputFile(1)
	@OutputDB("NAME")
	private String name;

	@Bind(2)
	@InputFile(2)
	@OutputDB("LOCATION")
	private String location;

	@InputFile(3)
	private String establishedDayString;

	@Bind(3)
	@OutputDB("ESTABLISHED_DAY")
	private Date establishedDay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEstablishedDayString() {
		return establishedDayString;
	}

	public void setEstablishedDayString(String establishedDayString) {
		this.establishedDayString = establishedDayString;
	}

	public Date getEstablishedDay() {
		return establishedDay;
	}

	public void setEstablishedDay(Date establishedDay) {
		this.establishedDay = establishedDay;
	}
}
