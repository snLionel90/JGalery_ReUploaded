package Galeria;

public class Foto {
	
	private String nombre_foto;
	private String descripcion;
	private String nombreFichero;
	
	
	public Foto(String nombre_foto, String descripcion, String nombreFichero) {
		//super();
		this.nombre_foto = nombre_foto;
		this.descripcion = descripcion;
		this.nombreFichero = nombreFichero;
	}

	public String getNombre_foto() {
		return nombre_foto;
	}


	public void setNombre_foto(String nombre_foto) {
		this.nombre_foto = nombre_foto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombreFichero() {
		return nombreFichero;
	}


	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	@Override
	public String toString() {
		return "Foto [nombre_foto=" + nombre_foto + ", descripcion=" + descripcion + ", nombreFichero=" + nombreFichero
				+ "]";
	}
	
	
	
}
