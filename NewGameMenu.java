import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.Group;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

public class NewGameMenu extends JFrame implements ActionListener{
	//user input values assigned here
	private String usrName;
	private Difficulty gameDifficulty;
	private int questionCount;
	
	private JPanel newGamePanel;
	private GroupLayout layout;
	private JTextField nameField, countField;
	private JLabel nameLabel, countLabel;
	private JRadioButton easy, medium, hard;
	private ButtonGroup buttonGroup;
	
	//button to execute
	private JButton newGameButton;
	
	//random number variables
	private int first, second, answer;
	
	public NewGameMenu(){
		super("New Game");
		
	//initialize New Game Menu format
		this.setBackground(new Color(148, 148, 183));
		this.setSize(600, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
	//settingsPanel = new JPanel(new GroupLayout(getContentPane()));
		newGamePanel = new JPanel();
		newGamePanel.setPreferredSize(new Dimension(500, 200));
		this.add(newGamePanel);
		
		
		nameLabel = new JLabel("Player Name : ");
		countLabel = new JLabel("Problem count : ");
		
		nameField = new JTextField(10);
		countField = new JTextField(5);
		
		nameLabel.setLabelFor(nameField);
		countLabel.setLabelFor(countField);
		
		//create buttons with appropriate strings
		easy = new JRadioButton(Difficulty.EASY.getDifficulty());
		medium = new JRadioButton(Difficulty.MEDIUM.getDifficulty());
		hard = new JRadioButton(Difficulty.HARD.getDifficulty());
		
		newGameButton = new JButton("Create New Game!");

		
	//Grouplayout Configuration
		layout = new GroupLayout(newGamePanel);
		newGamePanel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
	
	//Creates GroupLayout configurations 
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		//add parallel group with radio buttons 	
			hGroup.addGroup(layout.createParallelGroup()
					.addComponent(easy)
					.addComponent(medium)
					.addComponent(hard));
		//add parallel group with text fields
			hGroup.addGroup(layout.createParallelGroup()
					.addComponent(nameLabel)
					.addComponent(countLabel));
		//add last parallel group with create new game button
			hGroup.addGroup(layout.createParallelGroup()
					.addComponent(nameField)
					.addComponent(countField)
					.addComponent(newGameButton));
			layout.setHorizontalGroup(hGroup);
			
			
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
			vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
					.addComponent(easy)
					.addComponent(nameLabel)
					.addComponent(nameField));
			vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
					.addComponent(medium)
					.addComponent(countLabel)
					.addComponent(countField));
			vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
					.addComponent(hard)
					.addComponent(newGameButton));
			layout.setVerticalGroup(vGroup);
			
		//group the radio buttons, button group ensures only one radio button can be selected
		buttonGroup = new ButtonGroup();
		buttonGroup.add(easy);
		buttonGroup.add(medium);
		buttonGroup.add(hard);
		
		//add actionlisteners		
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		newGameButton.addActionListener(this);

		this.pack();
		this.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	 //if button is selected, get the Difficulty, User Name, and Question Count	
		if(e.getSource() == newGameButton){
			this.usrName = nameField.getText();
			if(easy.isSelected())
				this.gameDifficulty = Difficulty.EASY;
			if(medium.isSelected())
				this.gameDifficulty = Difficulty.MEDIUM;
			if(hard.isSelected())
				this.gameDifficulty = Difficulty.HARD;
			
			try{
			this.questionCount = Integer.parseInt(countField.getText());
			}catch(NumberFormatException exception){
				JOptionPane.showMessageDialog(this, "Please enter the number of questions \nyou would like to answer to answer");
				exception.printStackTrace();
				//create an input to fix this issue
			}
			
		}
		
	}
	
	public int getQuestionCount() {
		return questionCount;
	}


	public Player createPlayer(){
		Player playa = new Player();
		playa.setName(usrName);
		playa.setDifficulty(gameDifficulty);
		return playa;
	}

}
