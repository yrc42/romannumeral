package com.example.AdobeTakehomeAPI.api.controller;
import com.example.AdobeTakehomeAPI.service.ConversionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConvertionController {
    private static final Logger logger = LogManager.getLogger(ConvertionController.class);
    private final ConversionService conversionService;
    @Autowired
    public ConvertionController(ConversionService conversionService){
        this.conversionService = conversionService;
    }
    @GetMapping("/romannumeral")
    public ResponseEntity<?> getRomanConversion(@RequestParam Integer query){
        try {
            logger.info("Input: {}", query);
            String output= this.conversionService.getRomanConversion(query);
            Map<String, Object> response = new HashMap<>();
            response.put("input", query);
            response.put("output", output);
            logger.info("Successfully converted {} to Roman numeral: {}", query, output);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            logger.error("Invalid input: {}", query, exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            logger.error("An error occurred converting input {}", query, exception);
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
