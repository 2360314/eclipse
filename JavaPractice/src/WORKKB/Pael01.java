package WORKKB;

import javax.swing.*;

public class Pael01 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(300,600);
		
		// ID
		JLabel idLabel = new JLabel("아이디");
		JTextField idTxt = new JTextField(10);
		
		JPanel jp = new JPanel();
		jp.add(idLabel);
		jp.add(idTxt);
		
		//Password
		JLabel pwLabel = new JLabel("비밀번호");
		JPasswordField pwTxt = new JPasswordField(10);
		
		JPanel jp2 = new JPanel();
		jp2.add(pwLabel);
		jp2.add(pwTxt);
		 
		
		// 로그인, 취소
		JButton LoginBtn = new JButton("로그인");
		JButton OutBtn = new JButton("취소");
		JPanel jp3 = new JPanel();
		jp3.add(LoginBtn);
		jp3.add(OutBtn);
		
		JPanel all = new JPanel();
		f.setTitle("로그인창");
		all.add(jp);
		all.add(jp2);
		all.add(jp3);
		f.add(all);
		
		f.setVisible(true);
	}

}
