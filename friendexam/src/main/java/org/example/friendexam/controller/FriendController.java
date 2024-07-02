package org.example.friendexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.service.FriendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

    //기본 리스트
//    @GetMapping
//    public String friedns(Model model){
//        Iterable<Friend> list =friendService.findAllFriends();
//        model.addAttribute("friendList",list);
//        return "friends/list";
//    }
    //페이징을이용한 리스트
    @GetMapping
    public String friedns(Model model , @RequestParam(defaultValue = "1")int page , @RequestParam(defaultValue = "5") int size){
                                                        //현재페이지 , 전체사이즈
        Pageable pageable = PageRequest.of(page -1 , size );

        Page<Friend> list =friendService.findAllFriends(pageable);
        model.addAttribute("friendList",list);
        model.addAttribute("currentPage",page);
        return "friends/list";
    }


    //등록폼으로 이동
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("friend" , new Friend());
        return "friends/form";
    }
    //등록
    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend , RedirectAttributes redirectAttributes){
        if(friendService.addFriend(friend)){
            redirectAttributes.addFlashAttribute("message" , "친구등록성공");
            return "redirect:/friends";
        }else{
            redirectAttributes.addFlashAttribute("message" , "친구등록실패");
            return "redirect:friends/form";
        }
    }

    //상세보기
    @GetMapping("/{id}")//"friends/id" 의 형태
    public String detailFriend(@PathVariable Long id , Model model){
        Friend friend = friendService.friendDetail(id);
        model.addAttribute("friend" , friend);

        return "friends/detail";
    }

    //삭제
    @GetMapping("/delete/{id}")
    public  String deleteFriend(@PathVariable Long id){
        friendService.deleteFriend(id);

        return "redirect:/friends";
    }

    //수정폼 이동
    @GetMapping("/edit/{id}")//"friends/id" 의 형태
    public String editFriend(@PathVariable Long id , Model model){
        Friend friend = friendService.friendDetail(id);
        model.addAttribute("friend",friend);
        return "friends/editForm";
    }
    //수정
    @PostMapping("/edit")
    public String modFriend( @ModelAttribute Friend friend){
        friendService.addFriend(friend);
        return "redirect:/friends";
    }
}
