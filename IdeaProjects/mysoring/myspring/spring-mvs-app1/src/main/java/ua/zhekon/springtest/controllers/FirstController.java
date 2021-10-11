package ua.zhekon.springtest.controllers;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String sayHello(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String last_name = request.getParameter("last_name");

        model.addAttribute("massage", "Name" + name + " " + last_name);
        return "first/hello";
    }

    @GetMapping("/bye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "last_name", required = false) String lastName) {
        System.out.println(" from bye " + name + " " + lastName);
        return "first/goodbye";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {
        double result;

        switch (action) {
            case "m":
                result = a - b;
                break;
            case "a":
                result = a + b;
                break;
            case "s":
                result = a * b;
                break;
            case "d":
                result = a / (double) b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);

        return "first/calculator";
    }
}
