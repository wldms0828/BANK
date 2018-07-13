package controller;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.JOptionPane;
import domain.*;
import service.*;
import seviceImpl.*;

enum Membutton{
	//join은 일반 유저추가, add는 직원 추가
	EXIT,
	JOIN,ADD,//create
	LIST,FIND_BY_ID,FIND_BY_NAME,COUNT,//전체 , one , some
	UPDATE,
	WITHDRAWAL
};
public class MemberController {
	public static void main(String[] args) {
		MemberBean member =null;
		MemberService service = new MemberServiceImpl();
		while(true) {
		
			switch((Membutton) JOptionPane.showInputDialog(null, // frame
					"Select function", // frame title
					"MemberMenu", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					new Membutton[] {Membutton.EXIT,
					Membutton.JOIN,
					Membutton.ADD,
					Membutton.LIST,
					Membutton.FIND_BY_ID,
					Membutton.FIND_BY_NAME,
					Membutton.COUNT,
					Membutton.UPDATE,
					Membutton.WITHDRAWAL,
					}, // Array of choices
					null // default
							)) {
			/*
			 * uid,password,name,ssn,address,phone,email;
			 * */
			case EXIT : return;
			case JOIN :
				member = new UserBean();
				member.setUid(JOptionPane.showInputDialog("ID"));
				member.setPassword(JOptionPane.showInputDialog("PASSWORD"));
				member.setName(JOptionPane.showInputDialog("Name"));
				member.setSsn(JOptionPane.showInputDialog("SSN"));
				member.setAddress(JOptionPane.showInputDialog("ADDRESS"));
				member.setPhone(JOptionPane.showInputDialog("PHONE"));
				member.setEmail(JOptionPane.showInputDialog("EMAIL"));
				service.join((UserBean) member);
				break;
			case ADD : 
				member = new StaffBean();
				member.setUid(JOptionPane.showInputDialog("ID"));
				member.setPassword(JOptionPane.showInputDialog("PASSWORD"));
				member.setName(JOptionPane.showInputDialog("Name"));
				member.setSsn(JOptionPane.showInputDialog("SSN"));
				member.setAddress(JOptionPane.showInputDialog("ADDRESS"));
				member.setPhone(JOptionPane.showInputDialog("PHONE"));
				member.setEmail(JOptionPane.showInputDialog("EMAIL"));
				service.add((StaffBean) member);
				break;
			case LIST : 
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case FIND_BY_ID : 
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("ID"));
				member.setPassword(JOptionPane.showInputDialog("PASSWORD"));
				JOptionPane.showMessageDialog(null, service.findById(member));
				break;
			case FIND_BY_NAME : 
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("NAME")));
				break;
			case COUNT : 
				JOptionPane.showMessageDialog(null, service.count());
				break;
			case UPDATE :
				member.setUid(JOptionPane.showInputDialog("ID"));
				member.setPassword(JOptionPane.showInputDialog("PASSWORD")
						+ ("/")
						+ JOptionPane.showInputDialog("NEWPASSWORD"));
				JOptionPane.showMessageDialog(null, service.update(member));
				break;
			case WITHDRAWAL : 
				break;
			default : break;
			}
		}
	}
}

