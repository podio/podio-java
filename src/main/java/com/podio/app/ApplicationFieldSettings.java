package com.podio.app;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationFieldSettings implements Serializable {

	private static final long serialVersionUID = 1L;

	private TextFieldSize size;

	private List<String> allowedValues;

	private List<Integer> referenceableTypes;

	private List<String> allowedCurrencies;

	private List<CategoryOption> options;

	private Boolean multiple;
        
	private String color;
        
	private Boolean showInCalendars;
      
	private DateFieldEndDateType endDate;

	private DateFieldTimeEntryType timeEntry;
        
	public ApplicationFieldSettings() {
		super();
	}

	public ApplicationFieldSettings(TextFieldSize size,
			List<String> allowedValues, List<Integer> referenceableTypes,
			List<String> allowedCurrencies, List<CategoryOption> options,
			Boolean multiple) {
		super();
		this.size = size;
		this.allowedValues = allowedValues;
		this.referenceableTypes = referenceableTypes;
		this.allowedCurrencies = allowedCurrencies;
		this.options = options;
		this.multiple = multiple;
	}

	@JsonProperty("size")
	public TextFieldSize getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(TextFieldSize size) {
		this.size = size;
	}

	@JsonProperty("allowed_values")
	public List<String> getAllowedValues() {
		return allowedValues;
	}

	@JsonProperty("allowed_values")
	public void setAllowedValues(List<String> allowedValues) {
		this.allowedValues = allowedValues;
	}

	@JsonProperty("referenceable_types")
	public List<Integer> getReferenceableTypes() {
		return referenceableTypes;
	}

	@JsonProperty("referenceable_types")
	public void setReferenceableTypes(List<Integer> referenceableTypes) {
		this.referenceableTypes = referenceableTypes;
	}

	@JsonProperty("allowed_currencies")
	public List<String> getAllowedCurrencies() {
		return allowedCurrencies;
	}

	@JsonProperty("allowed_currencies")
	public void setAllowedCurrencies(List<String> allowedCurrencies) {
		this.allowedCurrencies = allowedCurrencies;
	}

	public List<CategoryOption> getOptions() {
		return options;
	}

	public void setOptions(List<CategoryOption> options) {
		this.options = options;
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	@Override
	public String toString() {
		return "ApplicationFieldSettings [allowedValues=" + allowedValues
				+ ", referenceableTypes=" + referenceableTypes
				+ ", allowedCurrencies=" + allowedCurrencies + "]";
	}

	public static ApplicationFieldSettings getState(List<String> allowedValues) {
		return new ApplicationFieldSettings(null, allowedValues, null, null,
				null, null);
	}

	public static ApplicationFieldSettings getApp(
			List<Integer> referenceableTypes) {
		return new ApplicationFieldSettings(null, null, referenceableTypes,
				null, null, null);
	}

	public static ApplicationFieldSettings getText(TextFieldSize size) {
		return new ApplicationFieldSettings(size, null, null, null, null, null);
	}

	public static ApplicationFieldSettings getMoney(
			List<String> allowedCurrencies) {
		return new ApplicationFieldSettings(null, null, null,
				allowedCurrencies, null, null);
	}

	public static ApplicationFieldSettings getCategory(
			List<CategoryOption> options, boolean multiple) {
		return new ApplicationFieldSettings(null, null, null, null, options,
				multiple);
	}

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

        @JsonProperty("calendar")
        public Boolean getShowInCalendars() {
                return showInCalendars;
        }

        @JsonProperty("calendar")
        public void setShowInCalendars(Boolean showInCalendars) {
                this.showInCalendars = showInCalendars;
        }

        @JsonProperty("end")
        public DateFieldEndDateType getEndDate() {
                return endDate;
        }

        @JsonProperty("end")
        public void setEndDate(DateFieldEndDateType endDate) {
                this.endDate = endDate;
        }

        @JsonProperty("time")
        public DateFieldTimeEntryType getTimeEntry() {
                return timeEntry;
        }

        @JsonProperty("time")
        public void setTimeEntry(DateFieldTimeEntryType timeEntry) {
                this.timeEntry = timeEntry;
        }
        
}
