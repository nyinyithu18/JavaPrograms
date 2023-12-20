package freedom_program;

import java.util.Scanner;

public class FreedomProgram {

	Process process = new BrandNames();
	Scanner sc = new Scanner(System.in);

	public FreedomProgram() {
		welcom();
	}

	public void welcom() {

		process.welcomFeatures();
		System.out.println(AccountModel.ASERIE);
		process.mainFeatures();
		choose();
	}

	public void choose() {

		SignupOrLogin signin = new SignupOrLogin();

		System.out.println(AccountModel.SPACE);
		System.out.print("Choose > ");
		String onlyChoose = sc.nextLine();

		switch (onlyChoose) {
		case "Call":

			process.callProcess();
			break;
		case "Exit":
			process.exitProcess();
			break;

		case "Home":
			System.out.println(AccountModel.SPACE);
			process.home();

			System.out.println(AccountModel.SPACE);
			process.products();

			System.out.println(AccountModel.ASERIE);

			break;

		case "Products":
			System.out.println(AccountModel.SPACE);
			process.products();

			System.out.println(AccountModel.SPACE);

			BrandNames brandName = (BrandNames) process;
			brandName.dressBrandNames();
			System.out.println(AccountModel.SPACE);

			brandName.shoeBrandNames();
			System.out.println(AccountModel.SPACE);

			brandName.phoneBrandNames();
			System.out.println(AccountModel.ASERIE);

			break;

		case "Languages":
			process.languageProcess();
			break;

		case "Profile":
			process.profileProcess();
			break;

		case "Sign in/Sign up":
			signin.signUpProcess();
			break;

		case "Login":
			try {
				signin.loginProcess();
			} catch (NullPointerException e) {
				System.err.println(e.getLocalizedMessage());
			}
			break;

		default:
			System.out.println("Please,write the correct word !");
			choose();
			break;

		}
	}

	public static void main(String[] args) {

		new FreedomProgram();
	}
}

interface Things {
	String phone = "       Call : 09.123456789";
	String products = "Products";
	String languages = "Languages";
	String profile = "Profile";
	String exit = "                                      Exit";

	default void welcomFeatures() {
		System.out.println(AccountModel.DESTLINE);
		System.out.println(AccountModel.WELCOM);
		System.out.println(AccountModel.DESTLINE);
	}

	public void languageProcess();

	public void profileProcess();

	public void callProcess();

	public void exitProcess();

}

interface Product {
	String home = "Home";
	String signin = "Sign in/Sign up";
	String searchProduct = "<  Search Product  >";
	String loginDiscount = "Login & Get 10% Discount";

	public void mainFeatures();

	public abstract void home();

	public abstract void products();

	public abstract void searchProducts();

}

class Process implements Things, Product {

	String place = home + "   " + products + "   " + languages + "   " + profile + "   " + signin;
	String placeOne = "        " + searchProduct + "       " + loginDiscount;

	@Override
	public void mainFeatures() {
		System.out.println(AccountModel.SPACE);
		System.out.println(phone);
		System.out.println(exit);
		System.out.println(AccountModel.PLUSDEST);
		System.out.println(place);
		System.out.println(AccountModel.PLUSDEST);
		System.out.println(placeOne);
	}

	@Override
	public void home() {

	}

	@Override
	public void products() {

	}

	@Override
	public void searchProducts() {

	}

	@Override
	public void languageProcess() {
		System.out.println(AccountModel.SPACE);
		System.out.println("Myanmar Language > \r\nEnglish Language > \r\nKorea Language > \r\nJapan Language > ");

	}

	@Override
	public void profileProcess() {
		System.out.println(AccountModel.SPACE);
		System.out.println("<>Name : __________________");
		System.out.println("<>Gender: _________________");
		System.out.println("<>Phone : _________________");
		System.out.println("<>Email : _________________");
		System.out.println("<>Password: _______________");
	}

	@Override
	public void callProcess() {
		System.out.println("Your Phone Call :");
	}

	@Override
	public void exitProcess() {
		System.out.println("Your Phone Screen :");
	}

}

class FinalProcess extends Process {
	@Override
	public void home() {
		System.out.println(AccountModel.SPACE);
		System.out.println("|Products| ");
		System.out.println(AccountModel.SPACE);
		System.out.println("Up Down With Scroll Wheel!");
	}

	@Override
	public void products() {
		System.out.println("_____Dress_____");
		System.out.println("_____Shoe_____");
		System.out.println("_____Phone_____");
		System.out.println("_____Computer_____");
		System.out.println("_____Books_____");

	}

	@Override
	public void searchProducts() {

	}
}

class BrandNames extends FinalProcess {

	public void dressBrandNames() {
		System.out.println("### Polo ###");
		System.out.println("### Goirenzo ###");
		System.out.println("### Puma ###");
		System.out.println("### Lee ###");
		System.out.println("### Supreme ###");

	}

	public void shoeBrandNames() {
		System.out.println("*** Adidas ***");
		System.out.println("*** Nike ***");
		System.out.println("*** Bata ***");
		System.out.println("*** Reebok ***");
		System.out.println("*** Jordan ***");

	}

	public void phoneBrandNames() {
		System.out.println("~~ Apple ~~");
		System.out.println("~~ Huawei ~~");
		System.out.println("~~ Redmi ~~");
		System.out.println("~~ OnePlus ~~");
		System.out.println("~~ BlackBerry ~~");

	}

}
