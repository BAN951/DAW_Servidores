package repaso;

public class Multiplicacion extends Operacion {

	public Multiplicacion(double operandoA, double operandoB) {
		super(operandoA, operandoB);
	}

	@Override
	public double operar() {
		return operandoA * operandoB;
	}

}
