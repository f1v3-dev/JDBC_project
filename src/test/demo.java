package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionListener;

public class demo extends JFrame  {
	private Connection conn = null;
	private JLabel state;
	// Table Header Name
	private String colName[] = { "��ǰ�ڵ�", "��ǰ", "����", "���" };
	// Table Data list (Header data, adding row)
	private DefaultTableModel model = new DefaultTableModel(colName, 0);
	// Create Table
	private JTable table = new JTable(model);
	private String row[] = new String[4];
	ImageIcon imageicon = new ImageIcon("ID.jpg");
	JLabel label = new JLabel(imageicon);
	JButton sbtn, ibtn, ubtn, dbtn;
	DAO dao = new DAO(); // �ܺ� Ŭ���� ȣ��
	
	int table_count = 0;
	// JFrame ������
	public demo() {
		
		
		setTitle("DataBase Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// BorderLayout��Ȱ���ػ����Ϸ�������Ʈ��ġ
		setLayout(new BorderLayout());
		
		// �ϴܺο������¹�ư������Ʈ���г�
		JPanel Btn_panel = new JPanel();
		JPanel panel = new JPanel();
		Btn_panel.setLayout(new FlowLayout());
		panel.setLayout(new FlowLayout());
		
		panel.add(label);
		
		// ��ȸ, ����, ����, ���� ��ư ���� �� �гο� ����
		sbtn = new JButton("��ȸ");
		sbtn.setBackground(Color.RED);
		sbtn.setForeground(Color.WHITE);
		Btn_panel.add(sbtn);

		ibtn = new JButton("����");
		ibtn.setSize(30, 30);
		ibtn.setBackground(Color.GREEN);
		ibtn.setForeground(Color.WHITE);
		Btn_panel.add(ibtn);

		ubtn = new JButton("����");
		ubtn.setBackground(Color.GREEN);
		ubtn.setForeground(Color.WHITE);
		Btn_panel.add(ubtn);

		dbtn = new JButton("����");
		dbtn.setBackground(Color.GREEN);
		dbtn.setForeground(Color.WHITE);
		Btn_panel.add(dbtn);


		
		// ��ȸ(select) ��ư �׼� ������
		sbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					//System.out.println(dao.conn.getAutoCommit());
					DefaultTableModel mod = (DefaultTableModel)table.getModel();
					mod.setNumRows(0);
					
					dao.conn.commit();
					Statement stmt = dao.conn.createStatement();
					ResultSet rset = stmt.executeQuery("select * from cafe order by code");
					
					//row = dao.readData();
					
					while (rset.next()) {
						// row ���б�
						for (int i = 1; i < 5; i++) {
							row[i - 1] = rset.getString(i);
						}
						System.out.println();
						// JTable�����
						model.addRow(row);
						//model.addRow(row);
					}

				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		
		

		// ����(insert) ��ư �׼� ������
		ibtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//PreparedStatement ps = null;
					//String SQL = "insert into cafe values(?, ?, ?, ?)";
					
					//setTitle("INSERT");
	
					JFrame jframe = new JFrame();
					JPanel jpanel = new JPanel();
					JTextField tf1 = new JTextField();
					JTextField tf2 = new JTextField();
					JTextField tf3 = new JTextField();
					JTextField tf4 = new JTextField();
					JTextArea ta = new JTextArea();
					JButton btn1;
					
					JLabel jl1 = new JLabel("CODE : ");
					JLabel jl2 = new JLabel("NAME : ");
					JLabel jl3 = new JLabel("PRICE : ");
					JLabel jl4 = new JLabel("COUNT : ");
					
					//jframe.setBounds(50, 50, 800, 400);
					jframe.setSize(800, 200);
					jframe.setVisible(true);
					
					jpanel.setLayout(null);
					jframe.add(jpanel);
					
					// �Է� ����
					tf1.setBounds(63, 25, 70, 25);
					jpanel.add(tf1); // �ڵ� �Է� ����
					tf2.setBounds(200, 25, 100, 25);
					jpanel.add(tf2); // �̸� �Է� ����
					tf3.setBounds(380, 25, 80, 25);
					jpanel.add(tf3); // ���� �Է� ����
					tf4.setBounds(550, 25, 70, 25);
					jpanel.add(tf4); // ���� �Է� ����
					
					
					jl1.setBounds(20, 21, 70, 30);
					jl2.setBounds(150, 21, 70, 30);
					jl3.setBounds(330, 21, 70, 30);
					jl4.setBounds(490, 21, 70, 30);
					
					jpanel.add(btn1=new JButton("INSERT"));
					btn1.setBounds(650, 21, 100, 30);
					
					jpanel.add(jl1);
					jpanel.add(jl2);
					jpanel.add(jl3);
					jpanel.add(jl4);
					
					btn1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == btn1) {
								String code = tf1.getText();
								String name = tf2.getText();
								int price = Integer.parseInt(tf3.getText());
								int count = Integer.parseInt(tf4.getText());
								dao.insertData(new Data(code, name, price, count));
								JOptionPane.showMessageDialog(null, "�Է� ����");
								tf1.setText("");
								tf2.setText("");
								tf3.setText("");
								tf4.setText("");
							}
						}
					});
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		
		// ����(update) ��ư �׼� ������
		ubtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {//PreparedStatement ps = null;
					//String SQL = "insert into cafe values(?, ?, ?, ?)";
					
					//setTitle("UPDATE");
	
					JFrame jframe = new JFrame();
					JPanel jpanel = new JPanel();
					JTextField tf1 = new JTextField();
					JTextField tf2 = new JTextField();
					JButton btn1;
					
					
					//jframe.setBounds(50, 50, 800, 400);
					jframe.setSize(400, 250);
					jframe.setVisible(true);
					
					jpanel.setLayout(null);
					jframe.add(jpanel);
					
					// �Է� ����
					tf1.setBounds(155, 25, 150, 25);
					jpanel.add(tf1); // �ڵ� �Է� ����
					tf2.setBounds(155, 70, 150, 25);
					jpanel.add(tf2);

					JLabel jl1 = new JLabel("������ �������� �ڵ� : ");
					jl1.setBounds(20, 21, 150, 30);
					
					JLabel jl2 = new JLabel("������ �������� ���� : ");
					jl2.setBounds(20, 66, 150, 30);
					
					
					jpanel.add(btn1=new JButton("UPDATE"));
					btn1.setBounds(150, 150, 100, 30);

					jpanel.add(jl1);
					jpanel.add(jl2);
					
					btn1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == btn1) {
								String code = tf1.getText();
								int price = Integer.parseInt(tf2.getText());
//								dao.updateData(new Data(price, code));
								
								if (dao.updateData(new Data(price, code))) {
									JOptionPane.showMessageDialog(null, "���� ����");
								}else {
									JOptionPane.showMessageDialog(null, "������ �������� �ڵ尡 �����ϴ�.");
								}
								tf1.setText("");
								tf2.setText("");
							}
						}
					});
					
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		
		// ����(delete) ��ư �׼� ������
		dbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//setTitle("DELETE");
					
					JFrame jframe = new JFrame();
					JPanel jpanel = new JPanel();
					JTextField tf1 = new JTextField();
					JButton btn1;
					
					
					//jframe.setBounds(50, 50, 800, 400);
					jframe.setSize(300, 200);
					jframe.setVisible(true);
					
					jpanel.setLayout(null);
					jframe.add(jpanel);
					
					// �Է� ����
					tf1.setBounds(150, 25, 100, 25);
					jpanel.add(tf1); // �ڵ� �Է� ����
					

					JLabel jl1 = new JLabel("������ �������� �ڵ� : ");
					jl1.setBounds(20, 21, 150, 30);
					
					jpanel.add(btn1=new JButton("DELETE"));
					btn1.setBounds(150, 100, 100, 30);

					jpanel.add(jl1);
					
					btn1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == btn1) {
								String code = tf1.getText();
								if (dao.deleteData(code)) {
									JOptionPane.showMessageDialog(null, "���� ����");
								}else {
									JOptionPane.showMessageDialog(null, "������ �������� �ڵ尡 �����ϴ�.");
								}
								tf1.setText("");
							}
						}
					});
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});

		// DB �дº�
		// DB ������¿��
		state = new JLabel();
		state.setText("Oracle DB �����׽�Ʈ");
		// JFrame����ġ�����ڸ�Ȱ���Ѱ�������ġ����
		add(state, BorderLayout.NORTH);
		// JScrollPane : ȭ�鿡�Ѿ��콺ũ�ѹٰ�����
		add(new JScrollPane(table), BorderLayout.CENTER);

		add(Btn_panel, BorderLayout.SOUTH);
		add(panel, BorderLayout.WEST);
		
		
		try {
			// Quary
			Statement stmt = dao.conn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from cafe order by code");
			
			while (rset.next()) {
				// row ���б�
				for (int i = 1; i < 5; i++) {
					row[i - 1] = rset.getString(i);
					table_count++;
				}
				System.out.println();
				// JTable�����
				model.addRow(row);
			}
			
			state.setText("DB �б⼺��");
		} catch (SQLException e) {
			e.printStackTrace();
			state.setText("DB �б����" + e.toString());
		}
		setSize(1300, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new demo();
	}
}
