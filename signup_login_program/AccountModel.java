package signup_login_program.signup_login_program;

class AccountModel {
	final static String DESTLINE = "----------------------------------";
	final static String WELCOM = "   <<< WELCOM TO MY Program >>>   ";
	final static String SPACE = " ";
	final static String ASERIE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	final static String PLUSDEST = "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-";
	private String userName;
	private String email;
	private int password;
	private int rePassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getRePassword() {
		return rePassword;
	}

	public void setRePassword(int rePassword) {
		this.rePassword = rePassword;
	}
}
