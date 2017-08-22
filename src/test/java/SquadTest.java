import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class SquadTest{

//instance of Squad
  @Test
  public void squad_instanceOfNewSquad_true(){
    Squad newSquad = new Squad("GOT", "Fantasy", 2);
    assertEquals(true, newSquad instanceof Squad);
  }

  //displaying a particular attribute
  @Test
  public void getCause_getParticularAttribute_String(){
    Squad newSquad = new Squad("GOT", "Fantasy", 2);
    assertEquals("Fantasy", newSquad.getCause());
  }

  //return the new squads created
  @Test
  public void all_displayAllInstancesOfSquad_array(){
    Squad firstSquad = new Squad("GOT", "Fantasy", 2);
    Squad secondSquad = new Squad("Sheldon", "Having one spot", 2);
    assertEquals(true, Squad.all().contains(firstSquad));
    assertEquals(true, Squad.all().contains(secondSquad));
  }

  //clearing previously created squads
  @Test
  public void clear_clearAllPreviousSquads_0(){
    Squad newSquad = new Squad("GOT", "Fantasy", 2);
    Squad.clear();
    assertEquals(Squad.all().size(), 0);
  }

  //assigning and accessing Squad IDs
  @Test
  public void createID_createsSquadWithId_1(){
    Squad.clear();
    Squad newSquad = new Squad("GOT", "Fantasy", 2);
    assertEquals(1, newSquad.createID());
  }

  //locates Squad with ID
  @Test
  public void find_locatesSquadWithIDs_secondSquad(){
    Squad firstSquad = new Squad("GOT", "Fantasy", 2);
    Squad secondSquad = new Squad("Sheldon", "Having one spot", 2);
    assertEquals(Squad.find(secondSquad.createID()), secondSquad);
  }

  //to test whether it begins with an empty hero list
  @Test
  public void getHero_initiallyReturnsEmptyList_ArrayList(){
    Squad.clear();
    Squad newSquad = new Squad("GOT", "Fantasy", 2);
    assertEquals(0, newSquad.getHero().size());
  }

//adding hero to a squad
  @Test
  public void addHero_addsAHeroToASquad_true(){
    Hero newHero = new Hero("Dany", 25, "Fire breather", "Too kind");
    Squad newSquad = new Squad("GOT", "Fantasy", 2);
    newSquad.addHero(newHero);
    assertEquals(true, newSquad.getHero().contains(newHero));

  }
}
