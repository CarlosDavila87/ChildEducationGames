import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FlashCards extends JFrame implements ActionListener{
	
	private int int1,int2,answer,totalCorrect,totalProblems, count;
	private JLabel problemLabel;
	private JLabel totalLabel;
	private JPanel panel;
	private Font font;
	private JMenuBar menuBar;
	private JMenu file, difficulty, settings;
	private JMenuItem newGame, exit, easy, medium, hard;
	private NewGameMenu newGameMenu;

	private StringBuilder builder;
	private JButton[] buttons;
	private GridBagConstraints c;
	
	 public FlashCards(String title){
		 super(title);
		 this.setLayout(new BorderLayout());
		 this.setSize(700, 550);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
		 font = new Font("Chalkboard", Font.BOLD, 20);
		 int1 = 0;
		 int2 = 0;
		 answer = 0;
		 totalCorrect = 0;
		 totalProblems = 0;
		 
		 c = new GridBagConstraints();
		 
		 panel = new JPanel(new GridBagLayout());
		 panel.setPreferredSize(new Dimension(700, 550));
		 panel.setBackground(new Color(0, 153, 0));
	
	// JLabels for problem and scoring	 
		 
		 problemLabel = new JLabel("Click A button to get started");
		 problemLabel.setForeground(Color.WHITE);
		 problemLabel.setFont(font);

		 totalLabel = new JLabel("Score : ");
		 totalLabel.setForeground(Color.WHITE);
		 totalLabel.setFont(font);
	//images
		 //testlabel = new JLabel(new ImageIcon("/Users/Carlos/Documents/workspace/ChildrenGames/src/images/GoodBye.png"));
	
	//JButtons	
		 buttons = new JButton[4];
		 for(int i = 0; i < buttons.length; i++){
			 buttons[i] = new JButton("Button" +(i+1));
			 buttons[i].setFont(font);
			 buttons[i].addActionListener(this);
		 }

	/*Set Component Constraints & Add To JPanel */
		 
		 /*-----All Components -----*/
		 	c.ipadx = 20;
		 	c.ipady = 20;
		 	c.weightx = 10;
		 	c.weighty = 40;
		/*ProblemString Constraints*/
		 	c.gridx = 2;
		 	c.gridy = 0;
		 	c.gridwidth = 2;
		 	panel.add(problemLabel, c);
		 	c.gridwidth =1;
		/*----- Answer Button Constraints -----*/
		 	c.gridx = 4;
		 	c.gridy = 2;
		 	panel.add(buttons[3], c);
		 	//panel.add(button4, c);
		 	c.gridx = 3;
		 	c.gridy = 2;
		 	panel.add(buttons[2], c);
		 	//panel.add(button3, c);
		 	c.gridx = 2;
		 	c.gridy = 2;
		 	panel.add(buttons[1], c);
		 	//panel.add(button2, c);
		 	c.gridx = 1;
		 	c.gridy = 2;
		 	panel.add(buttons[0], c);
		 	//panel.add(button1, c);

		/*-----Total Correct String Constraints -----*/
		 	c.gridx = 4;
		 	c.gridy = 3;
		 	c.anchor = GridBagConstraints.PAGE_END;
		 	panel.add(totalLabel, c);
	/*End Of Setting  Component Constraints & Add To JPanel */
		 	
	//Menu Bar Setup
		 menuBar = new JMenuBar();
		 	
		 	file = new JMenu("File");
		 		exit = new JMenuItem("Exit");
		 		newGame = new JMenuItem("New Game");
		 	difficulty = new JMenu("Difficulty");
		 		easy = new JMenuItem(Difficulty.EASY.getDifficulty());
		 		medium = new JMenuItem(Difficulty.MEDIUM.getDifficulty());
		 		hard = new JMenuItem(Difficulty.HARD.getDifficulty());
		 	settings = new JMenu("Settings");
		 	
		 	file.add(newGame);
		 	file.addSeparator();
		 	file.add(exit);
		 	
		 	difficulty.add(easy);
		 	difficulty.addSeparator();

		 	difficulty.add(medium);
		 	difficulty.addSeparator();

		 	difficulty.add(hard);
		 	
		 	menuBar.add(file);
		 	menuBar.add(difficulty);
		 	menuBar.add(settings);
	
		 	
		 	exit.addActionListener(this);
		 	newGame.addActionListener(this);
		 	
		 	
			this.add(panel);
			this.pack();
		 	this.setJMenuBar(menuBar);
		 
		 
		 this.setVisible(true);
		 
	 }
	 /**
	  * This private method creates a new random addition problem.
	  * @return
	  */
	 private void randomAddition(){
			Random random = new Random();
			int1 = random.nextInt(11);
			int2 = random.nextInt(11);
			answer = int1 + int2;
			scrambleAnswers();
			setProblemLabel();
			setTotalLabel();
		}
	 /**
	  * This method checks to see if button clicked matches the correct answer to the problem
	  * @param button clicked 
	  * @return true if correct button pressed
	  */
	 private boolean checkAnswers(JButton button){
		 System.out.println("Button Value : " + Integer.parseInt(button.getText()));
		 System.out.println("Answer Value : " + answer);
		 return (Integer.parseInt(button.getText()) == answer);
	 }
	 /**
	  * This private method scrambles the Question answer, and three aditional numbers. Finally, adds 
	  * to the JButtons
	  */
	 private void scrambleAnswers(){
		 Random random = new Random();
		 int [] randoms = new int[4]; // used for random position in JButton [] buttons 
		 
		 //Assigns random integers & answer to random buttons
		 for(int i = 0; i < 4; i++){
		 randoms[i] = random.nextInt(4);
		 buttons[i].setText(Integer.toString(randoms[i]));
		 }
		 buttons[random.nextInt(4)].setText(Integer.toString(answer));	 
	 }
	 private void setProblemLabel(){
		 StringBuilder builder = new StringBuilder();
			builder.append(int1);
			builder.append(" + ");
			builder.append(int2);
			builder.append(" = ? ");
			problemLabel.setText(builder.toString());
	 }
	 private void setTotalLabel(){
		 StringBuilder newSB = new StringBuilder();
			newSB.append("Score : " + totalCorrect);
			newSB.append("/");
			newSB.append(totalProblems);
			totalLabel.setText(newSB.toString());
	 }
	 
/*-----------------------------------------------
 * -------------MAIN METHOD----------------------
 * ---------------------------------------------*/
	public static void main(String[] args){
		FlashCards test = new FlashCards("Flash Cards Game");
		test.randomAddition();
	}

	@Override
	public void actionPerformed(ActionEvent e){
	//exit menu
		if(e.getSource() == exit){
			int value = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", 0);
			if(value == 0)
				System.exit(0);
		}
		else if(e.getSource() == newGame){
			System.out.println("New Game Selected");
			newGameMenu = new NewGameMenu();
		}
		//Casts the source to a JButton and performs random addition
		else if(e.getSource() == buttons[0] || e.getSource() == buttons[1] || 
				e.getSource() == buttons[2] || e.getSource() == buttons[3]){
			JButton tmpButton = new JButton();
			tmpButton = (JButton)e.getSource();
			boolean pass = checkAnswers(tmpButton);
			if(pass)
				totalCorrect+=1;
			this.randomAddition(); 
		}
	}
}