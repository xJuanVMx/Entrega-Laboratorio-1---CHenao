package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import clases.ModeloDeDatos;

public class VentanaLista extends JFrame {

    private JTextArea textArea;
    private JScrollPane scrollPane;

    public VentanaLista(ModeloDeDatos modelo) {

        setTitle("Lista de Estudiantes");
        setSize(500,400);
        setLocationRelativeTo(null);
        setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(20,20,440,300);

        textArea = new JTextArea();
        textArea.setEditable(false);

        scrollPane.setViewportView(textArea);

        add(scrollPane);

        textArea.setText(modelo.imprimirListaEstudiantes());
    }
}