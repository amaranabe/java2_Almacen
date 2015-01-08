import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

//import java.util.*;


public class Main {

	public static void main (String[] args) {
		
		try {

                  /*0.- Creo un fichero*/
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
                  String lineadelfichero="algo";
                  String [] atributosdistribuidor=new String[7];
                  ArrayList <Distribuidor> listadistribuidores=new ArrayList <Distribuidor> ();

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

            /*
            *Ejercicio3:
            Paso 4.A- Solicitamos información de manzanas y la guardamos en objeto manzana y luego lo guardamos en Arraylist
            */
            int contadorm=0;

            System.out.println("¿Cuántas manzanas quieres?");
            contadorm=sc.nextInt();
            int i;
            for (i=0;i<=contadorm;i++) {
                  
                  Scanner sc = new Scanner(System.in);
                  Manzana pedidomanzanas=new Manzana();

                  System.out.println("Introduce tipo de manzana: " + );
                  String peticion=sc.next();
                  pedidomanzanas.setTipomanzana (peticion);

                  System.out.println("Introduce procedencia de la manzana: " + );
                  peticion=sc.next();
                  pedidomanzanas.setProcendencia(peticion);

                  System.out.println("Introduce el color de la manzana: " + );
                  peticion=sc.next();
                  pedidomanzanas.setColor(peticion);

                  System.out.println("Introduce el precio (euros/kg): " + );
                  peticion=sc.next();
                  pedidomanzanas.setEuroskilo(peticion);

                  System.out.println("Introduce el nombre del distribuidor: " +);
                  peticion=sc.next();
                  int posiciondeinteres=-1;
                  for (int k=0; k<listadistribuidores.size();k++) {
                        if(listadistribuidores.get(k).getNombre()==peticion){
                              posiciondeinteres=k;
                        }
                  }
            }


            pedidomanzanas.setDistribuidor(listadistribuidores.get(posiciondeinteres))
            ArrayList<Manzana> listamanzanas=new ArrayList<Manzana>();
            listamanzanas.add(pedidomanzanas);

            */




	}

}