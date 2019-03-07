package com.grepthor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Box;

public class Home_frame{

	public JFrame frame;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_frame window = new Home_frame();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Home_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBounds(490, 260, 454, 169);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnLaunch = new JButton("LAUNCH");
		btnLaunch.setBounds(170, 89, 83, 23);
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main_frame main_frame = new Main_frame();
				main_frame.frame.setVisible(true);

			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnLaunch);

		JLabel label = new JLabel("All Rights Reserved @ Grepthor Software Solutions");
		label.setBounds(82, 123, 315, 14);
		label.setForeground(Color.WHITE);
		frame.getContentPane().add(label);

		Canvas canvas = new Canvas();
		canvas.setBounds(345, 16, 0, 0);
		canvas.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {

			}
		});

		frame.getContentPane().add(canvas);
		
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(0, 0, 1, 1);
		frame.getContentPane().add(verticalBox);
		
		JLabel lblPoweredBy = new JLabel("Powered By");
		lblPoweredBy.setIcon(new ImageIcon(Home_frame.class.getResource("/maxresdefault (1).jpg")));
		lblPoweredBy.setBounds(0, -38, 533, 150);
		frame.getContentPane().add(lblPoweredBy);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home_frame.class.getResource("/Flying-Owl-Desktop-Wallpaper-HD.jpg")));
		label_1.setBounds(0, 76, 448, 65);
		frame.getContentPane().add(label_1);
		
		
		
		
	}
}