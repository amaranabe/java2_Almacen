public class Lechuga {

		public Lechuga(){
		}

			

		private String tipoLechuga;
		private String procedencia;
		private String color;
		private Double eurosUnidad;
		private Distribuidor distribuidor;
		private int codbarras;


		public String getTipolechuga() {

			return tipoLechuga;
		}

		public void setTipolechuga(String idtipoLechuga) {

			this.tipoLechuga=idtipoLechuga;
		}

		public String getProcedencia() {

			return procedencia;
		}

		public void setProcedencia(String idprocedencia) {

			this.procedencia=idprocedencia;
		}

		public String getColor() {

			return color;
		}

		public void setColor(String idcolor) {

			this.color=idcolor;
		}

		public Double getEurosunidad() {

			return eurosUnidad;
		}

		public void setEurosunidad(Double ideurosUnidad) {

			this.eurosUnidad=ideurosUnidad;
		}

		public Distribuidor getDistribuidor () {

			return distribuidor;
		}

		public void setDistribuidor (Distribuidor iddistribuidor) {

			this.distribuidor=iddistribuidor;
		}

		public int getCodbarras() {
			return codbarras;
		}

		public void setCodbarras(int idcodbarras) {
			this.codbarras=idcodbarras;
		}

		public void mostrarlechuga() {
			System.out.println("Las características de la lechuga son:");
			System.out.println("			Tipo: "+getTipolechuga());
			System.out.println("			Procedencia: "+getProcedencia());
			System.out.println("			Color: "+getColor());
			System.out.println("			Precio: "+getEurosunidad()+" euros/unidad");
			System.out.println("			Distribuidor: "+getDistribuidor());	
			System.out.println();	
		}



}


