package MainPart.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import MainPart.Basket;
import MainPart.Home;
import MainPart.Product;
import MainPart.User;

public class ProManageList implements ProManage {

	// 쇼핑몰 파트에서 장바구니에서 제품 구매후, 유저의 정보 최신화를 위해 선언만 해둠
	UserManageList userManage;
	ProManageList proManage;
	
	// 유저의 정보를 불러오기 위한 메소드 
	public void read() {
		userManage = new UserManageList();
		userManage.userReadCsv();
	}
	
	// 상품정보가 담기는 ArrayList 선언
    ArrayList<Product> products = new ArrayList<>();
    // 쇼핑몰 파트에서 장바구니에 해당하는 Basket 선언
    private Basket basket;
    Scanner scan = new Scanner(System.in);   
    
    
	@Override // 상품을 등록할때 사용하는 메소드 
	public void proAdd() {
		System.out.println("------- 상품등록 -------");
		System.out.printf("상품의 이름을 입력해주세요. \n상품이름 : ");
		String name = scan.next();
		
		// 상품안에 있는 상품목록과, 등록하고자 하는 상품명이 일치하면 발생하는 중복을 체크하기위한 체크코드
		for (Product product : products) {
			if (product.getProName().equals(name)) {
				System.out.println("중복된 상품입니다. 확인하고 다시 입력해주세요. ");
				return;
			} 
		}
			System.out.printf("상품의 번호를 입력해주세요. \n상품번호 : ");
			int num = scan.nextInt();
			
			System.out.printf("상품의 가격을 입력해주세요. \n상품가격 : ");
			int price = scan.nextInt();
			
			scan.nextLine(); //  nextInt()사용후 남아있는 개행문자가 다음 호출된 Scanner.nextLine()의 입력으로 처리되기 때문에 문제가 생함.
                             // 이를 해결하고자 (개행문자를 초기화해주기 위해서) 사용함. 그렇지 않으면 상품가격에서 정보를 입력하는 칸으로 넘어갈때 정보입력을 건너뛰고 끝나게됨
			
			System.out.printf("상품의 정보를 입력해주세요. \n상품정보 : ");
			String info = scan.nextLine();
			
			System.out.printf("상품의 재고량을 입력해주세요. \n상품재고량 : ");
			int count = scan.nextInt();
			
			Product pd = new Product(num, name, price, info, count);
			products.add(pd);
			
			System.out.println("추가가 완료되었습니다. ");
			System.out.printf( "상품번호 : " + pd.getProNum() + "\n상품이름 : " + pd.getProName() + "\n상품가격 : " + 
			pd.getProPrice() + "\n상품정보 : " + pd.getProInfo() + "\n상품재고량 : " + pd.getProCount() + "\n----------------\n");
		
			proSaveCsv();
	}

	@Override // 상품등록된 상품의 정보를 수정하기 위한 메소드
	public void proEdit() {
		System.out.println("------- 상품수정 -------");
		System.out.printf("수정할 상품의 이름을 입력해주세요. \n상품이름 : ");
		String name = scan.next();

		// for문을 사용하여 상품 크기를 측정하고, 등록되어있는 상품과 입력한 상품의 이름이 일치하게되면 수정으로 넘어간다.
		for (int i = 0; i < products.size(); i++) {
			Product pr = products.get(i);
			if (pr.getProName().equals(name)) {
				System.out.println("상품번호 : " + pr.getProNum() + "\n상품이름 : " + pr.getProName() + "\n상품가격 : " + 
			    pr.getProPrice() + "\n상품정보 : " + pr.getProInfo() + "\n상품재고량 : " + pr.getProCount() + "\n------------------\n");
				System.out.println("수정할 내용을 수정해주세요.");
				
				System.out.printf("수정될 상품번호 : ");
				int newNum = scan.nextInt();
				
				System.out.printf("\n수정될 상품이름 : ");
				String newName = scan.next();
				
				System.out.printf("\n수정될 상품가격 : ");
				int newPrice = scan.nextInt();
				
				System.out.printf("\n수정될 상품정보 : ");
				String newInfo = scan.next();
				
				scan.nextLine(); //  nextInt()사용후 남아있는 개행문자가 다음 호출된 Scanner.nextLine()의 입력으로 처리되기 때문에 문제가 생함.
				                 // 이를 해결하고자 (개행문자를 초기화해주기 위해서) 사용함. 그렇지 않으면 상품정보에서 재고량을 입력하는 칸으로 넘어갈때 재고량를 건너뛰고 끝나게됨
				
				System.out.printf("\n수정될 상품재고량 : ");
				int newCount = scan.nextInt();
				
				pr.setProNum(newNum);
				pr.setProName(newName);
				pr.setProPrice(newPrice);
				pr.setProInfo(newInfo);
				pr.setProCount(newCount);
				
				System.out.println("수정이 완료되었습니다. ");
				System.out.printf("상품번호 : " + pr.getProNum() + "\n상품이름 : " + pr.getProName() + "\n상품가격 : " + pr.getProPrice() 
				+ "\n상품정보 : " + pr.getProInfo() + "\n상품재고량 : " + pr.getProCount() + "\n-------------------\n");
			}
		}
		        proSaveCsv();
	}

	@Override // 등록된 상품을 삭제하기 위한 메소드
	public void proDel() {
		ArrayList<Product> productList = products;
		
		System.out.println("------- 상품삭제 -------");
		System.out.printf("삭제할 상품이름을 입력해주세요. ");
		String name = scan.next();
		
		// 값을 가져와서 삭제하기 위하여 Iterator를 사용
		for (Iterator<Product> productiter = products.iterator(); productiter.hasNext(); ) {
			Product product = productiter.next();
			if (product.getProName().equals(name)) {
				productiter.remove();
				productList.remove(product);
				System.out.println("상품이 삭제되었습니다. ");	
				return;
			} 
		}
		System.out.println("삭제하고자 하는 상품이 없습니다. ");
		proSaveCsv();
	}

	@Override // 조회하고 싶은 상품을 검색해서 조회할 수 있게 해주는 메소드
	public void proView() {
		System.out.println("------- 상품조회 -------");
		System.out.println("조회할 상품을 입력해주세요. ");
		String name = scan.next();
	
		if(products.isEmpty()) {
			System.out.println("조회할 상품이 업습니다. ");
		} else {
			for (Product product : products) {
				if(product.getProName().equals(name)) {
					productList(product);
					return;
				}
			}
		}
	}

	@Override // 등록된 상품 전체를 출력해주는 메소드
	public void proAll() {
		System.out.println("----- 상품전체조회 -----");
		
		// 값이 비어있는 경우, 상품등록을 하라는 메세지 송출, 그렇지 않으면 상품전체를 불러옴
		if(products.isEmpty()) {
			System.out.println("조회할 상품이 없습니다. 상품을 등록해주세요. ");
			return;
		} else {
			for (Product product : products)
				productList(product);
			    return;
		}
	}

	@Override // 쇼핑몰에서 상품을 구매하기위한 메소드 
	public void proBuy() {
		read(); // 등록되어있는 유저들의 정보를 불러옴
	    ArrayList<User> users = userManage.getUsers(); // 
	    
		System.out.println("------ 상품구매 ------");
		System.out.printf("로그인을 진행해주세요. \n아이디 : ");
		String id = scan.next();
        boolean proFound = false;
		int check = 0;
		User logInUser = null;
		for (User user : users) {
			if (user.getUserId().equals(id)) {
                logInUser = user;
				check = 1;
				System.out.println("저희 쇼핑몰에 오신것을 환영해요! ");
			} 
		}
		
        if (check == 0) {
        	System.out.println("존재하지 않는 아이디입니다. 다시 확인후 로그인해주세요.");
			return;
        }
        
        if (products.isEmpty() ) {
			System.out.println("조회할 상품이 없습니다. 상품을 등록해주세요. ");
			return;
		} else {
			proFound = true;
			for (Product product : products) {
				productList(product);
			}
		}

		System.out.printf("구매하실 상품의 이름을 입력해주세요. ");
		String name = scan.next();
		
		for (int i = 0; i < products.size();i++) {
			Product pro = products.get(i);
			if (pro.getProName().equals(name)) {
				System.out.printf("구매하실 상품의 개수를 입력해주세요. ");
				int count = scan.nextInt();
				System.out.printf("정말 구매하시겠습니까? \n1. 예\n2. 아니오");
				int next = scan.nextInt();
		
				switch (next)
				{
				case 1 :
					if (pro.getProCount() < count) {
						System.out.println("상품이 부족합니다. 재고량을 확인해주세요. ");
						return;
					} else {
						System.out.println("장바구니에 물품이 담겼습니다. ");
						System.out.printf("----- 장바구니 내역 -----\n" + "상품명 : " + name + "\n개수 : " + count );
	                    basket = new Basket(logInUser, pro, count);              
					    System.out.println("\n총 구매개수는 : " + basket.getPurchase() + "입니다.");
					    return;
					}
				case 2 :
					return;
				}
			}
		}
	}
	
	@Override // 상품관리 탭에서 메인으로 가기위한 메소드 - 
    public void proMain() {
		proSaveCsv();
		Home.main(null);
	}

	@Override // 상품구매섹션에서 구매를 완료하면 진행되는 상품이 담긴 장바구니, 여기서 상품을 최종 구매하기 위한 메소드
	public void proBasket() {	
		// 장바구니가 비었을경우
		if (basket == null) {
			System.out.println("장바구니가 비어있습니다. 상품을 먼저 담아주세요");
			return;
		}
		System.out.println("------ 장바구니 ------");
		System.out.printf("%s님의 장바구니\n상품명 : %s\n개수 : %d\n", basket.getUser().getUserId(), basket.getProduct().getProName(), basket.getPurchase());		
		// 현재 이용중인 유저의 정보, 상품이름, 구매갯수를 나타냄
		
		System.out.println("장바구니에 담긴 상품을 구매 하시겠습니까? ");
		System.out.printf("1. 예\n2. 아니오");
		int bNext = scan.nextInt();
		
		switch (bNext)
		{
		case 1 :
			for (int i = 0 ; i < products.size(); i++) {
				Product pro = products.get(i);
				if(pro.getProName().equals(basket.getProduct().getProName())) { 
					if (pro.getProCount() != 0) { // 장바구니에 담긴 유저의 정보중 충전된 캐쉬를 불러와서  장바구니에 담긴 상품의 구매가격 * 갯수를 뺀 값을 처리하는 변수선언
						int purCash =  basket.getUser().getUserCash() - ( pro.getProPrice() * basket.getPurchase() ) ;
						int purChase = pro.getProCount() - basket.getPurchase(); // 상품재고량에서 구매 물품갯수만큼 빼는 변수선언
						if (purCash < 0) {
							System.out.println("잔액이 부족합니다. 구매를 진행할 수 없습니다. ");
							return;
						}
					    pro.setProCount(purChase); // 상품의 갯수 최신화
					    basket.getUser().setUserCash(purCash); // 쇼핑을 이용중인 유저의 캐쉬 최신화
					    products.set(i, pro); // 상품 최신화
					    if (pro.getProCount() == 0) {
					    	products.remove(i);
					    }
					} else {
						System.out.println("상품이 존재하지 않습니다. 다시 확인해주세요. ");
						return;
					}
				}
			}
			basket = null; // 장바구니는 담긴것 전체를 구매하므로, 장바구니에서 구매를 진행하고 나면 장바구니를 비워줌
		    proSaveCsv(); // 변동된 상품의 정보를 저장
		    userManage.userSaveCsv(); // 변동된 회원의 정보를 저장
			System.out.println("구매가 완료되었습니다. ");	
			break;
		case 2 :
			return;
		default :
			System.out.println("잘못된 접근입니다. 프로그램을 종료합니다. ");
		}
	}

	@Override  // 쇼핑몰 페이지에서 메인페이지로 나가는 메소드
	public void Logout() {
		System.out.println("저희 쇼핑몰을 이용해주셔서 감사합니다. 즐거운 하루되세요!");
		Home.main(null);
	}
	
	@Override // 쇼핑몰 페이지에서 프로그램을 종료하기위한 메소드
	public void proExit() {
		proSaveCsv();
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}

	// 상품의 세부 정보를 보여주기 위한 메소드
	public void productList(Product product) {
		System.out.println("\n상품번호 : " + product.getProNum() + "\n상품이름 : " + product.getProName() + "\n상품가격 : " + product.getProPrice() + "\n상품정보 : " + product.getProInfo() + "\n상품재고량 : " + product.getProCount() + "\n-------------------" );
	}

	@Override // 상품정보를 Csv 파일로 저장하기 위한 메소드
	public void proSaveCsv() {
//		System.out.println("------- 상품정보 저장하기 ------");

		String directoryPath = "C:\\example\\directory\\";
		String fileName = "product_info.csv";
		
		File directory = new File(directoryPath);
		
		if (!directory.exists()) {
			if(directory.mkdirs()) {
//				System.out.println("디렉토리가 생성되었습니다.");
			} else {
//				System.out.println("디렉토리 생성에 실패하였습니다.");
			}
		} else {
//			System.out.println("이미 존재하는 디렉토리 입니다.");
		}
		
		String filePath = directoryPath + fileName;
		
		try (BufferedWriter writer = new BufferedWriter( new FileWriter(filePath))){
			
				writer.write("상품번호,상품이름,상품가격,상품정보,상품재고량");
				writer.newLine();

			for (Product product : products) {
				int proNum = product.getProNum();
				String proName = product.getProName();
				int proPrice = product.getProPrice();
				String proInfo = product.getProInfo();
				int proCount = product.getProCount();
				
				String line = proNum + "," + proName + "," + proPrice + "," + proInfo + "," + proCount ;
				writer.write(line);
				writer.newLine();		
			}
//			System.out.println("상품정보가 CSV파일로 저장되었습니다. ");
		} catch (IOException e) {
			System.out.println("상품정보를 저장하는 도중 오류가 발생했습니다." + e.getMessage());
		}
	}

	@Override // 상품정보 데이터가 담긴 Csv 파일의 데이터를 불러오기위함 
	public void proReadCsv() {
//		System.out.println("------ 상품정보 읽어오기 ------");
		
		String directoryPath = "C:\\example\\directory\\";
		String fileName = "product_info.csv";
		String filePath = directoryPath + fileName;
		
		// pfirstLine 쓰는이유는 첫번째 라인의 경우 각 항목을 나타냄. 불러올 경우에 데이터 값만 불러오면 되지 항목을 불러올 필요는 없어서 첫번째라인을 건너뛰기 위해 boolean 타입 변수선언
		boolean pFirstLine = true;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
		    String line;
		    
		    while ((line = reader.readLine()) != null) {
		    	// 첫번째 라인일때 false로 바꿔주고 continue로서 첫번째 라인을 건너뛰게 해서 값만 가져올수 있게끔 셋팅
		    	if (pFirstLine) {
		    		pFirstLine = false;
		    		continue;
		    	} 	
		    	// 줄별로 split을 사용하여 ","로 항목별로 값을 구분해준다.
		    	String[] data = line.split(",");
		    	
		    	int proNum = Integer.parseInt(data[0].trim());
		    	String proName = data[1].trim();
		    	int proPrice = Integer.parseInt(data[2].trim());
		    	String proInfo = data[3].trim();
		    	int proCount = Integer.parseInt(data[4].trim());
		    	
		    	Product product = new Product(proNum, proName, proPrice, proInfo, proCount);
		        products.add(product);
		    }		  
//		    System.out.println("CSV 파일에서 상품정보를 읽어왔습니다.");
		} catch (IOException e) {
			System.out.println("상품정보를 읽어오는 도중 오류가 발생했습니다." + e.getMessage());
		}
	}
}