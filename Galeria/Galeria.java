package Galeria;

import java.util.ArrayList;

public class Galeria {
	private String id;
	private ArrayList<Foto>fotos;
	public Galeria(String id, ArrayList<Foto> fotos) {
		//super();
		this.id = id;
		if(fotos==null) {
			this.fotos = new ArrayList<Foto>();
		}
		else {
			this.fotos = fotos;
		}
		
	}
	public Galeria(String id) {
		//super();
		this.id = id;
		this.fotos = new ArrayList<Foto>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(ArrayList<Foto> fotos) {
		this.fotos = fotos;
	}
	@Override
	public String toString() {
		return "Galeria [id=" + id + ", fotos=" + fotos + "]";
	}
	
	
	
}
