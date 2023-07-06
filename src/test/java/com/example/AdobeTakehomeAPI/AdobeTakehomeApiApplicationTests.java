package com.example.AdobeTakehomeAPI;

import com.example.AdobeTakehomeAPI.service.ConversionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConversionServiceTests {
	private ConversionService conversionService =new ConversionService();
	@Test
	public void testFunctionWithInput1(){
		int input =1;
		String expectedOutput =  "I";
		Assertions.assertEquals(conversionService.getRomanConversion(input), expectedOutput);
	}
	@Test
	public void InvalidConversion(){
		int input =-1;
		Assertions.assertThrows(IllegalArgumentException.class, ()->{conversionService.getRomanConversion(input);});
	}

}
