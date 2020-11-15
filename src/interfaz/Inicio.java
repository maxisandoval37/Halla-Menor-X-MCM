package interfaz;

import javax.swing.JFrame;
import javax.swing.JTextField;

import logica.HallarX_MCM;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

public class Inicio {

	public JFrame frame;
	private HallarX_MCM logica;
	private JTextField tFValorA;
	private JTextField tFValorM;
	private JButton btnCalcular;
	private JButton btnReset;
	private JLabel lblCreditos;
	private JLabel lblResultado;
	private String textoLabel;
	
	static Integer valorA;
	static Integer valorMCM;
	static Integer valorFinalX;
	
	private TextoTranslucido _textoTranslucido;
	public Inicio() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 100, 1000, 800);
		logica = new HallarX_MCM();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		inicializar_tfValorA();
		inicializar_tFValorM();
		inicializar_BotonCalcular();
		inicializarLabelResultadoFinal();
		inicializarLabelCreditos();
		inicializar_BotonReset();
	}
	
	private void inicializar_tfValorA() {
		tFValorA = new JTextField();
		setTextoTranslucido(new TextoTranslucido("VALOR DE A", tFValorA));
		tFValorA.setBounds(200, 500, 135, 55);
		frame.getContentPane().add(tFValorA);
		tFValorA.setColumns(10);
		limitarInputUsuario(tFValorA);
	}
	
	private void inicializar_tFValorM() {
		tFValorM = new JTextField();
		setTextoTranslucido(new TextoTranslucido("VALOR DE M [MCM]", tFValorM));
		tFValorM.setBounds(650, 500, 135, 55);
		frame.getContentPane().add(tFValorM);
		tFValorM.setColumns(10);
		limitarInputUsuario(tFValorM);
	}
	
	private void inicializar_BotonCalcular() {
		btnCalcular = new JButton("CALCULAR!");
		btnCalcular.setBounds(410, 650, 164, 55);
		frame.getContentPane().add(btnCalcular);
		accionBotonCalcular();
	}
	
	private void inicializar_BotonReset() {
		btnReset = new JButton("REINICIAR");
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(Color.RED);
		btnReset.setBounds(870, 700, 90, 35);
		frame.getContentPane().add(btnReset);
		accionBotonReset();
	}
	
	private void inicializarLabelResultadoFinal() {
		lblResultado = new JLabel("<html><body><center><h1><br>[A : X] = M</h1><br></center></body></html>");
		lblResultado.setBounds(410, 75, 429, 158);
		frame.getContentPane().add(lblResultado);
	}
	
	private void inicializarLabelCreditos() {
		lblCreditos = new JLabel("By: maxisandoval37");
		lblCreditos.setBounds(40, 630, 429, 158);
		frame.getContentPane().add(lblCreditos);
	}
	
	private void accionBotonCalcular() {
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				capturarInputs();
				
				if (valorA != 0 && valorMCM != 0) {
					valorFinalX = logica.hallarX_MCD(valorA, valorMCM);
					asignarTextoAlLabelValorX(valorFinalX);
				}
				else 
					JOptionPane.showMessageDialog(null, "INGRESE UN VALOR NUMERICO >0 PARA CONTINUAR");
			}
		});
	}
	
	private void accionBotonReset() {
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				capturarInputs();
				valorFinalX = 0;
				valorMCM=0;
				valorA=0;
				tFValorA.setText("");
				tFValorM.setText("");
				asignarTextoAlLabelValorX(0);
			}
		});
	}

	private void capturarInputs() {
		valorA = Integer.parseInt(tFValorA.getText()+0)/10;
		valorMCM = Integer.parseInt(tFValorM.getText()+0)/10;
	}
	
	private void asignarTextoAlLabelValorX(Integer valorX) {
		textoLabel="<html><body><h1><br>El valor de X es: "+valorX+"</h1><br></body></html>";
		lblResultado.setText(textoLabel);
	}
	
	private void limitarInputUsuario(JTextField tf) {
		tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0') || (e.getKeyChar() > '9') && (e.getKeyChar() != '\b')) {
					e.consume();
				} else {
					if (tf.getText().length() >= 7)
						e.consume();
				}
			}
		});
	}
	
	public TextoTranslucido getTp() {
		return _textoTranslucido;
	}

	public void setTextoTranslucido(TextoTranslucido tt) {
		this._textoTranslucido = tt;
	}
}
