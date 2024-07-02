package org.example.friendexam.service;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.repository.FriendRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;
    //리스트
    public Iterable<Friend> findAllFriends(){
        return friendRepository.findAll();
    }

    //등록과 수정.
    @Transactional
    public boolean addFriend(Friend friend) {
        //Spring Data에서 제공되는 save라는 메서드는 id값이 이미 존재한다면 알아서 수정된다.
        Friend friend1 = friendRepository.save(friend);
        if(friend1.getId()!=null){
            return true;
        }else{
            return false;
        }
    }
    //상세
    @Transactional(readOnly = true)
    public Friend friendDetail(Long id) {
        return  friendRepository.findById(id).orElse(null);
    }
    //삭제
    @Transactional
    public void deleteFriend(Long id) {
        friendRepository.deleteById(id);
    }
    //페이징처리된 목록
    public Page<Friend> findAllFriends(Pageable pageable){
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), Sort.by(Sort.Direction.DESC,"id"));
        //페이지 넘버 , 페이지 갯수 , 정렬방법 넣어줌
        return friendRepository.findAll(sortedByDescId);
    }
}
