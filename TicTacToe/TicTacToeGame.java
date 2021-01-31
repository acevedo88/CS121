import java.awt.Point;

/*CS 121 #3 Project 5: TicTacToe
* 
* This program is implement with a Graphic User Interface to allow the user to play a game of TicTacToe with a computer.
* This source of code is the main code to get the GUI to work correctly.  The User will start each game and can select any
* open squares.  The winner of each game will be displayed along with their current move sets.  The game can be reset at any
* time.
* 
* @author Alex Acevedo
* Fall 2018
*/


public class TicTacToeGame implements TicTacToe{

	//Instance variables

	private Player [][] gameBoard;
	private Point [] moves;
	private Winner winner;
	private boolean gameDone = false;
	int currentMove = 0;



	//Contructors

	//Main Constructor used for the program
	public TicTacToeGame() {

		gameBoard = new Player[3][3];
		moves = new Point[9];

		for(int i=0;i<gameBoard.length;i++)
		{
			for(int j=0;j<gameBoard[0].length;j++)
			{
				gameBoard[i][j] = Player.OPEN;
			}
		}

		
		winner = Winner.IN_PROGRESS;
		gameDone = false;
		currentMove = 0;
		


	}

	
	//Other Methods
	
	//Checks if the board has any Open positions, if not than it is a draw
	private boolean isDraw()
	{
		for(int i=0;i<gameBoard.length;i++)
		{
			for(int j=0;j<gameBoard[0].length;j++)
			{
				
				if(gameBoard[i][j] == Player.OPEN)
				{
					return false;
				}
					

			}
		}
		return true;
	}
	
	
	//Has won Method that checks if a Player has made a winning move each time a button is clicked
	private boolean hasWon(Player player, int row, int col)
	{
		
		if((gameBoard[0][0] == player && gameBoard[0][1] == player && gameBoard[0][2] == player)||
				(gameBoard[1][0] == player && gameBoard[1][1] == player && gameBoard[1][2] == player)||
				(gameBoard[2][0] == player && gameBoard[2][1] == player && gameBoard[2][2] == player)||
				(gameBoard[0][0] == player && gameBoard[1][0] == player && gameBoard[2][0] == player)||
				(gameBoard[0][1] == player && gameBoard[1][1] == player && gameBoard[2][1] == player)||
				(gameBoard[0][2] == player && gameBoard[1][2] == player && gameBoard[2][2] == player)||
				(gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player)||
				(gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player))
		{
			return true;
		}

		
		else
			return false;
	}




	//Every time the new game button is clicked than this method sets the board and all values back to its original state
	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		
		
		gameBoard = new Player[3][3];
		moves = new Point[9];
		
		for(int i=0;i<gameBoard.length;i++)
		{
			for(int j=0;j<gameBoard[0].length;j++)
			{
				gameBoard[i][j] = Player.OPEN;
			}
		}
		
		gameDone = false;
		
		winner = Winner.IN_PROGRESS;
		currentMove = 0;
		
	}

	//Checks if any of the ways to win is a valid way
	@Override
	public boolean gameOver() {
		
		return gameDone;
		
	}

	
	//If the player has won, this method checks who won
	@Override
	public Winner winner() {
		// TODO Auto-generated method stub

		

		return winner;

	}

	
	//This methods gets a copy of the current game grid and stores its values.  Encapsulated
	@Override
	public Player[][] getGameGrid() {
		// TODO Auto-generated method stub
		
		int i = 0;
		int j = 0;
		
		Player[][] copyPlayers = new Player[3][3];
		
		for( i = 0; i < gameBoard.length; i++)
		{
			for(j = 0; j<gameBoard.length; j++)
			{
				copyPlayers[i][j] = gameBoard[i][j];
			}
		}
		
		
		
		return copyPlayers;
	}

	
	//Gets a copy of the current moves each player have made and will be available to call.  Encapsulated 
	@Override
	public Point[] getMoves() {
		// TODO Auto-generated method stub
		
		int i = 0;
		
		Point[] copyMoves = new Point[currentMove];
		
		for(i = 0; i < currentMove; i++)
		{
			copyMoves[i] = moves[i];
			
		}
		

		return copyMoves;
		
	}

	
	//Method the will allow the user to choose an open square.  Once the game is over, it will stop and store the winner.
	@Override
	public boolean choose(Player player, int row, int col) {
		// TODO Auto-generated method stub

		
		
		if (row >=0 && row <=2 && col >=0 && col <=2 &&
				gameBoard[row][col] == Player.OPEN  && !gameDone)
		{
			
			
					gameBoard[row][col] = player;
					
					moves[currentMove] = new Point(row,col);
					
					currentMove++;
					//System.out.println(currentMove);
					
					if(hasWon(player, row, col))
					{
						gameDone = true;
						winner = (player ==Player.X?Winner.X:Winner.O);
					}
					else if(isDraw())
					{
						gameDone = true;
						winner = Winner.TIE;
					}
					else	
					{
						winner = Winner.IN_PROGRESS;
						
					}
					return true;
				
		}
		else
			return false;
	}



}
