package classes;

import java.util.List;

public class Person {
	private String name;
	private String personId;
	private String personCode;
	private Integer age;
	private String passion;
	private String occupation;
	private List<String> phoneNum;

	public String getName() {
		return name;
	}

	public List<String> getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(List<String> phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonCode() {
		return this.personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassion() {
		return passion;
	}

	public void setPassion(String passion) {
		this.passion = passion;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setName(String name) {
		this.name = name;
	}
}