import java.awt.GridLayout;

import javax.swing.JPanel;
/**
 * CheckerBoard class
 * @author Huy Tran Quang
 *
 */
public class CheckerBoard extends JPanel{
	//Constants and instance variables
	private static final int ROW = 8;
	private static final int COLUMN = 8;
	private char[][] boardStatus = new char[ROW][COLUMN];
	/**
	 * Constructor
	 * @param boardStatus the 2-dimensional array of the status value
	 * of each square.
	 */
	public CheckerBoard(char [][] boardStatus) {
		setBoardStatus(boardStatus);
		setLayout(new GridLayout(ROW, COLUMN));
		for(int i = 0; i < boardStatus.length; i++) {
			for(int j = 0; j < boardStatus[i].length; j++) {
				setCheckerPiece(i, j, boardStatus[i][j]);
			}
		}
	}
	/**
	 * a mutator method that set the boardStatus array using 
	 * the received parameter.
	 * @param boardStatus the 2-dimensional array of the status value
	 * of each square.
	 */
	public void setBoardStatus(char [][] boardStatus) {
		this.boardStatus = boardStatus;
		exceptionCheck();
		repaint();
		}
	/**
	 * Check all possible exceptions of the board
	 */
	public void exceptionCheck() {
		for(int i = 0; i < boardStatus.length; i++) {
			for(int j = 0; j < boardStatus[i].length; j++) {
				if(boardStatus[i][j] != 'e' && boardStatus[i][j] != 'b'
						&& boardStatus[i][j] != 'r') {
					throw new IllegalArgumentException("Invalid Argument at: " + i +", "+ j
							+ ": \nOnly 'r', 'b', and 'e' are accepted.");
				}
				else if((i > 2 && boardStatus[i][j] == 'b') || (i < 5 && boardStatus[i][j] == 'r')){
					throw new IllegalArgumentException("Invalid Argument at: " + i +", "+ j
							+ ": \nChecker is put on an invalid square of the checkerboard.");
				}
				else if((i + j) % 2 == 0 && boardStatus[i][j] != 'e') {
					throw new IllegalArgumentException("Invalid Argument at: " + i +", "+ j
							+ ": \nCheckers are supposed to be placed on a green square only");
				}
			}
		}
	}
	
	/**
	 * a mutator method that sets the value of status for the 
	 * square specified by row and column.
	 * @param row the row number of the square
	 * @param column the column number of the square
	 * @param status the status of the square
	 */
	public void setCheckerPiece(int row, int column, char status) {
		CheckerPiece cp = new CheckerPiece(row, column, status);
		repaint();
		add(cp);
	}

}
