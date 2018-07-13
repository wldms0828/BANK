package controller;

import javax.swing.JOptionPane;
import domain.AccountBean;
import domain.MinusAccountBean;
import service.*;
import seviceImpl.AccountserviceImpl;

enum Accbutton{
	EXIT,
	ACCOUNT,
	MINUS_ACCOUNT,
	DPOSITE,
	WITHDRAW,
	LIST,
	FIND_BY_ID,
	FIND_BY_NAME,
	MINUS_LIST,
	CHANGE_PASS,
	DELETE_ACCOUNT
};
public class AccountController {
	public static void main(String[] args) {
		AccountBean account;
		Accountservice service = new AccountserviceImpl();
		while(true) {
		
			switch((Accbutton) JOptionPane.showInputDialog(null, // frame
					"Select function", // frame title
					"AccountMenu", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					new Accbutton[] {Accbutton.EXIT,
					Accbutton.ACCOUNT,
					Accbutton.MINUS_ACCOUNT,
					Accbutton.DPOSITE,
					Accbutton.WITHDRAW,
					Accbutton.LIST,
					Accbutton.FIND_BY_ID,
					Accbutton.FIND_BY_NAME,
					Accbutton.MINUS_LIST,
					Accbutton.CHANGE_PASS,
					Accbutton.DELETE_ACCOUNT}, // Array of choices
					null // default
							)) {
			case EXIT : return;
			case ACCOUNT :
				account = new AccountBean();
				account.setName(JOptionPane.showInputDialog("이름을 입력하세요."));
				account.setUid(JOptionPane.showInputDialog("사용자 ID를 입력하세요."));
				account.setPassword(JOptionPane.showInputDialog("사용자 PW를 입력하세요."));
				service.createAccount(account);
				break;
			case MINUS_ACCOUNT : 
				account = new MinusAccountBean();
				account.setName(JOptionPane.showInputDialog("이름을 입력하세요."));
				account.setUid(JOptionPane.showInputDialog("사용자 ID를 입력하세요."));
				account.setPassword(JOptionPane.showInputDialog("사용자 PASS를 입력하세요."));
				((MinusAccountBean) account).setLimit(Integer.parseInt(JOptionPane.showInputDialog("대출한도를 입력하세요.")));
				service.createAccount(account);
				break;
			case DPOSITE : 
				break;
			case WITHDRAW : 
				break;
			case LIST : 
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case FIND_BY_ID : 
				/*ID와 PASS 받아서 일치하면 계좌내역을 보여줘.
				 * 단, 혹시 모르니 비밀번호는 ****처리
				 * */
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("사용자 ID를 입력하세요."));
				account.setPassword(JOptionPane.showInputDialog("사용자 PASS를 입력하세요."));
				JOptionPane.showMessageDialog(null, service.findById(account));
				break;
			case FIND_BY_NAME :
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름을 입력하세요.")));
				break;
			case MINUS_LIST: 
				JOptionPane.showMessageDialog(null, service.minusList());
				break;
			case CHANGE_PASS : 
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("사용자 ID를 입력하세요."));
				account.setPassword(JOptionPane.showInputDialog("사용자 PASS를 입력하세요.")
						+"/"+
						 JOptionPane.showInputDialog("변경할 PASS를 입력하세요."));
				//ID,PASS,NEW PASS
				JOptionPane.showMessageDialog(null, service.changePass(account));
				break;
			case DELETE_ACCOUNT : 
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("사용자 ID를 입력하세요."));
				account.setPassword(JOptionPane.showInputDialog("사용자 PASS를 입력하세요.")
						+"/"+
						JOptionPane.showInputDialog("비밀번호를 한 번 더 입력하세요.")
						);
				JOptionPane.showMessageDialog(null, service.deleteAccount(account)); 
				//계좌삭제 후 총 계좌 수가 1 감소해야함.
				break;
			default : break;
			}
		}
	}
}
