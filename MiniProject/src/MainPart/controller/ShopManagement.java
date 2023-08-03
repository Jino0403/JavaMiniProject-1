package MainPart.controller;

import java.util.Scanner;

public class ShopManagement {
    	
	Scanner sc = new Scanner(System.in);
	UserManageList userManage = new UserManageList();
	ProManageList proManage = new ProManageList();
	
	// 실행될떄마다 유저의 정보가 상품에 대한 정보가 저장됨
	public ShopManagement() {
		userManage.userReadCsv();
		proManage.proReadCsv();
	}

	public void sManagement() {

	while (true) {
		System.out.println("-------- 다있소 쇼핑몰 --------");
		System.out.printf("1. 상품구매\n2. 장바구니\n3. 로그아웃");
		int nextNum = sc.nextInt();
		
		switch (nextNum)
		{
		case 1 : 	
			proManage.proBuy(); // 상품구매 메소드 실행
			break;
		case 2 : 
			proManage.proBasket(); // 상품구매로 구매하고자 장바구니에 담은 물건들을 구매하기 위한 장바구니 실행
			break;
		case 3 :	
			proManage.Logout(); // 상품구매 관련된 행위가 일어난 후 정보를 최신화 하며, 쇼핑몰에서 로그아웃
			break;
		default :
			System.out.println("잘못된 접근입니다. 프로그램을 종료합니다."); // 위 케이스 외 입력시 잘못된 접근판단, 프로그램 종료시킴
			return;
		}
	}
  }
}
