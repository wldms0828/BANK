package seviceImpl;

import domain.*;
import service.Accountservice;
import java.text.SimpleDateFormat;
import java.util.Date;
public class AccountserviceImpl implements Accountservice {
	private AccountBean[] list;
	private AccountBean[] minuslist;
	private int count;
	private int count2;
	public AccountserviceImpl() {
		count = 0;
		count2 = 0;
		list = new AccountBean[10];
		minuslist = new AccountBean[10];
	}

	@Override
	public void createAccount(AccountBean account) {
		account.setAccountNum(createAccountNum());
		//account.setAccountType();
		account.setCreateDate(createDate());
		account.setMoney(deposit(""));
		addList(account);
	
	}

	@Override
	public void addList(AccountBean account) {
		
		list[count++] = account;
		if(account instanceof MinusAccountBean) {
			minuslist[count2++] = account;
		}
		
	}

	@Override
	public AccountBean[] list() {
		System.out.println("배열의 카운트: " +count);
		String res = "";
		for(int i =0;i<list.length;i++) {
			res += list[i]+"\n";
		}
		System.out.println("배열 내부"+res);
		return list;
	}

	@Override
	public int deposit(String money) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int withdraw(String money) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String createAccountNum() {
		String accountNum = "";
		for(int i = 0 ;i<3;i++) {
			if(i<2) {
				accountNum+=createRandom(0,999) + "-";
			}else {
				accountNum+=createRandom(0,999);
			}}
		return accountNum;
	}

	@Override
	public String createRandom(int start, int end) {
		String random = String.format("%03d",((int) (Math.random() * 999)));
		
		return random;
	}

	@Override
	public String createDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String date = sdf.format(d);
		return date;
	}

	

	@Override
	public AccountBean findById(AccountBean account) {
		AccountBean searchedaccount = new AccountBean();
		//배열 list 를 looping 하면서
		//ID가 일치하고 PASS가 일치한 값을 찾아서 그 객체를 리턴한다
		//일단 일치하는 값이 없는 경우는 나중에 처리
		for(int i = 0;i<count;i++) {
			if(account.getUid().equals(list[i].getUid()) 
					&& 
					account.getUid().equals(list[i].getUid())) {
				searchedaccount = list[i];
				break;
			}
		}
		return searchedaccount;
	}
	@Override
	public AccountBean[] findByName(String name) {
		AccountBean[] arr = new AccountBean[countSameWord(name)];
		
		return arr;
	}
	@Override
	public int countSameWord(String word) {
		int temp=0;//동명이인의 숫자
		for(int i = 0;i<count;i++) {
			if(word.equals(list[i].getName())) {
				temp++;}
		}
		return temp;
	}

	@Override
public AccountBean[] minusList() {
		
		return minuslist;
	}


	@Override
	public String changePass(AccountBean account) {
		String msg = "";
		String password = account.getPassword().split("/")[0];
		String newPassword = account.getPassword().split("/")[1];
		account.setPassword(password);
		account = findById(account);
		if(account.getUid()==null) {
			msg = "ID 존재하지 않거나 비밀번호 불일치";
		}else {
			if(password.equals(newPassword)) {
				msg = "비밀번호 변경 실패";
			}else {
				account.setPassword(newPassword);
				msg = "변경성공";
			}
		}
		//성공 : 변경완료 
		//실패 : 변경실패(이전의 비밀번호와 같으면)
		return msg;
	}

	@Override
	public String deleteAccount(AccountBean account) {
		String deletemsg = "";
		String password = account.getPassword().split("/")[0];
		String confirmPassword = account.getPassword().split("/")[1];
		account.setPassword(confirmPassword);
		for(int i = 0;i<count;i++) {
			if(account.getUid().equals(list[i].getUid())
					&&
					password.equals(list[i].getPassword())
					&&
					confirmPassword.equals(list[i].getPassword())) {
				list[i] = list[count-1];
				list[count-1]=null;
				count--;
				/*list[i] = list[--count]; --가 앞에오면 -1하고 시작
				list[count]=null;*/
				deletemsg = "계좌 삭제 완료";
				break;
			}else {
				deletemsg = "계좌 삭제 실패";
			}
		}
		
		return deletemsg;
	}
}

