package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Iniciando aplicación...");
        App app = new App();
        System.out.println(app.saludo());
    }

    public String saludo() {
        return "Kaixo DevOps";
    }
}