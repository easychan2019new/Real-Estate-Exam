package com.alexande.realestateexam.schedule;

import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateStudyDay {

    @Autowired
    private final UserRepository userRepository;

    public UpdateStudyDay(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //@Scheduled(cron = "*/5 * * * * *")// every 5 second
    @Scheduled(cron = "0 0 0 * * ?")// triggered at 0:00 everyday
    public void taskRun(){
        List<User> users = userRepository.findAll();
        for (User user: users) {
            // update user's total study day
            if (user.getDailyPractice() != 0) {
                user.setTotalStudyDay(user.getTotalStudyDay() + 1);
            }
            // initialize user's daily practice to 0
            user.setDailyPractice(0);

            userRepository.save(user);

//            System.out.println("Spring task run ——" + new Date());
//            System.out.println(user.getTotalStudyDay());
        }
    }
}
