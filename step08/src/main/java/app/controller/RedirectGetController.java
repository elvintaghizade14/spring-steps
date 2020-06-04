package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * https://www.baeldung.com/spring-redirect-and-forward
 * https://spring.io/guides/gs/uploading-files/
 */
@RequestMapping("/links")
@Controller
public class RedirectGetController {

  /**
   * http://localhost:8080/links/a
   * to:
   * http://localhost:8080/book
   *
   * generic approach
   */
  @GetMapping("a")
  public String handle1() {
    return "redirect:/book";
  }

  /**
   * http://localhost:8080/links/b
   * to:
   * http://localhost:8080/book
   *
   * using RedirectView
   */
  @GetMapping("b")
  public RedirectView handle2() {
    return new RedirectView("/book");
  }

  /**
   * http://localhost:8080/links/c
   * to:
   * http://localhost:8080/book?a=3
   *
   * using RedirectView
   * with request parameter
   */
  @GetMapping("c")
  public RedirectView handle3(RedirectAttributes ra) {
    ra.addAttribute("a", "3");
    return new RedirectView("/book");
  }

  /**
   * http://localhost:8080/links/d
   * to:
   * http://localhost:8080/book?a=3
   *
   * using RedirectView
   * plus passing a model attribute
   */
  @GetMapping("d")
  public RedirectView handle4(RedirectAttributes ra) {
    ra.addFlashAttribute("author", "Alex");
    return new RedirectView("/book/x");
  }

  /**
   * http://localhost:8080/links/e
   * to:
   * http://localhost:8080/book/y?a=3
   *
   * using RedirectView
   * plus passing a model attribute
   */
  @GetMapping("e")
  public RedirectView handle5(RedirectAttributes ra) {
    ra.addFlashAttribute("author", "Alex");
    return new RedirectView("/book/y");
  }

  /**
   * http://localhost:8080/links/e
   * to:
   * http://localhost:8080/book?a=5
   *
   * model and view approach
   */
  @GetMapping("f")
  public ModelAndView handle6(ModelMap m) {
    m.addAttribute("a", "5"); // param
    return new ModelAndView("redirect:/book", m);
  }

}
