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
	//容器的集合
	Vector<JPanel> jpanel = new Vector<JPanel>();
	/**
	 * 所有的容器
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
	
	DefaultTableModel defaultTableModel = null;// 表格模式
	JTableHeader head = null;// 表格标题对象

	JTable studentJTable = null;// 表格
	JScrollPane studentJScrollPane = null;// 滚动条
	Vector studentVector = null;// 表格内容集合
	Vector titleVector = null;// 表格标题集合

	JComboBox<String> jCBSelectQueryField = null;// 查询字段

	private static DbProcessDemo dbProcess;// 连接数据库
	String SelectQueryFieldStr = "学号";

	JLabel L_xsxxb = null;// 学生信息表
	JLabel L_xzcxzd = null;// 选择查询字段
	JLabel L_equal = null;// =
	JLabel L_xh = null;// 学号
	JLabel L_xm = null;// 姓名
	JLabel L_xb = null;// 性别
	JLabel L_bj = null;// 班级
	JLabel L_sr = null;// 生日
	JLabel L_jg = null;// 籍贯
	JLabel L_yx = null;// 院系

	JTextField T_cxzd = null;// 查询字段
	JTextField T_xh = null;// 学号
	JTextField T_xm = null;// 姓名
	JTextField T_xb = null;// 性别
	JTextField T_bj = null;// 班级
	JTextField T_sr = null;// 生日
	JTextField T_jg = null;// 籍贯
	JTextField T_yx = null;// 院系

	JButton jBQuery = null;// 查询
	JButton jBQueryAll = null;// 查询所有记录
	JButton jBInsert = null;// 插入
	JButton jBUpdate = null;// 更新
	JButton jBDeleteCurrentRecord = null;// 删除当前记录
	JButton jBDeleteAllRecords = null;// 删除所有记录
	JButton jBRewardPunish = null;
	JButton jBChange = null;// 变更学籍

	private void setup() {
		/**
		 * 字体
		 */
		Font f = new Font("楷体", Font.BOLD, 25);
		Font f1 = new Font("楷体", Font.BOLD, 18);
		Font f2 = new Font("楷体", Font.BOLD, 15);
		/**
		 * 总框架
		 */
		p1 = new JPanel();
		p1.setLayout(null);
		this.add(p1);
		/**
		 * 输入删除更新查询容器
		 */
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(new Rectangle(0, 250, 700, 250));
		p2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p1.add(p2);
		/**
		 * 按钮容器
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
		 * 按钮
		 */
		jBQuery = new JButton("查询");
		jBQuery.setFont(f);
		jBQueryAll = new JButton("查询所有记录");
		jBQueryAll.setFont(f);
		jBInsert = new JButton("插入");
		jBInsert.setFont(f);
		jBUpdate = new JButton("更新");
		jBUpdate.setFont(f);
		jBDeleteCurrentRecord = new JButton("删除当前记录");
		jBDeleteCurrentRecord.setFont(f);
		jBDeleteAllRecords = new JButton("删除所有记录");
		jBDeleteAllRecords.setFont(f);
		/**
		 * 为按钮设置监听器
		 */
		jBQuery.addActionListener(this);
		jBQueryAll.addActionListener(this);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		jBDeleteCurrentRecord.addActionListener(this);
		jBDeleteAllRecords.addActionListener(this);
		/**
		 * 将按钮插入容器中
		 */
		p4.add(jBInsert);
		p4.add(jBUpdate);
		p5.add(jBQuery);
		p6.add(jBQueryAll);
		p7.add(jBDeleteCurrentRecord);
		p8.add(jBDeleteAllRecords);
		/**
		 * 奖励、学籍变更、处罚按钮容器
		 */
		p9 = new JPanel();
		p9.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));
		p9.setBounds(new Rectangle(0, 500, 700, 80));
		p9.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p1.add(p9);
		/**
		 * 奖罚系统，学籍变更按钮插入容器
		 */
		jBRewardPunish = new JButton("奖罚系统");
		jBRewardPunish.setFont(f);
		jBChange = new JButton("学籍变更");
		jBChange.setFont(f);
		p9.add(jBRewardPunish);
		p9.add(jBChange);
		/**
		 * 为奖罚系统，学籍变更添加监听器
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
		 * 输入容器
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
		 * 创建输入框以及相应的标签
		 */
		L_xzcxzd = new JLabel("选择查询字段");// 选择查询字段
		L_xzcxzd.setFont(f1);
		L_equal = new JLabel("=");// =
		L_equal.setFont(f);
		L_xh = new JLabel("学号");// 学号
		L_xh.setFont(f);
		L_xh.setForeground(Color.red);
		L_xm = new JLabel("姓名");// 姓名
		L_xm.setFont(f);
		L_xb = new JLabel("性别");// 性别
		L_xb.setFont(f);
		L_bj = new JLabel("班级");// 班级
		L_bj.setFont(f);
		L_sr = new JLabel("生日");// 生日
		L_sr.setFont(f);
		L_jg = new JLabel("籍贯");// 籍贯
		L_jg.setFont(f);
		L_yx = new JLabel("院系");// 院系
		L_yx.setFont(f);

		T_cxzd = new JTextField(10);// 查询字段
		T_xh = new JTextField(10);// 学号
		T_xm = new JTextField(10);// 姓名
		T_xb = new JTextField(10);// 性别
		T_bj = new JTextField(10);// 班级
		T_sr = new JTextField(10);// 生日
		T_jg = new JTextField(10);// 籍贯
		T_yx = new JTextField(10);// 院系
		/**
		 * 为所有的输入框设置字体
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
		 * 将输入框以及标签插入容器
		 */
		L_xzcxzd.setBounds(new Rectangle(20, 5, 120, 40));
		jCBSelectQueryField = new JComboBox<String>();// 查询字段
		jCBSelectQueryField.setFont(f1);
		jCBSelectQueryField.addItem("学号");
		jCBSelectQueryField.addItem("姓名");
		jCBSelectQueryField.addItem("性别");
		jCBSelectQueryField.addItem("班级");
		jCBSelectQueryField.addItem("院系");
		jCBSelectQueryField.addItem("生日");
		jCBSelectQueryField.addItem("籍贯");
		/**
		 * getItem()：用来获得触发此次事件的选项，该方法的返回值为 Object 型。
		 * 
		 * getStateChange()：用来获得此次事件的类型，即是由取消原来选中项的选中状态触发的，还是由选中新选项触发的，该方法的返回值为 int
		 * 型，可以通过 ItemEvent 类中如下静态常量判断此次事件的具体类型：
		 * 
		 * SELECTED：代表此次事件是由选中 新选项触发的。
		 * 
		 * DESELECTED：代表此次事件是由取消原来选中项的选中状态触发的。
		 */
		jCBSelectQueryField.addItemListener(new ItemListener() {// 下拉框事件监听
			public void itemStateChanged(ItemEvent event) {
				switch (event.getStateChange()) {
				case ItemEvent.SELECTED:
					SelectQueryFieldStr = (String) event.getItem();
					System.out.println("选中：" + SelectQueryFieldStr);
					break;
				case ItemEvent.DESELECTED:
					System.out.println("取消选中：" + event.getItem());
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
		 * 学生信息表标签
		 */
		L_xsxxb = new JLabel("学生信息表");// 学生信息表
		L_xsxxb.setFont(f);
		p16 = new JPanel();
		p16.setLayout(new FlowLayout(FlowLayout.CENTER));
		p16.setBounds(new Rectangle(0, 0, 700, 50));
		p16.add(L_xsxxb);
		p1.add(p16);
		/**
		 * 学生信息表表格的容器
		 */
		p17 = new JPanel();
		p17.setLayout(null);
		p17.setBounds(new Rectangle(0, 50, 700, 200));
		// p17.setBorder(BorderFactory.createLineBorder(Color.black,1));
		p1.add(p17);
		/**
		 * 学生信息表表格
		 */
		studentVector = new Vector<String>();
		titleVector = new Vector<String>();

		titleVector.add("学号");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("班级");
		titleVector.add("院系");
		titleVector.add("生日");
		titleVector.add("籍贯");

		// defaultTableModel = new DefaultTableModel(studentVector, titleVector);
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setFont(f2);
		head = studentJTable.getTableHeader(); // 创建表格标题对象
		head.setFont(f);

		studentJScrollPane = new JScrollPane(studentJTable);
		studentJScrollPane.setBounds(new Rectangle(0, 0, 700, 200));
		// 分别设置水平和垂直滚动条自动出现
		studentJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// 为表格添加监听器
		studentJTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);

				T_xh.setText((String) v.get(0));// 学号
				T_xm.setText((String) v.get(1));// 姓名
				T_xb.setText((String) v.get(2));// 性别
				T_bj.setText((String) v.get(3));// 班級
				T_yx.setText((String) v.get(4));// 院系
				T_sr.setText((String) v.get(5));// 生日
				T_jg.setText((String) v.get(6));// 籍貫
			}
		});
		p17.add(studentJScrollPane);
		dbProcess = new DbProcessDemo();
		/**
		 * 将所有容器加入到jpanel集合中
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
		 * 设置背景
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
		super("学生信息管理系统");
		setup();
		setSize(700, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("查询") && !T_cxzd.getText().isEmpty()) {
			System.out.println("actionPerformed(). 查询");
			String sQueryField = T_cxzd.getText().trim();
			queryProcess(sQueryField);
			T_cxzd.setText("");
		} else if (e.getActionCommand().equals("查询所有记录")) {
			System.out.println("actionPerformed(). 查询所有记录");
			queryAllProcess();
		} else if (e.getActionCommand().equals("插入") && !T_xh.getText().isEmpty() && !T_xm.getText().isEmpty()
				&& !T_xb.getText().isEmpty() && !T_bj.getText().isEmpty() && !T_sr.getText().isEmpty()
				&& !T_yx.getText().isEmpty()&& !T_jg.getText().isEmpty()) {
			System.out.println("actionPerformed(). 插入");
			insertProcess();
		} else if (e.getActionCommand().equals("更新") && !T_xh.getText().isEmpty() && !T_xm.getText().isEmpty()
				&& !T_xb.getText().isEmpty() && !T_bj.getText().isEmpty() && !T_sr.getText().isEmpty()
				&& !T_yx.getText().isEmpty()&& !T_jg.getText().isEmpty()) {
			System.out.println("actionPerformed(). 更新");
			updateProcess();
		} else if (e.getActionCommand().equals("删除当前记录")) {
			System.out.println("actionPerformed(). 删除当前记录");
			deleteCurrentRecordProcess();
		} else if (e.getActionCommand().equals("删除所有记录")) {
			System.out.println("actionPerformed(). 删除所有记录");
			deleteAllRecordsProcess();

		}

	}

	private void deleteAllRecordsProcess() {
		// TODO Auto-generated method stub
		// 建立删除条件
				String sql = "delete from student;";
				System.out.println("deleteAllRecordsProcess(). sql = " + sql);
				try {
					if (dbProcess.executeUpdate(sql) < 1) {
						System.out.println("deleteAllRecordsProcess(). delete database failed.");
					}
				} catch (Exception e) {
					System.out.println("e = " + e);
					JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
				}
				queryAllProcess();
	}

	private void deleteCurrentRecordProcess() {
		// TODO Auto-generated method stub
		String sNo = T_xh.getText().trim();

		// 建立删除条件
		String sql = "delete from student where studentid = '" + sNo + "';";
		System.out.println("deleteCurrentRecordProcess(). sql = " + sql);
		try {
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("deleteCurrentRecordProcess(). delete database failed.");
			}
		} catch (Exception e) {
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
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
		
		// 建立更新条件
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
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
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
		
		// 建立插入条件
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
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	private void queryAllProcess() {
		// TODO Auto-generated method stub
		try {
			// 建立查询条件
						String sql = "select * from v_student;";
						System.out.println("queryAllProcess(). sql = " + sql);

						dbProcess.connect();
						ResultSet rs = dbProcess.executeQuery(sql);

			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
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
			

			studentJTable.updateUI();//刷新表格

			dbProcess.disconnect();//断开连接
		} catch (SQLException sqle) {
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}


	private void queryProcess(String sQueryField) {
		try {
			// 建立查询条件
			String sql = "select * from v_student where ";
			String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);

				sql = sql + queryFieldStr;
				sql = sql + " = ";
				sql = sql + "'" + sQueryField + "';";

			System.out.println("queryProcess(). sql = " + sql);

			dbProcess.connect();//连接
			ResultSet rs = dbProcess.executeQuery(sql);

			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
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

			studentJTable.updateUI();//刷新表格

			dbProcess.disconnect();//断开连接
		} catch (SQLException sqle) {
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	private String jCBSelectQueryFieldTransfer(String InputStr) {
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);

		if (InputStr.equals("学号")) {
			outputStr = "studentid";
		} else if (InputStr.equals("姓名")) {
			outputStr = "name";
		} else if (InputStr.equals("性别")) {
			outputStr = "sex";
		} else if (InputStr.equals("生日")) {
			outputStr = "birthday";
		} else if (InputStr.equals("籍贯")) {
			outputStr = "native_place";
		} else if (InputStr.equals("班级")) {
			outputStr = "class";
		} else if (InputStr.equals("院系")) {
			outputStr = "department";
		}
			
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
	

}
