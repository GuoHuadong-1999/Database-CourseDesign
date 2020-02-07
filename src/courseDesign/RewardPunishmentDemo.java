package courseDesign;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
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

public class RewardPunishmentDemo extends JFrame implements ActionListener {
	/**
	 * ����
	 */
	JPanel p1 = null;
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
	JPanel p18 = null;
	JPanel p19 = null;
	JPanel p20 = null;
	JPanel p21 = null;
	JPanel p22 = null;
	JPanel p23 = null;
	JPanel p24 = null;
	JPanel p25 = null;
	JPanel p26 = null;
	Vector<JPanel> jpanel = new Vector<JPanel>();
	/**
	 * �������ݿ�
	 */
	private static DbProcessDemo dbProcess;
	/**
	 * ���������ݡ�����ļ��Ϻͱ��
	 */
	Vector rewardVector = new Vector();;
	Vector rewardTitleVector = null;
	JTable rewardJTable = null;// ���
	JScrollPane rewardJScrollPane = null;// ������
	JTableHeader rewardHead = null;// ���������
	/**
	 * �ͷ��������Լ�����ļ���
	 */
	Vector punishmentVector = new Vector();
	Vector punishmentTitleVector = null;
	JTable punishmentJTable = null;// ���
	JScrollPane punishmentJScrollPane = null;// ������
	JTableHeader punishmentHead = null;// ���������
	/**
	 * ѡ�е������б�
	 */
	String SelectQueryFieldStr1 = "��¼��";
	String SelectQueryFieldStr2 = "��¼��";
	/**
	 * ��ѯ�ֶ�
	 */
	JComboBox<String> jCBSelectQueryField1 = null;
	JComboBox<String> jCBSelectQueryField2 = null;
	/**
	 * ���еı�ǩ
	 */
	JLabel L_jljlb = null;
	JLabel L_cfjlb = null;

	JLabel L_jljlgl = null;
	JLabel L_xzcxzd1 = null;
	JLabel L_jlh1 = null;
	JLabel L_xh1 = null;
	JLabel L_jldj = null;
	JLabel L_jlsj1 = null;
	JLabel L_ms1 = null;

	JLabel L_cfjlgl = null;
	JLabel L_xzcxzd2 = null;
	JLabel L_jlh2 = null;
	JLabel L_xh2 = null;
	JLabel L_cfdj = null;
	JLabel L_jlsj2 = null;
	JLabel L_sfsx = null;
	JLabel L_ms2 = null;

	JLabel L_equal1 = null;
	JLabel L_equal2 = null;
	/**
	 * ���еİ�ť
	 */
	JButton B_cx = null;
	JButton B_cxsyjl1 = null;
	JButton B_cxsyjl2 = null;
	JButton B_cr = null;
	JButton B_gx = null;
	JButton B_scdqjl = null;
	JButton B_scsyjl1 = null;
	JButton B_scsyjl2 = null;
	JButton B_qksrk = null;
	/**
	 * ���е��ı���
	 */
	JTextField T_cxsyzd1 = null;
	JTextField T_jlh1 = null;
	JTextField T_xh1 = null;
	JTextField T_jldj = null;
	JTextField T_jlsj1 = null;
	JTextField T_ms1 = null;

	JTextField T_cxsyzd2 = null;
	JTextField T_jlh2 = null;
	JTextField T_xh2 = null;
	JTextField T_cfdj = null;
	JTextField T_jlsj2 = null;
	JTextField T_sfsx = null;
	JTextField T_ms2 = null;

	/**
	 * ����
	 */
	Font f = new Font("����", Font.BOLD, 23);
	Font f1 = new Font("����", Font.BOLD, 18);
	Font f2 = new Font("����", Font.BOLD, 15);
	/**
	 * �洢�������Լ��ͷ��������
	 */
	JPanel p2 = new JPanel();
	JPanel J1 = null;
	JPanel J2 = null;

	private void setup() {
		
		/**
		 * ���沼��
		 */
		p2.setBounds(new Rectangle(0, 0, 700, 263));
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p1 = new JPanel();
		p1.setLayout(null);
		add(p1);
		p1.add(p2);
		p2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p3 = new JPanel();
		p3.setBounds(new Rectangle(0, 263, 700, 500));
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p1.add(p3);
		/**
		 * ��ť������
		 */
		p4 = new JPanel();
		p4.setLayout(new GridLayout(8, 1));
		p4.setBounds(new Rectangle(500, 0, 200, 500));
		p4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p3.add(p4);
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		p7 = new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.CENTER));
		p8 = new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		p9 = new JPanel();
		p9.setLayout(new FlowLayout(FlowLayout.CENTER));
		p24 = new JPanel();
		p24.setLayout(new FlowLayout(FlowLayout.CENTER));
		p25 = new JPanel();
		p25.setLayout(new FlowLayout(FlowLayout.CENTER));
		p26 = new JPanel();
		p26.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.add(p5);
		p4.add(p6);
		p4.add(p7);
		p4.add(p8);
		p4.add(p9);
		p4.add(p24);
		p4.add(p25);
		p4.add(p26);

		/**
		 * �������еİ�ť
		 */
		B_cx = new JButton("��ѯ");
		B_cx.setFont(f);
		B_cxsyjl1 = new JButton("<��>��ѯ���м�¼");
		B_cxsyjl1.setFont(f);
		B_cxsyjl2 = new JButton("<��>��ѯ���м�¼");
		B_cxsyjl2.setFont(f);
		B_cr = new JButton("����");
		B_cr.setFont(f);
		B_gx = new JButton("����");
		B_gx.setFont(f);
		B_scdqjl = new JButton("ɾ����ǰ��¼");
		B_scdqjl.setFont(f);
		B_scsyjl1 = new JButton("<��>ɾ�����м�¼");
		B_scsyjl1.setFont(f);
		B_scsyjl2 = new JButton("<��>ɾ�����м�¼");
		B_scsyjl2.setFont(f);
		B_qksrk = new JButton("��������");
		B_qksrk.setFont(f);
		p5.add(B_cr);
		p5.add(B_gx);
		p6.add(B_cx);
		p7.add(B_cxsyjl1);
		p8.add(B_cxsyjl2);
		p9.add(B_scdqjl);
		p24.add(B_scsyjl1);
		p25.add(B_scsyjl2);
		p26.add(B_qksrk);
		/**
		 * ����ť��Ӽ�����
		 */
		B_cx.addActionListener(this);
		B_cxsyjl1.addActionListener(this);
		B_cxsyjl2.addActionListener(this);
		B_cr.addActionListener(this);
		B_gx.addActionListener(this);
		B_scdqjl.addActionListener(this);
		B_scsyjl1.addActionListener(this);
		B_scsyjl2.addActionListener(this);
		B_qksrk.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				T_cxsyzd1.setText("");
				T_jlh1.setText("");
				T_xh1.setText("");
				T_jldj.setText("");
				T_jlsj1.setText("");
				T_ms1.setText("");

				T_cxsyzd2.setText("");
				T_jlh2.setText("");
				T_xh2.setText("");
				T_cfdj.setText("");
				T_jlsj2.setText("");
				T_sfsx.setText("");
				T_ms2.setText("");
			}
		});
		/**
		 * ������¼����
		 */
		p10 = new JPanel();
		p3.add(p10);
		p10.setLayout(null);
		p10.setBounds(new Rectangle(0, 0, 500, 250));
		p10.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		L_jljlgl = new JLabel("<html>��<br>��<br>��<br>¼<br>��<br>��<br>");
		L_jljlgl.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		L_jljlgl.setFont(f);
		L_jljlgl.setBounds(new Rectangle(0, 0, 30, 250));
		p10.add(L_jljlgl);

		p12 = new JPanel();
		p12.setLayout(new GridLayout(5, 1));
		p12.setBounds(new Rectangle(30, 0, 470, 250));
		p12.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p10.add(p12);

		p14 = new JPanel();
		p14.setLayout(null);
		p15 = new JPanel();
		p15.setLayout(null);
		p16 = new JPanel();
		p16.setLayout(null);
		p17 = new JPanel();
		p17.setLayout(null);
		p18 = new JPanel();
		p18.setLayout(null);
		p12.add(p14);
		p12.add(p15);
		p12.add(p16);
		p12.add(p17);
		p12.add(p18);

		L_xzcxzd1 = new JLabel("ѡ���ѯ�ֶ�");
		L_xzcxzd1.setFont(f1);
		L_xzcxzd1.setBounds(new Rectangle(25, 5, 120, 40));
		L_equal1 = new JLabel("=");
		L_equal1.setFont(f1);
		L_equal1.setBounds(new Rectangle(300, 5, 20, 40));
		L_jlh1 = new JLabel("��¼��");
		L_jlh1.setFont(f);
		L_jlh1.setForeground(Color.red);
		L_jlh1.setBounds(new Rectangle(25, 5, 100, 40));
		L_xh1 = new JLabel("ѧ��");
		L_xh1.setFont(f);
		L_xh1.setBounds(new Rectangle(260, 5, 100, 40));
		L_jldj = new JLabel("�����ȼ�");
		L_jldj.setFont(f);
		L_jldj.setBounds(new Rectangle(25, 5, 100, 40));
		L_jlsj1 = new JLabel("��¼ʱ��");
		L_jlsj1.setFont(f);
		L_jlsj1.setBounds(new Rectangle(25, 5, 100, 40));
		L_ms1 = new JLabel("����");
		L_ms1.setFont(f);
		L_ms1.setBounds(new Rectangle(25, 5, 100, 40));

		p14.add(L_xzcxzd1);
		p14.add(L_equal1);
		p15.add(L_jlh1);
		p15.add(L_xh1);
		p16.add(L_jldj);
		p17.add(L_jlsj1);
		p18.add(L_ms1);

		T_cxsyzd1 = new JTextField(10);
		T_jlh1 = new JTextField(10);
		T_xh1 = new JTextField(10);
		T_jldj = new JTextField(10);
		T_jlsj1 = new JTextField(10);
		T_ms1 = new JTextField(10);

		T_cxsyzd1.setBounds(new Rectangle(320, 5, 100, 40));
		T_jlh1.setBounds(new Rectangle(145, 5, 100, 40));
		T_xh1.setBounds(new Rectangle(340, 5, 100, 40));
		T_jldj.setBounds(new Rectangle(145, 5, 100, 40));
		T_jlsj1.setBounds(new Rectangle(145, 5, 100, 40));
		T_ms1.setBounds(new Rectangle(145, 5, 200, 40));
		p14.add(T_cxsyzd1);
		p15.add(T_jlh1);
		p15.add(T_xh1);
		p16.add(T_jldj);
		p17.add(T_jlsj1);
		p18.add(T_ms1);
		
		
		/**
		 * �ͷ���¼����
		 */
		p11 = new JPanel();
		p3.add(p11);
		p11.setLayout(null);
		p11.setBounds(new Rectangle(0, 250, 500, 250));
		p11.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		L_cfjlgl = new JLabel("<html>��<br>��<br>��<br>¼<br>��<br>��<br>");
		L_cfjlgl.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		L_cfjlgl.setFont(f);
		L_cfjlgl.setBounds(new Rectangle(0, 0, 30, 250));
		p11.add(L_cfjlgl);

		p13 = new JPanel();
		p13.setLayout(new GridLayout(5, 1));
		p13.setBounds(new Rectangle(30, 0, 470, 250));
		p13.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p11.add(p13);

		p19 = new JPanel();
		p19.setLayout(null);
		p20 = new JPanel();
		p20.setLayout(null);
		p21 = new JPanel();
		p21.setLayout(null);
		p22 = new JPanel();
		p22.setLayout(null);
		p23 = new JPanel();
		p23.setLayout(null);
		p13.add(p19);
		p13.add(p20);
		p13.add(p21);
		p13.add(p22);
		p13.add(p23);

		L_xzcxzd2 = new JLabel("ѡ���ѯ�ֶ�");
		L_xzcxzd2.setFont(f1);
		L_xzcxzd2.setBounds(new Rectangle(25, 5, 120, 40));
		L_equal2 = new JLabel("=");
		L_equal2.setFont(f1);
		L_equal2.setBounds(new Rectangle(300, 5, 20, 40));
		L_jlh2 = new JLabel("��¼��");
		L_jlh2.setFont(f);
		L_jlh2.setForeground(Color.red);
		L_jlh2.setBounds(new Rectangle(25, 5, 100, 40));
		L_xh2 = new JLabel("ѧ��");
		L_xh2.setFont(f);
		L_xh2.setBounds(new Rectangle(260, 5, 100, 40));
		L_cfdj = new JLabel("�ͷ��ȼ�");
		L_cfdj.setFont(f);
		L_cfdj.setBounds(new Rectangle(25, 5, 100, 40));
		L_jlsj2 = new JLabel("��¼ʱ��");
		L_jlsj2.setFont(f);
		L_jlsj2.setBounds(new Rectangle(260, 5, 100, 40));
		L_sfsx = new JLabel("�Ƿ���Ч");
		L_sfsx.setFont(f);
		L_sfsx.setBounds(new Rectangle(25, 5, 100, 40));
		L_ms2 = new JLabel("����");
		L_ms2.setFont(f);
		L_ms2.setBounds(new Rectangle(25, 5, 100, 40));

		p19.add(L_xzcxzd2);
		p19.add(L_equal2);
		p20.add(L_jlh2);
		p20.add(L_xh2);
		p21.add(L_cfdj);
		p21.add(L_jlsj2);
		p22.add(L_sfsx);
		p23.add(L_ms2);

		T_cxsyzd2 = new JTextField(10);
		T_jlh2 = new JTextField(10);
		T_xh2 = new JTextField(10);
		T_cfdj = new JTextField(10);
		T_jlsj2 = new JTextField(10);
		T_sfsx = new JTextField(10);
		T_ms2 = new JTextField(10);

		T_cxsyzd2.setBounds(new Rectangle(315, 5, 100, 40));
		T_jlh2.setBounds(new Rectangle(145, 5, 100, 40));
		T_xh2.setBounds(new Rectangle(360, 5, 100, 40));
		T_cfdj.setBounds(new Rectangle(145, 5, 100, 40));
		T_jlsj2.setBounds(new Rectangle(360, 5, 100, 40));
		T_sfsx.setBounds(new Rectangle(145, 5, 100, 40));
		T_ms2.setBounds(new Rectangle(145, 5, 200, 40));
		/**
		 * Ϊ���е��ı�����������
		 */
		T_cxsyzd1.setFont(f1);
		T_jlh1.setFont(f1);
		T_xh1.setFont(f1);
		T_jldj.setFont(f1);
		T_jlsj1.setFont(f1);
		T_ms1.setFont(f1);
		T_jlh2.setFont(f1);
		T_xh2.setFont(f1);
		T_cfdj.setFont(f1);
		T_jlsj2.setFont(f1);
		T_sfsx.setFont(f1);
		T_ms2.setFont(f1);
		T_cxsyzd2.setFont(f1);
		
		p19.add(T_cxsyzd2);
		p20.add(T_jlh2);
		p20.add(T_xh2);
		p21.add(T_cfdj);
		p21.add(T_jlsj2);
		p22.add(T_sfsx);
		p23.add(T_ms2);
		/**
		 * ��ѯ�ֶ�
		 */
		jCBSelectQueryField1 = new JComboBox<String>();
		jCBSelectQueryField1.setFont(f1);
		jCBSelectQueryField1.addItem("��¼��");
		jCBSelectQueryField1.addItem("ѧ��");
		jCBSelectQueryField1.addItem("�����ȼ�");
		jCBSelectQueryField1.addItem("��¼ʱ��");
		jCBSelectQueryField1.addItem("����");
		jCBSelectQueryField1.setBounds(new Rectangle(165, 5, 115, 40));
		p14.add(jCBSelectQueryField1);
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
		jCBSelectQueryField1.addItemListener(new ItemListener() {// �������¼�����
			public void itemStateChanged(ItemEvent event) {
				switch (event.getStateChange()) {
				case ItemEvent.SELECTED:
					SelectQueryFieldStr1 = (String) event.getItem();
					System.out.println("<������¼����> ѡ�У�" + SelectQueryFieldStr1);
					break;
				case ItemEvent.DESELECTED:
					System.out.println("<������¼����> ȡ��ѡ�У�" + event.getItem());
					break;
				}
			}
		});

		jCBSelectQueryField2 = new JComboBox<String>();
		jCBSelectQueryField2.setFont(f1);
		jCBSelectQueryField2.addItem("��¼��");
		jCBSelectQueryField2.addItem("ѧ��");
		jCBSelectQueryField2.addItem("�����ȼ�");
		jCBSelectQueryField2.addItem("��¼ʱ��");
		jCBSelectQueryField2.addItem("�Ƿ���Ч");
		jCBSelectQueryField2.addItem("����");
		jCBSelectQueryField2.setBounds(new Rectangle(165, 5, 115, 40));
		p19.add(jCBSelectQueryField2);
		jCBSelectQueryField2.addItemListener(new ItemListener() {// �������¼�����
			public void itemStateChanged(ItemEvent event) {
				switch (event.getStateChange()) {
				case ItemEvent.SELECTED:
					SelectQueryFieldStr2 = (String) event.getItem();
					System.out.println("<�ͷ���¼����> ѡ�У�" + SelectQueryFieldStr2);
					break;
				case ItemEvent.DESELECTED:
					System.out.println("<�ͷ���¼����> ȡ��ѡ�У�" + event.getItem());
					break;
				}
			}
		});
		dbProcess = new DbProcessDemo();
		punishmentTable();
		rewardTable();
		J1.setVisible(true);
		J2.setVisible(false);
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
		jpanel.add(p18);
		jpanel.add(p19);
		jpanel.add(p20);
		jpanel.add(p21);
		jpanel.add(p22);
		jpanel.add(p23);
		jpanel.add(p24);
		jpanel.add(p25);
		jpanel.add(p26);
		/**
		 * ���ñ�����ɫ
		 */
		rewardHead.setBackground(Color.orange);
		rewardJTable.setBackground(Color.orange);
		punishmentHead.setBackground(Color.orange);
	    punishmentJTable.setBackground(Color.orange);
	    Iterator<JPanel> interator = jpanel.iterator();
	    while(interator.hasNext()) {
	    	Object obj = interator.next();
	    	JPanel panel = (JPanel) obj;
	    	panel.setBackground(Color.orange);
	    }
	}

	/**
	 * ������
	 */
	private void rewardTable() {
		J1 = new JPanel();
		J1.setBounds(new Rectangle(0, 0, 700, 263));
		J1.setLayout(null);
		p2.add(J1);
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.setBounds(new Rectangle(0, 0, 700, 40));
		p3.setBackground(Color.orange);

		L_jljlb = new JLabel("������¼��");
		L_jljlb.setFont(f);
		L_jljlb.setBounds(new Rectangle(0, 0, 700, 40));

		p3.add(L_jljlb);
		J1.add(p3);

		/**
		 * ������¼������
		 */
		rewardTitleVector = new Vector();

		rewardTitleVector.add("��¼��");
		rewardTitleVector.add("ѧ��");
		rewardTitleVector.add("�����ȼ�");
		rewardTitleVector.add("��¼ʱ��");
		rewardTitleVector.add("����");

		// defaultTableModel = new DefaultTableModel();
		rewardJTable = new JTable(rewardVector, rewardTitleVector);
		rewardJTable.setFont(f2);
		rewardHead = rewardJTable.getTableHeader(); // �������������
		rewardHead.setFont(f);


		rewardJScrollPane = new JScrollPane(rewardJTable);
		rewardJScrollPane.setBounds(new Rectangle(0, 40, 700, 223));
		// �ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		rewardJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		rewardJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		J1.add(rewardJScrollPane);

		// Ϊ�����Ӽ�����
		rewardJTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) rewardVector.get(row);

				T_jlh1.setText((String) v.get(0));// ��¼��
				T_xh1.setText((String) v.get(1));// ѧ��
				T_jldj.setText((String) v.get(2));// �����ȼ�
				T_jlsj1.setText((String) v.get(3));// ��¼ʱ��
				T_ms1.setText((String) v.get(4));// ����
			}
		});
	}

	/**
	 * �ͷ���
	 */
	private void punishmentTable() {
		J2 = new JPanel();
		J2.setBounds(new Rectangle(0, 0, 700, 263));
		J2.setLayout(null);
		p2.add(J2);

		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.setBackground(Color.orange);
		p3.setBounds(new Rectangle(0, 0, 700, 40));

		L_cfjlb = new JLabel("�ͷ���¼��");
		L_cfjlb.setFont(f);
		L_cfjlb.setBounds(new Rectangle(0, 0, 700, 40));

		p3.add(L_cfjlb);
		J2.add(p3);

		/**
		 * �ͷ���¼������
		 */
		punishmentTitleVector = new Vector();

		punishmentTitleVector.add("��¼��");
		punishmentTitleVector.add("ѧ��");
		punishmentTitleVector.add("�ͷ��ȼ�");
		punishmentTitleVector.add("��¼ʱ��");
		punishmentTitleVector.add("�Ƿ���Ч");
		punishmentTitleVector.add("����");

		// defaultTableModel = new DefaultTableModel();
		punishmentJTable = new JTable(punishmentVector, punishmentTitleVector);
		punishmentJTable.setFont(f2);
		punishmentHead = punishmentJTable.getTableHeader(); // �������������
		punishmentHead.setFont(f);

		punishmentJScrollPane = new JScrollPane(punishmentJTable);
		punishmentJScrollPane.setBounds(new Rectangle(0, 40, 700, 223));
		// �ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		punishmentJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		punishmentJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		J2.add(punishmentJScrollPane);

		// Ϊ�����Ӽ�����
		punishmentJTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) punishmentVector.get(row);

				T_jlh2.setText((String) v.get(0));// ��¼��
				T_xh2.setText((String) v.get(1));// ѧ��
				T_cfdj.setText((String) v.get(2));// �ͷ��ȼ�
				T_jlsj2.setText((String) v.get(3));// ��¼ʱ��
				T_sfsx.setText((String) v.get(4));// �Ƿ���Ч
				T_ms2.setText((String) v.get(5));// ����
			}
		});
	}

	public RewardPunishmentDemo() {
		super("����ϵͳ");
		setup();
		setSize(715, 800);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/**
		 * ��ѯ
		 */
		if (e.getActionCommand().equals("��ѯ") && !T_cxsyzd1.getText().isEmpty()) {
			J1.setVisible(true);
			J2.setVisible(false);
			System.out.println("<������¼����> actionPerformed(). ��ѯ");
			String sQueryField = T_cxsyzd1.getText().trim();
			queryProcess(sQueryField, 0);
			T_cxsyzd1.setText("");
			rewardTable();
		} else if (e.getActionCommand().equals("��ѯ") && !T_cxsyzd2.getText().isEmpty()) {
			J1.setVisible(false);
			J2.setVisible(true);
			System.out.println("<�ͷ���¼����> actionPerformed(). ��ѯ");
			String sQueryField = T_cxsyzd2.getText().trim();
			queryProcess(sQueryField, 1);
			T_cxsyzd2.setText("");
		}
		/**
		 * <����>��ѯ���м�¼
		 */
		if (e.getActionCommand().equals("<��>��ѯ���м�¼")) {
			J1.setVisible(true);
			J2.setVisible(false);
			System.out.println("actionPerformed(). <��>��ѯ���м�¼");
			queryAllProcess(0);
		} else if (e.getActionCommand().equals("<��>��ѯ���м�¼")) {
			J1.setVisible(false);
			J2.setVisible(true);
			System.out.println("actionPerformed(). <��>��ѯ���м�¼");
			queryAllProcess(1);
		}
		/**
		 * ����
		 */
		if (e.getActionCommand().equals("����") && !T_jlh1.getText().isEmpty() && !T_xh1.getText().isEmpty()
				&& !T_jldj.getText().isEmpty() && !T_jlsj1.getText().isEmpty() && !T_ms1.getText().isEmpty()) {
			J1.setVisible(true);
			J2.setVisible(false);
			System.out.println("<������¼����> actionPerformed(). ����");
			insertProcess(0);
		}
		else if(e.getActionCommand().equals("����") && !T_jlh2.getText().isEmpty() && !T_xh2.getText().isEmpty()
				&& !T_cfdj.getText().isEmpty() && !T_jlsj2.getText().isEmpty() && !T_sfsx.getText().isEmpty() && !T_ms2.getText().isEmpty()) {
			J1.setVisible(false);
			J2.setVisible(true);
			System.out.println("<�ͷ���¼����> actionPerformed(). ����");
			insertProcess(1);
		}
		/**
		 * ����
		 */
		if (e.getActionCommand().equals("����") && !T_jlh1.getText().isEmpty() && !T_xh1.getText().isEmpty()
				&& !T_jldj.getText().isEmpty() && !T_jlsj1.getText().isEmpty() && !T_ms1.getText().isEmpty()) {
			J1.setVisible(true);
			J2.setVisible(false);
			System.out.println("<������¼����> actionPerformed(). ����");
			updateProcess(0);
		}else if(e.getActionCommand().equals("����") && !T_jlh2.getText().isEmpty() && !T_xh2.getText().isEmpty()
				&& !T_cfdj.getText().isEmpty() && !T_jlsj2.getText().isEmpty() && !T_sfsx.getText().isEmpty() && !T_ms2.getText().isEmpty()) {
			J1.setVisible(false);
			J2.setVisible(true);
			System.out.println("<�ͷ���¼����> actionPerformed(). ����");
			updateProcess(1);
		}
		/**
		 * ɾ����ǰ��¼
		 */
		if (e.getActionCommand().equals("ɾ����ǰ��¼")&&!T_jlh1.getText().isEmpty() && !T_xh1.getText().isEmpty()
				&& !T_jldj.getText().isEmpty() && !T_jlsj1.getText().isEmpty() && !T_ms1.getText().isEmpty()) {
			J1.setVisible(true);
			J2.setVisible(false);
			System.out.println("<������ѯ��¼> actionPerformed(). ɾ����ǰ��¼");
			deleteCurrentRecordProcess(0);
		}else if(e.getActionCommand().equals("ɾ����ǰ��¼")&&!T_jlh2.getText().isEmpty() && !T_xh2.getText().isEmpty()
				&& !T_cfdj.getText().isEmpty() && !T_jlsj2.getText().isEmpty() && !T_sfsx.getText().isEmpty() && !T_ms2.getText().isEmpty()) {
			J1.setVisible(false);
			J2.setVisible(true);
			System.out.println("<�ͷ���ѯ��¼> actionPerformed(). ɾ����ǰ��¼");
			deleteCurrentRecordProcess(1);
		}
		/**
		 * <����>ɾ�����м�¼
		 */
		if (e.getActionCommand().equals("<��>ɾ�����м�¼")) {
			J1.setVisible(true);
			J2.setVisible(false);
			System.out.println("<������ѯ��¼> actionPerformed(). ɾ�����м�¼");
			deleteAllRecordsProcess(0);

		}else if(e.getActionCommand().equals("<��>ɾ�����м�¼")) {
			J1.setVisible(false);
			J2.setVisible(true);
			System.out.println("<�ͷ���ѯ��¼> actionPerformed(). ɾ�����м�¼");
			deleteAllRecordsProcess(1);
		}
	}

	private void deleteAllRecordsProcess(int flag) {
		// TODO Auto-generated method stub
		if(flag==0) {
			// ����ɾ������
			String sql = "delete from reward;";
			System.out.println("<������ѯ��¼> deleteAllRecordsProcess(). sql = " + sql);
			try {
				if (dbProcess.executeUpdate(sql) < 1) {
					System.out.println("<������ѯ��¼> deleteAllRecordsProcess(). delete database failed.");
				}
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
			queryAllProcess(0);
		}else if(flag==1) {
			// ����ɾ������
						String sql = "delete from punishment;";
						System.out.println("<�ͷ���ѯ��¼> deleteAllRecordsProcess(). sql = " + sql);
						try {
							if (dbProcess.executeUpdate(sql) < 1) {
								System.out.println("<�ͷ���ѯ��¼> deleteAllRecordsProcess(). delete database failed.");
							}
						} catch (Exception e) {
							System.out.println("e = " + e);
							JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
						}
						queryAllProcess(1);
		}
		
	}

	private void deleteCurrentRecordProcess(int flag) {
		// TODO Auto-generated method stub
		if(flag==0) {
			String id = T_jlh1.getText().trim();

			// ����ɾ������
			String sql = "delete from reward where id = '" + id + "';";
			System.out.println("<������¼����> deleteCurrentRecordProcess(). sql = " + sql);
			try {
				if (dbProcess.executeUpdate(sql) < 1) {
					System.out.println("<������¼����> deleteCurrentRecordProcess(). delete database failed.");
				}
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
			queryAllProcess(0);
		}else if(flag==1) {
			String id = T_jlh2.getText().trim();

			// ����ɾ������
			String sql = "delete from punishment where id = '" + id + "';";
			System.out.println("<�ͷ���¼����> deleteCurrentRecordProcess(). sql = " + sql);
			try {
				if (dbProcess.executeUpdate(sql) < 1) {
					System.out.println("<�ͷ���¼����> deleteCurrentRecordProcess(). delete database failed.");
				}
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
			queryAllProcess(1);
		}
	}

	private void updateProcess(int flag) {
		// TODO Auto-generated method stub
		if(flag==0) {
			String id = T_jlh1.getText().trim();
			String rec_time = T_jlsj1.getText().trim();
			String description = T_ms1.getText().trim();
			String studentid= T_xh1.getText().trim();
			String reward = T_jldj.getText().trim();
			
			// ������������
			String sql = "update reward set rec_time = '";
			sql = sql + rec_time + "', description = '";
			sql = sql + description + "', studentid = '";
			sql = sql + studentid + "', reward = '";
			sql = sql + reward + "'";
			sql = sql + " WHERE id = '" + id + "';";
			System.out.println("<������¼����> updateProcess(). sql = " + sql);
			try {
				if (dbProcess.executeUpdate(sql) < 1) {
					System.out.println("<������¼����> updateProcess(). update database failed.");
				}
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
			queryAllProcess(0);
		}else if(flag==1) {
			String id = T_jlh2.getText().trim();
			String rec_time = T_jlsj2.getText().trim();
			String enable = T_sfsx.getText().trim();
			String description = T_ms2.getText().trim();
			String studentid= T_xh2.getText().trim();
			String levels = T_cfdj.getText().trim();
			
			// ������������
			String sql = "update punishment set rec_time = '";
			sql = sql + rec_time + "', enable = '";
			sql = sql + enable + "', description = '";
			sql = sql + description + "', studentid = '";
			sql = sql + studentid + "', levels = '";
			sql = sql + levels + "'";
			sql = sql + " WHERE id = '" + id + "';";
			System.out.println("<�ͷ���¼����> updateProcess(). sql = " + sql);
			try {
				if (dbProcess.executeUpdate(sql) < 1) {
					System.out.println("<�ͷ���¼����> updateProcess(). update database failed.");
				}
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
			queryAllProcess(1);
		}
		
	}

	private void insertProcess(int flag) {
		// TODO Auto-generated method stub
		if(flag==0) {
			String id = T_jlh1.getText().trim();
			String rec_time = T_jlsj1.getText().trim();
			String description = T_ms1.getText().trim();
			String studentid= T_xh1.getText().trim();
			String reward = T_jldj.getText().trim();
			
			// ������������
			String sql = "insert into reward values('";
			sql = sql + id + "','";
			sql = sql + rec_time + "','";
			sql = sql + description + "','";
			sql = sql + studentid + "','";
			sql = sql + reward + "');";

			System.out.println("<������¼����> insertProcess(). sql = " + sql);
			try {
				if (dbProcess.executeUpdate(sql) < 1) {
					System.out.println("<������¼����> insertProcess(). insert database failed.");
				}
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
			queryAllProcess(0);
		}else if(flag==1) {
			String id = T_jlh2.getText().trim();
			String rec_time = T_jlsj2.getText().trim();
			String enable = T_sfsx.getText().trim();
			String description = T_ms2.getText().trim();
			String studentid= T_xh2.getText().trim();
			String levels = T_cfdj.getText().trim();
			
			// ������������
			String sql = "insert into punishment values('";
			sql = sql + id + "','";
			sql = sql + rec_time + "','";
			sql = sql + enable + "','";
			sql = sql + description + "','";
			sql = sql + studentid + "','";
			sql = sql + levels + "');";

			System.out.println("<�ͷ���¼����> insertProcess(). sql = " + sql);
			try {
				if (dbProcess.executeUpdate(sql) < 1) {
					System.out.println("<�ͷ���¼����> insertProcess(). insert database failed.");
				}
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
			queryAllProcess(1);
		}
		
	}

	private void queryAllProcess(int flag) {
		// TODO Auto-generated method stub
		if(flag==0) {
			try {
				// ������ѯ����
							String sql = "select * from v_reward;";
							System.out.println("<������¼����> queryAllProcess(). sql = " + sql);

							dbProcess.connect();
							ResultSet rs = dbProcess.executeQuery(sql);

				// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				rewardVector.clear();
				while (rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString("id"));
					v.add(rs.getString("studentid"));
					v.add(rs.getString("reward"));
					v.add(rs.getString("rec_time"));
					v.add(rs.getString("description"));
					rewardVector.add(v);
				}

				rewardJTable.updateUI();// ˢ�±��

				dbProcess.disconnect();// �Ͽ�����
			} catch (SQLException sqle) {
				System.out.println("sqle = " + sqle);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
		}else if(flag==1) {
			try {
				// ������ѯ����
							String sql = "select * from v_punishment;";
							System.out.println("<�ͷ���¼����> queryAllProcess(). sql = " + sql);

							dbProcess.connect();
							ResultSet rs = dbProcess.executeQuery(sql);

				// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
							punishmentVector.clear();
							while (rs.next()) {
								Vector v = new Vector();
								v.add(rs.getString("id"));
								v.add(rs.getString("studentid"));
								v.add(rs.getString("levels"));
								v.add(rs.getString("rec_time"));
								v.add(rs.getString("enable"));
								v.add(rs.getString("description"));
								punishmentVector.add(v);
							}

							punishmentJTable.updateUI();// ˢ�±��

							dbProcess.disconnect();// �Ͽ�����
			} catch (SQLException sqle) {
				System.out.println("sqle = " + sqle);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void queryProcess(String sQueryField, int flag) {
		// TODO Auto-generated method stub
		if (flag == 0) {
			try {

				// ������ѯ����
				String sql = "select * from v_reward where ";
				String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr1, 0);

				sql = sql + queryFieldStr;
				sql = sql + " = ";
				sql = sql + "'" + sQueryField + "';";

				System.out.println("<������¼����> queryProcess(). sql = " + sql);

				dbProcess.connect();// ����
				ResultSet rs = dbProcess.executeQuery(sql);

				// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				rewardVector.clear();
				while (rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString("id"));
					v.add(rs.getString("studentid"));
					v.add(rs.getString("reward"));
					v.add(rs.getString("rec_time"));
					v.add(rs.getString("description"));
					rewardVector.add(v);
				}

				rewardJTable.updateUI();// ˢ�±��

				dbProcess.disconnect();// �Ͽ�����

			} catch (SQLException sqle) {
				System.out.println("sqle = " + sqle);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
		} else if (flag == 1) {
			try {
				// ������ѯ����

				String sql = "select * from v_punishment where ";
				String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr2, 1);

				sql = sql + queryFieldStr;
				sql = sql + " = ";
				sql = sql + "'" + sQueryField + "';";

				System.out.println("<�ͷ���¼����> queryProcess(). sql = " + sql);

				dbProcess.connect();// ����
				ResultSet rs = dbProcess.executeQuery(sql);

				// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				punishmentVector.clear();
				while (rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString("id"));
					v.add(rs.getString("studentid"));
					v.add(rs.getString("levels"));
					v.add(rs.getString("rec_time"));
					v.add(rs.getString("enable"));
					v.add(rs.getString("description"));
					punishmentVector.add(v);
				}

				punishmentJTable.updateUI();// ˢ�±��

				dbProcess.disconnect();// �Ͽ�����

			} catch (SQLException sqle) {
				System.out.println("sqle = " + sqle);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private String jCBSelectQueryFieldTransfer(String InputStr, int flag) {
		if (flag == 0) {
			String outputStr = "";
			System.out.println("<������¼����> jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);

			if (InputStr.equals("��¼��")) {
				outputStr = "id";
			} else if (InputStr.equals("ѧ��")) {
				outputStr = "studentid";
			} else if (InputStr.equals("�����ȼ�")) {
				outputStr = "reward";
			} else if (InputStr.equals("��¼ʱ��")) {
				outputStr = "rec_time";
			} else if (InputStr.equals("����")) {
				outputStr = "description";
			}

			System.out.println("<������¼����> jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
			return outputStr;
		} else if (flag == 1) {
			String outputStr = "";
			System.out.println("<�ͷ���¼����> jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);

			if (InputStr.equals("��¼��")) {
				outputStr = "id";
			} else if (InputStr.equals("ѧ��")) {
				outputStr = "studentid";
			} else if (InputStr.equals("�ͷ��ȼ�")) {
				outputStr = "levels";
			} else if (InputStr.equals("��¼ʱ��")) {
				outputStr = "rec_time";
			} else if (InputStr.equals("����")) {
				outputStr = "description";
			} else if (InputStr.equals("�Ƿ���Ч")) {
				outputStr = "enable";
			}

			System.out.println("<�ͷ���¼����> jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
			return outputStr;
		}
		return null;
	}
}
