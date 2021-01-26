package Valuta;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrenciesController 
{

	private final CurrenciesRepository itsRepository;
	
	CurrenciesController(CurrenciesRepository theRepository) 
	{
	    itsRepository = theRepository;
	}
	  
	@GetMapping("/currencies")
	List<Currencies> all() 
	{
	  return itsRepository.findAll();
	}

    @PostMapping("/currencies")
    Currencies newCurrencies(@RequestBody Currencies theCurrencies) 
    {
      return itsRepository.save(theCurrencies);
    }

    @GetMapping("/currencies/{id}")
    Currencies one(@PathVariable String theId) 
    {
      return itsRepository.findById(theId).orElseThrow(() -> new CurrenciesNotFoundException(theId));
    }

    @PutMapping("/currencies/{id}")
    Currencies replaceCurrencies(@RequestBody Currencies theCurrencies, @PathVariable String theId) 
    {
    	return itsRepository.findById(theId).map(currencies -> 
    	{
	        currencies.setName(theCurrencies.getName());
	        currencies.setNumberOfCoins(theCurrencies.getNumberOfCoins());
	        currencies.setMarketCap(theCurrencies.getMarketCap());
        	return itsRepository.save(currencies);
    	})
    	.orElseGet(() -> 
    	{
    		theCurrencies.setTicker(theId);
    		return itsRepository.save(theCurrencies);
    	});
    }

  @DeleteMapping("/currencies/{id}")
  void deleteEmployee(@PathVariable String theId) 
  {
	  itsRepository.deleteById(theId);
  }
}