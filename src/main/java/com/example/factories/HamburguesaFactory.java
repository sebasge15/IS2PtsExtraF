package com.example.factories;

import com.example.models.Comida;
import com.example.models.Hamburguesa;

public class HamburguesaFactory implements ComidaFactory {
    @Override
    public Comida crearComida(String nombre, double precio) {
        return new Hamburguesa(nombre, precio);
    }
}
