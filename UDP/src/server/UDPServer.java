package server;

import java.awt.FlowLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UDPServer {

	public static void main(String[] args) throws Exception {

		DatagramSocket ds = new DatagramSocket(9999);

		byte[] b1 = new byte[1024];
		DatagramPacket dp = new DatagramPacket(b1, b1.length);
		ds.receive(dp);
		String str = new String(dp.getData());

		String newmessage = " Hello server UDP";

		byte[] b2 = (newmessage + str).getBytes();
		InetAddress ia = InetAddress.getLocalHost();
		DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort());
		ds.send(dp1);

		// SERVER MESAJ EKRANI
		JFrame f = new JFrame("Server");
		f.setSize(225, 225);
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Server Message\n");
		panel.setLayout(new FlowLayout());
		JButton button = new JButton(newmessage);

		button.setBounds(100, 300, 200, 100);// x, y, width, height
		label.setBounds(100, 100, 200, 100);

		panel.add(label);
		panel.add(button);
		f.add(panel);

		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
