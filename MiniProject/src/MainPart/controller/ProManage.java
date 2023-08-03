package MainPart.controller;

// 메소드를 선언만 해놓고 재정의 하고자 인터페이스를 사용. 상품, 쇼핑몰 관련된 메소드가 선언만 되어있는 곳
public interface ProManage {
    
	public abstract void proAdd(); // 상품추가 메소드
	public abstract void proEdit(); // 상품수정 메소드
	public abstract void proDel(); // 상품삭제 메소드
	public abstract void proView(); // 상품검색 메소드
	public abstract void proAll(); // 상품전체조회 메소드
	public abstract void proMain(); // 상품관리 탭에서 메인화면으로 돌아가는 메소드
	public abstract void proExit(); // 상품관리 탭에서 종료하는 메소드
	
	public abstract void proBuy(); // 쇼핑몰에서 제품을 구매- 장바구니 담기 기능을 수행하는 메소드
	public abstract void proBasket(); // 장바구니에 담기 - 구매 기능을 수행하는 메소드
	public abstract void Logout(); // 쇼핑몰에서 로그아웃하는 메소드
	
	public abstract void proSaveCsv(); // 상품정보를 저장해서 Csv파일로 내보내는 메소드
	public abstract void proReadCsv(); // Csv파일로 저장된 상품정보를 불러오는 메소드
}
