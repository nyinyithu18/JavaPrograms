package notepad1_program;

import java.util.LinkedList;
import java.util.Scanner;

class NotepadProgram {

	public NotepadProgram() {
		checkException();
	}

	public void checkException() {
		NotepadProcess notepad = new NotepadProcess();
		notepad.welcomProgram();
		try {
			notepad.userChoice();
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			System.out.println("Receive integer only.");
			notepad.userChoice();
		} catch (ChoiceLimitationException e) {
			System.out.println(e.getMessage());
			notepad.userChoice();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		new NotepadProgram();
	}
}

interface Notepad {

	default void welcomProgram() {
		System.out.println(Constant.DUSTLINE);
		System.out.println("   <<< WELCOM TO NOTEPAD PROGRAM >>>");
		System.out.println(Constant.DUSTLINE);
	}

	public void userChoice();

	public int addNote();

	public void editNote(int date);

	public void searchNote();

	public void endProgram();
}

class NotepadProcess implements Notepad {

	LinkedList<NoteModel> noteList = new LinkedList<NoteModel>();
	Scanner sc = new Scanner(System.in);
	int date;	

	@Override
	public void userChoice() throws ChoiceLimitationException {
		System.out.println(" ");
		System.out.println("1.Add Note :");
		System.out.println("2.Edit Note :");
		System.out.println("3.Search Note :");
		System.out.println("4.End Program :");
		System.out.println(Constant.ASERIES);
		System.out.println(" ");

		System.out.print("Your Choice > ");
		int userChoice = Integer.parseInt(sc.nextLine());

		switch (userChoice) {
		case 1:
			addNote();
			break;

		case 2:
			editNote(date);
			break;

		case 3:
			searchNote();
			break;

		case 4:
			endProgram();
			break;

		default:

			break;
		}
		if (userChoice < 1 || 4 < userChoice) {
			throw new ChoiceLimitationException("Please enter between 1 to 4.");
		}
	}

	@Override
	public int addNote() throws NumberFormatException {

		System.out.println(" ");
		System.out.print("Title > ");
		String title = sc.nextLine();

		System.out.print("Date > ");
		date = Integer.parseInt(sc.nextLine());

		System.out.print("Memo > ");
		String memo = sc.nextLine();

		NoteModel noteModel = new NoteModel(title, date, memo);
		noteList.add(noteModel);

		System.out.println(" ");
		System.out.println("Your Add Note are saving. ");
		System.out.println(Constant.SERIE);

		userChoice();

		return date;
	}

	@Override
	public void editNote(int date) {
		System.out.println(" ");
		System.out.print("Title > ");
		String title = sc.nextLine();

		boolean flag = false;
		for (NoteModel note : noteList) {
			if (note == null) {
				continue;
			} else if (note.getTitle().equalsIgnoreCase(title)) {
				flag = true;
				System.out.println(note.getMemo());

				System.out.println(" ");
				System.out.print("New Memo > ");
				String newMemo = sc.nextLine();

				NoteModel noteModel = new NoteModel(title, date, newMemo);
				note.setMemo(newMemo);
				noteList.add(noteModel);

				System.out.println(" ");
				System.out.println("Your Edit Note are saving. ");
				System.out.println(Constant.SERIE);
				break;
			}
		}
		if (flag == false) {
			for (NoteModel note : noteList) {
				if (!(title.equalsIgnoreCase(note.getTitle()))) {
					System.out.println("Wrong your title.\r\nPlease,try again.");
				}
				break;
			}
			editNote(date);
		}
		userChoice();
	}

	@Override
	public void searchNote() {
		System.out.println(" ");
		System.out.print("Title > ");
		String title = sc.nextLine();

		boolean flag = false;
		for (NoteModel note : noteList) {
			if (note == null) {
				continue;
			} else if (note.getTitle().equalsIgnoreCase(title)) {
				flag = true;
				System.out.println(" ");
				System.out.println("Title : ".concat(note.getTitle()));
				System.out.println("Date  : " + (note.getDate()));
				System.out.println("Memo  : ".concat(note.getMemo()));
				System.out.println(Constant.SERIE);
				break;
			}
		}
		if (flag == false) {
			for (NoteModel note : noteList) {
				if (!(title.equalsIgnoreCase(note.getTitle()))) {
					System.out.println("Wrong your title.\r\nPlease,try again.");
				}
				break;
			}
			searchNote();
		}
		userChoice();
	}

	@Override
	public void endProgram() {
		System.out.println(" ");
		System.out.println("_______End Program_______");
		System.out.println(" ");
		System.out.println(Constant.PLUSSIGN);
		sc.close();
	}
}


class NoteModel {
	private String title;
	private int date;
	private String memo;
	private String newMemo;

	public NoteModel(String title, int date, String newMemo) {
		this.title = title;
		this.date = date;
		this.memo = newMemo;
	}
	
	public String getTitle() {
		return title;
	}public void setTitle(String title) {
		this.title = title;
	}
	
	public int getDate() {
		return date;
	}public void setDate(int date) {
		this.date = date;
	}
	
	public String getMemo() {
		return memo;
	}public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getNewMemo() {
		return newMemo;
	}public void setNewMemo(String newMemo) {
		this.newMemo = newMemo;
	}
}

class ChoiceLimitationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChoiceLimitationException() {
		super();
	}

	public ChoiceLimitationException(String message) {
		super(message);
	}
}

class Constant {

	public static final String DUSTLINE = "--------------------------------------";
	public static final String PLUSSIGN = "+++++++++++++++++++++++++++++++++++++++";
	public static final String SERIE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	public static final String ASERIES = "____________________________";
}