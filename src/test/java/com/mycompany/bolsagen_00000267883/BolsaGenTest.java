package com.mycompany.bolsagen_00000267883;

/**
 * Pruebas unitarias para BolsaGen con JUnit5.
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 */

import com.mycompany.bolsagen_00000267883.implementaciones.BolsaGen;
import com.mycompany.bolsagen_00000267883.excepciones.BolsaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas para BolsaGen.
 * Usa String para probar la funcionalidad genérica.
 */
public class BolsaGenTest {

    // Bolsa para pruebas
    private BolsaGen<String> bolsa;

    // Capacidad para pruebas
    private static final int CAPACIDAD_PRUEBA = 5;

    /**
     * Preparar antes de cada prueba.
     * Crea una nueva bolsa.
     */
    @BeforeEach
    public void setUp() {
        bolsa = new BolsaGen<>(CAPACIDAD_PRUEBA);
    }

    /**
     * Prueba constructor con capacidad negativa.
     */
    @Test
    public void testConstructorCapacidadNegativa() {
        // Lanzar BolsaException si capacidad negativa
        assertThrows(BolsaException.class, () -> {
            new BolsaGen<String>(-1);
        }, "Debería lanzar BolsaException con capacidad negativa");

        assertThrows(BolsaException.class, () -> {
            new BolsaGen<String>(-10);
        }, "Debería lanzar BolsaException con capacidad negativa");
    }

    /**
     * Prueba constructor con capacidad válida.
     */
    @Test
    public void testConstructorCapacidadValida() {
        // No lanzar excepción con capacidad válida
        assertDoesNotThrow(() -> {
            new BolsaGen<String>(0);
            new BolsaGen<String>(1);
            new BolsaGen<String>(100);
        }, "No debería lanzar excepción con capacidad válida");
    }

    /**
     * Prueba estaVacia con bolsa vacía.
     */
    @Test
    public void testEstaVaciaConBolsaVacia() {
        assertTrue(bolsa.estaVacia(), "La bolsa deberia estar vacia inicialmente");
        assertEquals(0, bolsa.obtenerNumeroElementos(), "El numero de elementos deberia ser 0");
    }

    /**
     * Prueba estaVacia con elementos.
     */
    @Test
    public void testEstaVaciaConElementos() {
        bolsa.agregar("Elemento");
        assertFalse(bolsa.estaVacia(), "La bolsa no deberia estar vacia despues de agregar un elemento");
    }

    /**
     * Prueba agregar un elemento.
     */
    @Test
    public void testAgregarElemento() {
        String elemento = "Hola";
        bolsa.agregar(elemento);

        assertFalse(bolsa.estaVacia(), "La bolsa no debería estar vacía después de agregar elemento");
        assertEquals(1, bolsa.obtenerNumeroElementos(), "Deberia haber 1 elemento en la bolsa");
        assertTrue(bolsa.existe(elemento), "El elemento agregado deberia existir en la bolsa");
    }

    /**
     * Prueba agregar a bolsa llena.
     */
    @Test
    public void testAgregarElementoBolsaLlena() {
        // Llenar la bolsa
        for (int i = 0; i < CAPACIDAD_PRUEBA; i++) {
            bolsa.agregar("Elemento" + i);
        }

        assertTrue(bolsa.estaLlena(), "La bolsa deberia estar llena");

        // Agregar más debería lanzar excepción
        assertThrows(BolsaException.class, () -> {
            bolsa.agregar("ElementoExtra");
        }, "Deberia lanzar BolsaException al agregar elemento a bolsa llena");
    }

    /**
     * Prueba obtenerNumeroElementos.
     */
    @Test
    public void testObtenerNumeroElementos() {
        assertEquals(0, bolsa.obtenerNumeroElementos(), "Inicialmente deberia haber 0 elementos");

        bolsa.agregar("A");
        assertEquals(1, bolsa.obtenerNumeroElementos(), "Deberia haber 1 elemento");

        bolsa.agregar("B");
        assertEquals(2, bolsa.obtenerNumeroElementos(), "Deberia haber 2 elementos");

        bolsa.agregar("C");
        assertEquals(3, bolsa.obtenerNumeroElementos(), "Deberia haber 3 elementos");
    }

    /**
     * Prueba existe con elemento presente.
     */
    @Test
    public void testExisteElementoPresente() {
        String elemento = "TestString";
        bolsa.agregar(elemento);

        assertTrue(bolsa.existe(elemento), "El elemento deberia existir en la bolsa");
    }

    /**
     * Prueba existe con elemento ausente.
     */
    @Test
    public void testExisteElementoAusente() {
        bolsa.agregar("Elemento1");

        assertFalse(bolsa.existe("ElementoInexistente"), "Un elemento no agregado no deberia existir");
    }

    /**
     * Prueba contar elementos.
     */
    @Test
    public void testContarElementos() {
        String elemento = "Repetido";

        assertEquals(0, bolsa.contar(elemento), "Inicialmente deberia contar 0 ocurrencias");

        bolsa.agregar(elemento);
        assertEquals(1, bolsa.contar(elemento), "Deberia contar 1 ocurrencia");

        bolsa.agregar(elemento);
        assertEquals(2, bolsa.contar(elemento), "Deberia contar 2 ocurrencias");

        bolsa.agregar("Otro");
        assertEquals(2, bolsa.contar(elemento), "Deberia seguir contando 2 ocurrencias del elemento original");
    }

    /**
     * Prueba remover elemento existente.
     */
    @Test
    public void testRemoverElementoExistente() {
        String elemento = "ParaRemover";
        bolsa.agregar(elemento);
        bolsa.agregar("Otro");

        int elementosIniciales = bolsa.obtenerNumeroElementos();
        boolean removido = bolsa.remover(elemento);

        assertTrue(removido, "Deberia retornar true al remover elemento existente");
        assertEquals(elementosIniciales - 1, bolsa.obtenerNumeroElementos(),
                    "El numero de elementos deberia disminuir en 1");
    }

    /**
     * Prueba remover elemento inexistente.
     */
    @Test
    public void testRemoverElementoInexistente() {
        bolsa.agregar("Elemento");

        int elementosIniciales = bolsa.obtenerNumeroElementos();
        boolean removido = bolsa.remover("Inexistente");

        assertFalse(removido, "Deberia retornar false al intentar remover elemento inexistente");
        assertEquals(elementosIniciales, bolsa.obtenerNumeroElementos(),
                    "El numero de elementos no deberia cambiar");
    }

    /**
     * Prueba remover aleatorio con elementos.
     */
    @Test
    public void testRemoverAleatorioBolsaConElementos() {
        bolsa.agregar("A");
        bolsa.agregar("B");
        bolsa.agregar("C");

        int elementosIniciales = bolsa.obtenerNumeroElementos();
        String elementoRemovido = bolsa.removerAleatorio();

        assertNotNull(elementoRemovido, "El elemento removido no deberia ser null");
        assertEquals(elementosIniciales - 1, bolsa.obtenerNumeroElementos(),
                    "El numero de elementos deberia disminuir en 1");
    }

    /**
     * Prueba remover aleatorio de bolsa vacía.
     */
    @Test
    public void testRemoverAleatorioBolsaVacia() {
        assertThrows(BolsaException.class, () -> {
            bolsa.removerAleatorio();
        }, "Debería lanzar BolsaException al remover aleatorio de bolsa vacia");
    }

    /**
     * Prueba el método limpiar.
     */
    @Test
    public void testLimpiar() {
        // Agregar varios elementos
        bolsa.agregar("A");
        bolsa.agregar("B");
        bolsa.agregar("C");

        assertFalse(bolsa.estaVacia(), "La bolsa no debería estar vacía antes de limpiar");

        // Limpiar la bolsa
        bolsa.limpiar();

        assertTrue(bolsa.estaVacia(), "La bolsa debería estar vacía después de limpiar");
        assertEquals(0, bolsa.obtenerNumeroElementos(), "Debería haber 0 elementos después de limpiar");
    }

    /**
     * Prueba obtenerCapacidad.
     */
    @Test
    public void testObtenerCapacidad() {
        assertEquals(CAPACIDAD_PRUEBA, bolsa.obtenerCapacidad(),
                    "La capacidad debería ser la especificada en el constructor");

        // Probar con diferentes capacidades
        BolsaGen<String> bolsa10 = new BolsaGen<>(10);
        assertEquals(10, bolsa10.obtenerCapacidad(), "La capacidad debería ser 10");

        BolsaGen<String> bolsa0 = new BolsaGen<>(0);
        assertEquals(0, bolsa0.obtenerCapacidad(), "La capacidad debería ser 0");
    }

    /**
     * Prueba estaLlena.
     */
    @Test
    public void testEstaLlena() {
        assertFalse(bolsa.estaLlena(), "La bolsa no debería estar llena inicialmente");

        // Llenar la bolsa
        for (int i = 0; i < CAPACIDAD_PRUEBA; i++) {
            bolsa.agregar("Elemento" + i);
        }

        assertTrue(bolsa.estaLlena(), "La bolsa debería estar llena después de agregar elementos hasta su capacidad");
    }

    /**
     * Prueba funcionalidad completa.
     */
    @Test
    public void testFuncionalidadCompleta() {
        // Bolsa vacía al inicio
        assertTrue(bolsa.estaVacia());
        assertEquals(0, bolsa.obtenerNumeroElementos());

        // Agregar elementos
        bolsa.agregar("Java");
        bolsa.agregar("Python");
        bolsa.agregar("Java");

        // Verificar después de agregar
        assertEquals(3, bolsa.obtenerNumeroElementos());
        assertTrue(bolsa.existe("Java"));
        assertTrue(bolsa.existe("Python"));
        assertFalse(bolsa.existe("C++"));

        // Verificar conteo
        assertEquals(2, bolsa.contar("Java"));
        assertEquals(1, bolsa.contar("Python"));
        assertEquals(0, bolsa.contar("C++"));

        // Remover elemento
        assertTrue(bolsa.remover("Python"));
        assertFalse(bolsa.existe("Python"));
        assertEquals(2, bolsa.obtenerNumeroElementos());

        // Agregar más hasta llenar
        bolsa.agregar("C++");
        bolsa.agregar("JavaScript");
        bolsa.agregar("Go");

        // Verificar llena
        assertTrue(bolsa.estaLlena());
        assertEquals(CAPACIDAD_PRUEBA, bolsa.obtenerNumeroElementos());

        // Limpiar y verificar
        bolsa.limpiar();
        assertTrue(bolsa.estaVacia());
        assertEquals(0, bolsa.obtenerNumeroElementos());
    }
}
