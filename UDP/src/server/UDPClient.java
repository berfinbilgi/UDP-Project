package server;

import java.awt.FlowLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UDPClient {

	public static void main(String[] args) throws Exception {

		DatagramSocket ds = new DatagramSocket();
		String message = " Hello client UDP";

		InetAddress ia = InetAddress.getLocalHost();
		DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), ia, 9999);
		ds.send(dp);

		byte[] buf = new byte[1024];
		DatagramPacket dp1 = new DatagramPacket(buf, buf.length);
		ds.receive(dp1);

		String str = new String(dp1.getData());
		System.out.println(str);

		// ÝSTEMCÝDEN GELEN MESAJ EKRANI
		JFrame f = new JFrame("Client");
		f.setSize(225, 225);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("Client message\n");
		JButton button = new JButton(message);

		button.setBounds(50, 300, 100, 100);
		label.setBounds(50, 100, 100, 100);

		panel.add(label);
		panel.add(button);

		// SUNUCUDAN GERÝ ÝSTEMCÝYE GÖNDERÝLEN MESAJ EKRANI
		JLabel label2 = new JLabel("Last message\n");
		JButton button2 = new JButton(str);
		button2.setBounds(50, 500, 100, 100);// x , y, width, height
		label2.setBounds(50, 450, 100, 100);

		panel.add(label2);
		panel.add(button2);
		f.add(panel);

		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
