package com.cruz.taller.moneda.service;

import org.springframework.stereotype.Service;

@Service
public class MonedaService {

    // Tasa fija: 1 USD = 4000 COP (tasa de referencia)
    private static final double TASA_USD_A_COP = 4000.0;

    public double convertirDolaresCOP(double dolares) {
        return dolares * TASA_USD_A_COP;
    }

    public double getTasa() {
        return TASA_USD_A_COP;
    }
}
