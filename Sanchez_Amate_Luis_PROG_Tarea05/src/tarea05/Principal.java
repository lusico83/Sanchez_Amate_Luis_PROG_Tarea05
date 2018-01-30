
package tarea05;

import tarea05.Cliente;
import tarea05.AlquilerVehiculos;
import tarea05.Alquiler;
import tarea05.ExcepcionAlquilerVehiculos;
import tarea05.Turismo;
import utilidades.Entrada;


public class Principal {
    
    public static void main(String[] args) {
        
        AlquilerVehiculos misAlquileres=new AlquilerVehiculos();
        int opcion;
		do {
			System.out.println("Alquiler de Vehiculos");
			System.out.println("---------------");
			System.out.println("1.- Añadir cliente");
			System.out.println("2.- Borrar cliente");
			System.out.println("3.- Listar clientes");
			System.out.println("5.- Añadir vehículo");
			System.out.println("6.- Borrar vehículo");
			System.out.println("8.- Listar vehículos");
			System.out.println("9.- Abrir trabajo");
			System.out.println("10.- Cerrar trabajo");
			System.out.println("12.- Listar trabajos");
			System.out.println("0.- Salir");
			
			do {
				System.out.print("\nElige una opción (0-11): ");
				opcion = Entrada.entero();
			} while (opcion < 0 || opcion > 12);
			switch (opcion) {
				case 1:
					Cliente nuevoCliente = null;
					do {
						System.out.println("\nAñadir cliente");
						System.out.println("--------------");
						System.out.print("Nombre: ");
						String nombre = Entrada.cadena();
						System.out.print("DNI: ");
						String dni = Entrada.cadena();
						System.out.print("Dirección: ");
						String direccion = Entrada.cadena();
						System.out.print("Localidad: ");
						String localidad = Entrada.cadena();
						System.out.print("Código postal: ");
						String codigoPostal = Entrada.cadena();
						try {
							nuevoCliente = new Cliente(nombre, dni, direccion, localidad, codigoPostal);
						} catch (ExcepcionAlquilerVehiculos e) {
							System.out.printf("ERROR: %s%n%n", e.getMessage());
							System.out.println("Vuelve a introducir los datos de forma correcta");
						}
					} while (nuevoCliente == null);
                                        try {
						misAlquileres.addCliente(nuevoCliente);
					} catch (ExcepcionAlquilerVehiculos e) {
						System.out.printf("ERROR: %s%n%n", e.getMessage());
					}
					break;
					
				case 2:
					System.out.println("\nBorrar cliente");
					System.out.println("--------------");
					System.out.print("\nIntroduce el DNI del cliente a borrar: ");
					String dniBorrar = Entrada.cadena();
					try {
                                                misAlquileres.borrarCliente(dniBorrar);
						System.out.println("El cliente ha sido borrado\n");
					} catch (Exception e) {
						System.out.printf("ERROR: %s%n%n", e.getMessage());
					}
					break;

				case 3:
					System.out.println("\nListado de clientes");
					System.out.println("-------------------");
					for (int i=0;i<=20;i++)
                                        {
						if (misAlquileres != null)
							System.out.println(cliente);
					}
					System.out.println("");
					break;
				case 5:
					Vehiculo nuevoVehiculo = null;
					System.out.println("\nAñadir vehículo");
					System.out.println("---------------");
					System.out.println("DNI del propietario: ");
					String dniPropietario = Entrada.cadena();
					Cliente propietario = miTaller.buscarCliente(dniPropietario);
					System.out.print("Matrícula: ");
					String matricula = Entrada.cadena();
					System.out.print("Marca: ");
					String marca = Entrada.cadena();
					System.out.print("Modelo: ");
					String modelo = Entrada.cadena();
					System.out.println("Color: ");
					String color = Entrada.cadena();
					System.out.print("Cilindrada: ");
					int cilindrada = Entrada.entero();
					try {
						nuevoVehiculo = new Vehiculo(propietario, matricula, marca, modelo, color, cilindrada);
						miTaller.anadirVehiculo(nuevoVehiculo);
					} catch (ExcepcionTallerMecanico e) {
						System.out.printf("ERROR: %s%n%n", e.getMessage());
					}
					break;
				case 6:
					System.out.println("\nBorrar vehículo");
					System.out.println("---------------");
					System.out.print("\nIntroduce la matrícula del vehículo a borrar: ");
					String matriculaBorrar = Entrada.cadena();
					try {
						miTaller.borrarVehiculo(matriculaBorrar);
						System.out.println("Turismo borrado satisfactoriamente\n");
					} catch (ExcepcionTallerMecanico e) {
						System.out.printf("ERROR: %s%n%n", e.getMessage());
					}
					break;
				case 7:
					System.out.println("\nBuscar vehículo");
					System.out.println("---------------");
					System.out.print("\nIntroduce la matrícula del vehículo a buscar: ");
					String matriculaBuscar = Entrada.cadena();
					Vehiculo vehiculoBuscado = miTaller.buscarVehiculo(matriculaBuscar);
					System.out.print("\nResultado de la búsqueda: ");
					mensaje = (vehiculoBuscado != null) ? vehiculoBuscado.toString() : "El vehículo no existe";
					System.out.printf("%s%n%n", mensaje);
					break;
				case 8:
					System.out.println("\nListado de vehículos");
					System.out.println("--------------------");
					for (Vehiculo vehiculo: miTaller.getVehiculos()) {
						if (vehiculo != null)
							System.out.println(vehiculo);
					}
					System.out.println("");
					break;
				case 9:
					System.out.println("\nAbrir trabajo");
					System.out.println("-------------");
					System.out.print("\nIntroduce la matrícula del vehículo: ");
					matriculaBuscar = Entrada.cadena();
					vehiculoBuscado = miTaller.buscarVehiculo(matriculaBuscar);
					if (vehiculoBuscado == null)
						System.out.println("ERROR: No existe un vehículo con dicha matrícula\n");
					else {
							try {
								miTaller.abrirTrabajo(vehiculoBuscado);
								System.out.println("Trabajo abierto satisfactoriamente\n");
							} catch (ExcepcionTallerMecanico e) {
								System.out.printf("ERROR: %s%n%n", e.getMessage());
							}
					}
					break;
				case 10:
					System.out.println("\nCerrar trabajo");
					System.out.println("--------------");
					System.out.print("\nIntroduce la matrícula del vehículo: ");
					matriculaBuscar = Entrada.cadena();
					vehiculoBuscado = miTaller.buscarVehiculo(matriculaBuscar);
					if (vehiculoBuscado == null)
						System.out.println("ERROR: No existe un vehículo con dicha matrícula\n");
					else {
						try {
							miTaller.cerrarTrabajo(vehiculoBuscado);
							System.out.println("Trabajo cerrado satisfactoriamente");
						} catch (ExcepcionTallerMecanico e) {
							System.out.printf("ERROR: %s%n%n", e.getMessage());
						}
					}
					break;
				case 11:
					System.out.println("\nAñadir horas a un trabajo");
					System.out.println("--------------");
					System.out.print("\nIntroduce la matrícula del vehículo: ");
					matriculaBuscar = Entrada.cadena();
					vehiculoBuscado = miTaller.buscarVehiculo(matriculaBuscar);
					if (vehiculoBuscado == null)
						System.out.println("ERROR: No existe un vehículo con dicha matrícula\n");
					else {
						System.out.println("Introduce el número de horas a añadir: ");
						int horas = Entrada.entero();
						try {
							miTaller.anadirHorasTrabajo(vehiculoBuscado, horas);
							System.out.println("Horas añadidas satisfactoriamente");
						} catch (ExcepcionTallerMecanico e) {
							System.out.printf("ERROR: %s%n%n", e.getMessage());
						}
					}
					break;
				case 12:
					System.out.println("\nListado de trabajos");
					System.out.println("---------------------");
					for (Trabajo trabajo: miTaller.getTrabajos()) {
						if (trabajo != null)
							System.out.println(trabajo);
					}
					System.out.println("");
					break;
				default:
					break;
			}
		} while (opcion != 0);
        

        
    }
    
}
