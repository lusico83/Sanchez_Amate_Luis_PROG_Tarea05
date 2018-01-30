
package tarea05;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Alquiler {
    
    private Cliente cliente;
    private Turismo turismo;
    private Date fecha;
    private int dias;
    private final SimpleDateFormat FORMATO_FECHA= new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private final double PRECIO_DIA = 30.0;
    
    public Alquiler(Cliente cliente, Turismo turismo) {
        
        this.cliente= cliente;
	this.turismo = turismo;
	fecha = new Date();
	dias = 0;
        turismo.disponible=false;
        
	}
    
        public Cliente getCliente(){
            return cliente;
        }
    
        public Turismo getTurismo() {
            return turismo;
	}
	
	public Date getFecha() {
            return fecha;
	}
	
	public int getDias() {
            return dias;
	}
	
    
    
    
}
