class Cliente {

	public Cliente() {

	}

	private String nombre;
	private String apellidos;
	private String DNI;
	private Direccion direccion;
	private Double numsocio;
	private Double dto;

	public void setNombre(String idnombre) {
		this.nombre=idnombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setApellidos(String idapellidos) {
		this.apellidos=idapellidos;
	}

	public String getApellidos() {

		return apellidos;
	}

	public void setDNI (String idDNI) {

		this.DNI=idDNI;
	}

	public String getDNI () {
		return DNI;
	}

	public void setDireccion (Direccion iddireccion) {
		this.direccion=iddireccion;
	}

	public Direccion getDireccion () {
		return direccion;
	}

	public void setNumsocio (Double idnumsocio) {
		this.numsocio=idnumsocio;
	}

	public Double getNumsocio () {
		return numsocio;
	}

	public void setDto (Double iddto) {
		this.dto=iddto;
	}

	public Double getDto () {
		return dto;
	}

	public void mostrarcliente () {
		System.out.println();
		System.out.println("	Nombre: 		"+getNombre());
		System.out.println("	Apellidos: 		"+getApellidos());
		System.out.println("	DNI: 			"+getDNI());
		System.out.println("	Direccion: 		"+getDireccion().getDir());
		System.out.println("	Direccion: 		"+getDireccion().getCP());
		System.out.println("	Direccion: 		"+getDireccion().getLocalidad());
		System.out.println("	Direccion:		"+getDireccion().getProvincia());
		//getDireccion().mostrardireccion();
		System.out.println("	Número Socio: 		"+getNumsocio());
		System.out.println("	Descuento: 		"+getDto());
		System.out.println();
	}


}