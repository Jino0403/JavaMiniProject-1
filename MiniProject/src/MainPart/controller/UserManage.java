package MainPart.controller;

import MainPart.User;
import MainPart.Product;

//메소드를 선언만 해놓고 재정의 하고자 인터페이스를 사용. 회원과 관련된 메소드가 선언만 되어있는 곳
public interface UserManage {

	  public abstract void add(); // 회원 등록을 위한 메소드
	  public abstract void charge(); // 회원 캐쉬를 충전하기 위한 메소드
	  public abstract void edit(); // 회원정보 수정을 위한 메소드
	  public abstract void delete(); // 회원정보 삭제를 위한 메소드
	  public abstract void view(); // 특정 회원 검색을 위한 메소드
	  public abstract void allView(); // 회원전체를 출력하기 위한 메소드
	  public abstract void exit(); // //회원정보 탭을 나가기 위한 메소드
	  public abstract void userList(User user); // 회원정보를 받아와서 출력하기 위한 메소드
	  public abstract void mainGo(); // 메인화면으로 돌아가는 메소드
	  
	  public abstract void userSaveCsv(); // 회원정보를 저장하기 위한 메소드
	  public abstract void userReadCsv(); // 회원정보를 불러오기 위한 메소드
}
