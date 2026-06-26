package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Demo extends JFrame{

	private	JTextArea textArea;
	private JTextField categoria, giacenza, nome, prezzo;
	private JLabel nCategoria, nGiacenza, nNome, nPrezzo;
	private JLabel title;
	private	JButton button;
	private BorderLayout border;
	
	public Demo(String title) {
		this.title = new JLabel(title);
		this.textArea = new JTextArea();
		this.button = new JButton("Cliccami se vuoi");
		this.border = new BorderLayout();
		this.categoria = new JTextField();
		this.giacenza= new JTextField();
		this.nome = new JTextField();
		this.prezzo= new JTextField();
		this.nCategoria = new JLabel("Categoria");
		this.nGiacenza = new JLabel("Giacenza");
		this.nNome = new JLabel("Nome");
		this.nPrezzo = new JLabel("Prezzo");
		
		
		this.init();
	}
	
	public void init() {
		
		button.addActionListener( e -> textArea.setText(
				textArea.getText() + "Hello window\n"
				) );
		
		title.setBackground(Color.GRAY);
		title.setFont(new Font("Arial Bold", Font.ITALIC, 36));
		
		add(title,border.NORTH);
		
		// Create a panel and set the layout to vertical BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add components
        panel.add(nNome);
        panel.add(nome);
		
        panel.add(nCategoria);
        panel.add(categoria);
        
        panel.add(nGiacenza);
        panel.add(giacenza);
        
        panel.add(nPrezzo);
        panel.add(prezzo);
        
		add(panel, border.CENTER);
        
		add(button,border.SOUTH);
		
		setTitle("Mia finestra");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

}
