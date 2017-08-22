import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

//class
public class Squad{
  private String mName;
  private String mCause;
  private int mMaxSize;
  private int mId;
  private static List<Squad> instances = new ArrayList<Squad>();
  private List<Hero> mHero;

  //Constructor
  public Squad (String name, String cause, int maxSize){
    mName = name;
    mCause = cause;
    mMaxSize = maxSize;
    instances.add(this);
    mId = instances.size();
    mHero = new ArrayList<Hero>();
  }

  //getting Cause attribute
  public String getCause(){
    return mCause;
  }

  //returning the array of Squad
  public static List<Squad> all(){
    return instances;
  }

  //clearing previously created squads
  public static void clear(){
    instances.clear();
  }

  //instantiates with an ID
  public int createID(){
    return mId;
  }

//locates Squad with ID
  public static Squad find(int id){
    return instances.get(id - 1);
  }

  //Squad should start with an empty hero list
  public List<Hero> getHero(){
    return mHero;
  }

//
public void addHero(Hero hero){
  mHero.add(hero);
}

}
