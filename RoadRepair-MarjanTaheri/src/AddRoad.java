import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class AddRoad extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try
				{
					AddRoad frame = new AddRoad();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddRoad()
	{
		setTitle("Add Road");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Road Name: ");
		lblNewLabel.setBounds(5, 45, 75, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(77, 43, 420, 20);
		contentPane.add(textField);
		textField.setColumns(1);
		
		JLabel lblNewLabel_1 = new JLabel("Road ID:");
		lblNewLabel_1.setBounds(5, 15, 55, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(77, 12, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Number Of Lanes:");
		lblNewLabel_2.setBounds(5, 78, 83, 13);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "4"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(101, 75, 55, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Road Type:");
		lblNewLabel_3.setBounds(5, 105, 80, 13);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Local");
		rdbtnNewRadioButton.setBounds(70, 101, 70, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Ally");
		rdbtnNewRadioButton_1.setBounds(140, 102, 70, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Art-Coll");
		rdbtnNewRadioButton_2.setBounds(224, 101, 70, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Park");
		rdbtnNewRadioButton_3.setBounds(343, 101, 103, 21);
		contentPane.add(rdbtnNewRadioButton_3);
	}
}
