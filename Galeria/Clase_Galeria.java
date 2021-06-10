package Galeria;

import java.util.ArrayList;

public class Clase_Galeria {
	private String id;
	private ArrayList<Clase_Foto>fotos;
	public Clase_Galeria(String id, ArrayList<Clase_Foto> fotos) {
		//super();
		this.id = id;
		if(fotos==null) {
			this.fotos = new ArrayList<Clase_Foto>();
		}
		else {
			this.fotos = fotos;
		}
		
	}
	public Clase_Galeria(String id) {
		//super();
		this.id = id;
		this.fotos = new ArrayList<Clase_Foto>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Clase_Foto> getFotos() {
		return fotos;
	}
	public void setFotos(ArrayList<Clase_Foto> fotos) {
		this.fotos = fotos;
	}
	@Override
	public String toString() {
		return "Galeria [id=" + id + ", fotos=" + fotos + "]";
	}
	
	
	
}
