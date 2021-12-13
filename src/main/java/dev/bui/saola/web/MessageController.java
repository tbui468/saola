package dev.bui.saola.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @GetMapping("/hello")
    public String hello() {
        return "This is a test string"; 
    }
}
