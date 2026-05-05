package com.cruz.taller.temperaturas.service;

import org.springframework.stereotype.Service;

@Service
public class TemperaturaService {

    public double celsiusAFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }
}
