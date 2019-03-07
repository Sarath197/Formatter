package com.grepthor;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class Main_frame {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_frame window = new Main_frame();
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
	public Main_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		JToggleButton toggleButton = new JToggleButton("Word To Pdf");
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WP_frame wp_frame = new WP_frame();
				wp_frame.frame.setVisible(true);
			}
		});
		toggleButton.setBounds(62, 100, 121, 23);
		frame.getContentPane().add(toggleButton);
		
		JToggleButton toggleButton_1 = new JToggleButton("Pdf To Word");
		toggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PW_frame pw_frame = new PW_frame();
				pw_frame.frame.setVisible(true);
			}
		});
		toggleButton_1.setBounds(262, 100, 121, 23);
		frame.getContentPane().add(toggleButton_1);
		
		JButton button = new JButton("close");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = JOptionPane.showConfirmDialog(
					    button,
					    "Are you really want to close?",
					    "Alert",
					    JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		button.setBounds(177, 149, 89, 23);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("All Rights Reserved @ Grepthor Software Solutions");
		label.setForeground(Color.WHITE);
		label.setBounds(98, 195, 305, 14);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Main_frame.class.getResource("/maxresdefault (1).jpg")));
		lblNewLabel.setBounds(0, 0, 446, 78);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main_frame.class.getResource("/Flying-Owl-Desktop-Wallpaper-HD.jpg")));
		lblNewLabel_1.setBounds(0, 0, 477, 248);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(460, 240, 446, 233);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(128, 128, 128));
		frame.setUndecorated(true);		
	}
}
