package service;

import domain.*;

public interface MemberService {

	void join(UserBean member);

	void add(StaffBean member);
	
	public MemberBean[] list ();

	public MemberBean findById(MemberBean member);

	public MemberBean[] findByName(String name);

	public String count();

	public String update(MemberBean member);








}
