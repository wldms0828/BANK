package service;

import domain.AccountBean;
public interface Accountservice {
	public void createAccount(AccountBean account);
	public void addList(AccountBean account);
	public AccountBean[] list() ;
	public int deposit(String money);
	public int withdraw(String money);
	public String createAccountNum();
	public String createRandom(int start,int end);
	public String createDate();
	public AccountBean findById(AccountBean account);
	public AccountBean[] findByName(String name);
	public int countSameWord(String word);
	public AccountBean[] minusList();
	public String changePass(AccountBean account);
	public String deleteAccount(AccountBean account);
	
}



