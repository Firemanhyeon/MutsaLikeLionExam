package org.example.javaspringmvc.friend.dao;

import org.example.javaspringmvc.friend.dto.Friend;

import java.util.List;

public interface FriendDAO {
    List<Friend> selectFriendList();
}
