import java.io.IOException;
import java.net.URL;
import javax.swing.*;

public class EditorPaneDemo extends JPanel{
	
	JEditorPane pane = new JEditorPane();
	JScrollPane scroll = new JScrollPane(pane);
	URL url = EditorPaneDemo.class.getResource("AvatarClass.html");
	
	public EditorPaneDemo() {
		 
		setSize(400,400);
		
		try {
			pane.setPage(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(scroll);
		
		setVisible(true);
	
		
	}

}
