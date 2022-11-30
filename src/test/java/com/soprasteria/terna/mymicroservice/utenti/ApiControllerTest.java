package com.soprasteria.terna.mymicroservice.utenti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.web.servlet.MockMvc;

import com.soprasteria.terna.mymicroservice.utenti.configuration.WebSecurityConfig;
import com.soprasteria.terna.mymicroservice.utenti.service.ApiService;

import uk.co.jemos.podam.api.PodamFactory;

@WebMvcTest(includeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value=WebSecurityConfig.class),
})
public class ApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ApiService service;

    @MockBean
    private PodamFactory podamFactory;

}

