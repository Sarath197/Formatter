package com.grepthor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PW_frame {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	String req,req1;
	static String viewPW;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PW_frame window = new PW_frame();
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
	public PW_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(460, 240, 487, 248);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Source");
		label.setForeground(Color.WHITE);
		label.setBounds(29, 75, 46, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(109, 72, 182, 20);
		frame.getContentPane().add(textField);
		
		JButton button = new JButton("Browse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf File", "pdf");
		        fileChooser.addChoosableFileFilter(filter);
				fileChooser.showOpenDialog(button);
				if(fileChooser.getSelectedFile()!=null) {
					textField.setText(textField.getText()+fileChooser.getSelectedFile());
					req=textField.getText();	
					
				}
				else {
					textField.setText("");
				}
			}
		});
		button.setBounds(301, 71, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("clear");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		button_1.setBounds(400, 71, 77, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("Destination");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(29, 128, 70, 14);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 125, 182, 20);
		frame.getContentPane().add(textField_1);
		
		JButton button_2 = new JButton("Browse");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				JFileChooser fileChooser = new JFileChooser(".");
		        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        fileChooser.showSaveDialog(button_2);
		        if(fileChooser.getSelectedFile()!=null) {
					textField_1.setText(textField_1.getText()+fileChooser.getSelectedFile());
					req1=textField_1.getText();	
					
				}
				else {
					textField_1.setText("");
				}
			}
		});
		button_2.setBounds(301, 124, 89, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("clear");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
			}
		});
		button_3.setBounds(400, 124, 77, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Convert");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

				
				try {
					
					String content = pdftoText(req);

					File file = new File(req1+"/gss.docx");
					viewPW=req1+"/gss.docx";

					if (!file.exists()) {
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(content);
					bw.close();

					System.out.println("Done");
					//bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				PW_Success_Frame pswf=new PW_Success_Frame();
				pswf.frame.setVisible(true);
				
			}
		});
		button_4.setBounds(157, 177, 89, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("cancel");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main_frame main_frame = new Main_frame();
				main_frame.frame.setVisible(true);
			}
		});
		button_5.setBounds(287, 177, 89, 23);
		frame.getContentPane().add(button_5);
		
		JLabel label_2 = new JLabel("All Rights Reserved @ Grepthor Software Solutions");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(10, 223, 352, 14);
		frame.getContentPane().add(label_2);
		
		JLabel lblPdfToWord = new JLabel("PDF TO WORD");
		lblPdfToWord.setForeground(Color.WHITE);
		lblPdfToWord.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 16));
		lblPdfToWord.setBounds(179, 11, 212, 14);
		frame.getContentPane().add(lblPdfToWord);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Main_frame main_frame = new Main_frame();
				main_frame.frame.setVisible(true);
			}
		});
		btnX.setFocusPainted(false);
		btnX.setBackground(new Color(255, 69, 0));
		btnX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnX.setBounds(441, 0, 46, 23);
		frame.getContentPane().add(btnX);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PW_frame.class.getResource("/Flying-Owl-Desktop-Wallpaper-HD.jpg")));
		lblNewLabel.setBounds(0, 0, 487, 248);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setUndecorated(true);
	}
	static String pdftoText(String fileName) {
		PDFParser parser;
		String parsedText = null;
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		File file = new File(fileName);
		if (!file.isFile()) {
			System.err.println("File " + fileName + " does not exist.");
			return null;
		}
		try {
			parser = new PDFParser(new RandomAccessFile(file,"r"));
			
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			return null;
		}
		try {
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (Exception e) {
			System.err
			.println("An exception occured in parsing the PDF Document."
					+ e.getMessage());
		} finally {
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return parsedText;
	}
}
