package Valuta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase 
{
	  private static final Logger itslog = LoggerFactory.getLogger(LoadDatabase.class);

	  @Bean
	  CommandLineRunner initDatabase(CurrenciesRepository theRepository) 
	  {
	    return args -> 
	    {
	    	itslog.info("Preloading " + theRepository.save(new Currencies("BTC", "Bitcoin", 16770000L, 189580000000L)));
	    	itslog.info("Preloading " + theRepository.save(new Currencies("ETH", "Ethereum", 96710000L, 69280000000L)));
	    	itslog.info("Preloading " + theRepository.save(new Currencies("XRP", "Ripple", 38590000000L, 64750000000L)));
	    	itslog.info("Preloading " + theRepository.save(new Currencies("BCH", "BitcoinCash", 16670000L, 69020000000L)));
	    };
	  }

}
