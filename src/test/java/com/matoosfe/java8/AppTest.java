package com.matoosfe.java8;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public static void dibujarFigura(Figura f) {
		f.dibujar();
	}
	
    public static void main(String[] args) {
		Cuadrado cuadrado = new Cuadrado();
		Triangulo triangulo = new  Triangulo();
		
		AppTest.dibujarFigura(cuadrado);
		AppTest.dibujarFigura(triangulo);
	}
}
