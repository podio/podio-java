package com.podio.search;

import com.podio.app.Application;
import com.podio.common.AuthorizationEntity;
import com.podio.org.Organization;

import org.codehaus.jackson.annotate.JsonProperty;
import com.podio.space.Space;
import org.joda.time.DateTime;

public class SearchResult {
        
	private Integer id;

	private ReferenceTypeSearchInApp type;

	private Integer rank;
        
        /**
	 * The app where the item belongs
	 */
	private Application app;
        
        private Organization org;
        
        private Space space;
        
        private String highlight;
        
        /**
	 * The entity who created the item
	 */
	private AuthorizationEntity createdBy;

	/**
	 * The date and time the item was created
	 */
        private DateTime createdOn;        
	
	/**
	 * The title of the item. This is made of up one of the fields below, or by
	 * the item name and id
	 */
	private String title;

	/**
	 * The direct link to the item
	 */
	private String link;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
        
	@JsonProperty("created_on")
	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

        public ReferenceTypeSearchInApp getType() {
                return type;
        }

        public void setType(ReferenceTypeSearchInApp type) {
                this.type = type;
        }

        public Integer getRank() {
                return rank;
        }

        public void setRank(Integer rank) {
                this.rank = rank;
        }

        public Application getApp() {
                return app;
        }

        public void setApp(Application app) {
                this.app = app;
        }

        public Organization getOrg() {
                return org;
        }

        public void setOrg(Organization org) {
                this.org = org;
        }

        public Space getSpace() {
                return space;
        }

        public void setSpace(Space space) {
                this.space = space;
        }

        public String getHighlight() {
                return highlight;
        }

        public void setHighlight(String highlight) {
                this.highlight = highlight;
        }

        @JsonProperty("created_by")
        public AuthorizationEntity getCreatedBy() {
                return createdBy;
        }

        @JsonProperty("created_by")
        public void setCreatedBy(AuthorizationEntity createdBy) {
                this.createdBy = createdBy;
        }
        
}
