import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI {
	public static void main(String[] args) throws IOException {
		new GUI();
	}		
	public GUI() throws IOException  {
		JFrame HammingDistance = new JFrame();
		
		JPanel rightSide = new JPanel(new GridLayout(8,1));
		JPanel leftSide = new JPanel(new GridLayout(8,1));
		
		HammingDist hammingDist = new HammingDist();
		ArrayList<String> newWords = hammingDist.getWordBank();
		
		//Start With Row1: Enter Hamming Dist: "input"
		JPanel row1 = new JPanel(new GridLayout(1, 2));
		JLabel prompt1 = new JLabel("Enter Hamming Dist:");
		JTextField input1 = new JTextField();
		input1.setText("1");
		row1.add(prompt1);
		row1.add(input1);
		leftSide.add(row1);
	
		
	}
	
}
