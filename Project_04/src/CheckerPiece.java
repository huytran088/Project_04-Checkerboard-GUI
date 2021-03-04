import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
/**
 * CheckerPiece class
 * @author Huy Tran Quang
 *
 */
public class CheckerPiece extends JComponent {
	//Constants and instance variables
	private char status;
	private int row, column;
	private static final int SQR_LENGTH = 60;
	private static final int CHECKER_LENGTH = 40;
	
	/**
	 * Constructor
	 * @param row the row of the checker
	 * @param column the column of checker
	 * @param status the status of the checker
	 */
	public CheckerPiece(int row, int column, char status) {
		this.row = row;
		this.column = column;
		this.status = status;
	}
	/**
	 * paint the squares and checkers on the board
	 */
	public void paintComponent(Graphics g) {
		
		if((row+column) % 2 == 0) {
			g.setColor(Color.WHITE);
		}
		else if ((row+column) % 2 == 1) {
			g.setColor(Color.GREEN);
		}
		g.fillRect(0, 0, SQR_LENGTH, SQR_LENGTH);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, SQR_LENGTH, SQR_LENGTH);
			switch(status) {
			case 'r': 
				g.setColor(Color.RED);
				g.fillOval(10, 10, CHECKER_LENGTH, CHECKER_LENGTH);
			break;
			case 'b':
				g.setColor(Color.BLACK);
				g.fillOval(10, 10, CHECKER_LENGTH, CHECKER_LENGTH);
			break;
			default: break;
			}
		}
	}

