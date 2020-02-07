package courseDesign;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DatabaseStudentMessage extends JFrame implements ActionListener {
	//�����ļ���
	Vector<JPanel> jpanel = new Vector<JPanel>();
	/**
	 * ���е�����
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
	JPanel p16 = null;
	JPanel p17 = null;
	
	DefaultTableModel defaultTableModel = null;// ���ģʽ
	JTableHeader head = null;// ���������

	JTable studentJTable = null;// ���
	JScrollPane studentJScrollPane = null;// ������
	Vector studentVector = null;// ������ݼ���
	Vector titleVector = null;// �����⼯��

	JComboBox<String> jCBSelectQueryField = null;// ��ѯ�ֶ�

	private static DbProcessDemo dbProcess;// �������ݿ�
	String SelectQueryFieldStr = "ѧ��";

	JLabel L_xsxxb = null;// ѧ����Ϣ��
	JLabel L_xzcxzd = null;// ѡ���ѯ�ֶ�
	JLabel L_equal = null;// =
	JLabel L_xh = null;// ѧ��
	JLabel L_xm = null;// ����
	JLabel L_xb = null;// �Ա�
	JLabel L_bj = null;// �༶
	JLabel L_sr = null;// ����
	JLabel L_jg = null;// ����
	JLabel L_yx = null;// Ժϵ

	JTextField T_cxzd = null;// ��ѯ�ֶ�
	JTextField T_xh = null;// ѧ��
	JTextField T_xm = null;// ����
	JTextField T_xb = null;// �Ա�
	JTextField T_bj = null;// �༶
	JTextField T_sr = null;// ����
	JTextField T_jg = null;// ����
	JTextField T_yx = null;// Ժϵ

	JButton jBQuery = null;// ��ѯ
	JButton jBQueryAll = null;// ��ѯ���м�¼
	JButton jBInsert = null;// ����
	JButton jBUpdate = null;// ����
	JButton jBDeleteCurrentRecord = null;// ɾ����ǰ��¼
	JButton jBDeleteAllRecords = null;// ɾ�����м�¼
	JButton jBRewardPunish = null;
	JButton jBChange = null;// ���ѧ��

	private void setup() {
		/**
		 * ����
		 */
		Font f = new Font("����", Font.BOLD, 25);
		Font f1 = new Font("����", Font.BOLD, 18);
		Font f2 = new Font("����", Font.BOLD, 15);
		/**
		 * �ܿ��
		 */
		p1 = new JPanel();
		p1.setLayout(null);
		this.add(p1);
		/**
		 * ����ɾ�����²�ѯ����
		 */
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(new Rectangle(0, 250, 700, 250));
		p2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p1.add(p2);
		/**
		 * ��ť����
		 */
		p3 = new JPanel();
		p3.setLayout(new GridLayout(5, 1));
		p3.setBounds(new Rectangle(400, 0, 300, 250));
		p3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p2.add(p3);
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p7 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p8 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(p4);
		p3.add(p5);
		p3.add(p6);
		p3.add(p7);
		p3.add(p8);
		/**
		 * ��ť
		 */
		jBQuery = new JButton("��ѯ");
		jBQuery.setFont(f);
		jBQueryAll = new JButton("��ѯ���м�¼");
		jBQueryAll.setFont(f);
		jBInsert = new JButton("����");
		jBInsert.setFont(f);
		jBUpdate = new JButton("����");
		jBUpdate.setFont(f);
		jBDeleteCurrentRecord = new JButton("ɾ����ǰ��¼");
		jBDeleteCurrentRecord.setFont(f);
		jBDeleteAllRecords = new JButton("ɾ�����м�¼");
		jBDeleteAllRecords.setFont(f);
		/**
		 * Ϊ��ť���ü�����
		 */
		jBQuery.addActionListener(this);
		jBQueryAll.addActionListener(this);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		jBDeleteCurrentRecord.addActionListener(this);
		jBDeleteAllRecords.addActionListener(this);
		/**
		 * ����ť����������
		 */
		p4.add(jBInsert);
		p4.add(jBUpdate);
		p5.add(jBQuery);
		p6.add(jBQueryAll);
		p7.add(jBDeleteCurrentRecord);
		p8.add(jBDeleteAllRecords);
		/**
		 * ������ѧ�������������ť����
		 */
		p9 = new JPanel();
		p9.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));
		p9.setBounds(new Rectangle(0, 500, 700, 80));
		p9.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p1.add(p9);
		/**
		 * ����ϵͳ��ѧ�������ť��������
		 */
		jBRewardPunish = new JButton("����ϵͳ");
		jBRewardPunish.setFont(f);
		jBChange = new JButton("ѧ�����");
		jBChange.setFont(f);
		p9.add(jBRewardPunish);
		p9.add(jBChange);
		/**
		 * Ϊ����ϵͳ��ѧ�������Ӽ�����
		 */
		jBRewardPunish.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new RewardPunishmentDemo();
			}
		});
		jBChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new Change_School();
			}
		});
		/**
		 * ��������
		 */
		p10 = new JPanel();
		p10.setBounds(new Rectangle(0, 0, 400, 250));
		p10.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p2.add(p10);
		p10.setLayout(new GridLayout(5, 1));
		p11 = new JPanel();
		p11.setLayout(null);
		p12 = new JPanel();
		p12.setSize(400, 50);
		p12.setLayout(null);
		p13 = new JPanel();
		p13.setLayout(null);
		p14 = new JPanel();
		p14.setLayout(null);
		p15 = new JPanel();
		p15.setLayout(null);
		// p15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		p10.add(p11);
		p10.add(p12);
		p10.add(p13);
		p10.add(p14);
		p10.add(p15);
		/**
		 * ����������Լ���Ӧ�ı�ǩ
		 */
		L_xzcxzd = new JLabel("ѡ���ѯ�ֶ�");// ѡ���ѯ�ֶ�
		L_xzcxzd.setFont(f1);
		L_equal = new JLabel("=");// =
		L_equal.setFont(f);
		L_xh = new JLabel("ѧ��");// ѧ��
		L_xh.setFont(f);
		L_xh.setForeground(Color.red);
		L_xm = new JLabel("����");// ����
		L_xm.setFont(f);
		L_xb = new JLabel("�Ա�");// �Ա�
		L_xb.setFont(f);
		L_bj = new JLabel("�༶");// �༶
		L_bj.setFont(f);
		L_sr = new JLabel("����");// ����
		L_sr.setFont(f);
		L_jg = new JLabel("����");// ����
		L_jg.setFont(f);
		L_yx = new JLabel("Ժϵ");// Ժϵ
		L_yx.setFont(f);

		T_cxzd = new JTextField(10);// ��ѯ�ֶ�
		T_xh = new JTextField(10);// ѧ��
		T_xm = new JTextField(10);// ����
		T_xb = new JTextField(10);// �Ա�
		T_bj = new JTextField(10);// �༶
		T_sr = new JTextField(10);// ����
		T_jg = new JTextField(10);// ����
		T_yx = new JTextField(10);// Ժϵ
		/**
		 * Ϊ���е��������������
		 */
		T_cxzd.setFont(f1);
		T_xh.setFont(f1);
		T_xm.setFont(f1);
		T_xb.setFont(f1);
		T_bj.setFont(f1);
		T_sr.setFont(f1);
		T_jg.setFont(f1);
		T_yx.setFont(f1);
		/**
		 * ��������Լ���ǩ��������
		 */
		L_xzcxzd.setBounds(new Rectangle(20, 5, 120, 40));
		jCBSelectQueryField = new JComboBox<String>();// ��ѯ�ֶ�
		jCBSelectQueryField.setFont(f1);
		jCBSelectQueryField.addItem("ѧ��");
		jCBSelectQueryField.addItem("����");
		jCBSelectQueryField.addItem("�Ա�");
		jCBSelectQueryField.addItem("�༶");
		jCBSelectQueryField.addItem("Ժϵ");
		jCBSelectQueryField.addItem("����");
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
		jCBSelectQueryField.setBounds(new Rectangle(160, 5, 75, 40));
		L_equal.setBounds(new Rectangle(255, 5, 20, 40));
		T_cxzd.setBounds(new Rectangle(290, 5, 90, 40));
		p11.add(L_equal);
		p11.add(T_cxzd);
		p11.add(jCBSelectQueryField);
		p11.add(L_xzcxzd);
		L_xh.setBounds(new Rectangle(20, 5, 60, 40));
		T_xh.setBounds(new Rectangle(90, 5, 90, 40));
		p12.add(L_xh);
		p12.add(T_xh);
		L_xm.setBounds(new Rectangle(220, 5, 60, 40));
		T_xm.setBounds(new Rectangle(290, 5, 90, 40));
		p12.add(L_xm);
		p12.add(T_xm);
		L_xb.setBounds(new Rectangle(20, 5, 60, 40));
		T_xb.setBounds(new Rectangle(90, 5, 90, 40));
		p13.add(L_xb);
		p13.add(T_xb);
		L_bj.setBounds(new Rectangle(220, 5, 60, 40));
		T_bj.setBounds(new Rectangle(290, 5, 90, 40));
		p13.add(L_bj);
		p13.add(T_bj);
		L_sr.setBounds(new Rectangle(20, 5, 60, 40));
		T_sr.setBounds(new Rectangle(90, 5, 90, 40));
		p14.add(L_sr);
		p14.add(T_sr);
		L_yx.setBounds(new Rectangle(220, 5, 60, 40));
		T_yx.setBounds(new Rectangle(290, 5, 90, 40));
		p14.add(L_yx);
		p14.add(T_yx);
		L_jg.setBounds(new Rectangle(50, 5, 60, 40));
		T_jg.setBounds(new Rectangle(150, 5, 200, 40));
		p15.add(L_jg);
		p15.add(T_jg);
		/**
		 * ѧ����Ϣ���ǩ
		 */
		L_xsxxb = new JLabel("ѧ����Ϣ��");// ѧ����Ϣ��
		L_xsxxb.setFont(f);
		p16 = new JPanel();
		p16.setLayout(new FlowLayout(FlowLayout.CENTER));
		p16.setBounds(new Rectangle(0, 0, 700, 50));
		p16.add(L_xsxxb);
		p1.add(p16);
		/**
		 * ѧ����Ϣ���������
		 */
		p17 = new JPanel();
		p17.setLayout(null);
		p17.setBounds(new Rectangle(0, 50, 700, 200));
		// p17.setBorder(BorderFactory.createLineBorder(Color.black,1));
		p1.add(p17);
		/**
		 * ѧ����Ϣ����
		 */
		studentVector = new Vector<String>();
		titleVector = new Vector<String>();

		titleVector.add("ѧ��");
		titleVector.add("����");
		titleVector.add("�Ա�");
		titleVector.add("�༶");
		titleVector.add("Ժϵ");
		titleVector.add("����");
		titleVector.add("����");

		// defaultTableModel = new DefaultTableModel(studentVector, titleVector);
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setFont(f2);
		head = studentJTable.getTableHeader(); // �������������
		head.setFont(f);

		studentJScrollPane = new JScrollPane(studentJTable);
		studentJScrollPane.setBounds(new Rectangle(0, 0, 700, 200));
		// �ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		studentJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// Ϊ�����Ӽ�����
		studentJTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);

				T_xh.setText((String) v.get(0));// ѧ��
				T_xm.setText((String) v.get(1));// ����
				T_xb.setText((String) v.get(2));// �Ա�
				T_bj.setText((String) v.get(3));// �༉
				T_yx.setText((String) v.get(4));// Ժϵ
				T_sr.setText((String) v.get(5));// ����
				T_jg.setText((String) v.get(6));// ��؞
			}
		});
		p17.add(studentJScrollPane);
		dbProcess = new DbProcessDemo();
		/**
		 * �������������뵽jpanel������
		 */
		jpanel.add(p1);
		jpanel.add(p2);
		jpanel.add(p3);
		jpanel.add(p4);
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
		jpanel.add(p16);
		jpanel.add(p17);
		/**
		 * ���ñ���
		 */
		head.setBackground(Color.orange);
		studentJTable.setBackground(Color.orange);
		Iterator<JPanel> interator = jpanel.iterator();
	    while(interator.hasNext()) {
	    	Object obj = interator.next();
	    	JPanel panel = (JPanel) obj;
	    	panel.setBackground(Color.orange);
	    }
	}

	public DatabaseStudentMessage() {
		super("ѧ����Ϣ����ϵͳ");
		setup();
		setSize(700, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("��ѯ") && !T_cxzd.getText().isEmpty()) {
			System.out.println("actionPerformed(). ��ѯ");
			String sQueryField = T_cxzd.getText().trim();
			queryProcess(sQueryField);
			T_cxzd.setText("");
		} else if (e.getActionCommand().equals("��ѯ���м�¼")) {
			System.out.println("actionPerformed(). ��ѯ���м�¼");
			queryAllProcess();
		} else if (e.getActionCommand().equals("����") && !T_xh.getText().isEmpty() && !T_xm.getText().isEmpty()
				&& !T_xb.getText().isEmpty() && !T_bj.getText().isEmpty() && !T_sr.getText().isEmpty()
				&& !T_yx.getText().isEmpty()&& !T_jg.getText().isEmpty()) {
			System.out.println("actionPerformed(). ����");
			insertProcess();
		} else if (e.getActionCommand().equals("����") && !T_xh.getText().isEmpty() && !T_xm.getText().isEmpty()
				&& !T_xb.getText().isEmpty() && !T_bj.getText().isEmpty() && !T_sr.getText().isEmpty()
				&& !T_yx.getText().isEmpty()&& !T_jg.getText().isEmpty()) {
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
				String sql = "delete from student;";
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
		String sNo = T_xh.getText().trim();

		// ����ɾ������
		String sql = "delete from student where studentid = '" + sNo + "';";
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
		String sNo = T_xh.getText().trim();
		String sName = T_xm.getText().trim();
		String sSex = T_xb.getText().trim();
		String sclass = T_bj.getText().trim();
		String sdepartment = T_yx.getText().trim();
		String sbirth = T_sr.getText().trim();
		String snative_address = T_jg.getText().trim();
		
		// ������������
		String sql = "update student set name = '";
		sql = sql + sName + "', sex = '";
		sql = sql + sSex + "', birthday = '";
		sql = sql + sbirth + "', native_place = '";
		sql = sql + snative_address + "', class = '";
		sql = sql + sclass + "', department = '";
		sql = sql + sdepartment + "'";
		sql = sql + " WHERE studentid = '" + sNo + "';";
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
		String sNo = T_xh.getText().trim();
		String sName = T_xm.getText().trim();
		String sSex = T_xb.getText().trim();
		String sclass = T_bj.getText().trim();
		String sdepartment = T_yx.getText().trim();
		String sbirth = T_sr.getText().trim();
		String snative_address = T_jg.getText().trim();
		
		// ������������
		String sql = "insert into student values('";
		sql = sql + sNo + "','";
		sql = sql + sName + "','";
		sql = sql + sSex + "','";
		sql = sql + sbirth + "','";
		sql = sql + snative_address + "','";
		sql = sql + sclass + "','";
		sql = sql + sdepartment + "');";

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
						String sql = "select * from v_student;";
						System.out.println("queryAllProcess(). sql = " + sql);

						dbProcess.connect();
						ResultSet rs = dbProcess.executeQuery(sql);

			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			studentVector.clear();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("studentid"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("class"));
				v.add(rs.getString("department"));
				v.add(rs.getString("birthday"));
				v.add(rs.getString("native_place"));
				studentVector.add(v);
			}
			

			studentJTable.updateUI();//ˢ�±��

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
		try {
			// ������ѯ����
			String sql = "select * from v_student where ";
			String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);

				sql = sql + queryFieldStr;
				sql = sql + " = ";
				sql = sql + "'" + sQueryField + "';";

			System.out.println("queryProcess(). sql = " + sql);

			dbProcess.connect();//����
			ResultSet rs = dbProcess.executeQuery(sql);

			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			studentVector.clear();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("studentid"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("class"));
				v.add(rs.getString("department"));
				v.add(rs.getString("birthday"));
				v.add(rs.getString("native_place"));
				studentVector.add(v);
			}

			studentJTable.updateUI();//ˢ�±��

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
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);

		if (InputStr.equals("ѧ��")) {
			outputStr = "studentid";
		} else if (InputStr.equals("����")) {
			outputStr = "name";
		} else if (InputStr.equals("�Ա�")) {
			outputStr = "sex";
		} else if (InputStr.equals("����")) {
			outputStr = "birthday";
		} else if (InputStr.equals("����")) {
			outputStr = "native_place";
		} else if (InputStr.equals("�༶")) {
			outputStr = "class";
		} else if (InputStr.equals("Ժϵ")) {
			outputStr = "department";
		}
			
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
	

}
