import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

//instance of Hero
  @Test
  public void Hero_instanceOfNewHero_true(){
    Hero newHero = new Hero("Dany", 25, "Fire breather", "Too kind");
    assertEquals(true, newHero instanceof Hero);
  }

//getting a particular attribute
  @Test
  public void getName_getParticularAttribute_String(){
    Hero newHero = new Hero("Dany", 25, "Fire breather", "Too kind");
    assertEquals("Dany", newHero.getName());
  }

//return all heroes created
  @Test
  public void all_displayAllHeroInstances_array(){
    Hero firstHero = new Hero("Dany", 25, "Fire breather", "Too kind");
    Hero secondHero = new Hero("Arya", 18, "Ninja", "Trust issues");
    assertEquals(true, Hero.all().contains(firstHero));
    assertEquals(true, Hero.all().contains(firstHero));
  }

  //clearing previously created heroes
  @Test
  public void clear_clearAllPreviousHeroes_0(){
    Hero newHero = new Hero("Dany", 25, "Fire breather", "Too kind");
    Hero.clear();
    assertEquals(Hero.all().size(), 0);
  }

  //assigning and accessing hero IDs
  @Test
  public void createID_createsHeroWithId_1(){
    Hero.clear();
    Hero newHero = new Hero("Dany", 25, "Fire breather", "Too kind");
    assertEquals(1, newHero.createID());
  }

//locating specific Heroes using their unique IDs
@Test
public void find_locatesHeroesWithIDs_thirdHero(){
  Hero firstHero = new Hero("Dany", 25, "Fire breather", "Too kind");
  Hero secondHero = new Hero("Arya", 17, "Ninja", "Scary");
  Hero thirdHero = new Hero("Cersie", 36, "Smart", "Jaime");
  assertEquals(Hero.find(thirdHero.createID()), thirdHero);
}
}
