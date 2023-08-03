package MainPart.controller;

import java.util.Scanner;

public class UserManagement {

	UserManageList uManage;
	Scanner sc = new Scanner(System.in);

	// 고객정보의 최신화된 것을 불러오기 위하여 선언
    public UserManagement() {
    	 uManage = new UserManageList();
    	 uManage.userReadCsv();
    }
	
	public void uManagement() {

	while (true) {

		System.out.println("------ 고객관리 ------");
		System.out.printf("1. 고객등록\n2. 고객캐쉬충전\n3. 고객정보수정\n4. 고객정보삭제\n5. 개인고객조회\n6. 전체고객조회\n7. 메인으로 돌아가기\n8. 종료\n ");
		System.out.println("-------------------");
		
		int select = sc.nextInt();
		
		switch (select) 
		{
		case 1:
			uManage.add(); // 고객등록 메소드
			break;
		case 2:
			uManage.charge(); // 고객캐쉬충전 메소드 실행
			break;
		case 3:
			uManage.edit(); // 고객정보수정 메소드 실행
			break;
		case 4:
			uManage.delete(); // 고객정보삭제 메소드 실행
			break;
		case 5:
			uManage.view(); // 개인고객조회 메소드 실행
			break;
		case 6:
			uManage.allView(); // 전체고객조회 메소드 실행
			break;
		case 7:
			uManage.mainGo(); // 메인으로 돌아가는 메소드 실행
			break;
		case 8:
			uManage.exit(); // 고객관리 내 종료 메소드 실행
			return;
		}
	}
   }
}