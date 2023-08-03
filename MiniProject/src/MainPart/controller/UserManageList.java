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

import MainPart.Home;
import MainPart.User;

public class UserManageList implements UserManage {
    
    // 유저 정보가 담긴 arrayList 선언
	ArrayList<User> users = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);

    // Csv파일에 저장된 유저 정보를 불러오기 위한 메소드
	public void read() {
		UserManageList U = new UserManageList();
		U.userReadCsv();
	}

	@Override // 아이디, 이름, 전화번호, 주소를 입력받아 회원정보 등록
	public void add() {
    	
    	System.out.println("------ 회원등록 ------");
		System.out.printf("아이디를 입력해주세요. \n아이디 : ");
		String id = sc.next();
	    
		for (User user : users) {
		    if (user.getUserId().equals(id)) {
		    	System.out.println(id + "는 중복된 아이디입니다. ");
		    	return;
		    }
		}
				System.out.printf("이름을 입력해주세요. \n이름 : ");
				String name = sc.next();
				System.out.printf("전화번호를 입력해주세요. \n전화번호 : ");
				String phone = sc.next();
				sc.nextLine(); // 개행문자를 초기화해주기 위해서 사용함. 그렇지 않으면 전화번호에서 주소를 입력하는 칸으로 넘어갈때 주소를 건너뛰고 끝나게됨
				System.out.printf("주소를 입력해주세요. \n주소 : ");
				String address = sc.nextLine();
				System.out.printf("충전금액을 입력해주세요. \n충전금액 : ");
				int cash = sc.nextInt();
				// next()가 아닌 nextLine()을 사용한 이유는 next()는 띄워쓰기로 구분하기 때문에 주소 부분에서 띄워쓰기를 주게 되면, 충전금액 부분에 String값이 들어가 오류를 발생시킴.
				// 그리하여 필요한 부분에 nextLine()사용
			
				User a = new User(id,name,phone,address,cash);
				users.add(a);

				System.out.println("등록이 완료되었습니다.");
				System.out.printf("회원등록정보\n" + "아이디 : " + a.getUserId() + "\n이름 : " + a.getUserName() + "\n전화번호 : " + a.getUserPhone() 
				+ "\n주소 : " + a.getUserAddress() + "\n충전금액 : " + a.getUserCash() + " 원\n" + "-------------------\n");
				
				userSaveCsv();
				read();
				return ; 	
    }
		

    @Override // 유저의 캐쉬를 충전하기 위한 메소드
	public void charge() {
		System.out.println("------ 캐쉬충전 ------");
		System.out.println("충전하실 아이디를 입력해주세요. ");
	    System.out.printf("아이디 : ");
	    String id = sc.next();
	   
	    for (int i = 0; i < users.size(); i++) {
	    	User user = users.get(i);
	    	if(user.getUserId().equals(id)){
	    		System.out.println("충전하실 금액을 입력해주세요. ");
	    		System.out.println("현재캐쉬 :" + user.getUserCash() + "원");
	    		System.out.printf("충전금액 : ");
	    		int newCash = sc.nextInt();
	    		
	    		System.out.printf("충전하실 금액이 " + newCash + "원이 맞습니까? \n1. 예 \n2. 아니오");
	    		int cNum = sc.nextInt();
	    		
	    		switch (cNum)
	    		{
	    		case 1 : 
	    			System.out.println("충전이 완료되었습니다.");
	    			user.setUserCash(user.getUserCash()+ newCash);
	    			System.out.println("총 캐쉬량 : " + user.getUserCash() +"원");
	    			break;
	    		case 2 :
	    			break;
	    		default :
	    			System.out.println("잘못된 접근입니다. 프로그램을 종료합니다. ");
	    			exit();
	    		}
	    	}
	    }
	    userSaveCsv();
	}
	

	@Override // 회원정보를 수정하는 메소드
	public void edit() {
		System.out.println("------ 회원수정 ------");
		System.out.println("수정할 회원님의 아이디를 입력해주세요. ");
		System.out.printf("아이디 : ");
		String id = sc.next();
		for (int i = 0 ; i < users.size(); i++) {
			User edit = users.get(i);
			if(edit.getUserId().equals(id)) {
				System.out.println(id + "님의 정보\n이름 : " + edit.getUserName() + "\n전화번호 : " + edit.getUserPhone() + 
						"\n주소 : " + edit.getUserAddress() + "\n" );
				
				System.out.printf("변경하실 이름을 입력해주세요. \n이름 : ");
				String newName = sc.next();
				System.out.printf("변경하실 전화번호를 입력해주세요. \n전화번호 : ");
				String newPhone = sc.next();
				sc.nextLine(); //  개행문자를 초기화해주기 위해서 사용함. 그렇지 않으면 전화번호에서 주소를 입력하는 칸으로 넘어갈때 주소를 건너뛰고 끝나게됨
				System.out.printf("변경하실 주소를 입력해주세요. \n주소 : ");
				String newAddress = sc.nextLine();
				
				edit.setUserName(newName);
				edit.setUserPhone(newPhone);
				edit.setUserAddress(newAddress);
				
				System.out.println("수정이 완료되었습니다.");
				System.out.println(id + "님의 정보\n 이름 : " + newName + "\n전화번호 : " + newPhone + "\n주소 : " + newAddress + "\n");
				return;

			} 
			userSaveCsv();
		}
		System.out.println("입력하신 회원님의 정보가 존재하지 않습니다. ");
	}

	@Override // 회원정보를 삭제하기위한 메소드
	public void delete() {
		System.out.println("------ 회원삭제 ------");
		System.out.printf("삭제할 회원님의 아이디를 입력해주세요. \n아이디 : ");
		String id = sc.next();

		// 값을 가져와서 삭제하기 위해서 Iterator를 사용
		for (Iterator<User> useriter = users.iterator(); useriter.hasNext();) {
			User user = useriter.next();
			if(user.getUserId().equals(id)) {
				useriter.remove();
				System.out.println(id + "님의 정보가 삭제되었습니다.");
				return;
			} 
		userSaveCsv();		
		}
		System.out.println("입력하신 회원님의 정보가 존재하지 않습니다. ");
	}

	@Override // 특정 회원을 찾기위한 메소드
	public void view() {
		System.out.println("------ 회원검색 ------");
		System.out.printf("찾으실 회원님의 아이디를 입력해주세요. \n아이디 : ");
		String id = sc.next();
		
		for (User user : users) {
			if (user.getUserId().equals(id)) {
				System.out.printf( "\n-------------------\n" + user.getUserId() + "님의 회원정보\n");
				userList(user);
				return;
			} 			
		  }
		    System.out.println("입력하신 회원님의 정보가 존재하지 않습니다.");
		}
	         
	@Override // 전체 회원을 출력하기 위한 메소드
	public void allView() {
		System.out.println("------ 전체회원조회 ------");
		
		if(users.isEmpty() ) {
			System.out.println("등록된 회원님이 없습니다. ");
			System.out.println("회원을 등록해주세요. ");
			return;
		} else {
			for(User user : users) {
				userList(user);
			}
		}
	}
	
	@Override // 메인 화면으로 가기위한 메소드, 이제까지 진행된 유저 정보도 저장되어 넘어가게끔 하기위해 저장 메소드 추가.
	public void mainGo() {
		userSaveCsv();
		Home.main(null);
	}
	
	@Override // 회원관리에서 종료하기 위한 메소드, 이제까지 진행된 유저 정보 저장되고 종료되게끔 하기위해 저장 메소드 추가.
	public void exit() {
		userSaveCsv();
		System.out.println("프로그램을 종료합니다. 즐거운 하루되세요 ");
		System.exit(0);
	}
	
	@Override // 유저리스트를 불러올때, 유저의 정보를 항목별로 출력하기 위한 메소드
	public void userList(User user) {
	    System.out.printf("아이디 : " + user.getUserId() + "\n이름 : " + user.getUserName() + "\n전화번호 : " + user.getUserPhone() + "\n주소 : " + user.getUserAddress() + "\n충전금액 : " + user.getUserCash() + "원" + "\n-------------------\n");
	  
	}

    // proBuy 메소드에서 유저 정보를 불러오기 위해 사용하는하는 메소드
	public ArrayList<User> getUsers() {
		return users;
	}


	@Override // 회원정보를 Csv 파일로 저장하기 위한 메소드
	public void userSaveCsv() {
//		System.out.println("------ 회원저장파일 ------");
		
		String directoryPath = "c://example//directory//";
		String fileName = "user_info.csv";
		
		File directory = new File(directoryPath);
		
		// 디렉토리가 존재하지 않을경우 디렉토리를 생성하기 위한 메소드, 이미 존재할 경우 출력하는 값도 설정
		if (!directory.exists()) {
			if(directory.mkdir()) {
//				System.out.println("디렉토리가 생성되었습니다.");
			} else {
//				System.out.println("디렉토리 생성에 실패하였습니다.");
			}
		} else {
//			System.out.println("이미 존재하는 디렉토리입니다. ");
		}
		
		String filePath = directoryPath + fileName;
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
			writer.write("아이디,이름,전화번호,주소,충전금액");
			writer.newLine();
		
			for (User user : users) {
				String userId = user.getUserId();
				String userName = user.getUserName();
				String userPhone = user.getUserPhone();
				String userAddress = user.getUserAddress();
				String userCash = String.valueOf(user.getUserCash());
				
				String line = userId + "," + userName + "," + userPhone + "," + userAddress + "," + userCash;
			    writer.write(line);
			    writer.newLine();
			    
//			    System.out.println("회원정보가 CSV파일로 저장되었습니다. ");
			}
		} catch (IOException e) {
			System.out.println("회원정보를 읽어오는 도중 오류가 발생했습니다." + e.getMessage());
		}
	} 

	@Override // 회원정보 데이터가 담긴 Csv 파일의 데이터를 불러오기위함 
	public void userReadCsv() {
//		System.out.println("------ 회원정보 읽어오기 ------");
		
		String directoryPath = "c:/example/directory/";
		String fileName = "user_info.csv";
		String filePath = directoryPath + fileName;
		// ufirstLine 쓰는이유는 첫번째 라인의 경우 각 항목을 나타냄. 불러올 경우에 데이터 값만 불러오면 되지 항목을 불러올 필요는 없어서 첫번째라인을 건너뛰기 위해 boolean 타입 변수선언
		boolean uFirstLine = true;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// 첫번째 라인일때 false로 바꿔주고 continue로서 첫번째 라인을 건너뛰게 해서 값만 가져올수 있게끔 셋팅
				if (uFirstLine) {
					uFirstLine = false;
					continue;
				}
				// 줄별로 split을 사용하여 ","로 항목별로 값을 구분해준다.	
				String[] data = line.split(",");
				
				String userName = data[0];
				String userId = data[1];
				String userPhone = data[2];
				String userAddress = data[3];
				int userCash = Integer.parseInt(data[4]);
				
				User user = new User(userName,userId,userPhone,userAddress,userCash);
				users.add(user);
			}
//			System.out.println("회원정보로드가 완료되었습니다. ");
		} catch (IOException e) {
			System.out.println("회원정보를 읽어오는 도중 오류가 발생했습니다. " + e.getMessage());
		}	
	}

}
