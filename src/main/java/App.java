import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

//picking values from the form.vtl
post("/hero", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();

  ArrayList<Hero> heroes = request.session().attribute("heroes");
  if (heroes == null) {
      heroes = new ArrayList<Hero>();
      request.session().attribute("heroes", heroes);
  }

  String createdName = request.queryParams("name");
  int createdAge = Integer.parseInt(request.queryParams("age"));
  String createdSpecialPower = request.queryParams("specialPower");
  String createdWeakness = request.queryParams("weakness");
  Hero newHero = new Hero(createdName, createdAge, createdSpecialPower, createdWeakness);
  heroes.add(newHero);
  //request.session().attribute("hero", newHero);

  model.put("template", "templates/success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//displaying hero on form template
get("/", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("hero", request.session().attribute("hero"));
  model.put("template", "templates/form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

  }
}
