package org.example.restexam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/memos")
public class MemoRestControl {
    private final Map<Long,String> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody String content){
        Long id = counter.incrementAndGet();
        memos.put(id,content);
        return ResponseEntity.ok(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getMemo(@PathVariable("id") Long id){
        String memo = memos.get(id);
        if(memo ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMemo(@PathVariable("id") Long id , @RequestBody String content){
        if(!memos.containsKey(id)){
            return ResponseEntity.notFound().build();
        }
        memos.put(id,content);
        return ResponseEntity.ok("MemoUpdate");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable("id") Long id){
        String removeMemo = memos.remove(id);
        if(removeMemo==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("메세지삭제완료");
    }

    @GetMapping("/error")
    public String apierror(){
        throw new RuntimeException("API Error");
    }
}
