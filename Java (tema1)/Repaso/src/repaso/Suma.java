package repaso;

public class Suma extends Operacion {

	public Suma(double operandoA, double operandoB) {
		super(operandoA, operandoB);
	}
	
	@Override
	public double operar() {
		return operandoA + operandoB; 
	}
	
}
