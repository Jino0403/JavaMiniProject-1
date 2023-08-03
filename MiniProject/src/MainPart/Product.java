package MainPart;

// 상품정보에 들어가는 값을 정리해놓은 곳 - 상품번호, 상품이름, 상품가격, 상품정보, 상품재고량순
public class Product {
	private int proNum; 
	private String proName;
    private int proPrice;
    private String proInfo;
    private int proCount;
    
	public Product(int proNum, String proName , int proPrice , String proInfo, int proCount) {
    	this.proNum = proNum;
    	this.proName = proName;
    	this.proPrice = proPrice;
    	this.proInfo = proInfo;
    	this.proCount = proCount;
    }
	
	public int getProNum() {
    	return proNum;
    }
    
    public void setProNum(int proNum) {
    	this.proNum = proNum;
    }

	public String getProName() {
    	return proName;
    }
    
    public void setProName(String proName) {
    	this.proName = proName;
    }

    
    public int getProPrice() {
    	return proPrice;
    }
    
    public void setProPrice(int proPrice) {
    	this.proPrice = proPrice;
    }
    
    public String getProInfo() {
    	return proInfo;
    }
    
    public void setProInfo(String proInfo) {
    	this.proInfo = proInfo;
    }
    
    public int getProCount() {
    	return proCount;
    }
    
    public void setProCount(int proCount) {
    	this.proCount = proCount;
    }
    
    

}
