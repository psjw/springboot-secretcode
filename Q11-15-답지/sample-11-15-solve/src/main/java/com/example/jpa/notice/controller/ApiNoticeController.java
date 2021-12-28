package com.example.jpa.notice.controller;

import com.example.jpa.notice.model.NoticeModel;
import com.example.jpa.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class ApiNoticeController {

    private final NoticeRepository noticeRepository;


    /*
    @GetMapping("/api/notice")
    public String noticeString(){
        return "공지사항입니다.";
    }
    */

    /*
    @GetMapping("/api/notice")
    public NoticeModel notice() {

        LocalDateTime regDate = LocalDateTime.of(2021, 2, 8, 0, 0);

        NoticeModel notice = new NoticeModel();
        notice.setId(1);
        notice.setTitle("공지사항입니다.");
        notice.setContents("공지사항 내용입니다.");
        notice.setRegDate(regDate);

        return notice;
    }
    */

    /*
    @GetMapping("/api/notice")
    public List<NoticeModel> notice() {

        List<NoticeModel> noticeList = new ArrayList<>();

        noticeList.add(NoticeModel.builder()
                .id(1)
                .title("공지사항입니다.")
                .contents("공지사항내용입니다.")
                .regDate(LocalDateTime.of(2021, 1, 30, 0, 0))
                .build());
        noticeList.add(NoticeModel.builder()
                .id(2)
                .title("두번째 공지사항입니다.")
                .contents("두번째 공지사항내용입니다.")
                .regDate(LocalDateTime.of(2021, 1, 31, 0, 0))
                .build());

        return noticeList;
    }
    */

    @GetMapping("/api/notice")
    public List<NoticeModel> notice() {
        List<NoticeModel> noticeList = new ArrayList<>();

        return noticeList;
    }

    @GetMapping("/api/notice/count")
    public int noticeCount() {

        return 20;
    }


    /**
     11. 공지사항에 글을 등록하기 위해서 글작성에 대한 API를 만들어 보세요.
     [조건]
     - REST API 형식으로 구현
     - HTTP METHOD 는 POST
     - 요청 주소는 "/api/notice"
     - 전달되는 파라미터는 x-www-form-urlencoded 형식의 제목, 내용을 입력 받음
     - 파라미터는 추상화하지 않고 기본데이터 타입 형태로 전달받음
     - 리턴값은 입력된 형태에 게시글ID(1)를 추가하여 모델 형태로 리턴
     */
    /*
    @PostMapping("/api/notice")
    public NoticeModel addNotice(@RequestParam String title, @RequestParam String contents) {

        NoticeModel notice = NoticeModel.builder()
                .id(1)
                .title(title)
                .contents(contents)
                .regDate(LocalDateTime.now())
                .build();

        return notice;
    }
    */

    /**
     12. 공지사항에 글을 등록하기 위해서 글작성에 대한 API를 만들어 보세요.
     [조건]
     - REST API 형식으로 구현
     - HTTP METHOD 는 POST
     - 요청 주소는 "/api/notice2"
     - 전달되는 파라미터는 x-www-form-urlencoded 형식의 제목, 내용을 입력 받음
     - 파라미터를 공지사항 모델로 추상화하여 전달받음
     - 리턴값은 입력된 형태에 게시글ID(2)과 등록일자(현재시간)을 추가하여 모델 형태로 리턴
     */
    /*
    @PostMapping("/api/notice")
    public NoticeModel addNotice(NoticeModel noticeModel) {

        noticeModel.setId(2);
        noticeModel.setRegDate(LocalDateTime.now());

        return noticeModel;
    }*/

    /**
     13. 공지사항에 글을 등록하기 위해서 글작성에 대한 API를 만들어 보세요.
     [조건]
     - REST API 형식으로 구현
     - HTTP METHOD 는 POST
     - 요청 주소는 "/api/notice3"
     - 전달되는 파라미터는 application/json 형식의 제목, 내용을 입력 받음
     - 파라미터를 공지사항 모델로 추상화하여 전달받음
     - 리턴값은 입력된 형태에 게시글ID(3)과 등록일자(현재시간)을 추가하여 모델 형태로 리턴
     */
    /*
    @PostMapping("/api/notice")
    public NoticeModel addNotice(@RequestBody NoticeModel noticeModel) {

        noticeModel.setId(3);
        noticeModel.setRegDate(LocalDateTime.now());

        return noticeModel;
    }
    */

    /**
     14. 공지사항에 글을 등록하기 위한 글작성에 대한 API를 만들어 보세요.
     [조건]
     - REST API 형식으로 구현
     - HTTP METHOD 는 POST
     - 요청 주소는 "/api/notice4"
     - 전달되는 값은 application/json 형식의 제목, 내용을 입력 받음
     - 전달된 값을 저장하기 위한 JPA Repository 와 Entity를 통해서 Database 에 저장
     - 리턴값은 저장된 id값이 포함된 Entity 리턴
     [이미설정되어 있는 부분]
     -h2db memorydb
     */
    /*
    @PostMapping("/api/notice")
    public Notice addNotice(@RequestBody NoticeInput noticeInput) {

        Notice notice = Notice.builder()
                .title(noticeInput.getTitle())
                .contnets(noticeInput.getContents())
                .regDate(LocalDateTime.now())
                .build();

        noticeRepository.save(notice);

        return notice;
    }
    */

    /**
     15.  공지사항에 글을 등록하기 위한 글작성에 대한 API를 만들어 보세요.
     [조건]
     - REST API 형식으로 구현
     - HTTP METHOD 는 POST
     - 요청 주소는 "/api/notice4"
     - 전달되는 값은 application/json 형식의 제목, 내용을 입력 받음
     - 공지사항 등록일은 현재시간을 저장, 공지사항 조회수와 좋아요수는 초기값을 0으로 설정
     - 전달된 값을 저장하기 위한 JPA Repository 와 Entity를 통해서 Database 에 저장
     - 리턴값은 저장된 id값이 포함된 Entity 리턴
     [이미설정되어 있는 부분]
     -h2db memorydb
     */
    /*
    @PostMapping("/api/notice")
    public Notice addNotice(@RequestBody NoticeInput noticeInput) {

        Notice notice = Notice.builder()
                .title(noticeInput.getTitle())
                .contents(noticeInput.getContents())
                .regDate(LocalDateTime.now())
                .hits(0)
                .likes(0)
                .build();

        Notice resultNotice = noticeRepository.save(notice);

        return resultNotice;
    }
    */


}



















