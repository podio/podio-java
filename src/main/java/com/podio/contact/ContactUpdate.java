package com.podio.contact;

import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.LocalDate;

public class ContactUpdate {

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
        private LocalDate birthdate;

        /**
         * The organization or company the person is associated with
         */
        private String organization;

        /**
         * The department of the organization 
         */
        private String department;

        /**
         * The username for Skype 
         */
        private String skype;

        /**
         * Short text about the person
         */
        private String about;

        /**
         * The address where the person lives or work 
         */
        private List<String> addresses;

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
         * The location of the person
         */
        private List<String> locations;

        /**
         * Email address
         */
        private List<String> mails;

        /**
         * The phone number 
         */
        private List<String> phones;

        /**
         * The persons title, usually the work title
         */
        private List<String> titles;

        /**
         * The full URL of the users LinkedIn profile
         */
        private String linkedin;

        /**
         * The name of the users Twitter profile
         */
        private String twitter;

        /**
         * An URL to the persons homepage or the homepage of the company 
         */
        private List<String> urls;

        /**
         * The skill of the user
         */
        private List<String> skills;

        public ContactUpdate() {
                this(null, null, null, null, null, null, null, Collections.<String>emptyList(),
                        null, null, null, null, Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), null, null,
                        Collections.<String>emptyList(), Collections.<String>emptyList());
        }

        public ContactUpdate(String name, Integer avatar, LocalDate birthdate,
                        String organization, String department, String skype, String about,
                        List<String> addresses, String zip, String city, String state,
                        String country, List<String> locations, List<String> mails,
                        List<String> phones, List<String> titles, String linkedin,
                        String twitter, List<String> urls, List<String> skills) {
                super();

                this.name = name;
                this.avatar = avatar;
                this.birthdate = birthdate;
                this.organization = organization;
                this.department = department;
                this.skype = skype;
                this.about = about;
                this.addresses = addresses;
                this.zip = zip;
                this.city = city;
                this.state = state;
                this.country = country;
                this.locations = locations;
                this.mails = mails;
                this.phones = phones;
                this.titles = titles;
                this.linkedin = linkedin;
                this.twitter = twitter;
                this.urls = urls;
                this.skills = skills;
        }

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

        public String getDepartment() {
                return department;
        }

        public void setDepartment(String department) {
                this.department = department;
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

        @JsonProperty("adress")
        public List<String> getAddresses() {
                return addresses;
        }

        @JsonProperty("adress")
        public void setAddresses(List<String> addresses) {
                this.addresses = addresses;
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

        public String getLinkedin() {
                return linkedin;
        }

        public void setLinkedin(String linkedin) {
                this.linkedin = linkedin;
        }

        public String getTwitter() {
                return twitter;
        }

        public void setTwitter(String twitter) {
                this.twitter = twitter;
        }

        @JsonProperty("url")
        public List<String> getUrls() {
                return urls;
        }

        @JsonProperty("url")
        public void setUrls(List<String> urls) {
                this.urls = urls;
        }

        @JsonProperty("skill")
        public List<String> getSkills() {
                return skills;
        }

        @JsonProperty("skill")
        public void setSkills(List<String> skills) {
                this.skills = skills;
        }

}
