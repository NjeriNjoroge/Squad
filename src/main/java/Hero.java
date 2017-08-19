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
  private int mId;

  //Constructor
  public Hero ( String name, int age,String specialPower, String weakness){
    mName = name;
    mAge = age;
    mSpecialPower = specialPower;
    mWeakness = weakness;
    instances.add(this);
    mId = instances.size();
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

//clearing previous created heroes
public static void clear(){
  instances.clear();
}

//assigning and accessing IDs
public int createID(){
  return mId;
}

//locating specific Heroes using their unique IDs
public static Hero find(int id){
  return instances.get(id - 1);
}

  }
