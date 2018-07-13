package seviceImpl;
import domain.*;
import service.*;
public class MemberServiceImpl implements MemberService {
	MemberBean[] list ;
	int count;
	public MemberServiceImpl(){
		list = new MemberBean[10];
		count = 0;
	}
	public void addList(MemberBean member) {
		list[count++] = member;
	} 
	public MemberBean[] list() {
		return list;
	}
	@Override
	public void join(UserBean member) {
		member.setCreditRating("7등급");
		addList(member);
		
	}

	@Override
	public void add(StaffBean member) {
		member.setAccessNum("1234");
		addList(member);
	}
	@Override
	public MemberBean findById(MemberBean member) {
		MemberBean searchedmember = new MemberBean();
		for(int i =0;i<count;i++) {
			if(member.getUid().equals(list[i].getUid())) {
				searchedmember = list[i];
				System.out.println();
				break;
		}
		}
		return searchedmember;
	}
	@Override
	public MemberBean[] findByName(String name) {
		MemberBean[] searchName = new MemberBean[searchCount(name)];
		int n = 0;
		for(int i=0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				searchName[n]=list[i];
				n++;
			}
		}
		return searchName;
	}
	public int searchCount(String name) {
		int nameCount = 0;
		for(int i =0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				nameCount++;
			}
		}
		return nameCount;
	}
	@Override
	public String count() {
		String res = "회원수는" + count + "명입니다.";
		return res;
	}
	@Override
	public String update(MemberBean member) {
		String msg ="";
		String password = member.getPassword().split("/")[0];
		String newPassword = member.getPassword().split("/")[1];
		MemberBean upd = findById(member);
		upd.setPassword(password);
		if(upd.getUid()==null) {
				msg = "ID 불일치 혹은 비밀번호 변경실패";
		}else {
			if(password.equals(newPassword)) {
				msg = "변경실패";
			}else {
				msg = "변경성공";}
		}
			
		return msg;
	}


}
