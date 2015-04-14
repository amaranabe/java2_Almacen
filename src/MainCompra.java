import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;


public class MainCompra {


	public static void leerclientes() {


	}

	public static void leerproductos()
	{

	}
	
	public static void main(String[] args) {
	

/*LEER PRODUCTOS:
				1. Leer de ficheros los distintos productos, manzana, lechuga, leche
				2. Cargarlos a una arraylist
*/

          
//leer manzanas
          
          

          //declaro variables
          ArrayList<Manzana> listamanzana=new ArrayList<Manzana>();

          try {
	          	File f=new File("manzanas.txt");
		        FileReader fr=new FileReader(f);
		        BufferedReader br=new BufferedReader(fr);

		        String lineafichero;
		        String [] datoslinea;

		        //inicio lectura
		        lineafichero=br.readLine();
		        while (lineafichero!=null) {
		        		Manzana manz=new Manzana();

		        		datoslinea=lineafichero.split("; ");
		        		manz.setCodbarras(Integer.parseInt(datoslinea[0]));
		        		manz.setTipomanzana(datoslinea[1]);
		        		manz.setProcedencia(datoslinea[2]);
		        		manz.setColor(datoslinea[3]);
		        		manz.setEuroskilo(Double.parseDouble(datoslinea[4]));

		        		listamanzana.add(manz);

		        		lineafichero=br.readLine();
          		}

          }

          catch (Exception e) {
          	System.out.println("Error: "+e.getMessage());
          }
          
//leer lechugas

          ArrayList<Lechuga> listalechuga=new ArrayList<Lechuga>();

          try {
	          	File f=new File("lechugas.txt");
		        FileReader fr=new FileReader(f);
		        BufferedReader br=new BufferedReader(fr);

		        String lineafichero;
		        String [] datoslinea;

		        //inicio lectura
		        lineafichero=br.readLine();
		        while (lineafichero!=null) {
		        		Lechuga lechg=new Lechuga();

		        		datoslinea=lineafichero.split("; ");
		        		lechg.setCodbarras(Integer.parseInt(datoslinea[0]));
		        		lechg.setTipolechuga(datoslinea[1]);
		        		lechg.setProcedencia(datoslinea[2]);
		        		lechg.setColor(datoslinea[3]);
		        		lechg.setEurosunidad(Double.parseDouble(datoslinea[4]));

		        		listalechuga.add(lechg);

		        		lineafichero=br.readLine();
          		}

          }

          catch (Exception e) {
          	System.out.println("Error: "+e.getMessage());
          }

//leer leche

          ArrayList<Leche> listaleche=new ArrayList<Leche>();

          try {
	          	File f=new File("leches.txt");
		        FileReader fr=new FileReader(f);
		        BufferedReader br=new BufferedReader(fr);

		        String lineafichero;
		        String [] datoslinea;

		        //inicio lectura
		        lineafichero=br.readLine();
		        while (lineafichero!=null) {
		        		Leche lech=new Leche();

		        		datoslinea=lineafichero.split("; ");
		        		lech.setCodbarras(Integer.parseInt(datoslinea[0]));
		        		lech.setTipo(datoslinea[1]);
		        		lech.setProcedencia(datoslinea[2]);
		        		lech.setEuroslitro(Double.parseDouble(datoslinea[3]));

		        		listaleche.add(lech);

		        		lineafichero=br.readLine();
          		}

          }

          catch (Exception e) {
          	System.out.println("Error: "+e.getMessage());
          }

/*LEER CLIENTES:
*/

           ArrayList<Cliente> listacliente=new ArrayList<Cliente>();

            try {
		            File fl=new File("clientes.txt");
		            FileReader fr=new FileReader(fl);
		            BufferedReader br=new BufferedReader(fr);

		            //1. LECTURA DE FICHERO
		            String lecturalinea;
		            lecturalinea=br.readLine();
		            while (lecturalinea!=null) {

		                  Cliente datoscliente=new Cliente();

		                  //separo la linea extraida de fichero por "; " y se lo asigno a un array de string para luego poder acceder a esos datos
		            //2. ASIGNACIÓN A OBJETO CLIENTES
		                  String [] arraydatos=lecturalinea.split("; ");
		                  //se la añado en un objeto de tipo cliente llamado datoscliente
		                  datoscliente.setNombre(arraydatos[0]);
		                  datoscliente.setApellidos(arraydatos[1]);
		                  datoscliente.setDNI(arraydatos[2]);
		                  //resolver datos objeto direccion
		                        String [] arraydatosdireccion=arraydatos[3].split("# ");
		                        Direccion datosdireccion=new Direccion();
		                        datosdireccion.setDir(arraydatosdireccion[0]);
		                        datosdireccion.setCP(Integer.parseInt(arraydatosdireccion[1]));
		                        datosdireccion.setLocalidad(arraydatosdireccion[2]);
		                        datosdireccion.setProvincia(arraydatosdireccion[3]);

		                  datoscliente.setDireccion(datosdireccion);//ya tiene como parametro de entrada un objeto de tipo Direccion

		                  datoscliente.setNumsocio(Double.parseDouble(arraydatos[4]));
		                  datoscliente.setDto(Double.parseDouble(arraydatos[5]));

		            //3. INTRODUCIR REFERENCIA A OBJETO CLIENTE EN UN ARRAYLIST LLAMADO LISTACLIENTE 
		                  listacliente.add(datoscliente);

		                  lecturalinea=br.readLine();

		            }
            }

            catch (Exception e) {
                  System.out.println("Error: "+e.getMessage());
            }

/*RELLENAR COMPRA
	1. Mostrar los productos (visualizar)
	2. Solicitar qué productos
*/

//visualizar en pantalla
			System.out.println("LISTADO DE MANZANAS:");
			System.out.println("--------------------");
			for (int i=0;i<listamanzana.size();i++) {
				listamanzana.get(i).mostrarmanzana();
			}

			System.out.println();
			System.out.println("LISTADO DE LECHUGAS");
			System.out.println("-------------------");
			for (int i=0;i<listalechuga.size() ;i++ ) {
				listalechuga.get(i).mostrarlechuga();
			}

			System.out.println();
			System.out.println("LISTADO DE LECHES");
			System.out.println("-------------------");
			for (int i=0;i<listaleche.size() ;i++ ) {
				listaleche.get(i).mostrarleche();
			}

//solicitar informacion cliente
			Scanner sc=new Scanner(System.in);
			double socio;

			System.out.println();
			System.out.print("Numero socio: ");
			System.out.println();
			socio=sc.nextInt();
			int p=-1;

			//busco en el arraylist, si existe ese socio le asigno el correspondiente descuento
			for (int i=0;i<listacliente.size();i++) {
				if (socio==listacliente.get(i).getNumsocio()) {
							p=i;
				}
				else {
					System.out.println("No existe ese numero de socio.");
				}
			}

/*double descuento=listacliente.get(p).getDto();
//solicitar productos
			int codigo=0;
			int cantidad;
			double coste;

			System.out.println();
			System.out.print("Introduzca el codigo de barras del producto que desea: ");
			System.out.println();
			codigo=sc.nextInt();






MOSTRAR CUENTA
*/


	}


}