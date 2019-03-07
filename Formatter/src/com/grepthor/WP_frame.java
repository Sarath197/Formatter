package com.grepthor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class WP_frame {

	JFrame frame;
	static JTextField textField;
	private JTextField textField_1;
	public static String req;
	public static String req1,viewWP;

	/**
	 * Launch the application.
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WP_frame window = new WP_frame();
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
	public WP_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionText);
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);




		/* Source */


		JLabel label = new JLabel("Source");
		label.setForeground(Color.WHITE);
		label.setBounds(10, 62, 46, 14);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(90, 59, 182, 20);
		frame.getContentPane().add(textField);

		JButton button = new JButton("Browse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Word File", "docx");
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
		button.setBounds(282, 58, 89, 23);
		frame.getContentPane().add(button);

		JButton btnClear_1 = new JButton("clear");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnClear_1.setBounds(381, 58, 77, 23);
		frame.getContentPane().add(btnClear_1);
		/* __________________________________________________________________ */

		/* DESTINATION */

		JLabel label_1 = new JLabel("Destination");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(10, 115, 70, 14);
		frame.getContentPane().add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 112, 182, 20);
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
		button_2.setBounds(282, 111, 89, 23);
		frame.getContentPane().add(button_2);

		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
			}
		});
		btnClear.setBounds(381, 111, 77, 23);
		frame.getContentPane().add(btnClear);

		/* _________________________________________________________ */

		/* CONVERT */

		JButton button_4 = new JButton("Convert");		
		button_4.setBounds(138, 165, 89, 23);
		frame.getContentPane().add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String ext = FilenameUtils.getExtension(req);
				String output = readDocxFile(req);
				if ("docx".equalsIgnoreCase(ext)) {
					output = readDocxFile(req);
				}
				else {
					System.out.println("INVALID FILE TYPE. ONLY .doc and .docx are permitted.");
				}
				try {
					writePdfFile(output);
				} catch (FileNotFoundException | DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				WP_Success_Frame wpsf=new WP_Success_Frame();
				wpsf.frame.setVisible(true);
			}
			
		});



		JButton button_5 = new JButton("cancel");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main_frame main_frame = new Main_frame();
				main_frame.frame.setVisible(true);
			}
		});
		button_5.setBounds(270, 165, 89, 23);
		frame.getContentPane().add(button_5);

		JLabel label_2 = new JLabel("All Rights Reserved @ Grepthor Software Solutions");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(7, 234, 352, 14);
		frame.getContentPane().add(label_2);

		JLabel lblWordToPdf = new JLabel("WORD TO PDF");
		lblWordToPdf.setForeground(Color.WHITE);
		lblWordToPdf.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 16));
		lblWordToPdf.setBounds(175, 11, 212, 20);
		frame.getContentPane().add(lblWordToPdf);

		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main_frame main_frame = new Main_frame();
				main_frame.frame.setVisible(true);
			}
		});
		btnX.setFocusPainted(false);
		btnX.setBackground(new Color(255, 69, 0));
		btnX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnX.setBounds(431, 0, 46, 23);
		frame.getContentPane().add(btnX);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(WP_frame.class.getResource("/Flying-Owl-Desktop-Wallpaper-HD.jpg")));
		lblNewLabel.setBounds(0, 0, 477, 248);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(460, 240, 477, 248);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setUndecorated(true);
	}
	
	
	
	public static String readDocFile(String fileName) {
		String output = ""; 
		try {
			File file = new File(fileName); 
			FileInputStream fis = new FileInputStream(file.getAbsolutePath()); 
			HWPFDocument doc = new HWPFDocument(fis); 
			WordExtractor we = new WordExtractor(doc); 
			String[] paragraphs = we.getParagraphText(); 
			for (String para : paragraphs) 
			{ 
				output =output + "\n" + para.toString() + "\n"; 
			} 
			fis.close(); 
		} 
		catch (Exception e)
		{ 
			e.printStackTrace(); 
		} 
		return output; 
	}


	public static String readDocxFile(String fileName) {
		String output = "";
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			XWPFDocument document = new XWPFDocument(fis);
			List<XWPFParagraph> paragraphs = document.getParagraphs();
			for (XWPFParagraph para : paragraphs) {
				output = output + "\n" + para.getText() + "\n";
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	public static void writePdfFile(String output) throws FileNotFoundException, DocumentException {
		File file = new File(req1+"/gss.pdf");
		viewWP=req1+"/gss.pdf";
		FileOutputStream fileout = new FileOutputStream(file);
		Document document = new Document();
		PdfWriter.getInstance(document, fileout);
		document.addTitle("PDF");
		document.open();
		String[] splitter = output.split("\\n");
		for (int i = 0; i < splitter.length; i++) {
			Chunk chunk = new Chunk(splitter[i]);
			
			document.add(chunk);
			Paragraph paragraph = new Paragraph();
			paragraph.add("");
			document.add(paragraph);
		}
		document.close();
	}
}

	
	

