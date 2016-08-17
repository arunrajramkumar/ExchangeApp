package com.xyz.common.controller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
 

import org.springframework.web.context.WebApplicationContext;

import com.xyz.common.model.CurrencyExchangeRate;
import com.xyz.common.service.ExchangeService;

import java.util.Arrays;
 









import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {
		"classpath:exchange-db.xml"
} )
@WebAppConfiguration
public class ControllerTest {
 
    private MockMvc mockMvc;
 
    @Mock
    private ExchangeService todoServiceMock;
    
    
   
 
    //Add WebApplicationContext field here.
 
    //The setUp() method is omitted.
    
    
    @Test
    public void mockTest(){
    	
    	todoServiceMock = mock(ExchangeService.class);
    	
    	CurrencyExchangeRate first = new CurrencyExchangeRate();
    	first.setCurrencyName("INR");
    	CurrencyExchangeRate second = new CurrencyExchangeRate();
    	second.setCurrencyName("USD");
        when(todoServiceMock.listExchangeRates()).thenReturn(Arrays.asList(first, second));
    	
        assertEquals(todoServiceMock.listExchangeRates().size(), 3);
    }
    
 
   /* @Test
    public void findAll_TodosFound_ShouldReturnFoundTodoEntries() throws Exception {
       
 
    	CurrencyExchangeRate first = new CurrencyExchangeRate();
    	first.setCurrencyName("INR");
    	CurrencyExchangeRate second = new CurrencyExchangeRate();
    	second.setCurrencyName("USD");
        when(todoServiceMock.listExchangeRates()).thenReturn(Arrays.asList(first, second));
 
        mockMvc.perform(get("exchange/list"))
                .andExpect(status().isOk())
               // .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].currencyName", is("INR")))
                //.andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
                //.andExpect(jsonPath("$[0].title", is("Foo")))
                .andExpect(jsonPath("$[1].currencyName", is("USD")));
                //.andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
               // .andExpect(jsonPath("$[1].title", is("Bar")));
 
        verify(todoServiceMock, times(1)).listExchangeRates();
        verifyNoMoreInteractions(todoServiceMock);
    }*/
}