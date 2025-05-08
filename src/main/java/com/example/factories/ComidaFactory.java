package com.example.factories;

import com.example.models.Comida;

public interface ComidaFactory {
    Comida crearComida(String nombre, double precio);
}
