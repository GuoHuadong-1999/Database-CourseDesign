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
	 * 输入框
	 */
	JTextField T_yhm = null;
	JPasswordField password1 = null;
	JPasswordField password2 = null;
	private static DbProcessDemo dbProcess;// 连接数据库
	private void setup() {
		/** 
		  * 创建最外层的容器
		 */
		JPanel p1 = new JPanel();
		add(p1);
		p1.setLayout(null);
		/**
		 * 字体
		 * */
		Font f = new Font("楷体", Font.BOLD, 25);
		Font f1 = new Font("楷体", Font.BOLD, 18);
		/**
		 * 用户名的标签
		 * */
		JLabel J_yhm = new JLabel("用户名");
		J_yhm.setFont(f);
		J_yhm.setBounds(new Rectangle(100, 50, 100, 50));
		//J_yhm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(J_yhm);
		/**
		 * 密码的标签
		 * */
		JLabel J_mm = new JLabel("密码");
		J_mm.setFont(f);
		J_mm.setBounds(new Rectangle(100, 110, 100, 50));
		//J_mm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(J_mm);
		/**
		 * 确认密码的标签
		 * */
		JLabel J_qrmm = new JLabel("确认密码");
		J_qrmm.setFont(f);
		J_qrmm.setBounds(new Rectangle(100, 170, 130, 50));
		//J_qrmm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(J_qrmm);
		/**
		 * 用户名的输入框
		 * */
		T_yhm = new JTextField();
		T_yhm.setFont(f1);
		T_yhm.setBounds(new Rectangle(250, 50, 300,50));
		p1.add(T_yhm);
		/**
		 * 密码的输入框
		 */
		password1=new JPasswordField(20);
		password1.setEchoChar('*');
		password1.setFont(f1);
		password1.setBounds(new Rectangle(250, 110, 300, 50));
		p1.add(password1);
		/**
		 * 确认密码的输入框
		 */
		password2=new JPasswordField(20);
		password2.setEchoChar('*');
		password2.setFont(f1);
		password2.setBounds(new Rectangle(250, 170, 300, 50));
		//password2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p1.add(password2);
		/**
		 * 注册按钮
		 */
		JPanel p2 = new JPanel();
		p2.setBounds(new Rectangle(150, 270,400,50));
		//p2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,60,5));
		p1.add(p2);
		JButton B_zc = new JButton("注册");
		B_zc.setFont(f);
		p2.add(B_zc);
		/**
		 * 为注册按钮创建监听器
		 */
		B_zc.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(examine()) {
					System.out.println("恭喜您注册成功！");
					setVisible(false);
				}
			}

			private boolean examine() {
				// TODO Auto-generated method stub
				try {
					// 建立查询条件
					String sql = "select * from user;";
					System.out.println("queryAllProcess(). sql = " + sql);

					dbProcess.connect();
					ResultSet rs = dbProcess.executeQuery(sql);
					// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					boolean flag = true;
					while (rs.next()) {
						if(rs.getString("id").equals(T_yhm.getText())) {
							flag = false;
							System.err.println("抱歉，用户名已存在，请重新输入！");
							T_yhm.setText("");
							return flag;
						}
					}
					/**
					 * 如果用户名不存在，插入该信息
					 */
					if(flag&&password1.getText().equals(password2.getText())) {
						insertProcess();
						return true;
					}else if(!password1.getText().equals(password2.getText())) {
						System.err.println("抱歉，两次密码不相同，请重新输入！");
						password1.setText("");
						password2.setText("");
						return false;
					}

					dbProcess.disconnect();// 断开连接
				} catch (SQLException sqle) {
					System.out.println("sqle = " + sqle);
					JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					System.out.println("e = " + e);
					JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
				}
				return false;
			}

			private void insertProcess() {
				// TODO Auto-generated method stub
				String id = T_yhm.getText();
				String password = password1.getText();
				
				// 建立插入条件
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
					JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		dbProcess = new DbProcessDemo();
		/**
		 * 设置背景颜色
		 */
		p1.setBackground(Color.orange);
		p2.setBackground(Color.orange);
	}
	public EnrollDemo(){
		super("注册器");
		setup();
		setBounds(200, 200, 700, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
