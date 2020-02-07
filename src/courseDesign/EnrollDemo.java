package courseDesign;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class EnrollDemo extends JFrame {
	/**
	 * �����
	 */
	JTextField T_yhm = null;
	JPasswordField password1 = null;
	JPasswordField password2 = null;
	private static DbProcessDemo dbProcess;// �������ݿ�
	private void setup() {
		/** 
		  * ��������������
		 */
		JPanel p1 = new JPanel();
		add(p1);
		p1.setLayout(null);
		/**
		 * ����
		 * */
		Font f = new Font("����", Font.BOLD, 25);
		Font f1 = new Font("����", Font.BOLD, 18);
		/**
		 * �û����ı�ǩ
		 * */
		JLabel J_yhm = new JLabel("�û���");
		J_yhm.setFont(f);
		J_yhm.setBounds(new Rectangle(100, 50, 100, 50));
		//J_yhm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(J_yhm);
		/**
		 * ����ı�ǩ
		 * */
		JLabel J_mm = new JLabel("����");
		J_mm.setFont(f);
		J_mm.setBounds(new Rectangle(100, 110, 100, 50));
		//J_mm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(J_mm);
		/**
		 * ȷ������ı�ǩ
		 * */
		JLabel J_qrmm = new JLabel("ȷ������");
		J_qrmm.setFont(f);
		J_qrmm.setBounds(new Rectangle(100, 170, 130, 50));
		//J_qrmm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(J_qrmm);
		/**
		 * �û����������
		 * */
		T_yhm = new JTextField();
		T_yhm.setFont(f1);
		T_yhm.setBounds(new Rectangle(250, 50, 300,50));
		p1.add(T_yhm);
		/**
		 * ����������
		 */
		password1=new JPasswordField(20);
		password1.setEchoChar('*');
		password1.setFont(f1);
		password1.setBounds(new Rectangle(250, 110, 300, 50));
		p1.add(password1);
		/**
		 * ȷ������������
		 */
		password2=new JPasswordField(20);
		password2.setEchoChar('*');
		password2.setFont(f1);
		password2.setBounds(new Rectangle(250, 170, 300, 50));
		//password2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(password2);
		/**
		 * ע�ᰴť
		 */
		JPanel p2 = new JPanel();
		p2.setBounds(new Rectangle(150, 270,400,50));
		//p2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,60,5));
		p1.add(p2);
		JButton B_zc = new JButton("ע��");
		B_zc.setFont(f);
		p2.add(B_zc);
		/**
		 * Ϊע�ᰴť����������
		 */
		B_zc.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(examine()) {
					System.out.println("��ϲ��ע��ɹ���");
					setVisible(false);
				}
			}

			private boolean examine() {
				// TODO Auto-generated method stub
				try {
					// ������ѯ����
					String sql = "select * from user;";
					System.out.println("queryAllProcess(). sql = " + sql);

					dbProcess.connect();
					ResultSet rs = dbProcess.executeQuery(sql);
					// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
					boolean flag = true;
					while (rs.next()) {
						if(rs.getString("id").equals(T_yhm.getText())) {
							flag = false;
							System.err.println("��Ǹ���û����Ѵ��ڣ����������룡");
							T_yhm.setText("");
							return flag;
						}
					}
					/**
					 * ����û��������ڣ��������Ϣ
					 */
					if(flag&&password1.getText().equals(password2.getText())) {
						insertProcess();
						return true;
					}else if(!password1.getText().equals(password2.getText())) {
						System.err.println("��Ǹ���������벻��ͬ�����������룡");
						password1.setText("");
						password2.setText("");
						return false;
					}

					dbProcess.disconnect();// �Ͽ�����
				} catch (SQLException sqle) {
					System.out.println("sqle = " + sqle);
					JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					System.out.println("e = " + e);
					JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
				}
				return false;
			}

			private void insertProcess() {
				// TODO Auto-generated method stub
				String id = T_yhm.getText();
				String password = password1.getText();
				
				// ������������
				String sql = "insert into user values('";
				sql = sql + id + "','";
				sql = sql + password + "');";

				System.out.println("insertProcess(). sql = " + sql);
				try {
					if (dbProcess.executeUpdate(sql) < 1) {
						System.out.println("insertProcess(). insert database failed.");
					}
				} catch (Exception e) {
					System.out.println("e = " + e);
					JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		dbProcess = new DbProcessDemo();
		/**
		 * ���ñ�����ɫ
		 */
		p1.setBackground(Color.orange);
		p2.setBackground(Color.orange);
	}
	public EnrollDemo(){
		super("ע����");
		setup();
		setBounds(200, 200, 700, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
