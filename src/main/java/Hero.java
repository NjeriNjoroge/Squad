import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

//class
public class Hero {
  private int mAge;
  private String mName;
  private String mSpecialPower;
  private String mWeakness;
  private static List<Hero> instances = new ArrayList<Hero>();

  //Constructor
  public Hero ( String name, int age,String specialPower, String weakness){
    mName = name;
    mAge = age;
    mSpecialPower = specialPower;
    mWeakness = weakness;
    instances.add(this);
  }

  //getting a name attribute
  public String getName(){
    return mName;
  }

  //getting a age attribute
  public int getAge(){
    return mAge;
  }

  //getting a special power attribute
  public String getSpecialPower(){
    return mSpecialPower;
  }

  //getting a weakness attribute
  public String getWeakness(){
    return mWeakness;
  }

//return all heroes created
public static List<Hero> all(){
  return instances;
}
  }
