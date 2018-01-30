
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
    
    public void borrarCliente(String dni) {
            int posicion = 0;
            boolean encontrado = false;
            
       	    while (posicion < clientes.length && !encontrado) {
		if (clientes[posicion] != null && clientes[posicion].getDni().equals(dni))
                    encontrado = true;
		else
                    posicion++;
		}
            
		if (encontrado){
                    for (int i=posicion;i<clientes.length-1;i++) {
			clientes[i]=clientes[i+1];
			}
			clientes[clientes.length-1]=null;
		}
		else {
                    throw new ExcepcionAlquilerVehiculos("Este DNI no esta registrado");
		}
    }
    
    
    public Turismo getTurismo(String matricula){
        for (int i=0;i<=MAX_CLIENTES;i++){
            if (compruebaMatricula(matricula))
                if (turismos[i].matricula.equals(matricula))
                    throw new ExcepcionAlquilerVehiculos("Ya existe un turismo con esa matricula");
                
                else
                    return turismos[i];
        }
        return null;
    }
    
     private boolean compruebaMatricula(String matricula) {
		Pattern patron = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
		Matcher emparejador = patron.matcher(matricula);
		return emparejador.matches();
    }
    
     public void addTurismo(Turismo turismo){
        
        int posicion = 0;
	boolean posicionEncontrada = false;
        
            while (posicion < turismos.length && !posicionEncontrada) {
                    if (turismos[posicion] == null)
            		posicionEncontrada = true;
                    else
			if (turismos[posicion].getMatricula().equals(turismo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Esta matricula ya esta en uso");
			else
                                posicion++;
		}
            if (posicionEncontrada)
                    turismos[posicion]=turismo;
            else
		    throw new ExcepcionAlquilerVehiculos("No caben mas turismos");
        
    }
                
    
}
