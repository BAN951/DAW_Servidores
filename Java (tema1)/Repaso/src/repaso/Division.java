package repaso;

public class Division extends Operacion {

	public Division(double operandoA, double operandoB) {
		super(operandoA, operandoB);	
	}

	@Override
	public double operar() {
		return operandoA / operandoB ;
	}

}
