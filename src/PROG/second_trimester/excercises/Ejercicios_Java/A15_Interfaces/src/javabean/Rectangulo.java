package javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import negocio.IFiguras;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rectangulo implements IFiguras{
	
	private double lado1;
	private double lado2;
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return lado1*lado2/2;
	}
	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return lado1*2 + lado2*2;
	}
	@Override
	public double volumen() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
