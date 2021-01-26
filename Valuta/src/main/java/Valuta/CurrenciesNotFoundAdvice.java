package Valuta;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CurrenciesNotFoundAdvice 
{
	  @ResponseBody
	  @ExceptionHandler(CurrenciesNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(CurrenciesNotFoundException theExeception) 
	  {
	    return theExeception.getMessage();
	  }

}
