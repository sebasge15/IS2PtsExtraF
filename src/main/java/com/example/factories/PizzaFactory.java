package com.example.factories;

import com.example.models.Comida;
import com.example.models.Pizza;


public class PizzaFactory implements ComidaFactory {
    @Override
    public Comida crearComida(String nombre, double precio) {
        return new Pizza(nombre, precio);
    }
}