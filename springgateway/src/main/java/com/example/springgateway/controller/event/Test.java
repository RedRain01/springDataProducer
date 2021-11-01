package com.example.springgateway.controller.event;


import com.example.springgateway.service.EventUserService;
import com.example.springgateway.service.GreetingReactive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@SessionAttributes("stu")
public class Test {

    @Autowired
    private GreetingReactive reactiveFeignClient;

    @Autowired
    private EventUserService eventUserService;







    @GetMapping("/greetingReactiveWithParam")
    public Mono<String> greetingReactiveWithParam(@RequestParam(value = "id") Long id) {
        return reactiveFeignClient.greetingWithParam(id).map(s -> "reactive feign with param! : " + s);
    }
    @GetMapping("/deee")
    public Mono<String> greetingReactiveOther() {
        return reactiveFeignClient.greeting().map(s -> "reactive feign other! : " + s);
    }





    @GetMapping("/eew")
    @ResponseBody
    public String eew() {
      return   eventUserService.eee();
    }


    @GetMapping("/eet")
    @ResponseBody
    public String eeew() {
        return   "3333333333";
    }

    @ResponseBody
    @RequestMapping("/test12")
    @ModelAttribute("stu")
    public String addOrderDetil(WebSession session,Model model){
        Stu stu = new Stu("jack","123456","3333");
        session.getAttributes().put("ids",stu);
        model.addAttribute("webSession",session);
        return "model";
    }


/*
    @RequestMapping("/demo")
    @ResponseBody
    public String demo(WebSession session){

        */
/* Create instance of your API *//*

        IcecreamServiceApi client =
                WebReactiveFeign  //WebClient based reactive feign
                        .<IcecreamServiceApi>builder()
                        .target(IcecreamServiceApi.class, "127.0.0.1:8003");
    //    Flux<String> availableMixins = client.tete();

        Stu stu = session.getAttribute("ids");
        return stu.getId();
    }
*/

/*    @RequestMapping("/tete")
    @ResponseBody
    public Mono<String> tete(){

        *//* Create instance of your API *//*
        IcecreamServiceApi client =
                WebReactiveFeign  //WebClient based reactive feign
                        .<IcecreamServiceApi>builder()
                        .target(IcecreamServiceApi.class, "127.0.0.1:8003");
        Mono<String>  availableMixins = client.tete();
        return  availableMixins;
    }*/

    @PostMapping("/sss")
    public String setAttribute(@ModelAttribute SessionAttributeForm sessionAttributeForm, WebSession session) {
        session.getAttributes().put(sessionAttributeForm.getAttributeName(), sessionAttributeForm.getAttributeValue());
        return "redirect:/";
    }
    @GetMapping("/")
    public String index(Model model, WebSession webSession) {
        model.addAttribute("webSession", webSession);
        return "home";
    }

    @ResponseBody
    @RequestMapping("/test771")
    public String addOrderDetil1(){
        return "999";
    }


    @ResponseBody
    @RequestMapping("/yy")
    public Mono ss(@ModelAttribute Stu stu){
        String id = stu.getId();
        stu.setId("0909");
        return null;
    }

    @RequestMapping("/caaa")
    public String parameter(@ModelAttribute("user") User user) {
        return "index";
    }
}
