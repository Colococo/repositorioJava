package CursoJava;

import static java.awt.Font.PLAIN;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PiedraPapelGrafica {
	//propiedades
	private JFrame ventana;
	private JLabel displayResultado;
	private JLabel displayComputadora;
	private JLabel displayTexto;
	private JLabel displayTotal;
	private JLabel displayTotal1;
	private JLabel displayTotal2;
	private int opcionUsuario;
	private int empate;
	private int empate1;
	private int empate2;
	private int ganoCompu;
	private int ganoUsuario;
	
	public PiedraPapelGrafica() {
		//crear ventana
		ventana = new JFrame();
		ventana.setLayout(null);
		ventana.setTitle("Piedra-Papel-Tijera");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocation(new Point(800, 100));// ubicacion en pantalla
		ventana.setSize(new Dimension(600, 600));
		ventana.setVisible(true);
		ventana.setResizable(false);
		
		
		//metodos
		
		displayResultado = new JLabel("");
		displayResultado.setBounds(200, 65, 200, 50);  //posición y tamaño
		displayResultado.setBorder(new LineBorder(Color.DARK_GRAY));
		displayResultado.setFont(new Font("ARIAL", PLAIN, 20));
		displayResultado.setHorizontalAlignment(SwingConstants.CENTER);	
		ventana.add(displayResultado);
		
		displayComputadora = new JLabel("");
		displayComputadora.setBounds(390, 220, 100, 40);		
		displayComputadora.setFont(new Font("ARIAL", PLAIN, 18));
		displayComputadora.setOpaque(true);		
		displayComputadora.setForeground(Color.BLACK);
		displayComputadora.setBorder(new LineBorder(Color.DARK_GRAY));
		displayComputadora.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.add(displayComputadora);
		
		displayTotal = new JLabel("  Usuario: ");
		displayTotal.setBounds(335, 350, 200, 25);  //posición y tamaño
		displayTotal.setFont(new Font("ARIAL", PLAIN, 15));
		displayTotal.setHorizontalAlignment(SwingConstants.LEFT);	
		ventana.add(displayTotal);
		
		displayTotal1 = new JLabel("  Computadora: ");
		displayTotal1.setBounds(335, 370, 200, 25);  //posición y tamaño
		displayTotal1.setFont(new Font("ARIAL", PLAIN, 15));
		displayTotal1.setHorizontalAlignment(SwingConstants.LEFT);	
		ventana.add(displayTotal1);
		
		displayTotal2 = new JLabel("  Empates: ");
		displayTotal2.setBounds(335, 390, 200, 25);  //posición y tamaño
		displayTotal2.setFont(new Font("ARIAL", PLAIN, 15));
		displayTotal2.setHorizontalAlignment(SwingConstants.LEFT);	
		ventana.add(displayTotal2);
			
		
		// Textos
		crearTexto("Resultados", 290, 300);
		crearTexto("Avatar Usuario", 50, 150);
		crearTexto("Avatar Computadora", 335, 150);
		crearTexto("Ganador", 200, 15);
		
		//Botones PiedraPapelTijera	
		crearBoton("PIEDRA", 100, 220);
		crearBoton("PAPEL", 100, 300);
		crearBoton("TIJERA", 100, 380);
		crearBoton("Reset", 240, 480);				
	}	
	
	
		// ACCIONES BOTON PIEDRA PAPEL TIJERA
		private void crearBoton(String textoBoton, int posX, int posY) {
			JButton boton = new JButton(textoBoton);
			boton.setBounds(posX, posY, 100, 40);
			boton.setFont(new Font("ARIAL", PLAIN, 18));
			boton.setForeground(Color.WHITE);		
			boton.setForeground(Color.BLACK);		
			ventana.add(boton);	
			
				
			boton.addActionListener((ActionListener) new ActionListener() {			

				@Override
				public void actionPerformed(ActionEvent e) {
														
														
						int opcionComputadora = (int)(Math.random()*3)+1;														
					
						if (opcionComputadora == 1) {
							displayComputadora.setText("PIEDRA");
						}else if (opcionComputadora == 2) {
							displayComputadora.setText("PAPEL");
						}else {
							displayComputadora.setText("TIJERA");						
					    }
									
					
				switch (textoBoton) {
						
				case "PIEDRA":				
						if (textoBoton.equals("PIEDRA")) {							
							opcionUsuario = 1;						
							}if (opcionUsuario == opcionComputadora) {
								empate = empate + 1;
								String numCadena= Integer.toString(empate);
								displayTotal2.setText("  Empates: " + " " + numCadena);
								displayResultado.setText("Empate");														  
				              }else {
				            	  if (opcionComputadora == 2) {
									ganoCompu = ganoCompu + 1;
									String numCadena= Integer.toString(ganoCompu);
									displayTotal1.setText("  Computadora: " + " " + numCadena);
				            		displayResultado.setText("Computadora");
				            		  
				            	  }else {
				            		  ganoUsuario = ganoUsuario + 1;
									String numCadena= Integer.toString(ganoUsuario);
									displayTotal.setText("  Usuario: " + " " + numCadena);
				            		displayResultado.setText("Usuario");			            		
				            	  }				            	 
				            	  break;      	  	            	  
				              }							    
					
				case "PAPEL":					
						if (textoBoton.equals("PAPEL")) {							
							opcionUsuario = 2;												
							}if (opcionUsuario == opcionComputadora) {
								displayResultado.setText("Empate");
									empate1 = empate1 + 1;
									String numCadena= Integer.toString(empate1);
									displayTotal2.setText("  Empates: " + " " + numCadena);
									displayResultado.setText("Empate");
				              }else {
				            	  if (opcionComputadora == 3) {
				            		  ganoCompu = ganoCompu + 1;
									  String numCadena= Integer.toString(ganoCompu);
									  displayTotal1.setText("  Computadora: " + " " + numCadena);
				            		  displayResultado.setText("Computadora");
				            	  }else {
				            		  ganoUsuario = ganoUsuario + 1;
									  String numCadena= Integer.toString(ganoUsuario);
									  displayTotal.setText("  Usuario: " + " " + numCadena);
				            		  displayResultado.setText("Usuario");
				            	  }				            	 
				            	  break;      	  	            	  
				              }								
					     						
				case "TIJERA":					
						if (textoBoton.equals("TIJERA")) {							
							opcionUsuario = 3;							
							}if (opcionUsuario == opcionComputadora) {
								displayResultado.setText("Empate");
									empate2 = empate2 + 1;
									String numCadena= Integer.toString(empate2);
									displayTotal2.setText("  Empates: " + " " + numCadena);
									displayResultado.setText("Empate");
				              }else {
				            	  if (opcionComputadora == 1) {
				            		  ganoCompu = ganoCompu + 1;
									  String numCadena= Integer.toString(ganoCompu);
									  displayTotal1.setText("  Computadora: " + " " + numCadena);
				            		  displayResultado.setText("Computadora");
				            	  }else {
				            		  ganoUsuario = ganoUsuario + 1;
									  String numCadena= Integer.toString(ganoUsuario);
									  displayTotal.setText("  Usuario: " + " " + numCadena);
				            		  displayResultado.setText("Usuario");			            		  
				            	  }				            	 
				            	  break;      	  	            	  
				              }						     
							
				case "Reset":
					if (textoBoton.equals("Reset")) {
						empate = 0;
						empate1 = 0;
						empate2 = 0;
						ganoUsuario = 0;
						ganoCompu = 0;
						displayResultado.setText("");
						displayComputadora.setText("");
						displayTotal.setText("  Usuario: ");
						displayTotal1.setText("  Computadora: ");
						displayTotal2.setText("  Empates: ");
				
					}
					break;
				  }				
					
				}			
			});
			
			boton.repaint();					
		
	    }	
			

		private void crearTexto(String texto, int posX, int posY) {
			displayTexto = new JLabel(texto);
			displayTexto.setBounds(posX, posY, 200, 60);
			displayTexto.setFont(new Font("ARIAL", PLAIN, 20));
			displayTexto.setHorizontalAlignment(SwingConstants.CENTER);
			ventana.add(displayTexto);		
		}

	
	public static void main(String[] args) {
		
		new PiedraPapelGrafica();
			

	}

}
