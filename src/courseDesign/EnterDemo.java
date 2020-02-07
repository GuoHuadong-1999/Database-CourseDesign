package courseDesign;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class EnterMyJFrame extends JFrame implements ActionListener {
	JTextField T_yhm = null;
	JPasswordField password1 = null;
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
		 */
		Font f = new Font("����", Font.BOLD, 25);
		Font f1 = new Font("����", Font.BOLD, 18);
		/**
		 * �û����ı�ǩ
		 */
		JLabel J_yhm = new JLabel("�û���");
		J_yhm.setFont(f);
		J_yhm.setBounds(new Rectangle(100, 80, 100, 50));
		// J_yhm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(J_yhm);
		/**
		 * ����ı�ǩ
		 */
		JLabel J_mm = new JLabel("��  ��");
		J_mm.setFont(f);
		J_mm.setBounds(new Rectangle(100, 180, 100, 50));
		// J_mm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(J_mm);
		/**
		 * �û����������
		 */
		T_yhm = new JTextField();
		T_yhm.setBounds(new Rectangle(250, 80, 300, 50));
		T_yhm.setFont(f1);
		p1.add(T_yhm);
		/**
		 * ����������
		 */
		password1 = new JPasswordField(20);
		password1.setEchoChar('*');
		password1.setFont(f1);
		password1.setBounds(new Rectangle(250, 180, 300, 50));
		p1.add(password1);
		/**
		 * ��¼��ť
		 */
		JPanel p2 = new JPanel();
		p2.setBounds(new Rectangle(150, 270, 400, 50));
		// p2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p2.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 5));
		JButton B_dl = new JButton("��¼");
		B_dl.addActionListener(this);
		B_dl.setFont(f);
		p2.add(B_dl);
		p1.add(p2);
		/**
		 * ע�ᰴť
		 */
		JButton B_zc = new JButton("ע��");
		B_zc.setFont(f);
		B_zc.addActionListener(this);
		p2.add(B_zc);

		dbProcess = new DbProcessDemo();
		/**
		 * ���ñ�����ɫ
		 */
		p1.setBackground(Color.orange);
		p2.setBackground(Color.orange);
	}
	public EnterMyJFrame() {
		super("��¼��");
		setup();
		setBounds(200, 200, 700, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ע��")) {
			/**
			 * ����ע����
			 */
			new EnrollDemo();
		} else if (e.getActionCommand().equals("��¼") && examine()) {
			/**
			 * ��¼ѧ����Ϣ����ϵͳ
			 */
			new DatabaseStudentMessage();

		} else {
			System.err.println("�˺Ż��������!");
			T_yhm.setText("");
			password1.setText("");
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
			int flag = 0;
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			while (rs.next()) {
				if (rs.getString("id").equals(T_yhm.getText())) {
					flag = 1;
				}
				if (rs.getString("password").equals(password1.getText()) && flag == 1) {
					return true;
				} else {
					flag = 0;
				}
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
}

public class EnterDemo {
	public static void main(String[] args) {
		EnterMyJFrame enter = new EnterMyJFrame();
	}
}
