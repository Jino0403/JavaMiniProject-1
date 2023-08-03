package MainPart;


// 유저정보에 들어가는 값을 정리해놓은 곳 - 유저아이디, 유저이름, 유저전화번호, 유저주소, 유저캐쉬 순이다.
public class User {
	private String userId;
    private String userName;
    private String userPhone;
    private String userAddress;
    private int userCash;

	public User (String userId, String userName, String userPhone, String userAddress, int userCash){
    	this.userId = userId;
    	this.userName = userName;
    	this.userPhone = userPhone;
    	this.userAddress = userAddress;
    	this.userCash = userCash;
    }
    
    public String getUserId() {
    	return userId;
    }
    
    public void setUserId(String userId) {
    	this.userId = userId;
    }
    
    public String getUserName() {
    	return userName;
    }
    
    public void setUserName(String userName) {
    	this.userName = userName;
    }
    
    public String getUserPhone() {
    	return userPhone;
    }
    
    public void setUserPhone(String userPhone) {
    	this.userPhone = userPhone;
    }
    
    public String getUserAddress() {
    	return userAddress;
    }
    
    public void setUserAddress(String userAddress) {
    	this.userAddress = userAddress;
    }
    
    public int getUserCash() {
    	return userCash;
    }
    
    public void setUserCash(int userCash) {
    	this.userCash = userCash;
    }
    
}
