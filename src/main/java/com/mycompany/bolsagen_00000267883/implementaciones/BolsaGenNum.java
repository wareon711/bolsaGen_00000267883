package com.mycompany.bolsagen_00000267883.implementaciones;

/**
 * Extensión de BolsaGen para números con operaciones matemáticas.
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 */

import com.mycompany.bolsagen_00000267883.excepciones.BolsaException;

/**
 * Bolsa para números que extiende BolsaGen.
 * Agrega operaciones como suma, promedio y contar elementos por encima del promedio.
 * Solo para tipos que heredan de Number.
 *
 * @param <T> Tipo que debe extender Number.
 */
public class BolsaGenNum<T extends Number> extends BolsaGen<T> {

    /**
     * Crea una bolsa para números con capacidad fija.
     *
     * @param capacidad Máximo de elementos.
     * @throws BolsaException Si la capacidad es negativa.
     */
    public BolsaGenNum(int capacidad) {
        super(capacidad);
    }

    /**
     * Suma todos los números en la bolsa.
     *
     * @return La suma total como double.
     * @throws BolsaException Si está vacía.
     */
    public double suma() {
        if (estaVacia()) {
            throw new BolsaException("La bolsa esta vacia, no se puede calcular la suma");
        }

        double sumaTotal = 0.0;

        for (int i = 0; i < obtenerNumeroElementos(); i++) {
            T elemento = obtenerElemento(i);
            if (elemento != null) {
                sumaTotal += elemento.doubleValue();
            }
        }

        return sumaTotal;
    }

    /**
     * Calcula el promedio de los números.
     *
     * @return El promedio como double.
     * @throws BolsaException Si está vacía.
     */
    public double promedio() {
        if (estaVacia()) {
            throw new BolsaException("La bolsa esta vacia, no se puede calcular el promedio");
        }

        double sumaTotal = suma();
        return sumaTotal / obtenerNumeroElementos();
    }

    /**
     * Cuenta cuántos números están por encima del promedio.
     *
     * @return Número de elementos mayores al promedio.
     * @throws BolsaException Si está vacía.
     */
    public int mayores() {
        if (estaVacia()) {
            throw new BolsaException("La bolsa esta vacia, no se puede determinar elementos mayores al promedio");
        }

        double promedioCalculado = promedio();
        int contadorMayores = 0;

        for (int i = 0; i < obtenerNumeroElementos(); i++) {
            T elemento = obtenerElemento(i);
            if (elemento != null && elemento.doubleValue() > promedioCalculado) {
                contadorMayores++;
            }
        }

        return contadorMayores;
    }

    /**
     * Método auxiliar para obtener un elemento por posición.
     *
     * @param posicion Índice del elemento.
     * @return El elemento ahí.
     */
    private T obtenerElemento(int posicion) {
        return obtenerElementoEnPosicion(posicion);
    }
}
