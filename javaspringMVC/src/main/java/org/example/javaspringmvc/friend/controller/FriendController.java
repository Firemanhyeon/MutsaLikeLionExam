package org.example.javaspringmvc.friend.controller;

import lombok.RequiredArgsConstructor;
import org.example.javaspringmvc.friend.dto.Friend;
import org.example.javaspringmvc.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class FriendController {
    private final FriendService friendService ;

    @GetMapping("/friendList")
    public String getFriendList(Model model){
        List<Friend> list = friendService.getFriendList();

        model.addAttribute("friendList" , list);
        return "friend/friendlist";
    }

}
