package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Pedido;

public class GestorPedidos {
    private static GestorPedidos instancia;
    private List<Pedido> pedidos = new ArrayList<>();

    private GestorPedidos() {}

    public static synchronized GestorPedidos getInstancia() {
        if (instancia == null) {
            instancia = new GestorPedidos();
        }
        return instancia;
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> obtenerPedidos() {
        return new ArrayList<>(pedidos);
    }
}
