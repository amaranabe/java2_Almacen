public class Leche {

		public Leche(){

		}

		private String tipo;
		private String procedencia;
		private Double eurosLitro;
		private Distribuidor distribuidor;


		public String getTipo() {

			return tipo;
		}

		public void setTipo(String idtipo) {

			this.tipo=idtipo;
		}

		public String getProcedencia() {

			return procedencia;
		}

		public void setProcedencia(String idprocedencia) {

			this.procedencia=idprocedencia;
		}

		public Double getEuroslitro() {

			return eurosLitro;
		}

		public void setEuroslitro(Double ideurosLitro) {

			this.eurosLitro=ideurosLitro;
		}

		public Distribuidor getDistribuidor() {

			return distribuidor;
		}

		public void setDistribuidor (Distribuidor iddistribuidor) {

			this.distribuidor=iddistribuidor;
		}

		public void mostrarleche() {
			System.out.println("Las características de la leche son:");
			System.out.println("			Tipo: "+getTipo());
			System.out.println("			Procedencia: "+getProcedencia());
			System.out.println("			Precio: "+getEuroslitro()+" euros/litro");
			System.out.println("			Distribuidor: "+getDistribuidor());	
			System.out.println();	
		}


}


