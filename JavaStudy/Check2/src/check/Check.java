package check;

import constants.Constants;

public class Check {
	
	private String firstName = "会田";
	private String lastName= "千紘";

	
	private void printName() {
		
		System.out.println("printNameメソッド → " + firstName+lastName);
	}
	
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		Check check = new Check();
		check.printName();
		
		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);
		pet.introduce();
		
		RobotPet robotpet = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);
		robotpet.introduce();

	}

}