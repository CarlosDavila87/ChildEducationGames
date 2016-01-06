import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.Group;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class NewGameMenu extends JFrame implements ActionListener{
	//user input values assigned here
	private String usrName;
	private Difficulty gameDifficulty;
	private int questionCount;
	
	private JPanel settingsPanel;
	private JTextField nameField, countField;
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
				
		settingsPanel = new JPanel();
		settingsPanel.setPreferredSize(new Dimension(500, 200));
		
		nameField = new JTextField(5);
		countField = new JTextField(5);
		
		//create buttons with appropriate strings
		easy = new JRadioButton(Difficulty.EASY.getDifficulty());
		medium = new JRadioButton(Difficulty.MEDIUM.getDifficulty());
		hard = new JRadioButton(Difficulty.HARD.getDifficulty());
		
		//group the radio buttons
		buttonGroup = new ButtonGroup();
		buttonGroup.add(easy);
		buttonGroup.add(medium);
		buttonGroup.add(hard);
		
		//add actionlisteners		
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		
		newGameButton = new JButton("Create A New Game!");
		
		settingsPanel.add(easy);
		settingsPanel.add(medium);
		settingsPanel.add(hard);
		settingsPanel.add(nameField);
		settingsPanel.add(countField);
		settingsPanel.add(newGameButton);
		
		this.add(settingsPanel);
		this.pack();
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Player createPlayer(String playerName, Difficulty difficulty){
		Player playa = new Player(playerName, difficulty);
		return playa;
	}

}
