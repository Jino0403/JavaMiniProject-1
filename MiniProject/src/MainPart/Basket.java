package MainPart;

// 쇼핑몰에서 제품 구매시 이용하게되는 장바구니에 들어가는 값을 정리해놓은 곳 - 구매유저정보, 구매상품정보, 구매갯수
public class Basket {
    
	private User user;
    private Product product;
    private int purchase;
    
    public Basket(User user, Product product, int purchase) {
    	this.user = user;
    	this.product = product;
    	this.purchase = purchase;
    }
  
    public User getUser() {
    	return user;
    }
    
    public Product getProduct() {
    	return product;
    }
    
    public int getPurchase() {
    	return purchase;
    }
    
    public void setPurchase(int purchase) {
    	this.purchase = purchase;
    }
   
 
}
