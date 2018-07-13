package domain;

public class UserBean extends MemberBean {
	private String creditRating;

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	@Override
	public String toString() {
		return "사용자정보[아이디:" + uid + ", 비밀번호:" + password + ", 이름:" + name + ", 주민번호:" + ssn + ",주소:"
				+ address + ", 핸드폰번호:" + phone + ", 신용등급 : " + creditRating + "]";
	}
	
}
