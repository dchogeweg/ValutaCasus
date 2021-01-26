package Valuta;


import org.springframework.data.jpa.repository.JpaRepository;

interface CurrenciesRepository  extends JpaRepository<Currencies, String> 
{

}
