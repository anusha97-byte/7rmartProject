package constant;

public class Constant {
	public static final String TESTDATAFILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestDataProject.xlsx";
	public static final String FOODIMAGEFILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\pexels-ella-olsson-572949-1640777.jpg";
	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";
	public static final String CORRECTUSERNAMEANDPASSWORD = "After entering valid username and password home page is not displayed";
	public static final String INCORRECTUSERNAMEANDPASSWORD = "After entering ivalid credentials the home page is displayed";
	public static final String CORRECTUSERNAMEANDINCORRECTPASSWORD = "After entering valid username and invalid password home page is displayed";
	public static final String INCORRECTUSERNAMEANDCORRECTPASSWORD = "After entering valid password and invalid username home page is displayed";
	public static final String ADDADMININFORMATION = "After saving new username and password alert is not displayed";
	public static final String UPDATEADMININFORMATION = "After updating new username and password alert is not displayed";
	public static final String LOGOUTFROMPAGE = "After logout loginpage is not displayed";
	public static final String ADDCATEGORY = "After uploading image error mesage is not displayed";
	public static final String UPDATECATEGORY = "After update the category alert is not displayed";
	public static final String UPDATECONTACT = "After update contact alert is not displayed";
	public static final String UPDATEFOOTER = "After update the footer text alert is not displayed";
	public static final String ADDNEWS = "After saving new news alert is not displayed";
	public static final String UPDATENEWS = "After updating news alert is not displayed";

}
