package com.mycompany.bolsagen_00000267883.implementaciones;

/**
 * Implementación genérica de una bolsa (bag).
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 */

import com.mycompany.bolsagen_00000267883.excepciones.BolsaException;
import java.util.Random;

/**
 * Bolsa genérica para almacenar elementos de cualquier tipo.
 * Es como una bolsa donde puedes meter cosas sin orden específico.
 *
 * @param <T> Tipo de los elementos en la bolsa.
 */
public class BolsaGen<T> {

    // Arreglo para guardar los elementos
    private T[] arreglo;

    // Cuántos elementos hay ahora
    private int numeroElementos;

    // Máximo que puede tener
    private int capacidad;

    // Para generar números aleatorios
    private Random random;

    /**
     * Crea una bolsa con capacidad fija.
     *
     * @param capacidad Máximo de elementos.
     * @throws BolsaException Si la capacidad es negativa.
     */
    @SuppressWarnings("unchecked")
    public BolsaGen(int capacidad) {
        if (capacidad < 0) {
            throw new BolsaException("La capacidad no puede ser negativa");
        }

        this.capacidad = capacidad;
        this.numeroElementos = 0;
        this.arreglo = (T[]) new Object[capacidad];
        this.random = new Random();
    }

    /**
     * ¿Está vacía la bolsa?
     *
     * @return true si no hay elementos.
     */
    public boolean estaVacia() {
        return numeroElementos == 0;
    }

    /**
     * ¿Está llena la bolsa?
     *
     * @return true si llegó al máximo.
     */
    public boolean estaLlena() {
        return numeroElementos == capacidad;
    }

    /**
     * Cuántos elementos hay.
     *
     * @return Número actual de elementos.
     */
    public int obtenerNumeroElementos() {
        return numeroElementos;
    }

    /**
     * Capacidad máxima.
     *
     * @return Máximo de elementos posibles.
     */
    public int obtenerCapacidad() {
        return capacidad;
    }

    /**
     * Agrega un elemento.
     *
     * @param elemento Lo que quieres meter.
     * @throws BolsaException Si está llena.
     */
    public void agregar(T elemento) {
        if (estaLlena()) {
            throw new BolsaException("La bolsa esta llena, no se puede agregar mas elementos");
        }

        arreglo[numeroElementos] = elemento;
        numeroElementos++;
    }

    /**
     * ¿Existe este elemento?
     *
     * @param elemento Lo que buscas.
     * @return true si lo encuentra.
     */
    public boolean existe(T elemento) {
        for (int i = 0; i < numeroElementos; i++) {
            if (arreglo[i] != null && arreglo[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cuántas veces aparece este elemento.
     *
     * @param elemento Lo que cuentas.
     * @return Número de veces.
     */
    public int contar(T elemento) {
        int contador = 0;

        for (int i = 0; i < numeroElementos; i++) {
            if (arreglo[i] != null && arreglo[i].equals(elemento)) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Quita una ocurrencia de este elemento.
     *
     * @param elemento Lo que quieres quitar.
     * @return true si lo quitó.
     */
    public boolean remover(T elemento) {
        for (int i = 0; i < numeroElementos; i++) {
            if (arreglo[i] != null && arreglo[i].equals(elemento)) {
                arreglo[i] = arreglo[numeroElementos - 1];
                arreglo[numeroElementos - 1] = null;
                numeroElementos--;
                return true;
            }
        }
        return false;
    }

    /**
     * Quita un elemento al azar.
     *
     * @return El elemento quitado.
     * @throws BolsaException Si está vacía.
     */
    public T removerAleatorio() {
        if (estaVacia()) {
            throw new BolsaException("La bolsa esta vacia, no se puede remover elementos");
        }

        int indiceAleatorio = random.nextInt(numeroElementos);

        T elementoRemovido = arreglo[indiceAleatorio];

        arreglo[indiceAleatorio] = arreglo[numeroElementos - 1];
        arreglo[numeroElementos - 1] = null;
        numeroElementos--;

        return elementoRemovido;
    }

    /**
     * Vacía la bolsa completamente.
     */
    public void limpiar() {
        for (int i = 0; i < numeroElementos; i++) {
            arreglo[i] = null;
        }

        numeroElementos = 0;
    }

    /**
     * Obtiene un elemento por posición (solo para subclases).
     *
     * @param posicion Índice del elemento.
     * @return El elemento ahí.
     * @throws IndexOutOfBoundsException Si la posición es inválida.
     */
    protected T obtenerElementoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= numeroElementos) {
            throw new IndexOutOfBoundsException("Posicion fuera del rango valido: " + posicion);
        }
        return arreglo[posicion];
    }
}
