package poo;

public interface Trabajadores {

	double Establece_bonus(double gratificacion);
	
	double bonus_base=1500;  // Todas la variables en una interface son constantes, por lo tanto no hay que especificar que sean final
							// Tambien se presuponen public porque deben ser visibles sino no tendria sentido su existencia
							// y static puesto que las interfaces no pueden ser instanciadas.
	
}
