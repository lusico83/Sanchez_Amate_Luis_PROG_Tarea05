
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
                if (clientes[i].getDni().equals(dni))
                    throw new ExcepcionAlquilerVehiculos("Ya existe un cliente con ese DNI");
                
                else
                    return clientes[i];
        }
        return null;
    }
    
    private boolean compruebaDni(String dni) {
		Pattern patron = Pattern.compile("[0-9]{8}[A-Z]");
		Matcher emparejador = patron.matcher(dni);
		return emparejador.matches();
	}
    
    public void addCliente(Cliente cliente){
        
        int posicion = 0;
	boolean posicionEncontrada = false;
        
            while (posicion < clientes.length && !posicionEncontrada) {
                    if (clientes[posicion] == null)
            		posicionEncontrada = true;
                    else
			if (clientes[posicion].getDni().equals(cliente.getDni()))
				throw new ExcepcionAlquilerVehiculos("Este DNI ya esta en uso");
			else
                                posicion++;
		}
            if (posicionEncontrada)
                    clientes[posicion] = cliente;
            else
		    throw new ExcepcionAlquilerVehiculos("No caben mas clientes");
        
    }
    
}
