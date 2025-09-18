package com.mycompany.bolsagen_00000267883.excepciones;

/**
 * Excepción personalizada para manejar errores en la bolsa.
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 */

/**
 * Excepción para operaciones de la bolsa.
 * Extiende RuntimeException para errores en tiempo de ejecución.
 */
public class BolsaException extends RuntimeException {

    /**
     * Constructor vacío.
     */
    public BolsaException() {
        super();
    }

    /**
     * Constructor con mensaje.
     *
     * @param mensaje Descripción del error.
     */
    public BolsaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa.
     *
     * @param mensaje Descripción del error.
     * @param causa   Origen del problema.
     */
    public BolsaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    /**
     * Constructor avanzado con mensaje, causa y opciones.
     *
     * @param mensaje           Descripción del error.
     * @param causa             Origen del problema.
     * @param habilitarSupresion Si se permite suprimir excepciones.
     * @param rastreoEscritura  Si se habilita el rastreo.
     */
    public BolsaException(String mensaje, Throwable causa, boolean habilitarSupresion, boolean rastreoEscritura) {
        super(mensaje, causa, habilitarSupresion, rastreoEscritura);
    }
}
