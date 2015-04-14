import java.util.Scanner;
import java.util.ArrayList;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;


//import java.util.*;


public class Main {

	public static void main (String[] args) {
	
            String lineadelfichero;
            String [] atributosdistribuidor;
            ArrayList <Distribuidor> listadistribuidores=new ArrayList <Distribuidor> ();
	
		try {
                  /*-------------------EJERCICIO CREAR FICHERO DISTRIBUIDORES-----------------*/
                  /*0.- Creo fichero*/
			FileWriter fw=new FileWriter ("distribuidores.txt");
			fw.write("Eroski, Barrio San Agustín s/n., 48230, Elorrio, Bizkaia, 20033361-F, Jaime, Blanco");
                  fw.write(System.lineSeparator());
                  fw.write("Dia, Edificio TRIPARK  Calle Jacinto Benavente 2ª, 28232, Las Rozas, Madrid, 28164754-A, Jon, Irizar");
                  fw.write(System.lineSeparator());
                  fw.write("SuperAmara, Barrio Ventas s/n, 20305, Irun, Gipuzkoa, 39345574-A, Ana, Nuñez");
                  fw.write(System.lineSeparator());
                  fw.write("Lidl, Pol. Industrial La Granja, 08110, Montcada i Reixac, Barcelona, 40000089-Q, Jacinto, Benavente");
                  fw.write(System.lineSeparator());
                  fw.write("Carrefour, Carretera de Burgos Km. 14.500, 28108, Alcobendas, Madrid, 28425270-A, Ane, Mendarte");
                  fw.close();

            /*
            *Paso 1.- Recorro el fichero
            *Paso 2.- Creo un ArrayList y luego lo relleno
            */

                  FileReader fr=new FileReader ("distribuidores.txt");
                  BufferedReader br=new BufferedReader(fr);                              
                  
                  lineadelfichero=br.readLine();
                    while (lineadelfichero!=null) {
                        
                  
                        // Separar en el string en una lista de strings se correspondera con los diferentes atributos
                        atributosdistribuidor = lineadelfichero.split(", ");

                        //declaramos objeto distribuidor e instanciamos
                        Distribuidor distlinea=new Distribuidor();
                        distlinea.setNombre(atributosdistribuidor[0]);
                        
                        Direccion conversion=new Direccion();
                        conversion.setDir(atributosdistribuidor[1]);
                        conversion.setCP(Integer.parseInt(atributosdistribuidor[2]));
                        conversion.setLocalidad(atributosdistribuidor[3]);
                        conversion.setProvincia(atributosdistribuidor[4]);
                        //asignamos el objeto Direccion al metodo setDireccion del objeto Distribuidor distlinea
                        distlinea.setDireccion(conversion);

                        distlinea.setCIF(atributosdistribuidor[5]);

                        Contacto contact=new Contacto();
                        contact.setNombre(atributosdistribuidor[6]);
                        contact.setApellido(atributosdistribuidor[7]);
                        distlinea.setPersonacontacto(contact);

                        //introducimos el distribuidor en el arrayList
                        listadistribuidores.add(distlinea);

                        lineadelfichero=br.readLine();

                  }
                                  
                

            /* 
             *Paso 3.- Visualizo en pantalla el ArrayList 
            */
                  for (int i=0; i<listadistribuidores.size(); i++) {
                        String verarray= listadistribuidores.get(i).getNombre();
                        System.out.println ("Distribuidor "+(i+1) +" es: " +verarray);

                        Direccion d= listadistribuidores.get(i).getDireccion();
                        System.out.println ("Dirección es "+(i+1) +" es: " +d.getDir());

                        verarray= listadistribuidores.get(i).getCIF();
                        System.out.println ("CIF "+(i+1) +" es: " +verarray);
                        
                        Contacto c= listadistribuidores.get(i).getPersonacontacto();
                        System.out.println ("Persona de contacto "+(i+1) +" es: " +c.getNombre() + " "+ c.getApellido());

                  }
                

      	} //fin del try

		catch(IOException e){

            System.out.println("Error: "+e);
            }//fin del catch

/*---------------------LECTURA DE FICHERO CLIENTES.TXT E INTRODUCE ESOS DATOS E UN ARRAYLIST---------------------------*/

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
            }//fin del try

            catch (Exception e) {
                  System.out.println("Error: "+e.getMessage());
            }


            /*-------------------------VISUALIZAR EL ARRAYLIST------------------------------------*/

            System.out.println("Los clientes listados del archivo son: ");
            for (int i=0;i<listacliente.size();i++) {
                  listacliente.get(i).mostrarcliente();
            }




/*Ejercicio3:
--------------Paso 4.A- SOLICITAMOS INFORMACION MANZANAS---------------------------------------------------
            (y la guardamos en objeto manzana para luego guardarlo en Arraylist)            */


            Scanner sc=new Scanner(System.in);
            ArrayList<Manzana> listamanzanas=new ArrayList<Manzana>();

            System.out.println("¿Cuántas manzanas quieres?");
            int contadorm=sc.nextInt();
            int m;
            for (m=0;m<=contadorm;m++) {

                  System.out.println("Introduce tipo de manzana: ");
                  String peticion=sc.next();
                  Manzana pedidomanzanas=new Manzana();
                  pedidomanzanas.setTipomanzana (peticion);

                  System.out.println("Introduce procedencia de la manzana: ");
                  peticion=sc.next();
                  pedidomanzanas.setProcedencia(peticion);

                  System.out.println("Introduce el color de la manzana: ");
                  peticion=sc.next();
                  pedidomanzanas.setColor(peticion);

                  System.out.println("Introduce el precio (euros/kg): ");
                  pedidomanzanas.setEuroskilo(sc.nextDouble());

                  System.out.println("Introduce el nombre del distribuidor: ");
                  peticion=sc.next();
                        int posiciondeinteres=-1;
                        for (int k=0; k<listadistribuidores.size();k++) {

                              if(listadistribuidores.get(k).getNombre()==peticion){
                                    posiciondeinteres=k;
                              }

                        }
                  if (posiciondeinteres>-1)
                  {
                        pedidomanzanas.setDistribuidor(listadistribuidores.get(posiciondeinteres));
                  }
                        
                  listamanzanas.add(pedidomanzanas);
                  

            }

//Visualizamos arraylist de manzana (listamanzanas)

            System.out.println("=======================================================");
            System.out.println("El pedido de manzana es el siguiente: ");
            for (int im=0;im<listamanzanas.size();im++) {
                  System.out.println((im+1)+".");
                  listamanzanas.get(im).mostrarmanzana();
            }
            System.out.println("-------------------------------------------------------");

 
/*-----------------------------Paso 4B. SOLICITAR INFORMACION LECHUGA------------------------------------*/
            
            ArrayList<Lechuga> listalechuga=new ArrayList<Lechuga>();

            System.out.println();
            System.out.println("¿Cuántas lechugas quieres?");
            int numlechuga=sc.nextInt();

            for (int l=0;l<=numlechuga;l++) {
                  Lechuga pedidolechugas=new Lechuga();

                  System.out.print("Introduce tipo de lechuga: ");
                  String peticion=sc.next();
                  pedidolechugas.setTipolechuga(peticion);
                  System.out.println();

                  System.out.print("Introduce procedencia de la lechuga: ");
                  peticion=sc.next();
                  pedidolechugas.setProcedencia(peticion);
                  System.out.println();

                  System.out.print("Introduce color de la lechuga:  ");
                  peticion=sc.next();
                  pedidolechugas.setColor(peticion);
                  System.out.println();

                  System.out.print("Introduce el precio (euros/unidad): ");
                  pedidolechugas.setEurosunidad(sc.nextDouble());
                  System.out.println();

                  System.out.print("Introduce nombre del distribuidor: ");
                  peticion=sc.next();
                        //Buscamos el nombre en el arraylist distribuidor y guardamos la posicion
                        int posiciondeinteres2=-1;
                        for (int b=0;b<listadistribuidores.size();b++) {
                              if (peticion==listadistribuidores.get(b).getNombre()) {
                                    posiciondeinteres2=b;
                              }
                              
                        }
                  pedidolechugas.setDistribuidor(listadistribuidores.get(posiciondeinteres2));

                  listalechuga.add(pedidolechugas);                        
                              
            }//fin for lechugas

            //Visualizamos arraylist de lechuga (pedidolechugas)



            System.out.println();
            System.out.println("El pedido de lechuga es el siguiente: ");
            for (int il=0;il<listalechuga.size();il++) {
                  System.out.println((il+1)+". ");
                  listalechuga.get(il).mostrarlechuga();

            }
            System.out.println("-------------------------------------------------------");

/*------------------------------Paso 4C. SOLICITAR INFORMACION LECHE--------------------------------------------------*/
            ArrayList<Leche>listaleche=new ArrayList<Leche>();

            System.out.println("¿Cuántos pedidos de leche quieres?");
            int numleche;
            numleche=sc.nextInt();
            for (int lg=0;lg<=numleche;lg++) {

                  Leche pedidoleche=new Leche();

                  System.out.println("Introduce tipo de leche: ");
                  pedidoleche.setTipo(sc.next());

                  System.out.println("Introduce la procedencia: ");
                  pedidoleche.setProcedencia(sc.next());

                  System.out.println("Introduce el precio (euros/litro): ");
                  pedidoleche.setEuroslitro(sc.nextDouble());

                  System.out.println("Introduce el nombre del distribuidor: ");
                  String peticion=sc.next();
                  int posiciondeinteres3=-1;
                        for (int c=0;c<listadistribuidores.size();c++) {
                              
                              if (peticion==listadistribuidores.get(c).getNombre()) posiciondeinteres3=c;
                        }
                  pedidoleche.setDistribuidor(listadistribuidores.get(posiciondeinteres3));

                  listaleche.add(pedidoleche);
                        
            }

            //Visualizamos arraylist de tipo leche (listaleche)

            System.out.println();
            System.out.println("El pedido de leche es el siguiente: ");
            for (int ll=0;ll<listaleche.size();ll++) {
                  System.out.println((ll+1)+". ");
                  listaleche.get(ll).mostrarleche();
            }
            System.out.println("-------------------------------------------------------");

	

      //guardamos en un fichero txt llamado productos.txt

          try {
                  File fl=new File("productos.txt");
                  FileWriter fw=new FileWriter(fl);
                  //guardo manzanas
                  for (int i=0;i<listamanzanas.size();i++) {
                        fw.write(listamanzanas.get(i).getCodbarras()+"; ");
                        fw.write(listamanzanas.get(i).getTipomanzana()+"; ");
                        fw.write(listamanzanas.get(i).getProcedencia()+"; ");
                        fw.write(listamanzanas.get(i).getColor()+"; ");
                        fw.write(listamanzanas.get(i).getEuroskilo()+"; ");

                        fw.write(listamanzanas.get(i).getDistribuidor().getNombre()+"#");
                        fw.write(listamanzanas.get(i).getDistribuidor().getCIF()+"#");
                        fw.write(listamanzanas.get(i).getDistribuidor().getDireccion().getDir()+", ");
                        fw.write(listamanzanas.get(i).getDistribuidor().getDireccion().getCP()+", ");
                        fw.write(listamanzanas.get(i).getDistribuidor().getDireccion().getLocalidad()+", ");
                        fw.write(listamanzanas.get(i).getDistribuidor().getDireccion().getProvincia()+"\n");
                  }

                  //guardo lechugas

                  for (int i=0;i<listalechuga.size();i++) {
                        fw.write(listalechuga.get(i).getCodbarras()+"; ");
                        fw.write(listalechuga.get(i).getTipolechuga()+"; ");
                        fw.write(listalechuga.get(i).getProcedencia()+"; ");
                        fw.write(listalechuga.get(i).getColor()+"; ");
                        fw.write(listalechuga.get(i).getEurosunidad()+"; ");

                        fw.write(listaleche.get(i).getDistribuidor().getNombre()+"#");
                        fw.write(listalechuga.get(i).getDistribuidor().getCIF()+"#");
                        fw.write(listalechuga.get(i).getDistribuidor().getDireccion().getDir()+", ");
                        fw.write(listalechuga.get(i).getDistribuidor().getDireccion().getCP()+", ");
                        fw.write(listalechuga.get(i).getDistribuidor().getDireccion().getLocalidad()+", ");
                        fw.write(listalechuga.get(i).getDistribuidor().getDireccion().getProvincia()+"\n");
                  }

                  //guardo leche

				for (int i=0;i<listaleche.size();i++) {
                        fw.write(listaleche.get(i).getCodbarras()+"; ");
                        fw.write(listaleche.get(i).getTipo()+"; ");
                        fw.write(listaleche.get(i).getProcedencia()+"; ");
                        fw.write(listaleche.get(i).getEuroslitro()+"; ");

                        fw.write(listaleche.get(i).getDistribuidor().getNombre()+"#");
                        fw.write(listaleche.get(i).getDistribuidor().getCIF()+"#");
                        fw.write(listaleche.get(i).getDistribuidor().getDireccion().getDir()+", ");
                        fw.write(listaleche.get(i).getDistribuidor().getDireccion().getCP()+", ");
                        fw.write(listaleche.get(i).getDistribuidor().getDireccion().getLocalidad()+", ");
                        fw.write(listaleche.get(i).getDistribuidor().getDireccion().getProvincia()+"\n");
                  }
                  

            }

            catch (IOException e) {
                  System.out.println("Error E/S: " + e);
                  
            }
	}

}