package com.example.examen2;

import org.json.JSONObject;
import org.json.JSONException;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test1 {

    // Pruebas unitarias para el método convertirNumero
    @Test
    public void testConvertirNumeroBinario() {
        try {
            String input = "1010"; // 10 en decimal
            int base = 0; // Binario
            int resultado = Calculadora.convertirNumero(input, base);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("input", input);
            expectedJson.put("base", base);
            expectedJson.put("resultado", 10);

            assertEquals(expectedJson.getInt("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }

    @Test
    public void testConvertirNumeroHexadecimal() {
        try {
            String input = "A"; // 10 en decimal
            int base = 3; // Hexadecimal
            int resultado = Calculadora.convertirNumero(input, base);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("input", input);
            expectedJson.put("base", base);
            expectedJson.put("resultado", 10);

            assertEquals(expectedJson.getInt("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }

    // Pruebas unitarias para el método realizarOperacion
    @Test
    public void testRealizarOperacionSuma() {
        try {
            int num1 = 5;
            int num2 = 3;
            String operador = "+";
            int resultado = Calculadora.realizarOperacion(num1, num2, operador);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("num1", num1);
            expectedJson.put("num2", num2);
            expectedJson.put("operador", operador);
            expectedJson.put("resultado", 8);

            assertEquals(expectedJson.getInt("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }

    @Test
    public void testRealizarOperacionDivision() {
        try {
            int num1 = 10;
            int num2 = 2;
            String operador = "/";
            int resultado = Calculadora.realizarOperacion(num1, num2, operador);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("num1", num1);
            expectedJson.put("num2", num2);
            expectedJson.put("operador", operador);
            expectedJson.put("resultado", 5);

            assertEquals(expectedJson.getInt("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }

    // Pruebas unitarias para el método convertirADestino
    @Test
    public void testConvertirADestinoBinario() {
        try {
            int numeroDecimal = 10;
            int baseDestino = 0; // Binario
            String resultado = Calculadora.convertirADestino(numeroDecimal, baseDestino);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("numeroDecimal", numeroDecimal);
            expectedJson.put("baseDestino", baseDestino);
            expectedJson.put("resultado", "1010");

            assertEquals(expectedJson.getString("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }

    @Test
    public void testConvertirADestinoHexadecimal() {
        try {
            int numeroDecimal = 255;
            int baseDestino = 3; // Hexadecimal
            String resultado = Calculadora.convertirADestino(numeroDecimal, baseDestino);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("numeroDecimal", numeroDecimal);
            expectedJson.put("baseDestino", baseDestino);
            expectedJson.put("resultado", "ff");

            assertEquals(expectedJson.getString("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }


    // Pruebas unitarias para el método convertirNumero
    @Test
    public void testConvertirNumeroOctalValido() {
        try {
            String input = "17"; // 15 en decimal
            int base = 1; // Octal
            int resultado = Calculadora.convertirNumero(input, base);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("resultado", 15);

            assertEquals(expectedJson.getInt("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }

    @Test
    public void testConvertirNumeroDecimalInvalido() {
        try {
            String input = "12a"; // No válido en decimal
            int base = 2; // Decimal
            int resultado = Calculadora.convertirNumero(input, base);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("resultado", -1); // Indica un error esperado

            assertEquals(expectedJson.getInt("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }

    // Pruebas unitarias para el método realizarOperacion
    @Test
    public void testRealizarOperacionResta() {
        try {
            int num1 = 20;
            int num2 = 7;
            String operador = "-";
            int resultado = Calculadora.realizarOperacion(num1, num2, operador);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("resultado", 13);

            assertEquals(expectedJson.getInt("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRealizarOperacionOperadorInvalido() {
        // Probar un operador no soportado (ejemplo: módulo)
        int num1 = 20;
        int num2 = 7;
        String operador = "%";
        Calculadora.realizarOperacion(num1, num2, operador);
    }

    // Pruebas unitarias para el método convertirADestino
    @Test
    public void testConvertirADestinoOctal() {
        try {
            int numeroDecimal = 64;
            int baseDestino = 1; // Octal
            String resultado = Calculadora.convertirADestino(numeroDecimal, baseDestino);

            JSONObject expectedJson = new JSONObject();
            expectedJson.put("resultado", "100");

            assertEquals(expectedJson.getString("resultado"), resultado);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("JSONException fue lanzada");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertirADestinoBaseInvalida() {
        // Probar una conversión a una base que no está soportada (ejemplo: 5)
        int numeroDecimal = 10;
        int baseDestino = 5; // Base no soportada
        Calculadora.convertirADestino(numeroDecimal, baseDestino);
    }
}
