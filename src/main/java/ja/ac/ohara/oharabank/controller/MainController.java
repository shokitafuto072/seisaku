package ja.ac.ohara.oharabank.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import ja.ac.ohara.oharabank.model.Oharabankhyou;
import ja.ac.ohara.oharabank.service.GakuseiService;

@Controller
public class MainController {
	@Autowired
	private GakuseiService GakuseiService;
	

@GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "こんにちは");
    return "top";
  }
@GetMapping("/tekitou")
public String index2(Model model) {
  model.addAttribute("message", "こんにちは");
  return "test2";
}

@GetMapping("/touroku/")
public ModelAndView add(Oharabankhyou oharabankhyou, ModelAndView model)  {
    model.addObject("oharabankhyou", oharabankhyou);
    model.setViewName("touroku");
return model;
  }

@PostMapping("/oharabankhyou/")
public String gakuseihyou(@Validated @ModelAttribute @NonNull Oharabankhyou gakuseihyou, RedirectAttributes result, ModelAndView model,
        RedirectAttributes redirectAttributes) {
    try {
        this.GakuseiService.save(gakuseihyou);
        redirectAttributes.addFlashAttribute("exception", "");

    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("exception", e.getMessage());
    }
    return "top";

  }

}

