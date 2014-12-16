public class Distribuidor {

		public Distribuidor(){

		}

		private String nombre;
		private Direccion direccion;
		private String CIF;
		private Contacto personaContacto;


		public String getNombre() {

			return nombre;
		}

		public void setNombre(String idnombre) {

			nombre=idnombre;
		}

		public String getCIF() {

			return CIF;
		}

		public void setCIF(String idcif) {

			CIF=idcif;
		}

		public Direccion getDireccion() {

			return direccion;
		}

		public void setDireccion (Direccion iddireccion) {

			direccion=iddireccion;
		}

		public Contacto getPersonacontacto() {

			return personaContacto;
		}

		public void setPersonacontacto (Contacto idpersonaContacto) {

			personaContacto=idpersonaContacto;
		}

		



}


