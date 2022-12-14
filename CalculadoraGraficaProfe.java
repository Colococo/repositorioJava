package CursoJava;


import static java.awt.Font.PLAIN;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CalculadoraGraficaProfe {
	//propiedades
	private JFrame ventana;
	private JLabel operacion;
	private JLabel memoria;
	private JLabel display;
	private boolean nuevoOperando = true;
	private boolean puntoDecimal = false;
	private String operador = "";
	private double operando1 = 0;
	private double operando2 = 0;
	private double resultado = 0;
	private double sumarMemoria = 0;
		
	
	//métodos
	public CalculadoraGraficaProfe() {
		//crear ventana
		ventana = new JFrame();
		ventana.setLayout(null);
		ventana.setTitle("Calculadora");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocation(new Point(800, 200));
		ventana.setSize(new Dimension(290, 485)); 
		ventana.setVisible(true);
		ventana.setResizable(false);
		ventana.getContentPane().setBackground(Color.BLACK);
		
		//Agregar display de la operación
		operacion = new JLabel("");
		operacion.setBounds(16, 10, 243, 30);  //posición y tamaño
		operacion.setForeground(Color.WHITE);  //color de texto
		operacion.setHorizontalAlignment(SwingConstants.RIGHT);
		operacion.setBorder(new LineBorder(Color.DARK_GRAY));
		ventana.add(operacion);
		
		//Agregar display de la MEMORIA
		memoria = new JLabel("");
		memoria.setBounds(16, 10, 43, 30);  //posición y tamaño
		memoria.setForeground(Color.ORANGE);  //color de texto
		memoria.setHorizontalAlignment(SwingConstants.LEFT);
		memoria.setBorder(new LineBorder(Color.DARK_GRAY));
		ventana.add(memoria);
		
		//Agregar display de los números
		display = new JLabel("0");
		display.setBounds(15, 45, 245, 60);  //posición y tamaño
		display.setOpaque(true);
		display.setFont(new Font("ARIAL", PLAIN, 30));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setBorder(new LineBorder(Color.DARK_GRAY));
		ventana.add(display);
		
		//Agregar botones de números y operadores
		//Fila 1
		crearBoton("M", 15, 120);
		crearBoton("R", 80, 120);
		crearBoton("C", 145, 120);
		crearBoton("/", 210, 120);
		
		//Fila 2
		crearBoton("7", 15, 185);
		crearBoton("8", 80, 185);
		crearBoton("9", 145, 185);
		crearBoton("*", 210, 185);
		
		//Fila 3
		crearBoton("4", 15, 250);
		crearBoton("5", 80, 250);
		crearBoton("6", 145, 250);
		crearBoton("-", 210, 250);
		
		//Fila 4
		crearBoton("1", 15, 315);
		crearBoton("2", 80, 315);
		crearBoton("3", 145, 315);
		crearBoton("+", 210, 315);
		
		//Fila 5
		crearBoton("0", 80, 380);
		crearBoton(".", 145, 380);
		crearBoton("=", 210, 380);
		crearBoton("B", 15, 380);
		
		
	}
	
	private void crearBoton(String textoBoton, int posX, int posY) {
		JButton boton = new JButton(textoBoton);
		boton.setBounds(posX, posY, 50, 50);
		boton.setFont(new Font("ARIAL", PLAIN, 16));
		boton.setOpaque(true);		
			if(textoBoton.equals("=")) {
				boton.setBackground(Color.RED);
			}
			
			else if (textoBoton.equals("C")) {
				boton.setBackground(Color.BLUE);
			}
			else if (textoBoton.equals("M") || textoBoton.equals("R") || textoBoton.equals("B") ) {
				boton.setBackground(Color.ORANGE);
			}
			
		    else {
				boton.setBackground(Color.DARK_GRAY);
			}

		boton.setForeground(Color.WHITE);
		boton.setFocusPainted(false);
		ventana.add(boton);
		boton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//operacion.setText(textoBoton); //para probar el listener en cada botón
							
				
					if(textoBoton.equals("M")) {
						if(!display.getText().equals("0")) {
							memoria.setText("M");
							operando1 = Double.parseDouble(display.getText());
							sumarMemoria += operando1;							
							operacion.setText("");
							resetVariables();
							//System.out.println(sumarMemoria);
						}
						
					}else if (textoBoton.equals("R")) {
						if (sumarMemoria != 0 || !display.getText().equals("0") ) {
							memoria.setText("RM");
							display.setText(formatoSalidaDisplay(sumarMemoria));
							operacion.setText("");
							//resetVariables();
						}
													
						
					}else if (textoBoton.equals("B")) {
						memoria.setText("");
						sumarMemoria = 0;
						display.setText("0");
						operacion.setText("");
						resetVariables();
					}
				
							
				switch (textoBoton) {
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					if(nuevoOperando == true) {
						if(!textoBoton.equals("0") || !display.getText().equals("0")) {  //textoBoton == "0"
							display.setText(textoBoton);						
							nuevoOperando = false;
						}
					}
					else {
						if (sumarMemoria != 0) {
							memoria.setText("M");							
						}
						//System.out.println(display.getText());
						display.setText(display.getText() + textoBoton);						
						//System.out.println(display.getText());
					}
					break;
					
					
				case ".":
					if(puntoDecimal == false) { //si no se presionó el .
						if(display.getText().equals("0")) {
							display.setText(display.getText() + textoBoton);
							puntoDecimal = true;   //se presionó el .
							nuevoOperando = false;
						} else {
							display.setText("0" + textoBoton);
							nuevoOperando = false;
							puntoDecimal = true;
						}						
					}
					break;
								
				case "/":
				case "*":
				case "-":
				case "+":			
									
						if(operador.equals("") ) {							
							operador = textoBoton;
							operando1 = Double.parseDouble(display.getText());
														
							operacion.setText(operando1 + " " + operador);
							
							nuevoOperando = true;
							puntoDecimal = false;
						} else {							
							operando1 = resultado();
							operador = textoBoton;							
						}				
															
					
					operacion.setText(formatoSalidaDisplay(operando1) + " " + operador);
					break;
				case "C":	
					if (sumarMemoria != 0) {
						display.setText("0");
						operacion.setText("");
						memoria.setText("M");
						resetVariables();
					}else {
						display.setText("0");
						operacion.setText("");
						memoria.setText("");									
					    resetVariables();
					}
						
					//break;
				case "=":
					if(!operador.equals("")) {
						resultado();						
					}					
					break;					
				}
			}
			
		});
		boton.repaint();		
	}
	
	
	private double resultado() {
		operando2 = Double.parseDouble(display.getText());
		switch(operador) {
		case "+":
			resultado = operando1 + operando2;
			break;
		case "-":
			resultado = operando1 - operando2;
			break;
		case "*":
			resultado = operando1 * operando2;
			break;
		case "/":
			resultado = operando1 / operando2;
			break;
		}
			
		operacion.setText(formatoSalidaDisplay(operando1) + " " + operador + " " + formatoSalidaDisplay(operando2) + " =");
		display.setText(formatoSalidaDisplay(resultado));
		resetVariables();		
		puntoDecimal = false;
		return resultado;
	}
	
	
	
	private String formatoSalidaDisplay(double numero) {
		String numeroDisplay = "";
		DecimalFormatSymbols separador = new DecimalFormatSymbols();
		separador.setDecimalSeparator('.');
		DecimalFormat formatoResultado = new DecimalFormat("#.#########", separador);
		numeroDisplay = String.valueOf(formatoResultado.format(numero));
		return numeroDisplay;
	}
	
	private void resetVariables() {
		operando1 = 0;
		operando2 = 0;
		operador = "";
		//sumarMemoria = 0;
		nuevoOperando = true;
		puntoDecimal = false;
	}

	public static void main(String[] args) {
		
		new CalculadoraGraficaProfe();
		
			
		
	}

}


