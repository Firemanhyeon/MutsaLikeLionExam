package org.example.restexam.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileController {
    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response){
        Path filepath = Paths.get("/Users/jeonghohyeon/Desktop/fileexam/cat.jpg");
        response.setContentType("image/jpeg");
        try{
            InputStream inputStream = Files.newInputStream(filepath);
            StreamUtils.copy(inputStream,response.getOutputStream());
            response.flushBuffer();
        }catch(IOException e){
            e.getStackTrace();
        }
    }

    @PostMapping(value = "/upload" , consumes = "multipart/form-data")
    public ResponseEntity<String> handleFileUpload(
            @RequestPart("file")MultipartFile file,
            @RequestPart("info")UploadInfo uploadInfo
    ){
        String message="";
        //
        System.out.println(file.getOriginalFilename()+"=======================");
        System.out.println(uploadInfo.getDescription()+"=======================");
        System.out.println(uploadInfo.getTag()+"=======================");

        try{
            //파일업로드를 처리하는 과정
            //MultipartFile객체인 file로부터 입력 스트림을 얻어온다. 이 입력 스트림을 통해 업로드 된 파일의 내용에 접근 할 수 있다.
            InputStream inputStream = file.getInputStream();
            //해당 경로에 있는 파일의 내용을 읽어와서 클라이언트가 업로드한 파일을 서버에 저장한다. 이때 FileOutputStream을 이용하여 해당 경로에 저장한다.
            //StreamUtils 란? : SpringFrameWork에서 제공하는 유틸리티 클래스 중 하나. 간단한 입출력 작업을 수행하기 위한 메서드를 제공한다.
            //copy()는 두개의 스트림 사이에서 데이터를 복사한다.
            StreamUtils.copy(inputStream,
                    new FileOutputStream("/Users/jeonghohyeon/Desktop/fileexam/"+file.getOriginalFilename()));

            message =  "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.ok().body(message);
        }catch (IOException e){
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.badRequest().body(message);
        }
    }
}
