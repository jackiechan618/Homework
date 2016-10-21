import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Double;

public class Calculator extends JFrame {
	private double x,y,sum;
	private int operation_flag = 0, clear_flag = 0, inputfinish_flag = 0;
	
	public Calculator(String title, int width, int height, Color col){		
		super(title);
		
		Container con = getContentPane();		
		con.setBackground(col);
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField tf = new JTextField();
		tf.setBackground(Color.BLACK);
		tf.setForeground(Color.GREEN);
		tf.setPreferredSize(new Dimension(width,height/4));
		tf.setFont(new Font("Helvetica", Font.PLAIN, 52));
		con.add(tf,BorderLayout.NORTH);
		
        /* ***** keyboard's layout ***** */
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,3));
		p.setPreferredSize(new Dimension(width*3/4,height*3/4));
		JButton b1 = new JButton("1");
		b1.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}					
				tf.setText(tf.getText()+"1");
				}
			});
		JButton b2 = new JButton("2");
		b2.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+"2");
			}
			});
		JButton b3 = new JButton("3");
		b3.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+"3");
			}
			});
		JButton b4 = new JButton("4");
		b4.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+"4");
			}
			});
		JButton b5 = new JButton("5");
		b5.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+"5");
			}
			});
		JButton b6 = new JButton("6");
		b6.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+"6");
			}
			});
		JButton b7 = new JButton("7");
		b7.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+"7");
			}
			});
		JButton b8 = new JButton("8");
		b8.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+"8");
			}
			});
		JButton b9 = new JButton("9");
		b9.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+"9");
			}
			});
		JButton b0 = new JButton("0");
		b0.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+"0");
			}
			});
		JButton b11 = new JButton(".");
		b11.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(clear_flag == 1){ 
					tf.setText("");
					clear_flag = 0;
				}
				if(inputfinish_flag == 1){ 
					tf.setText("");
					inputfinish_flag = 0;
				}
				tf.setText(tf.getText()+".");
			}
			});
		JButton b12 = new JButton("+");
		b12.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				x = Double.parseDouble(tf.getText());
				operation_flag = 1;
				inputfinish_flag = 1;
			}
		});
		JButton b13 = new JButton("-");
		b13.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				x = Double.parseDouble(tf.getText());
				operation_flag = 2;
				inputfinish_flag = 1;
			}
		});
		JButton b14 = new JButton("x");
		b14.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				x = Double.parseDouble(tf.getText());
				operation_flag = 3;
				inputfinish_flag = 1;
			}
		});
		JButton b15 = new JButton("/");
		b15.setFont(new Font("Helvetica", Font.PLAIN, 28));
		b15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				x = Double.parseDouble(tf.getText());
				operation_flag = 4;
				inputfinish_flag = 1;
			}
		});		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(b0);
		p.add(b11);
		p.add(b12);
		p.add(b13);
		p.add(b14);
		p.add(b15);
		p.setForeground(new Color(90,0,128));
		con.add(p,BorderLayout.CENTER);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2,1));
		
		JButton but1 = new JButton("AC");
		but1.setFont(new Font("Helvetica", Font.PLAIN, 28));
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
				{tf.setText("");}
			});
		JButton but2 = new JButton("=");
		but2.setFont(new Font("Helvetica", Font.PLAIN, 28));
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(operation_flag != 0){
					y = Double.parseDouble(tf.getText());
					if(operation_flag == 1){
						sum = x + y;					
						tf.setText(Double.toString(sum));
					}
					else if(operation_flag == 2){
						sum = x - y;					
						tf.setText(Double.toString(sum));
					}
					else if(operation_flag == 3){
						sum = x * y;					
						tf.setText(Double.toString(sum));
					}
					else if(operation_flag == 4){
						if(y != 0){
							sum = x / y;					
							tf.setText(Double.toString(sum));
						}
						else
							tf.setText("error");			
					}
					operation_flag = 0;
					clear_flag = 1;
				}
			}
		});
		p2.add(but1);
		p2.add(but2);
		p2.setForeground(new Color(90,0,128));
		con.add(p2,BorderLayout.EAST);

		
		setVisible(true);
	}
	
	public static void main(String [] a){
		Calculator cal = new Calculator ("Calculator", 600, 600, Color.lightGray);
	}
}
