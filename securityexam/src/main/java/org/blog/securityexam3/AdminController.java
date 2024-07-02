package org.blog.securityexam3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/abc")
    public String abc(){//admin만 접근가능
        return "abc";
    }


    @GetMapping("/def")
    public String list(){//admin ,superuser접근가능
        return "def";
    }

    @GetMapping("/add")
    public String add(){//superuser 접근가능
        return "add";
    }
}
