package MainPart.controller;

import java.util.Scanner;

public class ProManagement {
	
	ProManageList proManage;
	Scanner sc = new Scanner(System.in);

	// 실행될때마다 상품의 최신정보가 로드됨
	public ProManagement() {
		proManage = new ProManageList();
		proManage.proReadCsv();
	}
	
    public void pManagement() {
    	
        while (true) {
        	
        	System.out.println("---- 상품관리 ----");
        	System.out.printf("1. 상품등록\n2. 상품수정\n3. 상품삭제\n4. 상품조회\n5. 상품전체조회\n6. 메인으로 돌아가기\n7. 종료\n");
        	System.out.println("---------------");
        	
        	int nextPro = sc.nextInt();
        	
        	switch(nextPro)
        	{
        	case 1 :
        		proManage.proAdd(); // 상품등록 메소드 실행
        		break;
        	case 2 :
        		proManage.proEdit(); // 상품수정 메소드 실행
        		break;
        	case 3 :
        		proManage.proDel(); // 상품삭제 메소드 실행
        		break;
        	case 4 :
        		proManage.proView(); // 상품조회 메소드 실행
        		break;
        	case 5 :
        		proManage.proAll(); // 상품전체조회 메소드 실행
        		break;
        	case 6 :
        		proManage.proMain(); // 메인으로 돌아가기 메소드 실행
        		break;
        	case 7 :
        		proManage.proExit(); // 상품관리 탭에서의 프로그램 종료 메소드 실행
        		break;
        	default :
        		System.out.println("잘못된 접근입니다. 프로그램을 종료합니다. "); // 위 케이스 외 입력시 잘못된 접근판단, 프로그램 종료시킴
        		return;
        	}
        }
    }
}
