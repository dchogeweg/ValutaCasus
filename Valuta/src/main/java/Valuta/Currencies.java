package Valuta;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currencies 
{
	private @Id String itsTicker;
	private String itsName;
	private Long itsNumberOfCoins;
	private Long itsMarketCap;
	

	public Currencies()
	{
		
	}
	
	
	public Currencies(String theTicker, String theName, Long theNumberOfCoins, Long theMarketCap)
	{
		itsTicker = theTicker;
		itsName = theName;
		itsNumberOfCoins = theNumberOfCoins;
		itsMarketCap = theMarketCap;
	}
	
	public String getTicker()
	{
		return itsTicker;
	}
	
	public String getName()
	{
		return itsName;
	}
	
	public Long getNumberOfCoins()
	{
		return itsNumberOfCoins;
	}
	
	public Long getMarketCap()
	{
		return itsMarketCap;
	}
	
	
	public void setTicker(String theTicker)
	{
		itsTicker = theTicker;
	}
	
	public void setName(String theName)
	{
		itsName = theName;
	}
	
	public void setNumberOfCoins(Long theNumberOfCoins)
	{
		itsNumberOfCoins = theNumberOfCoins;
	}
	
	public void setMarketCap(Long theMarketCap)
	{
		itsMarketCap = theMarketCap;
	}
	
	  @Override
	  public String toString() 
	  {
	    return "Currency{" + "Ticker=" + itsTicker + 
	    					", name=" + itsName +
	    					", Number of Coins=" + itsNumberOfCoins +
	    					", Market Cap" + itsMarketCap + '}';
	  }
}
