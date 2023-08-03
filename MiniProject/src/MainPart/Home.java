package MainPart;

import java.util.Scanner;

import MainPart.controller.ProManagement;
import MainPart.controller.ShopManagement;
import MainPart.controller.UserManagement;

public class Home {
    public static void main(String[] args) {
	
	    Scanner sc = new Scanner(System.in);
            
        // uManage는 고객관리섹션으로, pManage는 상품관리 섹션, sManage는 쇼핑몰로 이동하기 위해 선언되었음.
        UserManagement uManage = new UserManagement();
        ProManagement pManage = new ProManagement();
        ShopManagement sManage = new ShopManagement();

    	System.out.println("---- daitso Shopping ----");
	    System.out.printf("1. 쇼핑몰\n2. 고객관리\n3. 상품관리\n4. 종료\n");
	    System.out.println("어떤 메뉴를 선택하시겠습니까?");
	    System.out.println("-------------------------");
	    
	    int nextNum = sc.nextInt();
    	
    	while (true) { 
    	    
    	switch (nextNum)
    	{
    	case 1:	
    		sManage.sManagement(); // 쇼핑몰 화면으로 이동
    		break;
    	case 2:
    		uManage.uManagement(); // 고객관리 화면으로 이동
    		break;
    	case 3:
    		pManage.pManagement(); // 상품관리 화면으로 이동
    		break;
    	case 4:
    		System.out.println("프로그램을 종료합니다. ");
    		return;
    	default :
    		System.out.println("비정상적인 접근입니다. 프로그램을 종료합니다.");
    		return;
    	}
      }
  }
}
