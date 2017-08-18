import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

  @Test
  public void Hero_instanceOfNewHero_true(){
    Hero newHero = new Hero("Dany", 25, "Fire breather", "Too kind");
    assertEquals(true, newHero instanceof Hero);
  }

  @Test
  public void getName_getParticularAttribute_String(){
    Hero newHero = new Hero("Dany", 25, "Fire breather", "Too kind");
    assertEquals("Dany", newHero.getName());
  }

  @Test
  public void all_displayAllHeroInstances_array(){
    Hero firstHero = new Hero("Dany", 25, "Fire breather", "Too kind");
    Hero secondHero = new Hero("Arya", 18, "Ninja", "Trust issues");
    assertEquals(true, Hero.all().contains(firstHero));
    assertEquals(true, Hero.all().contains(firstHero));
  }

}
