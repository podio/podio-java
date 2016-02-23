package com.podio.item;

public class ItemCount
{
	private int count;

	/**
	 * @return the count
	 */
	public int getCount()
	{
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount( int count )
	{
		this.count = count;
	}
	
	@Override
	public String toString()
	{
		if ( count == 1 )
			return count + " item";
		return count + " items";
	}
}
