package domain;

public class MinusAccountBean extends AccountBean {
	public final static String BANK_NAME="비트뱅크";
	public final static String ACCOUNT_TYPE="마이너스통장";

	public int  limit;// 대출금, 대출한도
	public void setLimit(int limit) {
		this.limit= limit;
	}
	public void setAccountType(String accoutType) {
		accountType=ACCOUNT_TYPE;
	}
	public int getLimit() {
		return limit;
	}
	
	public String toString() {
		return String.format(" %s\n %s\n 계좌번호 : %s\n 이름 : %s\n 생성일 : %s\n 잔액 : %d\n 아이디 : %s\n 비밀번호 : ****\n 대출한도 : %d",
				BANK_NAME,ACCOUNT_TYPE,super.getAccountNum(),super.getName(),super.getCreatDate(),super.getMoney(),super.getUid(),limit);
		}
	}
