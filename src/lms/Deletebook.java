package lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Deletebook extends JFrame {

	private JPanel contentPane;
	private JTextField BOOK_ID;
	private JTextField BOOK_NAME;
	private JTextField AUTHOR;
	private JTextField PUBLICATION;
	private JTextField TOTAL_BOOKS;
	private JTextField COURSE;
	private JTextField YEAR;
	private JTextField EDITION;
	private JTextField SEMESTER;
	private JTextField BRANCH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deletebook frame = new Deletebook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Deletebook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DELETE BOOK FROM LIBRARY");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(179, 11, 389, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BOOK ID-");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(27, 77, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		BOOK_ID = new JTextField();
		BOOK_ID.setBounds(133, 76, 170, 20);
		contentPane.add(BOOK_ID);
		BOOK_ID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("BOOK NAME-");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(27, 144, 110, 14);
		contentPane.add(lblNewLabel_2);
		
		BOOK_NAME = new JTextField();
		BOOK_NAME.setEditable(false);
		BOOK_NAME.setBounds(133, 142, 170, 20);
		contentPane.add(BOOK_NAME);
		BOOK_NAME.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("AUTHOR-");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(27, 213, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		AUTHOR = new JTextField();
		AUTHOR.setEditable(false);
		AUTHOR.setBounds(133, 211, 170, 20);
		contentPane.add(AUTHOR);
		AUTHOR.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("PUBLICATION-");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(27, 274, 97, 14);
		contentPane.add(lblNewLabel_4);
		
		PUBLICATION = new JTextField();
		PUBLICATION.setEditable(false);
		PUBLICATION.setBounds(133, 271, 170, 20);
		contentPane.add(PUBLICATION);
		PUBLICATION.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("EDITION-");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(27, 333, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		TOTAL_BOOKS = new JTextField();
		TOTAL_BOOKS.setEditable(false);
		TOTAL_BOOKS.setBounds(455, 118, 146, 20);
		contentPane.add(TOTAL_BOOKS);
		TOTAL_BOOKS.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("TOTAL BOOKS-");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(328, 120, 117, 14);
		contentPane.add(lblNewLabel_6);
		
		COURSE = new JTextField();
		COURSE.setEditable(false);
		COURSE.setBounds(455, 164, 146, 20);
		contentPane.add(COURSE);
		COURSE.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("COURSE-");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_7.setBounds(328, 170, 103, 14);
		contentPane.add(lblNewLabel_7);
		
		YEAR = new JTextField();
		YEAR.setEditable(false);
		YEAR.setBounds(455, 211, 146, 20);
		contentPane.add(YEAR);
		YEAR.setColumns(10);
		
		EDITION = new JTextField();
		EDITION.setEditable(false);
		EDITION.setBounds(133, 331, 170, 20);
		contentPane.add(EDITION);
		EDITION.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("YEAR-");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_8.setBounds(328, 217, 74, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("SEMESTER-");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_9.setBounds(328, 273, 103, 14);
		contentPane.add(lblNewLabel_9);
		
		SEMESTER = new JTextField();
		SEMESTER.setEditable(false);
		SEMESTER.setBounds(455, 271, 146, 20);
		contentPane.add(SEMESTER);
		SEMESTER.setColumns(10);
		
		JButton btnNewButton = new JButton("DELETE BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "DELETE FROM BOOKS WHERE BOOK_ID=?";
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, BOOK_ID.getText());
                    int i = st.executeUpdate();
                    if(i>0) {
                    	setVisible(false);
                    	JOptionPane.showMessageDialog(null, " SUCCESSFULLY   DELETE    "+ BOOK_NAME.getText()  +"   FROM  LIBRARY");	
                    	setVisible(false);
                    	Menu frame = new Menu ();
    					frame.setVisible(true);
    					
    					
                   	 	
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null, "somewent wrong! TRY AGAIN.....");	
                    	}
                    
 	            	
    	            
				}
                    
                
				 catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 0, 255));
		btnNewButton.setBounds(249, 396, 139, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<<<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Menu frame = new Menu();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setForeground(new Color(255, 0, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(426, 396, 110, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT * FROM BOOKS WHERE BOOK_ID=?";
		    		
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, BOOK_ID.getText());
    	            ResultSet rs  = st.executeQuery();
                    if(rs.next()) {
                    	String s=rs.getString(1);
                    	String s1=rs.getString(2);
                    	String s2=rs.getString(3);
                    	String s3=rs.getString(4);
                    	String s4=rs.getString(5);
                    	String s5=rs.getString(6);
                    	String s6=rs.getString(7);
                    	String s7=rs.getString(8);
                    	String s8=rs.getString(9);
                    	String s9=rs.getString(10);
                    	
                    	
                    	BOOK_ID.setText(s);
                    	BOOK_NAME.setText(s1);
                    	AUTHOR.setText(s2);
                    	PUBLICATION.setText(s3);
                    	EDITION.setText(s4);
                    	TOTAL_BOOKS.setText(s5);
                    	COURSE.setText(s6);
                    	YEAR.setText(s7);
                    	SEMESTER.setText(s8);
                    	BRANCH.setText(s9);
                    	
                    
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null, "ENTERIES ARE NOT MATCHED WITH DATABASE !"
                    				+ "PLEASE ENTER CORRECT DETAILS");	
                    	}
                    
 	            	
    	            
				}
                    
                
				 catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(123, 104, 238));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(380, 75, 126, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_10 = new JLabel("BRANCH-");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_10.setBounds(328, 318, 103, 14);
		contentPane.add(lblNewLabel_10);
		
		BRANCH = new JTextField();
		BRANCH.setEditable(false);
		BRANCH.setBounds(455, 316, 146, 20);
		contentPane.add(BRANCH);
		BRANCH.setColumns(10);
	}
}
