package com.example.jpa.user.service;

import com.example.jpa.board.model.ServiceResult;
import com.example.jpa.common.MailComponent;
import com.example.jpa.common.exception.BizException;
import com.example.jpa.logs.service.LogService;
import com.example.jpa.user.entity.User;
import com.example.jpa.user.entity.UserInterest;
import com.example.jpa.user.model.*;
import com.example.jpa.user.repository.UserCustomRepository;
import com.example.jpa.user.repository.UserInterestRepository;
import com.example.jpa.user.repository.UserRepository;
import com.example.jpa.util.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCustomRepository userCustomRepository;
    private final UserInterestRepository userInterestRepository;

    private final MailComponent mailComponent;

    @Override
    public UserSummary getUserStatusCount() {

        long usingUserCount = userRepository.countByStatus(UserStatus.Using);
        long stopUserCount = userRepository.countByStatus(UserStatus.Stop);
        long totalUserCount = userRepository.count();

        return UserSummary.builder()
                .usingUserCount(usingUserCount)
                .stopUserCount(stopUserCount)
                .totalUserCount(totalUserCount)
                .build();
    }

    @Override
    public List<User> getTodayUsers() {

        LocalDateTime t = LocalDateTime.now();
        LocalDateTime startDate = LocalDateTime.of(t.getYear(), t.getMonth(), t.getDayOfMonth(), 0, 0);
        LocalDateTime endDate = startDate.plusDays(1);

        return userRepository.findToday(startDate, endDate);
    }

    @Override
    public List<UserNoticeCount> getUserNoticeCount() {

        return userCustomRepository.findUserNoticeCount();

    }

    @Override
    public List<UserLogCount> getUserLogCount() {

        return userCustomRepository.findUserLogCount();
    }

    @Override
    public List<UserLogCount> getUserLikeBest(){

        return userCustomRepository.findUserLikeBest();
    }

    @Override
    public ServiceResult addInterestUser(String email, Long id) {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            return ServiceResult.fail("?????? ????????? ???????????? ????????????.");
        }
        User user = optionalUser.get();

        Optional<User> optionalInterestUser = userRepository.findById(id);
        if (!optionalInterestUser.isPresent()) {
            return ServiceResult.fail("?????????????????? ????????? ?????? ????????? ???????????? ????????????.");
        }
        User interestUser = optionalInterestUser.get();

        //?????? ?????? ??????????
        if (user.getId() == interestUser.getId()) {
            return ServiceResult.fail(" ??????????????? ????????? ??? ????????????. ");
        }

        if (userInterestRepository.countByUserAndInterestUser(user, interestUser) > 0){
            return ServiceResult.fail("?????? ??????????????? ????????? ?????????????????????.");
        }

        UserInterest userInterest = UserInterest.builder()
                .user(user)
                .interestUser(interestUser)
                .regDate(LocalDateTime.now())
                .build();
        userInterestRepository.save(userInterest);

        return ServiceResult.success();
    }

    @Override
    public ServiceResult removeInterestUser(String email, Long interestId) {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            return ServiceResult.fail("?????? ????????? ???????????? ????????????.");
        }
        User user = optionalUser.get();

        Optional<UserInterest> optionalUserInterest = userInterestRepository.findById(interestId);
        if (!optionalUserInterest.isPresent()){
            return ServiceResult.fail("????????? ????????? ????????????.");
        }
        UserInterest userInterest = optionalUserInterest.get();

        if(userInterest.getUser().getId() != user.getId()){
            return ServiceResult.fail("????????? ????????? ????????? ????????? ??? ????????????.");
        }

        userInterestRepository.delete(userInterest);
        return ServiceResult.success();
    }


    @Override
    public User login(UserLogin userLogin) {

        Optional<User> optionalUser = userRepository.findByEmail(userLogin.getEmail());
        if (!optionalUser.isPresent()) {
            throw new BizException("?????? ????????? ???????????? ????????????.");
        }
        User user = optionalUser.get();


        if (!PasswordUtils.equalPassword(userLogin.getPassword(), user.getPassword())){
            throw new BizException("???????????? ????????? ????????????.");
        }

        return user;
    }

    @Override
    public ServiceResult addUser(UserInput userInput) {

        Optional<User> optionalUser = userRepository.findByEmail(userInput.getEmail());
        if (optionalUser.isPresent()) {
            throw new BizException("?????? ????????? ????????? ?????????.");
        }

        String encryptPassword = PasswordUtils.encryptedPassword(userInput.getPassword());

        User user = User.builder()
                .email(userInput.getEmail())
                .userName(userInput.getUserName())
                .regDate(LocalDateTime.now())
                .password(encryptPassword)
                .phone(userInput.getPhone())
                .status(UserStatus.Using)
                .build();
        userRepository.save(user);

        //????????? ??????.

        String fromEmail = "mapo.lib.02@gmail.com";
        String fromName = "?????????";
        String toEmail = user.getEmail();
        String toName = user.getUserName();

        String title = "??????????????? ??????????????????.";
        String contents = "??????????????? ??????????????????.";

        mailComponent.send(fromEmail, fromName, toEmail, toName, title, contents);


        return ServiceResult.success();
    }


}
