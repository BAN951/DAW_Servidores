package repaso;

public class Resta extends Operacion {

	public Resta(double operandoA, double operandoB) {
		super(operandoA, operandoB);
	}

	@Override
	public double operar() {
		return operandoA - operandoB; 
	}
	
}
