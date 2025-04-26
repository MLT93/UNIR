package javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import negocio.IFiguras;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cuadrado implements IFiguras, Comparable<Cuadrado>{
	
	private double lado;

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return lado*4;
	}

	@Override
	public double volumen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Cuadrado o) {
		// TODO Auto-generated method stub
	//	return (int) (this.lado - o.lado);
		
		if (this.lado == o.lado)
			return 0;
		if (this.lado < o.lado)
			return -1;
		else
			return 1;
	}
	
	
	

	
	
	

}
