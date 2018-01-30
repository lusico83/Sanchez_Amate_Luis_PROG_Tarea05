
package tarea05;


public class AlquilerVehiculos {
    
    private Cliente[] clientes;
    private Turismo[] turismos;
    private Alquiler[] alquileres;
    private final int MAX_TURISMOS = 20;
    private final int MAX_CLIENTES = 20;
    private final int MAX_ALQUILERES = 20;
    
    
    public AlquilerVehiculos() {
		clientes = new Cliente[MAX_CLIENTES];
		turismos = new Turismo[MAX_TURISMOS];
		alquileres = new Alquiler[MAX_ALQUILERES];
	}
    
}
