package Galeria;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;

public class gleria1 extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private  HiloGaleria lblImagen;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gleria1 frame = new gleria1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gleria1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 450);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		//------------------------------
		Foto f1 = new Foto("foto 1","descripcion1","foto1.jpg");
		Foto f2 = new Foto("foto 2","descripcion2","14557.jpg");
		Foto f3= new Foto("foto 3","descripcion2","sunset.jpg");	
		Foto f4= new Foto("foto 4","descripcion2","foto2.jpg");
		Foto f5= new Foto("foto 5","descripcion2","foto3.jpg");
		ArrayList<Foto>fotos = new ArrayList<Foto>();
		fotos.add(f1);
		fotos.add(f2);
		fotos.add(f3);
		fotos.add(f4);
		fotos.add(f5);	
		Galeria galeria1 = new Galeria("g1",fotos); //greo un grupo
		ThreadGroup gl = new ThreadGroup("galerias");
		//---------------------------------				
		this.lblImagen = new HiloGaleria("galeria1",5,gl,galeria1,"Aqui va la imagen ");
		this.lblImagen.setBounds(65, 39, 645, 327);
		//IMportarla imagen
		ImageIcon img = new ImageIcon(getClass().getResource("imagenes/foto1.jpg"));
		//escalar la imagen
		ImageIcon icono = new ImageIcon(img.getImage().getScaledInstance(this.lblImagen.getWidth(),this.lblImagen.getHeight(),Image.SCALE_DEFAULT));
		//plantar al label
		this.lblImagen.setIcon(icono);					
		this.contentPane.add(this.lblImagen);
		
		//-----
		this.btnNewButton = new JButton("Play");
		this.btnNewButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				if (! lblImagen.isIniciado()) {	
					lblImagen.getHilo().start();
					btnNewButton.setEnabled(false);
					btnNewButton_1.setEnabled(true);
				}else {
					lblImagen.reiniciar();		
					btnNewButton_1.setEnabled(true);
					btnNewButton.setEnabled(false);
				}
			}
		});
		this.btnNewButton.setBounds(213, 377, 89, 23);
		this.contentPane.add(this.btnNewButton);
		
		this.btnNewButton_1 = new JButton("Pausa");
		this.btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImagen.pausar();			
				btnNewButton.setEnabled(true);	
				btnNewButton_1.setEnabled(false);
			}
		});
		this.btnNewButton_1.setBounds(367, 377, 89, 23);
		this.contentPane.add(this.btnNewButton_1);		
		
		JLabel lblNewLabel = new JLabel("Mini Photo Gallery (c) sn.Lionel90");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(65, 11, 618, 17);
		contentPane.add(lblNewLabel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(512, 377, 89, 23);
		
		contentPane.add(btnSalir);
	}
}
