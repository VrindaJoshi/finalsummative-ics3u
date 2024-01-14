import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class CertificateClass extends JFrame{
	
	private JLabel name = new JLabel(AvatarBuilder.userAvatar.getName());
	private JLabel certificate = new JLabel(new ImageIcon(new ImageIcon("images/finalCertificate.png").getImage().getScaledInstance(1066, 766, java.awt.Image.SCALE_SMOOTH)));
	
	public CertificateClass() {
		
		setSize(1366, 766);
		setBackground(Color.WHITE);
				
		certificate.setBounds(0, 0, 1266, 766);
		certificate.setHorizontalAlignment(SwingConstants.CENTER);
		certificate.setLayout(null);
		
		name.setBounds(0, 370, 1266, 40);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		name.setLayout(null);
		add(name);
		add(certificate);

		
		setLayout(null);
		setVisible(true);
		
	}
	

}
