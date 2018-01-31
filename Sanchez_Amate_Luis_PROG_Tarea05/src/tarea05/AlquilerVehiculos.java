
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
    
    public Cliente[] getCliente() {
		return clientes;
	}
	
	public Turismo[] getTurismo() {
		return turismos;
	}
	
	public Alquiler[] getTrabajo() {
		return alquileres;
        }
    
    public Cliente getCliente(String dni){
        int posicion = 0;
	boolean encontrado = false;
        
            while (posicion < clientes.length && !encontrado) {
		if (clientes[posicion] != null && clientes[posicion].getDni().equals(dni))
			encontrado = true;
		else
			posicion++;
		}
		if (encontrado)
			return clientes[posicion];
		else
			return null;
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
                int posicion = 0;
		boolean posicionEncontrada = false;
                
		while (posicion < turismos.length && !posicionEncontrada) {
                    
                        if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula))
                            posicionEncontrada = true;
			else
                            posicion++;
		}
		if (posicionEncontrada)
			return turismos[posicion];
		else
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
		    throw new ExcepcionAlquilerVehiculos("No caben mas clientes");
        
    }
     
    public void borrarTurismo(String matricula) {
            int posicion = 0;
            boolean encontrado = false;
            
       	    while (posicion < turismos.length && !encontrado) {
		if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula))
                    encontrado = true;
		else
                    posicion++;
		}
            
		if (encontrado){
                    for (int i=posicion;i<turismos.length-1;i++) {
			turismos[i]=turismos[i+1];
			}
			turismos[turismos.length-1]=null;
		}
		else {
                    throw new ExcepcionAlquilerVehiculos("Esta matricula no esta registrada");
		}
    } 
    
    public void openAlquiler(Cliente cliente, Turismo turismo) {
		int posicion = 0;
		boolean posicionEncontrada = false;
		while (posicion < alquileres.length && !posicionEncontrada) {
			if (alquileres[posicion] == null)
				posicionEncontrada = true;
			else
				if (alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula()) && !alquileres[posicion].getTurismo().disponible){
                                posicionEncontrada=true;   
                                throw new ExcepcionAlquilerVehiculos("Este vehiculo esta alquilado");
                                }
				else
					posicion++;
		}
		if (posicionEncontrada)
			alquileres[posicion] = new Alquiler(cliente, turismo);
		else
			throw new ExcepcionAlquilerVehiculos("No caben mas alquileres");
                
    }
    
    public void closeAlquiler(Cliente cliente, Turismo turismo) {
		int posicion = 0;
		boolean encontrado = false;
		while (posicion < alquileres.length && !encontrado) {
			if (alquileres[posicion] != null && 
					alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula()) &&
					!alquileres[posicion].getTurismo().disponible &&
                                        alquileres[posicion].getCliente().getDni().equals(cliente.getDni()))
				encontrado = true;
			else
				posicion++;
		}
		if (encontrado)
			alquileres[posicion].close();
		else
			throw new ExcepcionAlquilerVehiculos("Este cliente no ha alquilado este coche");
    }
}    
