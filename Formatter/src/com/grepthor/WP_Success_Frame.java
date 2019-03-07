package com.grepthor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.ImageIcon;

public class WP_Success_Frame {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WP_Success_Frame window = new WP_Success_Frame();
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
	public WP_Success_Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(490, 260, 342, 139);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Successfully Converted");
		label.setForeground(Color.WHITE);
		label.setBounds(102, 37, 156, 14);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("View");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				File file=new File(WP_frame.viewWP);
				Desktop openFile=Desktop.getDesktop();
				try {
					openFile.open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(57, 62, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("close");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main_frame main_frame = new Main_frame();
				main_frame.frame.setVisible(true);
			}
		});
		button_1.setBounds(180, 62, 89, 23);
		frame.getContentPane().add(button_1);
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//contentPane.removeAll();
				
				new WP_frame().frame.setVisible(true);
			}
		});
		btnGo.setBounds(255, 106, 61, 23);
		frame.getContentPane().add(btnGo);
		btnGo.setEnabled(false);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		    		btnGo.setEnabled(true);
		        } 
		        
		       if(e.getStateChange() == ItemEvent.DESELECTED) {
		    		btnGo.setEnabled(false);
		        };
		    }
		});
		checkBox.setForeground(Color.WHITE);
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(6, 105, 21, 23);
		frame.getContentPane().add(checkBox);
		
		JButton button_2 = new JButton("Go");
		button_2.setEnabled(false);
		button_2.setBounds(255, 105, 61, 23);
		frame.getContentPane().add(button_2);
		
		JLabel lblWouldYouLike = new JLabel("Would you like to convert one more");
		lblWouldYouLike.setForeground(Color.WHITE);
		lblWouldYouLike.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWouldYouLike.setBounds(33, 110, 212, 14);
		frame.getContentPane().add(lblWouldYouLike);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(WP_Success_Frame.class.getResource("/164917249-water-drops-wallpapers.jpg")));
		lblNewLabel.setBounds(0, 0, 342, 139);
		frame.getContentPane().add(lblNewLabel);
		
		
		frame.setUndecorated(true);
	}
}
