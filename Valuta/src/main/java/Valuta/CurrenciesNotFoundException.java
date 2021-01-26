package Valuta;

public class CurrenciesNotFoundException extends RuntimeException
{
	CurrenciesNotFoundException(String theId) 
	{
		super("Could not find employee " + theId);
	}

}
