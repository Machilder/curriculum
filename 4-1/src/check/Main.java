package check;

import constants.Constants;

public class Main {

    private static final String firstName = "松田";
    private static final String lastName = "大智";
    
    public static void main(String[] args) { 
        // TODO 自動生成されたメソッド・スタブ
        System.out.println("printNameメソッド ⇒ "+printName(firstName,lastName));
        
        Pet objPet = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);
        objPet.introduce();
        
        Pet objRobot = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);
        objRobot.introduce();
    }
    private static String printName(String pfirstName,String plastName) {
        return  pfirstName+plastName;
    }

}
