package com.podio.contact;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.LocalDate;

import com.podio.file.File;

public class ProfileUpdate {

	/**
	 * The full name
	 */
	private String name;

	/**
	 * The file id of the avatar
	 */
	private Integer avatar;
	
	/**
	 * The image details for the user
	 */
	private File image;

	/**
	 * The birthdate
	 */
	private LocalDate birthdate;

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
	 * The zip code of the address
	 */
	private String zip;

        /**
	 * The name of the city
	 */
	private String city;

        /**
	 * The name of the state, only applicable in some countries
	 */
	private String state;

        /**
	 * The name of the country
	 */
	private String country;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAvatar() {
		return avatar;
	}

	public void setAvatar(Integer avatar) {
		this.avatar = avatar;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

	@JsonProperty("address")
	public List<String> getAddresses() {
		return addresses;
	}

	@JsonProperty("address")
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	@JsonProperty("im")
	public List<String> getIms() {
		return ims;
	}

	@JsonProperty("im")
	public void setIms(List<String> ims) {
		this.ims = ims;
	}

	@JsonProperty("location")
	public List<String> getLocations() {
		return locations;
	}

	@JsonProperty("location")
	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	@JsonProperty("mail")
	public List<String> getMails() {
		return mails;
	}

	@JsonProperty("mail")
	public void setMails(List<String> mails) {
		this.mails = mails;
	}

	@JsonProperty("phone")
	public List<String> getPhones() {
		return phones;
	}

	@JsonProperty("phone")
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	@JsonProperty("title")
	public List<String> getTitles() {
		return titles;
	}

	@JsonProperty("title")
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	@JsonProperty("url")
	public List<String> getUrls() {
		return urls;
	}

	@JsonProperty("url")
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
}
