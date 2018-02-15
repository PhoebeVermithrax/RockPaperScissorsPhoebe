/*
 * Created by: Phoebe Vermithrax
 * Created on: 15-Feb-2018
 * Created for: ICS5U
 * Daily Assignment – Day #9
 * This program ...
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

//Import random.
import java.util.Random; 

public class RockPaperScissors {

	//Set global variables for the minimum and max value (1 and 3 to represent rock, paper and scissors), 
	//and the random number, which is the computer choice.
	final int MAX_VALUE = 3;
	final int MIN_VALUE = 1;
	int playerChoice;
	int playerScore = 0;
	int computerScore = 0;
	
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RockPaperScissors window = new RockPaperScissors();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Rock, Paper, Scissors");
		
		Group grpPlayerChoice = new Group(shell, SWT.NONE);
		grpPlayerChoice.setText("Player Choice");
		grpPlayerChoice.setBounds(32, 20, 130, 105);
		
		Button radPlayerRock = new Button(grpPlayerChoice, SWT.RADIO);
		radPlayerRock.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Set the player choice is 1.
			}
		});
		radPlayerRock.setBounds(10, 25, 90, 16);
		radPlayerRock.setText("Rock");
		
		Button radPlayerScissors = new Button(grpPlayerChoice, SWT.RADIO);
		radPlayerScissors.setBounds(10, 69, 90, 16);
		radPlayerScissors.setText("Scissors");
		
		Button radPlayerPaper = new Button(grpPlayerChoice, SWT.RADIO);
		radPlayerPaper.setBounds(10, 47, 90, 16);
		radPlayerPaper.setText("Paper");
		
		Group grpComputerChoice = new Group(shell, SWT.NONE);
		grpComputerChoice.setBounds(190, 20, 130, 105);
		grpComputerChoice.setText("Computer Choice");
		
		Button radCompRock = new Button(grpComputerChoice, SWT.RADIO);
		radCompRock.setBounds(10, 24, 90, 16);
		radCompRock.setText("Rock");
		
		Button radCompPaper = new Button(grpComputerChoice, SWT.RADIO);
		radCompPaper.setBounds(10, 46, 90, 16);
		radCompPaper.setText("Paper");
		
		Button radCompScissors = new Button(grpComputerChoice, SWT.RADIO);
		radCompScissors.setBounds(10, 68, 90, 16);
		radCompScissors.setText("Scissors");
		
		Group grpPlay = new Group(shell, SWT.NONE);
		grpPlay.setText("Play");
		grpPlay.setBounds(32, 131, 191, 105);
		
		Label lblPlayerScoreIntro = new Label(grpPlay, SWT.NONE);
		lblPlayerScoreIntro.setBounds(10, 26, 110, 15);
		lblPlayerScoreIntro.setText("Player's Score:");
		
		Label lblPlayerScore = new Label(grpPlay, SWT.NONE);
		lblPlayerScore.setBounds(126, 26, 55, 15);
		//Set the player score to be zero.
		lblPlayerScore.setText("" + 0);
		
		Label lblComputerScoreIntro = new Label(grpPlay, SWT.NONE);
		lblComputerScoreIntro.setBounds(10, 54, 110, 15);
		lblComputerScoreIntro.setText("Computer's Score:");
		
		Label lblComputersScore = new Label(grpPlay, SWT.NONE);
		lblComputersScore.setBounds(126, 54, 55, 15);
		//Set the computer score to be zero.
		lblComputersScore.setText("" + 0);
		
		Label lblWinLoseTie = new Label(shell, SWT.NONE);
		lblWinLoseTie.setBounds(287, 181, 130, 15);
		lblWinLoseTie.setText("New Label");
		//make it invisible.
		lblWinLoseTie.setVisible(false);
		
		Button btnPlay = new Button(grpPlay, SWT.NONE);
		btnPlay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Set the computerChoice.
				int computerChoice;
				
				//State the variables for rock, paper and scissors. final means constant.
				final int ROCK = 1;
				final int PAPER = 2;
				final int SCISSORS = 3;
				
				//Once you have gotten the user's choice, check to see which ones they've chosen.
				if (radPlayerRock.getSelection() == true)
				{
					//Set the player choice to rock.
					playerChoice = ROCK;
				}
				else if (radPlayerPaper.getSelection() == true)
				{
					//Set the player choice to Paper.
					playerChoice = PAPER;
				}
				else if (radPlayerScissors.getSelection() == true)
				{
					//Set the player choice to scissors.
					playerChoice = SCISSORS;
				}
				//If nothing was clicked,
				else
				{
					//Set the player choice to 0.
					playerChoice = 0;
				}
				
				//Randomly generate numbers between 1-3 to represent rock, paper, and scissors for the computer.
				computerChoice = ((int) (Math.random()*MAX_VALUE)+MIN_VALUE);
				
				//Set the radio buttons for the computer.
				if (computerChoice == ROCK)
				{
					//Set the radio button for rock to be selected. Have all the other ones not be selected.
					radCompRock.setSelection(true);
					radCompPaper.setSelection(false);
					radCompScissors.setSelection(false);
				}
				else if (computerChoice == PAPER)
				{
					//Set the radio button for paper to be selected. Have all the other ones not be selected.
					radCompPaper.setSelection(true);
					radCompRock.setSelection(false);
					radCompScissors.setSelection(false);
				}
				else if (computerChoice == SCISSORS)
				{
					//Set the radio button for scissors to be selected. Have all the other ones not be selected.
					radCompScissors.setSelection(true);
					radCompRock.setSelection(false);
					radCompPaper.setSelection(false);
				}
				
				//Next, compare the user's and the computer's choices.
				if (playerChoice == computerChoice)
				{
					//Set the label, reading that it's a tie. enable the text visibility.
					lblWinLoseTie.setVisible(true);
					lblWinLoseTie.setText("It's a tie");
				}
				//If the player choice was rock,
				else if (playerChoice == ROCK)
				{
					//See the computer's choice.
					if (computerChoice == PAPER)
					{
						//Tell the user that the computer won.
						lblWinLoseTie.setVisible(true);
						lblWinLoseTie.setText("Computer Wins");
						
						//Update the Computer Score and text.
						computerScore++;
						lblComputersScore.setText("" + computerScore);
					}
					//If the computer chose scissors,
					else
					{
						//Tell the user that they won.
						lblWinLoseTie.setVisible(true);
						lblWinLoseTie.setText("You win");
						
						//Update the player score and text.
						playerScore++;
						lblPlayerScore.setText("" + playerScore);
					}
				}
				//if the player's choice was paper,
				else if (playerChoice == PAPER)
				{
					//See the computer's choice.
					if (computerChoice == ROCK)
					{
						//Tell the user that they won.
						lblWinLoseTie.setVisible(true);
						lblWinLoseTie.setText("You win");
						
						//Update the player score and text.
						playerScore++;
						lblPlayerScore.setText("" + playerScore);
					}
					//If the computer chose scissors,
					else
					{
						//Tell the user that the computer won.
						lblWinLoseTie.setVisible(true);
						lblWinLoseTie.setText("Computer Wins");
						
						//Update the Computer Score and text.
						computerScore++;
						lblComputersScore.setText("" + computerScore);
					}
				}
				//If the user's choice was scissors,
				else if (playerChoice == SCISSORS)
				{
					//See the computer's choice,
					if (computerChoice == ROCK)
					{
						//Tell the user that the computer won.
						lblWinLoseTie.setVisible(true);
						lblWinLoseTie.setText("Computer Wins");
						
						//Update the Computer Score and text.
						computerScore++;
						lblComputersScore.setText("" + computerScore);
					}
					//If the computer's choice was paper,
					else
					{
						//Tell the user that they won.
						lblWinLoseTie.setVisible(true);
						lblWinLoseTie.setText("You win");
						
						//Update the player score and text.
						playerScore++;
						lblPlayerScore.setText("" + playerScore);
					}
				}
				//If the user chose nothing,
				if (playerChoice == 0)
				{
					lblWinLoseTie.setText("Please choose an option.");
				}
			}
		});
		btnPlay.setBounds(58, 75, 75, 25);
		btnPlay.setText("Play");
		
	}
}
