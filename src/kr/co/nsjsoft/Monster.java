package kr.co.nsjsoft;

public class Monster {

	private String name;
	
	public Monster(String name) {
		this.name = name;
	}
	
	static class Brain {
		static void think() {
			System.out.println("NSJSoft is thinking...");
		}
	}
	
	public void spawn () {
		Brain brain = new Brain();
		//brain.think();
	}
}


