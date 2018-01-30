
package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public Cliente getCliente(String dni){
        for (int i=0;i<=MAX_CLIENTES;i++){
            if (compruebaDni(dni))
                return clientes[i];
            else
                return null;  
        }
    }
    
    private boolean compruebaDni(String dni) {
		Pattern patron = Pattern.compile("[0-9]{8}[A-Z]");
		Matcher emparejador = patron.matcher(dni);
		return emparejador.matches();
	}
    
}
