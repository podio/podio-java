package com.podio.contact;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	/**
	 * The id of the user
	 */
	private int userId;

	/**
	 * The full name
	 */
	private String name;

	/**
	 * The file id of the avatar
	 */
	private Integer avatar;

	/**
	 * The birthdate
	 */
	private Date birthdate;

	/**
	 * The organization or company the person is associated with
	 */
	private String organization;

	/**
	 * The username for Skype
	 */
	private String skype;

	/**
	 * Short text about the person
	 */
	private String about;

	/**
	 * The addresses where the person lives or work
	 */
	private List<String> addresses;

	/**
	 * Any instant messaging address
	 */
	private List<String> ims;

	/**
	 * The locations of the person
	 */
	private List<String> locations;

	/**
	 * Email addresses
	 */
	private List<String> mails;

	/**
	 * The phone numbers
	 */
	private List<String> phones;

	/**
	 * The persons title, usually the work title
	 */
	private List<String> titles;

	/**
	 * An URL to the persons homepage or the homepage of the company
	 */
	private List<String> urls;

	@XmlElement(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "avatar")
	public Integer getAvatar() {
		return avatar;
	}

	public void setAvatar(Integer avatar) {
		this.avatar = avatar;
	}

	@XmlElement(name = "birthdate")
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@XmlElement(name = "organization")
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@XmlElement(name = "skype")
	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	@XmlElement(name = "about")
	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@XmlElement(name = "address")
	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	@XmlElement(name = "im")
	public List<String> getIms() {
		return ims;
	}

	public void setIms(List<String> ims) {
		this.ims = ims;
	}

	@XmlElement(name = "location")
	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	@XmlElement(name = "mail")
	public List<String> getMails() {
		return mails;
	}

	public void setMails(List<String> mails) {
		this.mails = mails;
	}

	@XmlElement(name = "phone")
	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	@XmlElement(name = "title")
	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	@XmlElement(name = "url")
	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
}
