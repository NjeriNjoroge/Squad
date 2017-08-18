import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

//route for showing the form
get("/", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

//displaying the created hero
get("/hero", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("name", request.queryParams("name"));
  model.put("age", request.queryParams("age"));
  model.put("specialPower", request.queryParams("specialPower"));
  model.put("weakness", request.queryParams("weakness"));
  model.put("template", "templates/hero.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

  }
}
