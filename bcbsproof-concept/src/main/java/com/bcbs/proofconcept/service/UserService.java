package com.bcbs.proofconcept.service;

import com.bcbs.proofconcept.dao.UserInfoDao;
import com.bcbs.proofconcept.model.User;
import com.bcbs.proofconcept.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserInfoRepository userInfoRepository;
    //private final PasswordEncoder passwordEncoder;

    public String addUser(UserInfoDao userInfo) {
        //userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        User user = new User();
        user.setEmail(userInfo.getEmail());
        user.setFirstname(userInfo.getFirstname());
        user.setLastname(userInfo.getLastname());
        user.setAvatar(userInfo.getAvatar());
        user.setUsername(userInfo.getUserName());
        user.setRoles(userInfo.getRoles());
        //user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(user);
        return "user added to system";
    }

    public List<UserInfoDao> findUsers() {
        List<User> users = userInfoRepository.findAll();
        List<UserInfoDao> userInfoDaos = users.stream().map(this::mapToDAo).toList();
        return userInfoDaos;
    }

    public UserInfoDao getUserById(Integer id) {
        Optional<User> userOpt = userInfoRepository.findById(id);
        User retUser    = userOpt.orElse(new User(0,"", "", "","","","","") );
        UserInfoDao ufd = mapToDAo(retUser);
        return ufd;
    }

    public String deleteById(Integer id) {
        if(userInfoRepository.existsById(id)){
            userInfoRepository.deleteById(id);
        }
        return "record with the following id was deleted " + id;
    }

    private UserInfoDao mapToDAo(User user){
        UserInfoDao userInfoDao = new UserInfoDao();
        userInfoDao.setId(user.getId());
        userInfoDao.setEmail(user.getEmail());
        userInfoDao.setFirstname(user.getFirstname());
        userInfoDao.setLastname(user.getLastname());
        userInfoDao.setAvatar(user.getAvatar());
        userInfoDao.setUserName(user.getUsername());
        userInfoDao.setPassword(user.getPassword());
        userInfoDao.setRoles(user.getRoles());
        return userInfoDao;
    }
}
