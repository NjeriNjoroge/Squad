//class
public class Hero {
  private int mAge;
  private String mName;
  private String mSpecialPower;
  private String mWeakness;

  //Constructor
  public Hero ( String name, int age,String specialPower, String weakness){
    mName = name;
    mAge = age;
    mSpecialPower = specialPower;
    mWeakness = weakness;
  }

  //getting a particular attribute
  public String getName(){
    return mName;
  }
}
