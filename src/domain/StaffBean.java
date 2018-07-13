package domain;

public class StaffBean extends MemberBean {
	private String accessNum;

	public String getAccessNum() {
		return accessNum;
	}

	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}

	@Override
	public String toString() {
		return "직원정보[아이디:" + uid + ", 비밀번호:" + password + ", 이름:" + name + ", 주민번호:" + ssn + ",주소:"
				+ address + ", 핸드폰번호:" + phone + ", 접근번호 : " + accessNum + "]";
	}
}
