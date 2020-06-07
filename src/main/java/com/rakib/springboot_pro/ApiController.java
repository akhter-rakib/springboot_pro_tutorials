package com.rakib.springboot_pro;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@CrossOrigin(origins = "*", methods =
        {GET, POST, PUT, DELETE, OPTIONS})
@ResponseBody
public @interface ApiController {
    @AliasFor(
            annotation = Controller.class
    )
    String value() default "";
}
