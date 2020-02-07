package courseDesign;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;


public class Change_School extends JFrame implements ActionListener{
	//�����ļ���
	Vector<JPanel> jpanel = new Vector<JPanel>();
	/**
	 * ���ݿ�����
	 */
	private static DbProcessDemo dbProcess;
	/**
	 * ���
	 */
	Vector changeVector =null;
	Vector changeTitleVector = null;
	JTable changeJTable = null;// ���
	JScrollPane changeJScrollPane = null;// ������
	JTableHeader changeHead = null;// ���������
	/**
	 * �����б�ѡ�е�����
	 */
	String SelectQueryFieldStr = "��¼��";
	/**
	 * ��ѯ�ֶ�
	 */
	JComboBox<String> jCBSelectQueryField = null;
	/**
	 * ����
	 * */
	Font f = new Font("����", Font.BOLD, 25);
	Font f1 = new Font("����", Font.BOLD, 18);
	Font f2 = new Font("����", Font.BOLD, 15);
	/**
	 * ����
	 */
	JPanel p1 = null;
	JPanel p2 = null;
	JPanel p3 = null;
	JPanel p4 = null;
	JPanel p5 = null;
	JPanel p6 = null;
	JPanel p7 = null;
	JPanel p8 = null;
	JPanel p9 = null;
	JPanel p10 = null;
	JPanel p11 = null;
	JPanel p12 = null;
	JPanel p13 = null;
	JPanel p14 = null;
	JPanel p15 = null;
	/**
	 * ��ǩ
	 */
	JLabel L_xjbgxxb = null;
	JLabel L_xzcxzd = null;
	JLabel L_equal = null;
	JLabel L_id = null;
	JLabel L_rec_time = null;
	JLabel L_description = null;
	JLabel L_studentid = null;
	JLabel L_changes = null;
	/**
	 * �ı���	
	 */
	
	JTextField T_xzcxzd = null;
	JTextField T_id = null;
	JTextField T_rec_time = null;
	JTextField T_description = null;
	JTextField T_studentid = null;
	JTextField T_changes = null;
	/**
	 * ��ť
	 */
	JButton B_cx = null;
	JButton B_cxsyjl = null;
	JButton B_cr = null;
	JButton B_gx = null;
	JButton B_scdqjl = null;
	JButton B_scsyjl = null;
	JButton B_qksrk = null;
	
	private void setup() {
		/**
		 * �Ű�
		 */
		p1 = new JPanel();
		p1.setLayout(null);
		add(p1);
		
		p2 = new JPanel();
		p2.setBounds(new Rectangle(0, 0, 700, 300));
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(new Rectangle(0, 300, 500, 400));
		p3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p1.add(p3);
		
		p4 = new JPanel();
		p4.setLayout(new GridLayout(6, 1));
		p4.setBounds(new Rectangle(500, 300, 200, 400));
		p4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p1.add(p4);
		/**
		 * ���
		 */
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5.setBounds(new Rectangle(0, 0, 700, 40));
		L_xjbgxxb = new JLabel("ѧ�������Ϣ��");
		L_xjbgxxb.setFont(f);
		p5.add(L_xjbgxxb);
		p2.add(p5);
		
		changeVector = new Vector();
		changeTitleVector = new Vector();

		changeTitleVector.add("��¼��");
		changeTitleVector.add("ѧ��");
		changeTitleVector.add("������");
		changeTitleVector.add("��¼ʱ��");
		changeTitleVector.add("����");

		// defaultTableModel = new DefaultTableModel();
		changeJTable = new JTable(changeVector, changeTitleVector);
		changeJTable.setFont(f2);
		changeHead = changeJTable.getTableHeader(); // �������������
		changeHead.setFont(f);

		changeJScrollPane = new JScrollPane(changeJTable);
		changeJScrollPane.setBounds(new Rectangle(0, 40, 700, 260));
		// �ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		changeJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		changeJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		p2.add(changeJScrollPane);
		// Ϊ�����Ӽ�����
		changeJTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) changeVector.get(row);

				T_id.setText((String) v.get(0));// ��¼��
				T_studentid.setText((String) v.get(1));// ѧ��
				T_changes.setText((String) v.get(2));// ������
				T_rec_time.setText((String) v.get(3));// ��¼ʱ��
				T_description.setText((String) v.get(4));// ����
			}
		});
		/**
		 * �������
		 */
		p3.setLayout(new GridLayout(4, 1));
		p6 = new JPanel();
		p6.setLayout(null);
		p7 = new JPanel();
		p7.setLayout(null);
		p8 = new JPanel();
		p8.setLayout(null);
		p9 = new JPanel();
		p9.setLayout(null);
		p3.add(p6);
		p3.add(p7);
		p3.add(p8);
		p3.add(p9);
		
		L_xzcxzd = new JLabel("ѡ���ѯ�ֶ�");
		L_xzcxzd.setBounds(new Rectangle(20, 30, 120, 40));
		L_equal = new JLabel("=");
		L_equal.setBounds(new Rectangle(290, 30, 30, 40));
		L_id = new JLabel("��¼��");
		L_id.setForeground(Color.red);
		L_id.setBounds(new Rectangle(20, 30, 100, 40));
		L_rec_time = new JLabel("��¼ʱ��");
		L_rec_time.setBounds(new Rectangle(240, 30, 120, 40));
		L_description = new JLabel("����");
		L_description.setBounds(new Rectangle(20, 30, 100, 40));
		L_studentid = new JLabel("ѧ��");
		L_studentid.setBounds(new Rectangle(240, 30, 100, 40));
		L_changes = new JLabel("�������");
		L_changes.setBounds(new Rectangle(20, 30, 120, 40));
		
		T_xzcxzd = new JTextField();
		T_xzcxzd.setBounds(new Rectangle(330, 30, 110, 40));
		T_id = new JTextField();
		T_id.setBounds(new Rectangle(130, 30, 110, 40));
		T_rec_time = new JTextField();
		T_rec_time.setBounds(new Rectangle(350, 30, 110, 40));
		T_description = new JTextField();
		T_description.setBounds(new Rectangle(130, 30, 220, 40));
		T_studentid = new JTextField();
		T_studentid.setBounds(new Rectangle(350, 30, 110, 40));
		T_changes = new JTextField();
		T_changes.setBounds(new Rectangle(130, 30, 110, 40));
		//����
		p6.add(L_xzcxzd);
		p6.add(L_equal);
		p7.add(L_id);
		p7.add(L_rec_time);
		p8.add(L_changes);
		p8.add(L_studentid);
		p9.add(L_description);
		
		p6.add(T_xzcxzd);
		p7.add(T_id);
		p7.add(T_rec_time);
		p8.add(T_changes);
		p8.add(T_studentid);
		p9.add(T_description);
		
		/**
		 * �����б�
		 */
		jCBSelectQueryField = new JComboBox<String>();// ��ѯ�ֶ�
		jCBSelectQueryField.setFont(f1);
		jCBSelectQueryField.addItem("��¼��");
		jCBSelectQueryField.addItem("ѧ��");
		jCBSelectQueryField.addItem("������");
		jCBSelectQueryField.addItem("��¼ʱ��");
		jCBSelectQueryField.addItem("����");
		/**
		 * getItem()��������ô����˴��¼���ѡ��÷����ķ���ֵΪ Object �͡�
		 * 
		 * getStateChange()��������ô˴��¼������ͣ�������ȡ��ԭ��ѡ�����ѡ��״̬�����ģ�������ѡ����ѡ����ģ��÷����ķ���ֵΪ int
		 * �ͣ�����ͨ�� ItemEvent �������¾�̬�����жϴ˴��¼��ľ������ͣ�
		 * 
		 * SELECTED������˴��¼�����ѡ�� ��ѡ����ġ�
		 * 
		 * DESELECTED������˴��¼�����ȡ��ԭ��ѡ�����ѡ��״̬�����ġ�
		 */
		jCBSelectQueryField.addItemListener(new ItemListener() {// �������¼�����
			public void itemStateChanged(ItemEvent event) {
				switch (event.getStateChange()) {
				case ItemEvent.SELECTED:
					SelectQueryFieldStr = (String) event.getItem();
					System.out.println("ѡ�У�" + SelectQueryFieldStr);
					break;
				case ItemEvent.DESELECTED:
					System.out.println("ȡ��ѡ�У�" + event.getItem());
					break;
				}
			}
		});
		jCBSelectQueryField.setBounds(new Rectangle(160, 30, 110, 40));
		p6.add(jCBSelectQueryField);
		/**
		 * ��������
		 */
		L_xzcxzd.setFont(f1);
		L_equal.setFont(f1);
		L_id.setFont(f);
		L_rec_time.setFont(f);
		L_description.setFont(f);
		L_studentid.setFont(f);
		L_changes.setFont(f);
		T_xzcxzd.setFont(f1);
		T_id.setFont(f1);
		T_rec_time.setFont(f1);
		T_description.setFont(f1);
		T_studentid.setFont(f1);
		T_changes.setFont(f1);
		/**
		 * ��Ӱ�ť
		 */
		B_cx = new JButton("��ѯ");
		B_cx.setFont(f);
		B_cxsyjl = new JButton("��ѯ���м�¼");
		B_cxsyjl.setFont(f);
		B_cr = new JButton("����");
		B_cr.setFont(f);
		B_gx = new JButton("����");
		B_gx.setFont(f);
		B_scdqjl = new JButton("ɾ����ǰ��¼");
		B_scdqjl.setFont(f);
		B_scsyjl = new JButton("ɾ�����м�¼");
		B_scsyjl.setFont(f);
		B_qksrk = new JButton("��������");
		B_qksrk.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				T_xzcxzd.setText("");
				T_id.setText("");
				T_rec_time.setText("");
				T_description.setText("");
				T_studentid.setText("");
				T_changes.setText("");
			}
			
		});
		B_qksrk.setFont(f);
		
		p10 = new JPanel();
		p10.setLayout(new FlowLayout(FlowLayout.CENTER));
		p11 = new JPanel();
		p11.setLayout(new FlowLayout(FlowLayout.CENTER));
		p12 = new JPanel();
		p12.setLayout(new FlowLayout(FlowLayout.CENTER));
		p13 = new JPanel();
		p13.setLayout(new FlowLayout(FlowLayout.CENTER));
		p14 = new JPanel();
		p14.setLayout(new FlowLayout(FlowLayout.CENTER));
		p15 = new JPanel();
		p15.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		p10.add(B_cr);
		p10.add(B_gx);
		p11.add(B_cx);
		p12.add(B_cxsyjl);
		p13.add(B_scdqjl);
		p14.add(B_scsyjl);
		p15.add(B_qksrk);
		
		p4.add(p10);
		p4.add(p11);
		p4.add(p12);
		p4.add(p13);
		p4.add(p14);
		p4.add(p15);
		/**
		 * ����ť��Ӽ�����
		 */
		B_cx.addActionListener(this);
		B_cxsyjl.addActionListener(this);
		B_cr.addActionListener(this);
		B_gx.addActionListener(this);
		B_scdqjl.addActionListener(this);
		B_scsyjl.addActionListener(this);
		
		dbProcess = new DbProcessDemo();
		/**
		 * ���������뵽����jpanel��
		 */
		jpanel.add(p5);
		jpanel.add(p6);
		jpanel.add(p7);
		jpanel.add(p8);
		jpanel.add(p9);
		jpanel.add(p10);
		jpanel.add(p11);
		jpanel.add(p12);
		jpanel.add(p13);
		jpanel.add(p14);
		jpanel.add(p15);
		/**
		 * ���ñ�����ɫ
		 */
		Iterator<JPanel> interator = jpanel.iterator();
	    while(interator.hasNext()) {
	    	Object obj = interator.next();
	    	JPanel panel = (JPanel) obj;
	    	panel.setBackground(Color.orange);
	    }
		changeHead.setBackground(Color.orange);
		changeJTable.setBackground(Color.orange);
	}
	public Change_School() {
		super("ѧ�������Ϣ��");
		setup();
		setBounds(200, 200, 712, 735);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("��ѯ") && !T_xzcxzd.getText().isEmpty()) {
			System.out.println("actionPerformed(). ��ѯ");
			String sQueryField = T_xzcxzd.getText().trim();
			queryProcess(sQueryField);
			T_xzcxzd.setText("");
		} else if (e.getActionCommand().equals("��ѯ���м�¼")) {
			System.out.println("actionPerformed(). ��ѯ���м�¼");
			queryAllProcess();
		} else if (e.getActionCommand().equals("����") && !T_id.getText().isEmpty() && !T_studentid.getText().isEmpty()
				&& !T_changes.getText().isEmpty() && !T_rec_time.getText().isEmpty() && !T_description.getText().isEmpty()) {
			System.out.println("actionPerformed(). ����");
			insertProcess();
		} else if (e.getActionCommand().equals("����") && !T_id.getText().isEmpty() && !T_studentid.getText().isEmpty()
				&& !T_changes.getText().isEmpty() && !T_rec_time.getText().isEmpty() && !T_description.getText().isEmpty()) {
			System.out.println("actionPerformed(). ����");
			updateProcess();
		} else if (e.getActionCommand().equals("ɾ����ǰ��¼")) {
			System.out.println("actionPerformed(). ɾ����ǰ��¼");
			deleteCurrentRecordProcess();
		} else if (e.getActionCommand().equals("ɾ�����м�¼")) {
			System.out.println("actionPerformed(). ɾ�����м�¼");
			deleteAllRecordsProcess();

		}
	}
	private void deleteAllRecordsProcess() {
		// TODO Auto-generated method stub
		// ����ɾ������
		String sql = "delete from changes;";
		System.out.println("deleteAllRecordsProcess(). sql = " + sql);
		try {
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("deleteAllRecordsProcess(). delete database failed.");
			}
		} catch (Exception e) {
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}
	private void deleteCurrentRecordProcess() {
		// TODO Auto-generated method stub
		String id = T_id.getText().trim();

		// ����ɾ������
		String sql = "delete from changes where id = '" + id + "';";
		System.out.println("deleteCurrentRecordProcess(). sql = " + sql);
		try {
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("deleteCurrentRecordProcess(). delete database failed.");
			}
		} catch (Exception e) {
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}
	private void updateProcess() {
		// TODO Auto-generated method stub
		String id = T_id.getText().trim();
		String studentid = T_studentid.getText().trim();
		String changes = T_changes.getText().trim();
		String rec_time = T_rec_time.getText().trim();
		String description = T_description.getText().trim();
				
				// ������������
				String sql = "update changes set rec_time = '";
				sql = sql + rec_time + "', description = '";
				sql = sql + description + "', studentid = '";
				sql = sql + studentid + "', changes = '";
				sql = sql + changes + "'";
				sql = sql + " WHERE id = '" + id + "';";
				System.out.println("updateProcess(). sql = " + sql);
				try {
					if (dbProcess.executeUpdate(sql) < 1) {
						System.out.println("updateProcess(). update database failed.");
					}
				} catch (Exception e) {
					System.out.println("e = " + e);
					JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
				}
				queryAllProcess();
	}
	private void insertProcess() {
		// TODO Auto-generated method stub
		String id = T_id.getText().trim();
		String studentid = T_studentid.getText().trim();
		String changes = T_changes.getText().trim();
		String rec_time = T_rec_time.getText().trim();
		String description = T_description.getText().trim();
		
		// ������������
		String sql = "insert into changes values('";
		sql = sql + id + "','";
		sql = sql + rec_time + "','";
		sql = sql + description + "','";
		sql = sql + studentid + "','";
		sql = sql + changes + "');";

		System.out.println("insertProcess(). sql = " + sql);
		try {
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("insertProcess(). insert database failed.");
			}
		} catch (Exception e) {
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}
	private void queryAllProcess() {
		// TODO Auto-generated method stub
		try {
			// ������ѯ����
						String sql = "select * from v_changes;";
						System.out.println("queryAllProcess(). sql = " + sql);

						dbProcess.connect();
						ResultSet rs = dbProcess.executeQuery(sql);

			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			changeVector.clear();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("studentid"));
				v.add(rs.getString("changes"));
				v.add(rs.getString("rec_time"));
				v.add(rs.getString("description"));
				changeVector.add(v);
			}
			

			changeJTable.updateUI();//ˢ�±��

			dbProcess.disconnect();//�Ͽ�����
		} catch (SQLException sqle) {
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void queryProcess(String sQueryField) {
		// TODO Auto-generated method stub
		try {
			// ������ѯ����
			String sql = "select * from v_changes where ";
			String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);

				sql = sql + queryFieldStr;
				sql = sql + " = ";
				sql = sql + "'" + sQueryField + "';";

			System.out.println("queryProcess(). sql = " + sql);

			dbProcess.connect();//����
			ResultSet rs = dbProcess.executeQuery(sql);

			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			changeVector.clear();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("studentid"));
				v.add(rs.getString("changes"));
				v.add(rs.getString("rec_time"));
				v.add(rs.getString("description"));
				changeVector.add(v);
			}

			changeJTable.updateUI();//ˢ�±��

			dbProcess.disconnect();//�Ͽ�����
		} catch (SQLException sqle) {
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
		}
	}
	private String jCBSelectQueryFieldTransfer(String InputStr) {
		// TODO Auto-generated method stub
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);

		if (InputStr.equals("��¼��")) {
			outputStr = "id";
		} else if (InputStr.equals("ѧ��")) {
			outputStr = "studentid";
		} else if (InputStr.equals("������")) {
			outputStr = "changes";
		} else if (InputStr.equals("��¼ʱ��")) {
			outputStr = "rec_time";
		} else if (InputStr.equals("����")) {
			outputStr = "description";
		}
			
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
