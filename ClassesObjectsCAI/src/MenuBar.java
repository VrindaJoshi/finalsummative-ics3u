import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuBar implements MenuListener {

	static final JMenuBar MENUBAR = new JMenuBar();

	static final JMenu mMenu = new JMenu("Home");
	static final JMenu mEdu = new JMenu("Learn");
	static final JMenu mActivity = new JMenu("Play");
	static final JMenu mQuiz = new JMenu("Quiz");
	
	
	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

		

}
