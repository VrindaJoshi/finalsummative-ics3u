import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

// CERTIFICATE CLASS: displays certificate at the end of the quiz, if user passes
public class CertificateClass extends JFrame {

	private JLabel name = new JLabel(AvatarBuilder.userAvatar.getName()); // name of user
	private JLabel certificate = new JLabel(new ImageIcon(new ImageIcon("images/finalCertificate.png").getImage()
			.getScaledInstance(1066, 766, java.awt.Image.SCALE_SMOOTH)));

	// constructor
	public CertificateClass() {

		// setup
		setSize(1366, 766);
		setName("All About Objects+ + Classes");

		// image bounds
		certificate.setBounds(0, 0, 1266, 766);
		certificate.setHorizontalAlignment(SwingConstants.CENTER);
		certificate.setLayout(null);

		// set name label
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
