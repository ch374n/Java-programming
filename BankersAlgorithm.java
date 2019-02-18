/*
    Deadlock prevention using bankers algorithm
	Safety sequence using safety algorithm
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Process {
	private String pName;
	private List<Integer> resources;
	public Process(String pName, List<Integer> resources) {
		this.pName     = pName;
		this.resources = resources;
	}

	public List<Integer> getResourceList() {
		return resources;
	}

	public String getName() {
		return pName;
	}
}

public class BankersAlgorithm {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Process> allocationMat = new ArrayList<>();
	private static List<Process> maxMat = new ArrayList<>();
	private static List<Process> needMat = new ArrayList<>();
	private static List<Integer> resourcesList;
	private static List<Integer> available = new ArrayList<>();
	private static List<Process> safetySequence = new ArrayList<>();
	private static int numProcess;
	private static int numResources;

	public static void init() {
		System.out.println("enter number of processes and no of resources : ");	
		numProcess   = scanner.nextInt();
		numResources = scanner.nextInt();
		scanner.nextLine();

		for(int i = 0; i < numProcess; i++) {
			resourcesList = new ArrayList<>();
			System.out.println("enter resources allocated for process P" + i + " : ");
			for(int j = 0; j < numResources; j++) {
				resourcesList.add(scanner.nextInt());
			}			

			allocationMat.add(new Process("P" + i, resourcesList));
			resourcesList = new ArrayList<>();
			System.out.println("enter maximum resources required for process P" + i + " : ");
			for(int j = 0; j < numResources; j++) {
				resourcesList.add(scanner.nextInt());
			}			
			maxMat.add(new Process("P" + i, resourcesList));
		}		
		scanner.nextLine();
		System.out.println("enter quantity of available resources : ");
		for(int i = 0; i < numResources; i++) {
			available.add(scanner.nextInt());
		}
	}

	public static void main(String[] args) {
		init();
		System.out.print("\033[H\033[2J");
		bankersAlgorithm();
		safetyAlgorithm();
	}

	public static void bankersAlgorithm() {
		System.out.println("Need matrix : ");
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		for(int i = 0 ; i < numProcess; i++) {
			Process p1 = allocationMat.get(i);
			Process p2 = maxMat.get(i);
			list1 = p1.getResourceList();
			list2 = p2.getResourceList();
			resourcesList = new ArrayList<>();

			for(int j = 0; j < numResources; j++) {
				resourcesList.add(list2.get(j) - list1.get(j));
			}			
			
			needMat.add(new Process(p1.getName(), resourcesList));
		}

		for(Process p : needMat) {
			System.out.println(p.getName() + "  " + p.getResourceList());
		}
		System.out.println();
	}

	public static Process findProcess(List<Process> mat, Process p) {
		for(Process p1 : mat) {
			if(p1.getName().equals(p.getName())) {
				return p1;
			}
		}
			return null;
	}
	public static void execute() {
		int j = 0;
		while(j < numProcess) {
			boolean flag = true;
			if(j >= needMat.size()) {
				return;
			}
			Process p = needMat.get(j);
			resourcesList = p.getResourceList();
			for(int i = 0; i < numResources; i++) {
				if(resourcesList.get(i) > available.get(i)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				safetySequence.add(p);
				needMat.remove(j);
				List<Integer> l1 = findProcess(allocationMat, p).getResourceList();
				for(int i = 0; i < numResources; i++) {
					available.set(i, available.get(i) + l1.get(i));					
				}
				j--;
			}
				j++;
		}
	}

	public static void safetyAlgorithm() {
		while(!needMat.isEmpty()) {
			execute();
		}

		System.out.println("Safety sequence : ");
		for(Process p : safetySequence) {
			System.out.print(p.getName() + " --> ");
		}
	}
}
 
