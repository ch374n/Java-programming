import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PageReplacement {
	protected int numFrames;
	protected int numEntries;
	protected String[] pageTrace; 
	protected List<List<String>> pageFrames = new ArrayList<>();
	protected List<List<Integer>> distance = new ArrayList<>();
	protected Scanner scanner = new Scanner(System.in);

	public void init() {
		System.out.println("enter number of frames : ");
		numFrames = scanner.nextInt();
		scanner.nextLine();

		System.out.println("enter number of entries in page trace :");
		numEntries = scanner.nextInt();
		scanner.nextLine();

		System.out.println("enter page trace : ");
		pageTrace = scanner.nextLine().split(" "); 

		List<Integer> arr = new ArrayList<>();

		for(int j = 0; j < numFrames; j++) {
			arr.add(-1);
		}

		for(int i = 0; i < numEntries; i++) {
			distance.add(arr);
		}
	}

	public void display(float hit) {
		System.out.println("page frames : ");
		for(List<String> s : pageFrames) {
			System.out.println(s);
		}

		System.out.println("\n\n\n");
		System.out.println("Hit ratio : " + (hit / numEntries));

	}
}
