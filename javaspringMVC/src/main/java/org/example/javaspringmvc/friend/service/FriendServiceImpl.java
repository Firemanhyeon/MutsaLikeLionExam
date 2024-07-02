package org.example.javaspringmvc.friend.service;

import lombok.RequiredArgsConstructor;
import org.example.javaspringmvc.friend.dao.FriendDAO;
import org.example.javaspringmvc.friend.dto.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class FriendServiceImpl implements FriendService {

    private final FriendDAO friendDAO ;

    @Override
    public List<Friend> getFriendList() {
        return friendDAO.selectFriendList();
    }
}
