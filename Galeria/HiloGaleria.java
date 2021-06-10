package Galeria;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HiloGaleria extends JLabel implements Runnable {
	
	private Thread hilo;	
	private Clase_Galeria ga; 
	private final int TIEMPO_ENTRE_FOTOS;
	//--------------------
	private int fotoActual;
	private boolean iniciado;
	private boolean pausado;
	private boolean terminado;
	
	public HiloGaleria(String nombre, int prioridad, ThreadGroup gl, Clase_Galeria galeria1, String etiqueta) {
		super(etiqueta);
		TIEMPO_ENTRE_FOTOS = 3000; //3 segundos
		hilo = new Thread(gl,this, nombre);
		hilo.setPriority(prioridad);
		this.ga = galeria1;
		fotoActual = 0;
		//Estado de un hilo 
		iniciado = false;
		pausado = false;
		terminado = false;
	}
	public synchronized void pausar() {
		pausado = true;
	}
	public synchronized void reiniciar() {
		pausado = false;
		notify();
	}
	@Override
	public void run() {
		iniciado = true;
		while (!terminado)
		{
			try {
				if (pausado) {
					synchronized(this) {
						wait();
					}
					
				}
				mostrarFotos();				
				Thread.sleep(TIEMPO_ENTRE_FOTOS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public synchronized boolean isIniciado() {
		return iniciado;
	}

	public synchronized void setIniciado(boolean iniciado) {
		this.iniciado = iniciado;
	}

	public synchronized boolean isPausado() {
		return pausado;
	}

	public synchronized void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

	public synchronized boolean isTerminado() {
		return terminado;
	}

	public synchronized void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	private synchronized void mostrarFotos() {
		Clase_Foto f = this.ga.getFotos().get(this.fotoActual); 
		System.out.println("Mostrando la foto -->" +f.toString());
		this.fotoActual = (this.fotoActual+1)% this.ga.getFotos().size();
		ImageIcon img = new ImageIcon(getClass().getResource("imagenes/" +f.getNombreFichero()));
		//escalar la imagen
		ImageIcon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
		//plantar al label
		this.setIcon(icono);		
		/*
		 * La foto actial para el ejepm,lo de 4 fotos deberia valer 
		 * 0,1,2,3,0,1,2,3.....
		 * podemos consegir ese efecto dividiendo el numero entre 4 cojiendo el ressto ( % )
		 * por ejemplo
		 * 	0 % 4 = 0
		 * 	1 % 4 = 1
		 *	2 % 4 = 2
		 * 	3 % 4 = 3
		 *	 4 % 4 = 0	
		 **/	
	}

	public Thread getHilo() {
		return hilo;
	}

	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}
	public synchronized void terminar() {
		terminado = true;
		
	}

}
