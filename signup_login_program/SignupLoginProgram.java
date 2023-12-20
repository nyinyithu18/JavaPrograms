package signup_login_program.signup_login_program;

import java.util.Scanner;

public class SignupLoginProgram {

	Scanner sc = new Scanner(System.in);
	AccountModel[] data = new AccountModel[5];

	public SignupLoginProgram() {
		welcomStart();
	}

	public void welcomStart() {
		System.out.println(AccountModel.DESTLINE);
		System.out.println(AccountModel.WELCOM);
		System.out.println(AccountModel.DESTLINE);

		start();
	}

	public void start() {
		System.out.println(AccountModel.SPACE);
		System.out.println("	<<< Sign Up >>>");
		System.out.println("	<<< Login >>>");
		System.out.println(AccountModel.SPACE);
		System.out.println("If you have account > Click Login:");
		System.out.println("If you don't  have account >Click Sign Up:");
		System.out.println(AccountModel.SPACE);

		System.out.print("Click Signup Or Login > ");
		String choose = sc.nextLine();

		switch (choose) {
		case "Signup":
			signUpProcess();
			break;
		case "Login":
			try {
				loginProcess();
			} catch (NullPointerException e) {
				System.out.println(AccountModel.SPACE);
				System.out.println("!! You don't have account !!");
				signUpProcess();
			}
			break;
		default:
			System.out.println(AccountModel.SPACE);
			System.out.println("!! Please,Click Signup Or Login !!");
			start();
			break;
		}
	}

	public void signUpProcess() {
		System.out.println(AccountModel.SPACE);
		System.out.println("        <<< Sign Up >>>");
		System.out.println(AccountModel.SPACE);
		System.out.print("Username > ");
		String username = sc.nextLine();

		System.out.print("Email > ");
		String email = sc.nextLine();

		System.out.print("Password > ");
		int password = Integer.parseInt(sc.nextLine());

		System.out.print("RePassword > ");
		int rePassword = Integer.parseInt(sc.nextLine());

		if (rePassword == password) {

			AccountModel accountModel = new AccountModel();
			accountModel.setUserName(username);
			accountModel.setEmail(email);
			accountModel.setPassword(password);
			accountModel.setRePassword(rePassword);

			boolean flag = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i] == null) {
					flag = true;
					data[i] = accountModel;
					signupOutput();
					break;
				}
			}
			if (flag == false) {
				System.out.println("You cann't Sign Up at this time !");
			}
		} else {
			System.out.println(AccountModel.SPACE);
			System.out.println("Wrong your rePassword ! : Please Try Again !");
			signUpProcess();
		}
		loginProcess(); // For Your Testing
	}

	public void signupOutput() {
		System.out.println(AccountModel.SPACE);
		System.out.println("Sign Up Success !");
	}

	public void loginProcess() {
		System.out.println(AccountModel.SPACE);
		System.out.println("        <<< Login >>>");
		System.out.println(AccountModel.SPACE);
		System.out.print("Username > ");
		String username = sc.nextLine();

		System.out.print("Email > ");
		String email = sc.nextLine();

		System.out.print("Password > ");
		int password = Integer.parseInt(sc.nextLine());

		boolean flag = false;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {
				continue;
			}
			if (username.equals(data[i].getUserName()) && email.equals(data[i].getEmail())
					&& password == data[i].getPassword()) {
				flag = true;
				loginOutput();

			}
			break;

		}

		if (flag == false) {
			for (AccountModel element : data) {

				if (!(username.equals(element.getUserName()))) {
					System.out.println(AccountModel.SPACE);
					System.out.println("Wrong Your Username !\r\nPlease Try Again !");
				}

				else if (!(email.equals(element.getEmail()))) {
					System.out.println(AccountModel.SPACE);
					System.out.println("Wrong Your Email !\r\nPlease Try Again !");
				}

				else if (password != element.getPassword()) {
					System.out.println(AccountModel.SPACE);
					System.out.println("Wrong Your Password !\r\nPlease Try Again !");
				}
				break;
			}
			loginProcess();
		}
		sc.close();
	}

	public void notFoundData() {
		System.out.println(AccountModel.SPACE);
		System.out.println("Your Data not Found !");
	}

	public void loginOutput() {
		System.out.println(AccountModel.SPACE);
		System.out.println("Login Success !");
	}

	public static void main(String[] args) {

		new SignupLoginProgram();

	}

}
