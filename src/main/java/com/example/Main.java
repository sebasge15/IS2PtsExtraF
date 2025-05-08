package com.example;

import com.example.factories.ComidaFactory;
import com.example.factories.EnsaladaFactory;
import com.example.factories.HamburguesaFactory;
import com.example.factories.PizzaFactory;
import com.example.models.Comida;
import com.example.models.Pedido;
import com.example.models.Usuario;
import com.example.services.GestorPedidos;

public class Main {
    public static void main(String[] args) {
        // Creación de fábricas
        ComidaFactory pizzaFactory = new PizzaFactory();
        ComidaFactory hamburguesaFactory = new HamburguesaFactory();
        ComidaFactory ensaladaFactory = new EnsaladaFactory();

        // Creación de comidas
        Comida pizza = pizzaFactory.crearComida("Pizza Pepperoni", 14.99);
        Comida hamburguesa = hamburguesaFactory.crearComida("Burger Clásica", 9.99);
        Comida ensalada = ensaladaFactory.crearComida("Ensalada Griega", 7.99);

        // Crear usuario y pedido
        Usuario usuario = new Usuario("Sebastian Gonzalez");
        Pedido pedido = new Pedido(usuario);
        pedido.agregarItem(pizza);
        pedido.agregarItem(hamburguesa);
        pedido.agregarItem(ensalada);

        // Registrar pedido en el gestor
        GestorPedidos gestor = GestorPedidos.getInstancia();
        gestor.agregarPedido(pedido);

        // Mostrar información inicial
        System.out.println("=== Estado inicial del pedido ===");
        System.out.println("Total: S/." + pedido.calcularTotal());
        System.out.println("Estado: " + pedido.getEstado());

        // Actualizar estado
        pedido.cambiarEstado("en preparación");

        // Mostrar estado actualizado
        System.out.println("\n=== Estado actualizado del pedido ===");
        System.out.println("Nuevo estado: " + pedido.getEstado());

        // Listar todos los pedidos en el sistema
        System.out.println("\n=== Pedidos registrados ===");
        for (Pedido p : gestor.obtenerPedidos()) {
            System.out.println("\nPedido de: " + p.getUsuario().getNombre());
            System.out.println("Items:");
            p.getItems().forEach(item -> System.out.printf("- %s: S/.%.2f\n", item.getNombre(), item.getPrecio()));
            System.out.printf("Total: S/.%.2f\n", p.calcularTotal());
            System.out.println("Estado: " + p.getEstado());
        }

        // Verificar instancia única
        GestorPedidos otroGestor = GestorPedidos.getInstancia();
        System.out.println("\n¿Misma instancia? " + (gestor == otroGestor));
    }
}