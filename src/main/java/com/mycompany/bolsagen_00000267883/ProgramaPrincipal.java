package com.mycompany.bolsagen_00000267883;

/**
 * Programa principal para mostrar cómo funcionan BolsaGen y BolsaGenNum.
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 */

import com.mycompany.bolsagen_00000267883.implementaciones.BolsaGen;
import com.mycompany.bolsagen_00000267883.implementaciones.BolsaGenNum;
import com.mycompany.bolsagen_00000267883.excepciones.BolsaException;

public class ProgramaPrincipal {

    /**
     * Método principal que corre todas las demos.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRACION DE BOLSAGEN Y BOLSAGENNUM ===\n");

        // Demostracion con BolsaGen<Integer>
        demostrarBolsaGenInteger();

        // Demostracion con BolsaGen<String>
        demostrarBolsaGenString();

        // Demostracion con BolsaGenNum<Integer>
        demostrarBolsaGenNumInteger();

        // Demostracion con BolsaGenNum<Double>
        demostrarBolsaGenNumDouble();

        System.out.println("\n=== DEMONSTRACION COMPLETADA ===");
    }

    /**
     * Muestra BolsaGen con Integer.
     * Cubre los puntos a) a h) de la rúbrica.
     */
    private static void demostrarBolsaGenInteger() {
        System.out.println("--- DEMOSTRACION BOLSAGEN<INTEGER> ---");

        // a) Crear bolsa de Integer vacía
        BolsaGen<Integer> bolsaInt = new BolsaGen<>(3);
        System.out.println("Bolsa de Integer creada con capacidad 3");

        // b) Verificar si está vacía
        System.out.println("Esta vacia? " + bolsaInt.estaVacia());

        // c) Agregar Integer
        bolsaInt.agregar(10);
        bolsaInt.agregar(20);
        bolsaInt.agregar(30);
        System.out.println("Agregados elementos: 10, 20, 30");

        // d) Lanzar excepción si está llena
        try {
            bolsaInt.agregar(40); // Esto debería lanzar excepción
        } catch (BolsaException e) {
            System.out.println("Excepcion capturada al intentar agregar a bolsa llena: " + e.getMessage());
        }

        // e) Mostrar número de elementos
        System.out.println("Numero de elementos en la bolsa: " + bolsaInt.obtenerNumeroElementos());

        // f) Verificar si existe un elemento
        System.out.println("Existe el 20? " + bolsaInt.existe(20));
        System.out.println("Existe el 50? " + bolsaInt.existe(50));

        // g) Remover un elemento
        boolean removido = bolsaInt.remover(20);
        System.out.println("Se removio el 20? " + removido);
        System.out.println("Elementos despues de remover: " + bolsaInt.obtenerNumeroElementos());

        // h) Limpiar la bolsa
        bolsaInt.limpiar();
        System.out.println("Bolsa limpiada. Esta vacia? " + bolsaInt.estaVacia());

        System.out.println();
    }

    /**
     * Muestra BolsaGen con String.
     * Cubre los puntos i) a o) de la rúbrica.
     */
    private static void demostrarBolsaGenString() {
        System.out.println("--- DEMOSTRACION BOLSAGEN<STRING> ---");

        // i) Crear bolsa de String vacía
        BolsaGen<String> bolsaStr = new BolsaGen<>(4);
        System.out.println("Bolsa de String creada con capacidad 4");

        // j) Agregar String
        bolsaStr.agregar("Java");
        bolsaStr.agregar("Python");
        bolsaStr.agregar("Java");
        bolsaStr.agregar("C++");
        System.out.println("Agregados elementos: Java, Python, Java, C++");

        // k) Lanzar excepción si está llena
        try {
            bolsaStr.agregar("JavaScript"); // Esto debería lanzar excepción
        } catch (BolsaException e) {
            System.out.println("Excepcion capturada al intentar agregar a bolsa llena: " + e.getMessage());
        }

        // l) Verificar si está vacía (no debería)
        System.out.println("Esta vacia? " + bolsaStr.estaVacia());

        // m) Contar ocurrencias de un elemento
        System.out.println("Numero de veces que aparece 'Java': " + bolsaStr.contar("Java"));
        System.out.println("Numero de veces que aparece 'Python': " + bolsaStr.contar("Python"));

        // n) Remover un elemento
        boolean removido = bolsaStr.remover("Python");
        System.out.println("Se removio 'Python'? " + removido);
        System.out.println("Elementos despues de remover: " + bolsaStr.obtenerNumeroElementos());

        // o) Remover elemento al azar
        String elementoAleatorio = bolsaStr.removerAleatorio();
        System.out.println("Elemento removido aleatoriamente: " + elementoAleatorio);
        System.out.println("Elementos despues de remover aleatorio: " + bolsaStr.obtenerNumeroElementos());

        System.out.println();
    }

    /**
     * Muestra BolsaGenNum con Integer.
     * Cubre los puntos p) a v) de la rúbrica.
     */
    private static void demostrarBolsaGenNumInteger() {
        System.out.println("--- DEMOSTRACION BOLSAGENNUM<INTEGER> ---");

        // p) Crear bolsa de Integer vacía
        BolsaGenNum<Integer> bolsaNumInt = new BolsaGenNum<>(4);
        System.out.println("BolsaGenNum de Integer creada con capacidad 4");

        // q) Agregar Integer
        bolsaNumInt.agregar(5);
        bolsaNumInt.agregar(10);
        bolsaNumInt.agregar(15);
        bolsaNumInt.agregar(20);
        System.out.println("Agregados elementos: 5, 10, 15, 20");

        // r) Lanzar excepción si está llena
        try {
            bolsaNumInt.agregar(25); // Esto debería lanzar excepción
        } catch (BolsaException e) {
            System.out.println("Excepcion capturada al intentar agregar a bolsa llena: " + e.getMessage());
        }

        // s) Mostrar número de elementos
        System.out.println("Numero de elementos en la bolsa: " + bolsaNumInt.obtenerNumeroElementos());

        // t) Calcular suma
        double suma = bolsaNumInt.suma();
        System.out.println("Suma de los elementos: " + suma);

        // u) Calcular promedio
        double promedio = bolsaNumInt.promedio();
        System.out.println("Promedio de los elementos: " + promedio);

        // v) Contar elementos mayores al promedio
        int mayores = bolsaNumInt.mayores();
        System.out.println("Elementos mayores al promedio: " + mayores);

        System.out.println();
    }

    /**
     * Muestra BolsaGenNum con Double.
     * Cubre los puntos w) a cc) de la rúbrica.
     */
    private static void demostrarBolsaGenNumDouble() {
        System.out.println("--- DEMOSTRACION BOLSAGENNUM<DOUBLE> ---");

        // w) Crear bolsa de Double vacía
        BolsaGenNum<Double> bolsaNumDouble = new BolsaGenNum<>(5);
        System.out.println("BolsaGenNum de Double creada con capacidad 5");

        // x) Agregar Double
        bolsaNumDouble.agregar(2.5);
        bolsaNumDouble.agregar(7.8);
        bolsaNumDouble.agregar(1.2);
        bolsaNumDouble.agregar(9.1);
        bolsaNumDouble.agregar(4.4);
        System.out.println("Agregados elementos: 2.5, 7.8, 1.2, 9.1, 4.4");

        // y) Lanzar excepción si está llena
        try {
            bolsaNumDouble.agregar(6.6); // Esto debería lanzar excepción
        } catch (BolsaException e) {
            System.out.println("Excepcion capturada al intentar agregar a bolsa llena: " + e.getMessage());
        }

        // z) Mostrar número de elementos
        System.out.println("Numero de elementos en la bolsa: " + bolsaNumDouble.obtenerNumeroElementos());

        // aa) Calcular suma
        double suma = bolsaNumDouble.suma();
        System.out.println("Suma de los elementos: " + String.format("%.2f", suma));

        // bb) Calcular promedio
        double promedio = bolsaNumDouble.promedio();
        System.out.println("Promedio de los elementos: " + String.format("%.2f", promedio));

        // cc) Contar elementos mayores al promedio
        int mayores = bolsaNumDouble.mayores();
        System.out.println("Elementos mayores al promedio: " + mayores);

        System.out.println();
    }
}
