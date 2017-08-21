import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

//class
public class Squad{
  private String mName;
  private String mCause;
  private static List<Squad> instances = new ArrayList<Squad>();

  //Constructor
  public Squad (String name, String cause){
    mName = name;
    mCause = cause;
    instances.add(this);
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
}
