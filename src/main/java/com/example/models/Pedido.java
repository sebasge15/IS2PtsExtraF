package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Usuario usuario;
    private List<Comida> items = new ArrayList<>();
    private String estado;

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
        this.estado = "pendiente";
    }

    public void agregarItem(Comida comida) {
        items.add(comida);
    }

    public double calcularTotal() {
        return items.stream().mapToDouble(Comida::getPrecio).sum();
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String getEstado() {
        return estado;
    }

    public List<Comida> getItems() {
        return new ArrayList<>(items);
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
