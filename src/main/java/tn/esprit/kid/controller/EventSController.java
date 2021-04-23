package tn.esprit.kid.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(value = "session")
@Controller(value = "eventController") // Name of the bean in Spring IoC
@ELBeanName(value = "eventController") // Name of the bean used by JSF
@Join(path = "/", to = "/event.jsf")

public class EventSController {

}
