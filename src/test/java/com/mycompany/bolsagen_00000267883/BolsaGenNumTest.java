package com.mycompany.bolsagen_00000267883;

/**
 * Pruebas unitarias para BolsaGenNum con JUnit5.
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 */

import com.mycompany.bolsagen_00000267883.implementaciones.BolsaGenNum;
import com.mycompany.bolsagen_00000267883.excepciones.BolsaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas para BolsaGenNum.
 * Usa Double para probar operaciones numéricas.
 */
public class BolsaGenNumTest {

    // Bolsa para pruebas
    private BolsaGenNum<Double> bolsaNum;

    // Capacidad para pruebas
    private static final int CAPACIDAD_PRUEBA = 5;

    // Tolerancia para decimales
    private static final double DELTA = 0.0001;

    /**
     * Preparar antes de cada prueba.
     * Crea una nueva bolsa.
     */
    @BeforeEach
    public void setUp() {
        bolsaNum = new BolsaGenNum<>(CAPACIDAD_PRUEBA);
    }

    /**
     * Prueba el constructor heredado de BolsaGen.
     */
    @Test
    public void testConstructorCapacidadNegativa() {
        // Lanzar BolsaException si capacidad negativa
        assertThrows(BolsaException.class, () -> {
            new BolsaGenNum<Double>(-1);
        }, "Deberia lanzar BolsaException con capacidad negativa");
    }

    /**
     * Prueba suma con bolsa vacía.
     */
    @Test
    public void testSumaBolsaVacia() {
        assertThrows(BolsaException.class, () -> {
            bolsaNum.suma();
        }, "Deberia lanzar BolsaException al calcular suma de bolsa vacia");
    }

    /**
     * Prueba suma con elementos válidos.
     */
    @Test
    public void testSumaElementosValidos() {
        bolsaNum.agregar(10.5);
        bolsaNum.agregar(20.3);
        bolsaNum.agregar(5.2);

        double sumaEsperada = 10.5 + 20.3 + 5.2;
        assertEquals(sumaEsperada, bolsaNum.suma(), DELTA,
                    "La suma deberia ser la suma de todos los elementos");
    }

    /**
     * Prueba suma con un solo elemento.
     */
    @Test
    public void testSumaUnElemento() {
        double valor = 42.7;
        bolsaNum.agregar(valor);

        assertEquals(valor, bolsaNum.suma(), DELTA,
                    "La suma de un solo elemento deberia ser el mismo elemento");
    }

    /**
     * Prueba suma con números negativos.
     */
    @Test
    public void testSumaNumerosNegativos() {
        bolsaNum.agregar(-5.5);
        bolsaNum.agregar(10.0);
        bolsaNum.agregar(-2.5);

        double sumaEsperada = -5.5 + 10.0 + (-2.5);
        assertEquals(sumaEsperada, bolsaNum.suma(), DELTA,
                    "La suma deberia manejar correctamente numeros negativos");
    }

    /**
     * Prueba promedio con bolsa vacía.
     */
    @Test
    public void testPromedioBolsaVacia() {
        assertThrows(BolsaException.class, () -> {
            bolsaNum.promedio();
        }, "Deberia lanzar BolsaException al calcular promedio de bolsa vacia");
    }

    /**
     * Prueba promedio con elementos válidos.
     */
    @Test
    public void testPromedioElementosValidos() {
        bolsaNum.agregar(10.0);
        bolsaNum.agregar(20.0);
        bolsaNum.agregar(30.0);

        double promedioEsperado = (10.0 + 20.0 + 30.0) / 3.0;
        assertEquals(promedioEsperado, bolsaNum.promedio(), DELTA,
                    "El promedio deberia ser la suma dividida entre el numero de elementos");
    }

    /**
     * Prueba promedio con un solo elemento.
     */
    @Test
    public void testPromedioUnElemento() {
        double valor = 15.5;
        bolsaNum.agregar(valor);

        assertEquals(valor, bolsaNum.promedio(), DELTA,
                    "El promedio de un solo elemento deberia ser el mismo elemento");
    }

    /**
     * Prueba mayores con bolsa vacía.
     */
    @Test
    public void testMayoresBolsaVacia() {
        assertThrows(BolsaException.class, () -> {
            bolsaNum.mayores();
        }, "Deberia lanzar BolsaException al calcular mayores de bolsa vacia");
    }

    /**
     * Prueba mayores con elementos válidos.
     */
    @Test
    public void testMayoresElementosValidos() {
        // Agregar: 10, 15, 20, 25, 30
        // Promedio = 20
        // Mayores: 25, 30 = 2
        bolsaNum.agregar(10.0);
        bolsaNum.agregar(15.0);
        bolsaNum.agregar(20.0);
        bolsaNum.agregar(25.0);
        bolsaNum.agregar(30.0);

        int mayoresEsperados = 2;
        assertEquals(mayoresEsperados, bolsaNum.mayores(),
                    "Deberia contar correctamente los elementos mayores al promedio");
    }

    /**
     * Prueba mayores cuando ninguno es mayor al promedio.
     */
    @Test
    public void testMayoresNingunElementoMayor() {
        // Todos iguales, ninguno mayor
        bolsaNum.agregar(10.0);
        bolsaNum.agregar(10.0);
        bolsaNum.agregar(10.0);

        assertEquals(0, bolsaNum.mayores(),
                    "Deberia retornar 0 cuando ningun elemento es mayor al promedio");
    }

    /**
     * Prueba mayores con un solo elemento.
     */
    @Test
    public void testMayoresUnElemento() {
        bolsaNum.agregar(42.0);

        // No puede ser mayor que sí mismo
        assertEquals(0, bolsaNum.mayores(),
                    "Un elemento no puede ser mayor que si mismo");
    }

    /**
     * Prueba funcionalidad heredada de BolsaGen.
     */
    @Test
    public void testFuncionalidadHeredada() {
        // Verificar métodos heredados
        assertTrue(bolsaNum.estaVacia(), "La bolsa deberia estar vacia inicialmente");
        assertEquals(0, bolsaNum.obtenerNumeroElementos(), "Deberia tener 0 elementos inicialmente");

        bolsaNum.agregar(1.5);
        bolsaNum.agregar(2.5);

        assertFalse(bolsaNum.estaVacia(), "La bolsa no deberia estar vacia despues de agregar elementos");
        assertEquals(2, bolsaNum.obtenerNumeroElementos(), "Deberia tener 2 elementos");
        assertTrue(bolsaNum.existe(1.5), "Deberia existir el elemento 1.5");
        assertTrue(bolsaNum.existe(2.5), "Deberia existir el elemento 2.5");
    }

    /**
     * Prueba funcionalidad completa con operaciones matemáticas.
     */
    @Test
    public void testFuncionalidadCompletaMatematica() {
        // Agregar: 2, 4, 6, 8, 10
        bolsaNum.agregar(2.0);
        bolsaNum.agregar(4.0);
        bolsaNum.agregar(6.0);
        bolsaNum.agregar(8.0);
        bolsaNum.agregar(10.0);

        // Suma = 30
        assertEquals(30.0, bolsaNum.suma(), DELTA, "La suma deberia ser 30");

        // Promedio = 6
        assertEquals(6.0, bolsaNum.promedio(), DELTA, "El promedio deberia ser 6");

        // Mayores: 8 y 10 > 6
        assertEquals(2, bolsaNum.mayores(), "Deberia haber 2 elementos mayores al promedio");

        // Remover 2, nueva suma 28, promedio 7, mayores 2
        bolsaNum.remover(2.0);

        assertEquals(28.0, bolsaNum.suma(), DELTA, "La suma deberia ser 28 despues de remover");

        assertEquals(7.0, bolsaNum.promedio(), DELTA, "El promedio deberia ser 7 despues de remover");

        assertEquals(2, bolsaNum.mayores(), "Deberia seguir habiendo 2 elementos mayores al nuevo promedio");
    }

    /**
     * Prueba con diferentes tipos numéricos (Integer).
     */
    @Test
    public void testConTiposNumericos() {
        BolsaGenNum<Integer> bolsaInt = new BolsaGenNum<>(3);

        bolsaInt.agregar(5);
        bolsaInt.agregar(10);
        bolsaInt.agregar(15);

        assertEquals(30.0, bolsaInt.suma(), DELTA, "La suma de enteros deberia funcionar correctamente");
        assertEquals(10.0, bolsaInt.promedio(), DELTA, "El promedio de enteros deberia funcionar correctamente");
        assertEquals(1, bolsaInt.mayores(), "Deberia haber 1 entero mayor al promedio");
    }

    /**
     * Prueba excepción al agregar a bolsa llena.
     */
    @Test
    public void testAgregarElementoBolsaLlena() {
        // Llenar la bolsa
        for (int i = 0; i < CAPACIDAD_PRUEBA; i++) {
            bolsaNum.agregar((double) i);
        }

        assertTrue(bolsaNum.estaLlena(), "La bolsa deberia estar llena");

        // Agregar más debería lanzar excepción
        assertThrows(BolsaException.class, () -> {
            bolsaNum.agregar(99.9);
        }, "Deberia lanzar BolsaException al agregar elemento a bolsa llena");
    }
}
