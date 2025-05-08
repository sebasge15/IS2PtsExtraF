package com.example.factories;

import com.example.models.Comida;
import com.example.models.Ensalada;

public class EnsaladaFactory implements ComidaFactory {
    @Override
    public Comida crearComida(String nombre, double precio) {
        return new Ensalada(nombre, precio);
    }
}
