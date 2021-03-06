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

//displaying hero on form template
// get("/", (request, response) -> {
//   Map<String, Object> model = new HashMap<String, Object>();
//   model.put("heroes", request.session().attribute("heroes"));
//   model.put("template", "templates/form.vtl");
//   return new ModelAndView(model, layout);
// }, new VelocityTemplateEngine());

//displaying a welcome message
get("/", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/index.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//display form
get("/hero", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//picking values from the form.vtl
post("/hero", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();

  // ArrayList<Hero> heroes = request.session().attribute("heroes");
  // if (heroes == null) {
  //     heroes = new ArrayList<Hero>();
  //     request.session().attribute("heroes", heroes);
  // }

  String createdName = request.queryParams("name");
  int createdAge = Integer.parseInt(request.queryParams("age"));
  String createdSpecialPower = request.queryParams("specialPower");
  String createdWeakness = request.queryParams("weakness");
  Hero newHero = new Hero(createdName, createdAge, createdSpecialPower, createdWeakness);
  //heroes.add(newHero);

  model.put("template", "templates/success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//user requests page, Velocity loops through objects and displays them
get("/heroes", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("heroes", Hero.all());
  model.put("template", "templates/heroes.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//displays the form for creating a new hero
get("/hero/new", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//new squad form
get("/squad/new", (request, respond) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/squad-form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//get values inputted in form fields
post("/squad", (request, repsond) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("Sname");
  String cause = request.queryParams("cause");
  int createdSize = Integer.parseInt(request.queryParams("maximum-size"));
  Squad newSquad = new Squad(name, cause, createdSize);
  model.put("template", "templates/squad-success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//displays the squads created
get("/squads", (request, repsonse) ->{
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("squads", Squad.all());
  model.put("template", "templates/squads.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//displays a selected squad by accessing its ID
get("/squads/:id", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
  model.put("squad", squad);
  model.put("template", "templates/squad.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//creates a link to the create new hero form
get("squads/:id/heroes/new", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
  model.put("squad", squad);
  model.put("template", "templates/squad-heroes-form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//processes the form submission and creates new hero in that squad
post("/heroes", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();

  Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));

  String createdName = request.queryParams("name");
  int createdAge = Integer.parseInt(request.queryParams("age"));
  String createdSpecialPower = request.queryParams("specialPower");
  String createdWeakness = request.queryParams("weakness");
  Hero testHero = new Hero(createdName, createdAge, createdSpecialPower, createdWeakness);

  squad.addHero(testHero);

  model.put("squad", squad);
  model.put("template", "templates/squad-heroes-success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

  }
}
