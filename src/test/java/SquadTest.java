import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest{

//instance of Squad
  @Test
  public void squad_instanceOfNewSquad_true(){
    Squad newSquad = new Squad("GOT", "Fantasy");
    assertEquals(true, newSquad instanceof Squad);
  }

  //displaying a particular attribute
  @Test
  public void getCause_getParticularAttribute_String(){
    Squad newSquad = new Squad("GOT", "Fantasy");
    assertEquals("Fantasy", newSquad.getCause());
  }

  //return the new squad created
  @Test
  public void all_displayAllInstancesOfSquad_array(){
    Squad firstSquad = new Squad("GOT", "Fantasy");
    Squad secondSquad = new Squad("Sheldon", "Having one spot");
    assertEquals(true, Squad.all().contains(firstSquad));
    assertEquals(true, Squad.all().contains(secondSquad));
  }

  //clearing previously created squads
  @Test
  public void clear_clearAllPreviousSquads_0(){
    Squad newSquad = new Squad("GOT", "Fantasy");
    Squad.clear();
    assertEquals(Squad.all().size(), 0);
  }
}
