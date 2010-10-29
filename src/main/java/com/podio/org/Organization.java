package com.podio.org;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.podio.space.Space;

@XmlRootElement
public class Organization {

	private int id;

	private String name;

	private int logo;

	private String url;

	private boolean premium;

	private String createRight;

	private List<Space> spaces;

	@XmlElement(name = "org_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "logo")
	public int getLogo() {
		return logo;
	}

	public void setLogo(int logo) {
		this.logo = logo;
	}

	@XmlElement(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	@XmlElement(name = "create_right")
	public String getCreateRight() {
		return createRight;
	}

	public void setCreateRight(String createRight) {
		this.createRight = createRight;
	}

	@XmlElement(name = "spaces")
	public List<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}
}
