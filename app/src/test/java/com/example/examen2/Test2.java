package com.example.examen2;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class Test2 {

    @Test
    public void testEncuentraElementoPresente() {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
        int elemento = 3;
        boolean resultado = Calculadora.Encuentra(lista, elemento);

        assertTrue(resultado);
    }

    @Test
    public void testEncuentraElementoAusente() {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
        int elemento = 6;
        boolean resultado = Calculadora.Encuentra(lista, elemento);

        assertFalse(resultado);
    }
}
