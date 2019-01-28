package repaso;

public abstract class Operacion implements Operable {
	
	protected double operandoA; 
	protected double operandoB; 
	
	private static int numeroInstancias = 0; 

	public Operacion(double operandoA, double operandoB) {
		this.operandoA = operandoA; 
		this.operandoB = operandoB;	
		numeroInstancias++;  
	}
	
	public final double getOperandoA() {
		return operandoA;
	}

	public final double getOperandoB() {
		return operandoB;
	}
	
	public final int getNumeroInstancias() {
		return numeroInstancias; 
	}
	
}
