package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import clases.ModeloDeDatos;
import clases.Procesos;
import entidades.Estudiante;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPromedio extends JFrame implements ActionListener{
	

	private JTextField txtMateria;
	private JTextField txtNombre;
	private JTextField txtDocumento;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JLabel lblResultado;
	private JButton btnEliminar;
	private JButton btnActualizar;
	
	private JButton btnConsultaIndividual;
	private JButton btnLista;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	Procesos misProcesos;
	ModeloDeDatos miModeloDeDatos;
	
	public VentanaPromedio() {
		misProcesos=new Procesos();
		miModeloDeDatos=new ModeloDeDatos();
		setTitle("Promedio estudiantes");
		setSize(659,672);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		iniciarComponentes();
}
	
	private void iniciarComponentes() {
		
	
		JLabel lblTitulo = new JLabel("SISTEMA CONTROL DE NOTAS");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 26, 606, 59);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMateria.setBounds(348, 117, 72, 22);
		
		txtMateria = new JTextField();
		txtMateria.setBounds(430, 120, 180, 19);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(106, 120, 201, 19);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(24, 117, 72, 22);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDocumento.setBounds(24, 85, 72, 22);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(106, 88, 201, 19);
		
		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(106, 162, 96, 19);
		
		JLabel lblNota1 = new JLabel("Nota1:");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNota1.setBounds(24, 159, 72, 22);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(309, 165, 96, 19);
		
		JLabel lblNota2 = new JLabel("Nota2:");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNota2.setBounds(227, 162, 72, 22);
		
		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(513, 165, 96, 19);
		
		JLabel lblNota3 = new JLabel("Nota3:");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNota3.setBounds(431, 162, 72, 22);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultado.setBounds(24, 215, 586, 22);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(80, 276, 100, 21);
		btnCalcular.addActionListener(this);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(200, 276, 100, 21);
		btnLimpiar.addActionListener(this);
		
		btnConsultaIndividual = new JButton("Consultar");
		btnConsultaIndividual.setBounds(440, 275, 100, 21);
		btnConsultaIndividual.addActionListener(this);
		
		btnLista = new JButton("Lista");
		btnLista.setBounds(320, 275, 100, 21);
		btnLista.addActionListener(this);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(170, 310, 120, 21);
		btnActualizar.addActionListener(this);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(320, 310, 120, 21);
		btnEliminar.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30,360, 586, 256);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
	
		add(lblTitulo);
		add(lblMateria);
		add(txtMateria);
		add(btnLimpiar);
		add(btnCalcular);
		add(lblResultado);
		add(lblNota3);
		add(txtNota3);
		add(lblNota2);
		add(txtNota2);
		add(lblNota1);
		add(txtNota1);
		add(lblNombre);
		add(txtNombre);
		add(btnConsultaIndividual);
		add(btnLista);
		add(scrollPane);
		add(lblDocumento);
		add(txtDocumento);
		add(btnActualizar);
		add(btnEliminar);
		
		
		
		}
	
	
	private void calcular() {

	    Estudiante miEstudiante = new Estudiante();

	    miEstudiante.setDocumento(txtDocumento.getText());
	    miEstudiante.setNombre(txtNombre.getText());
	    miEstudiante.setMateria(txtMateria.getText());
	    miEstudiante.setNota1(Double.parseDouble(txtNota1.getText()));
	    miEstudiante.setNota2(Double.parseDouble(txtNota2.getText()));
	    miEstudiante.setNota3(Double.parseDouble(txtNota3.getText()));

	    double promedio = misProcesos.calcularPromedio(miEstudiante);
	    miEstudiante.setPromedio(promedio);

	    if (promedio != -1) {

	        if (promedio < 3.5) {
	            lblResultado.setText("Resultado: Perdió.Su Promedio es: " + promedio);
	            lblResultado.setForeground(Color.RED);
	        } else {
	            lblResultado.setText("Resultado: Aprobó. Su Promedio es: " + promedio);
	            lblResultado.setForeground(Color.BLUE);
	        }

	        String registro = miModeloDeDatos.registrarEstudiante(miEstudiante);

	        if (!registro.equals("ok")) {
	            JOptionPane.showMessageDialog(null, registro,
	                    "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
	        }

	    } else {
	        lblResultado.setText("Revise los datos, no pueden ser negativos ni mayores a 5");
	        lblResultado.setForeground(Color.RED);
	    }

	
		System.out.println("EL promedio es: "+promedio);
	
	}
	
	private void consultarLista() {

	    VentanaLista miVentanaLista = new VentanaLista(miModeloDeDatos);
	    miVentanaLista.setVisible(true);
	}
	
	private void consultaIndividual() {

	    String documento = JOptionPane.showInputDialog("Ingrese el DOCUMENTO del estudiante");

	    Estudiante estudianteEncontrado = miModeloDeDatos.consultaEstudiante(documento);

	    if (estudianteEncontrado != null) {

	        txtDocumento.setText(estudianteEncontrado.getDocumento());
	        txtNombre.setText(estudianteEncontrado.getNombre());
	        txtMateria.setText(estudianteEncontrado.getMateria());
	        txtNota1.setText(estudianteEncontrado.getNota1() + "");
	        txtNota2.setText(estudianteEncontrado.getNota2() + "");
	        txtNota3.setText(estudianteEncontrado.getNota3() + "");

	        lblResultado.setText("Promedio: " + estudianteEncontrado.getPromedio());

	        if (estudianteEncontrado.getPromedio() < 3.5) {
	            lblResultado.setForeground(Color.RED);
	        } else {
	            lblResultado.setForeground(Color.BLUE);
	        }

	    } else {
	        JOptionPane.showMessageDialog(null,
	                "NO SE ENCUENTRA EL ESTUDIANTE",
	                "ADVERTENCIA",
	                JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	
	private void actualizar() {

	    Estudiante miEstudiante = new Estudiante();

	    miEstudiante.setDocumento(txtDocumento.getText());
	    miEstudiante.setNombre(txtNombre.getText());
	    miEstudiante.setMateria(txtMateria.getText());
	    miEstudiante.setNota1(Double.parseDouble(txtNota1.getText()));
	    miEstudiante.setNota2(Double.parseDouble(txtNota2.getText()));
	    miEstudiante.setNota3(Double.parseDouble(txtNota3.getText()));

	    double promedio = misProcesos.calcularPromedio(miEstudiante);
	    miEstudiante.setPromedio(promedio);

	    String mensaje = miModeloDeDatos.actualizarEstudiante(miEstudiante);

	    JOptionPane.showMessageDialog(null, mensaje);

	    if(promedio < 3.5){
	        lblResultado.setForeground(Color.RED);
	    }else{
	        lblResultado.setForeground(Color.BLUE);
	    }

	    lblResultado.setText("Promedio actualizado: " + promedio);
	}
	
	
	private void eliminar() {

	    String documento = txtDocumento.getText();

	    String mensaje = miModeloDeDatos.eliminarEstudiante(documento);

	    JOptionPane.showMessageDialog(null, mensaje);

	    limpiar();
	}
	
	
	private void limpiar() {
		txtDocumento.setText("");
		txtNombre.setText("");
		txtMateria.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
		lblResultado.setText("Resultado: ");
		lblResultado.setForeground(Color.black);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnCalcular) {
			System.out.println("Calcular");
			calcular();
			
			}else if(e.getSource()==btnLimpiar) {
			System.out.println("Limpiar");
			limpiar();
			
			}else if(e.getSource()==btnConsultaIndividual) {
				consultaIndividual();
				
			}else if(e.getSource()==btnLista) {
				consultarLista();
		
			}else if(e.getSource()==btnActualizar){
			    actualizar();
			}
			else if(e.getSource()==btnEliminar){
			    eliminar();
			}
		
 }
}
		

