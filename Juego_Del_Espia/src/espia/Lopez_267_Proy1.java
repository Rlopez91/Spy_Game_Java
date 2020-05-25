package espia;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Lopez_267_Proy1 implements ActionListener{
	private JFrame ventana;
	private JButton btn_pos, btn_start, btn_temp, btn_espia;
	private Random rnd;
	JLabel lbl_titulo, lbl_fila, lbl_columna, lbl_titulo2, lbl_norte, lbl_sur, lbl_este, lbl_oeste, lbl_intentos, lbl_espia, lbl_botones;
	JTextField tf_intentos, tf_espia, tf_botones;


	public static void main(String[] args){
		
		new Lopez_267_Proy1();

	}

	Lopez_267_Proy1(){
		
		
		ventana = new JFrame("Juego del Espia");
		ventana.setBounds(20,20,1000,1000);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lbl_titulo = new JLabel("<html>UNIVERSIDAD TECNOLOGICA DE PANANA<br>FACULTAD DE INGENIERIA EN SISTEMAS COMPUTACIONALES<br><br>LIC. DESARROLLO DE SOFTWARE<br><br>DESARROLLO DE SFOTWARE III<br><br>PROFESOR<br>RICARDO CHAN<br><br>ESTUDIANTE<br>RICARDO LOPEZ<br>N-21-267<br><br>GRUPO 1LS221<br><br>31 de mayo 2020</html>");
		lbl_titulo.setBounds(50,50,350,280);
		ventana.add(lbl_titulo);

		lbl_titulo2 = new JLabel("ENCUENTRA AL ESPIA");
		lbl_titulo2.setBounds(680, 50, 200, 20);
		ventana.add(lbl_titulo2);

		lbl_norte = new JLabel("NORTE");
		lbl_norte.setBounds(730, 115, 100, 20);
		ventana.add(lbl_norte);
		
		lbl_sur = new JLabel("SUR");
		lbl_sur.setBounds(740, 480, 80, 20);
		ventana.add(lbl_sur);

		lbl_oeste = new JLabel("OESTE");
		lbl_oeste.setBounds(520, 280, 80, 20);
		ventana.add(lbl_oeste);

		lbl_este = new JLabel("ESTE");
		lbl_este.setBounds(920, 280, 80, 20);
		ventana.add(lbl_este);

		for(int i=0; i<10; i++){
			lbl_fila = new JLabel(String.valueOf(i+1));
			lbl_columna = new JLabel(String.valueOf(-i+10));

			lbl_fila.setBounds(600+30*(i%10), 450, 20, 20); //(x+pos de botones*i%10, y, ancho, alto)
			lbl_columna.setBounds(580, 150+30*i, 20, 20);

			ventana.add(lbl_fila);
			ventana.add(lbl_columna);
		}

		for(int i=0; i<100; i++){
			btn_pos = new JButton();
			btn_pos.setBounds(600+30*(i%10),150+30*(i/10),25,25);
			btn_pos.addActionListener(this);
			ventana.add(btn_pos);
		}

		btn_start = new JButton("COMENZAR");
		btn_start.setBounds(600, 510, 150, 30);
		btn_start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btn_start) 
					btn_espia = new JButton();
					btn_espia.setBounds((rnd.nextInt(10)*30+600), rnd.nextInt(10)*30+150, 25, 25);
					tf_espia.setText(String.valueOf(btn_espia.getX())+" "+String.valueOf(btn_espia.getY()));
					tf_intentos.setText("0");
			}
		});
		ventana.add(btn_start);

		lbl_intentos = new JLabel("Intentos");
		lbl_intentos.setBounds(600, 550, 80, 20);
		ventana.add(lbl_intentos);

		tf_intentos = new JTextField("0");
		tf_intentos.setBounds(690, 550, 30, 20);
		ventana.add(tf_intentos);

		lbl_espia = new JLabel("Respuesta"); //solo para verificar que el programa funicione
		lbl_espia.setBounds(600, 580, 80, 20);
		lbl_espia.setVisible(false);
		ventana.add(lbl_espia);

		tf_espia = new JTextField();
		tf_espia.setBounds(690, 580, 80, 20);
		tf_espia.setVisible(false);
		ventana.add(tf_espia);
		
		lbl_botones = new JLabel("Usuario"); //solo para verificar el boton presionado por el usuario
		lbl_botones.setBounds(600, 610, 80, 20);
		lbl_botones.setVisible(false);
		ventana.add(lbl_botones);
		
		tf_botones = new JTextField();
		tf_botones.setBounds(690, 610, 80, 20);
		tf_botones.setVisible(false);
		ventana.add(tf_botones);
		
		rnd = new Random();

		ventana.setVisible(true);

	}
	

	public void actionPerformed(ActionEvent e) {
		
			btn_temp = (JButton)e.getSource();//para almacenar el event de cada boton
			
			tf_intentos.setText(String.valueOf(Integer.parseInt(tf_intentos.getText())+1));
			
			int x = btn_temp.getX(); //para obtener las coordenadas del boton que presiona el usuario
			int y = btn_temp.getY();
			
			btn_temp.setText(String.valueOf(x)+" "+String.valueOf(y));
			tf_botones.setText(btn_temp.getText());
			
			System.out.println();
			
			if(tf_espia.getText().equals(x+" "+y)) {
				JOptionPane.showMessageDialog(null, "ENCONTRASTE AL ESPIA");
			}
			
			else if((btn_temp.getX() == (btn_espia.getX()+30)) || (btn_temp.getX() == (btn_espia.getX()-30)) || (btn_temp.getY() == (btn_espia.getY()+30)) || (btn_temp.getY() == (btn_espia.getY()-30))) {
				JOptionPane.showMessageDialog(null, "SE HA MOVIDO EL ESPIA!");
				btn_espia.setBounds((rnd.nextInt(10)*30+600), rnd.nextInt(10)*30+150, 25, 25);
				tf_espia.setText(String.valueOf(btn_espia.getX())+" "+String.valueOf(btn_espia.getY()));
				
			}
			
			else if(btn_temp.getX() > btn_espia.getX() && btn_temp.getY() > btn_espia.getY()) {
				JOptionPane.showMessageDialog(null, "DIRIGETE AL NOROESTE");
			}
			
			else if(btn_temp.getX() < btn_espia.getX() && btn_temp.getY() < btn_espia.getY()) {
				JOptionPane.showMessageDialog(null, "DIRIGETE AL SURESTE");
			}
			
			else if(btn_temp.getX() < btn_espia.getX() && btn_temp.getY() > btn_espia.getY()) {
				JOptionPane.showMessageDialog(null, "DIRIGETE AL NORESTE");
			}
			
			else if(btn_temp.getX() > btn_espia.getX() && btn_temp.getY() < btn_espia.getY()) {
				JOptionPane.showMessageDialog(null, "DIRIGETE AL SUROESTE");
			}
			
			else if(btn_temp.getX() == btn_espia.getX() && btn_temp.getY() < btn_espia.getY()) {
				JOptionPane.showMessageDialog(null, "DIRIGETE AL SUR");
			}
			
			else if(btn_temp.getX() == btn_espia.getX() && btn_temp.getY() > btn_espia.getY()) {
				JOptionPane.showMessageDialog(null, "DIRIGETE AL NORTE");
			}
			
			else if(btn_temp.getX() > btn_espia.getX() && btn_temp.getY() == btn_espia.getY()) {
				JOptionPane.showMessageDialog(null, "DIRIGETE AL OESTE");
			}
			
			else if(btn_temp.getX() < btn_espia.getX() && btn_temp.getY() == btn_espia.getY()) {
				JOptionPane.showMessageDialog(null, "DIRIGETE AL ESTE");
			}
			
	}



}