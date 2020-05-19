import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/**
 * CheckerGame class
 * @author Huy Tran Quang
 *
 */
public class CheckerGame extends JFrame {
	//Constant and instance variable
	private static final long serialVersionUID = 1L;
	private char[][] boardStatus = 
			new char[][] {
		{'e', 'b', 'e', 'b', 'e', 'b', 'e', 'b'},
		{'b', 'e', 'b', 'e', 'b', 'e', 'b', 'e'},
		{'e', 'b', 'e', 'b', 'e', 'b', 'e', 'b'},
		{'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e'},
		{'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e'},
		{'r', 'e', 'r', 'e', 'r', 'e', 'r', 'e'},
		{'e', 'r', 'e', 'r', 'e', 'r', 'e', 'r'},
		{'r', 'e', 'r', 'e', 'r', 'e', 'r', 'e'},
	};
	/**
	 * Constructor
	 */
	public CheckerGame() {
		setLayout(new BorderLayout());
		setBoard();
		setStatusBar();
		setMenu();
		setSize(505, 585);
	}

	/**
	 * Build the checker board
	 */
	public void setBoard() {
		JPanel cb = new CheckerBoard(boardStatus);
		add(cb);
	}
	
	/**
	 * Build the status bar
	 */
	public void setStatusBar() {
		Box box = Box.createVerticalBox();
		JLabel label1 = new JLabel("This is where the status would be_");
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		box.add(label1);
		JLabel label2 = new JLabel("This game was developed by Huy Tran Quang");
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		box.add(label2);
		JPanel statusBar = new JPanel();
		statusBar.add(box);
		
		add(statusBar, BorderLayout.SOUTH);
	}
	/**
	 * Build the menu
	 */
	public void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		JMenu helpMenu = new JMenu("Help");
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem rules = new JMenuItem("Checker Game Rules");
		JMenuItem infomation = new JMenuItem("About Checker Game App");
		gameMenu.add(newItem);
		gameMenu.add(exitItem);
		helpMenu.add(rules);
		helpMenu.add(infomation);
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
	}
	

	//main method
	public static void main(String[] args) {
		JFrame checker = new CheckerGame();
		checker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checker.setTitle("Checker Game");
		checker.setVisible(true);
	}//end main method

}
