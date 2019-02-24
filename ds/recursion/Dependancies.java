// Given a task and dependancies, make sure you execute all tasks
// Note : all dependancies should be executed before main task
// implementation of topological sort
// directed acyclic graph

import java.util.List;
import java.util.ArrayList;

class Task {
	private String id;
	private List<Task> dependancies = new ArrayList<>();
	private boolean done = false;
	public Task(String id, Task... dependancyArray) {
		this.id = id;
		for(Task t : dependancyArray) {
			this.dependancies.add(t);
		}
	}
	public void execute() {
		if(done) {
			return;
		}
		for(Task t : dependancies) {
			t.execute();
		}
		setDone();
	}
	public void setDone() {
		done = true;
		System.out.println("completed task : " + id);
	}
}
public class Dependancies {
	public static void main(String[] args) {
	    List<Task> tasks = new ArrayList<>();
		tasks.add(new Task("A"));
		tasks.add(new Task("B", new Task("A")));
		tasks.add(new Task("C", new Task("A"), new Task("B"), new Task("D")));
		tasks.add(new Task("D", new Task("E")));
		tasks.add(new Task("E"));
		tasks.add(new Task("F", new Task("C")));
		tasks.add(new Task("G"));
		tasks.add(new Task("H"));
		buildCar(tasks);
	}
	public static void buildCar(List<Task> tasks) {
		for(Task t : tasks) {
			t.execute();
		}	
	}
}