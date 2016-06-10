package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("index", new ModelMap("message", "Message from /main"));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public ModelAndView start() {
        return new ModelAndView("welcome", new ModelMap("message", "Message from /main/welcome!!!"));
    }
}
