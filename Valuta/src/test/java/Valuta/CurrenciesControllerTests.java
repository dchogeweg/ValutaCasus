package Valuta;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrenciesControllerTests 
{

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void intialSituation() throws Exception 
	{
		this.mockMvc.perform(get("/currencies")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].ticker").value("BTC"))
				.andExpect(jsonPath("$[0].name").value("Bitcoin"))
				.andExpect(jsonPath("$[0].numberOfCoins").value("16770000"))
				.andExpect(jsonPath("$[0].marketCap").value("189580000000"))
				.andExpect(jsonPath("$[1].ticker").value("ETH"))
				.andExpect(jsonPath("$[1].name").value("Ethereum"))
				.andExpect(jsonPath("$[1].numberOfCoins").value("96710000"))
				.andExpect(jsonPath("$[1].marketCap").value("69280000000"))
				.andExpect(jsonPath("$[2].ticker").value("XRP"))
				.andExpect(jsonPath("$[2].name").value("Ripple"))
				.andExpect(jsonPath("$[2].numberOfCoins").value("38590000000"))
				.andExpect(jsonPath("$[2].marketCap").value("64750000000"))
				.andExpect(jsonPath("$[3].ticker").value("BCH"))
				.andExpect(jsonPath("$[3].name").value("BitcoinCash"))
				.andExpect(jsonPath("$[3].numberOfCoins").value("16670000"))
				.andExpect(jsonPath("$[3].marketCap").value("69020000000"));
	}

	@Test
	public void getSingleItem() throws Exception 
	{
		this.mockMvc.perform(get("/currencies/ETH")).andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$[0].ticker").value("ETH"))
			.andExpect(jsonPath("$[0].name").value("Ethereum"))
			.andExpect(jsonPath("$[0].numberOfCoins").value("96710000"))
			.andExpect(jsonPath("$[0].marketCap").value("69280000000"));
	}

}