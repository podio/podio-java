package com.podio.view;

import org.codehaus.jackson.annotate.JsonProperty;

public class ViewGroups
{
	@JsonProperty("value")
	private int id;
	private String label;
	
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId( int id )
	{
		this.id = id;
	}
	/**
	 * @return the label
	 */
	public String getLabel()
	{
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel( String label )
	{
		this.label = label;
	}
}
