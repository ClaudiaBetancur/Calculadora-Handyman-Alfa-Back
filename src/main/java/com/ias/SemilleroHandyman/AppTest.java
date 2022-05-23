package com.ias.SemilleroHandyman;

public class AppTest {

    public int sumar(int a, int b){
        return a + b;
    }

    public int multiplicar(int a, int b){
        return a * b;
    }

    public int dividir(int a, int b){
        try {
            return a / b;
        }catch (Exception e){
            return 0;
        }
    }

}
