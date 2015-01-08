public class Manzana {

		public Manzana(){
		}

			

		private String tipoManzana;
		private String procedencia;
		private String color;
		private Double eurosKilo;
		private Distribuidor distribuidor;


		public String getTipomanzana() {

			return tipoManzana;
		}

		public void setTipomanzana(String idtipoManzana) {

			this.tipoManzana=idtipoManzana;
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

		public Double getEuroskilo() {

			return eurosKilo;
		}

		public void setEuroskilo(Double ideurosKilo) {

			this.eurosKilo=ideurosKilo;
		}

		public Distribuidor getDistribuidor () {

			return distribuidor;
		}

		public void setDistribuidor (Distribuidor iddistribuidor) {

			this.distribuidor=iddistribuidor;
		}

		public void mostrarmanzana() {
			System.out.println("Las características de la manzana son:");
			System.out.println("			Tipo: "+getTipomanzana());
			System.out.println("			Procedencia: "+getProcedencia());
			System.out.println("			Color: "+getColor());
			System.out.println("			Precio: "+getEuroskilo()+" euros/kilo");
			System.out.println("			Distribuidor: "+getDistribuidor());	
			System.out.println();	
		}


}


