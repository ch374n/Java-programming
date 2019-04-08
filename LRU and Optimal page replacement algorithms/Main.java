import java.util.Scanner;

public class Main {
	private static LRU lru = new LRU();
	private static Optimal optimal = new Optimal();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean quit = false;
		while(!quit) {
			switch(getChoice()) {
				case 0: 
						lru.execute();
						break;
				case 1:
						optimal.execute();
						break;
				case 2:
						System.exit(0);

			}

			System.out.println("Would you like to continue ? [y/n]");
			String choice = scanner.nextLine();
			if (choice == "y") quit = true;
		}
	}

	public static int getChoice() {
		System.out.println("[0] LRU\n" +
						   "[1] Optimal\n" +
						   "[2] Exit\n" +
						   "Enter your choice : ");
		return scanner.nextInt();
	}
}