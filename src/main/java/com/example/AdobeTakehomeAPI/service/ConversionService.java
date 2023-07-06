package com.example.AdobeTakehomeAPI.service;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ConversionService {
    private static final LinkedHashMap<Integer, String> ROMAN_MAPPING = new LinkedHashMap<>();
    static {
        ROMAN_MAPPING.put(1000, "M");
        ROMAN_MAPPING.put(900, "CM");
        ROMAN_MAPPING.put(500, "D");
        ROMAN_MAPPING.put(400, "CD");
        ROMAN_MAPPING.put(100, "C");
        ROMAN_MAPPING.put(90, "XC");
        ROMAN_MAPPING.put(50, "L");
        ROMAN_MAPPING.put(40, "XL");
        ROMAN_MAPPING.put(10, "X");
        ROMAN_MAPPING.put(9, "IX");
        ROMAN_MAPPING.put(5, "V");
        ROMAN_MAPPING.put(4, "IV");
        ROMAN_MAPPING.put(1, "I");
    }
    public ConversionService(){
    }
    public String getRomanConversion(Integer input){
        if (input>3999 || input<1){
            throw new IllegalArgumentException("Number should be in range of 1-3999");
        }
        StringBuilder romanNumeral = new StringBuilder();
        for (Map.Entry<Integer, String> item: ROMAN_MAPPING.entrySet()){
            while (input>=item.getKey()){
                romanNumeral.append(item.getValue());
                input -= item.getKey();
            }
        }
        return romanNumeral.toString();
    }
}
