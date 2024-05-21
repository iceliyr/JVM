//package com.itheima.jvmoptimize.performance.practice.controller;
//
//import com.itheima.jvmoptimize.performance.practice.entity.User;
//import com.itheima.jvmoptimize.performance.practice.entity.UserDetails;
//import com.itheima.jvmoptimize.performance.practice.service.UserService;
//import com.itheima.jvmoptimize.performance.practice.vo.UserVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/puser")
//public class UserController2 {
//
//    @Autowired
//    private UserService userService;
//
//
//    //最终优化 - 并行stream流
//    @GetMapping
//    public List<UserVO> user5(){
//        //1.获取前端需要的详情数据
//        List<UserDetails> userDetails = userService.getUserDetails();
//
//        //2.获取缓存中的用户数据
//        List<User> users = userService.getUsers();
//        Map<Long, String> userMap = users.parallelStream().
//                collect(Collectors.toMap(User::getId, User::getName));
//
//        //3.遍历详情集合，从缓存中获取用户名，生成VO进行填充
//        return userDetails.parallelStream().map(userDetail -> {
//            UserVO userVO = new UserVO();
//            //可以使用BeanUtils对象拷贝
//            userVO.setId(userDetail.getId());
//            userVO.setName(userMap.get(userVO.getId()));
//            userVO.setRegister(userDetail.getRegister().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//            return userVO;
//        }).collect(Collectors.toList());
//
//    }
//
//    //stream流改造，性能会降低，为后续并行流做准备
//    public List<UserVO> user4(){
//        //1.获取前端需要的详情数据
//        List<UserDetails> userDetails = userService.getUserDetails();
//
//        //2.获取缓存中的用户数据
//        List<User> users = userService.getUsers();
//        Map<Long, String> userMap = users.stream().
//                collect(Collectors.toMap(User::getId, User::getName));
//
//        //3.遍历详情集合，从缓存中获取用户名，生成VO进行填充
//        return userDetails.stream().map(userDetail -> {
//            UserVO userVO = new UserVO();
//            //可以使用BeanUtils对象拷贝
//            userVO.setId(userDetail.getId());
//            userVO.setName(userMap.get(userVO.getId()));
//            userVO.setRegister(userDetail.getRegister().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//            return userVO;
//        }).collect(Collectors.toList());
//
//    }
//
//    //初始代码
//    public List<UserVO> user1(){
//        //1.获取前端需要的详情数据
//        List<UserDetails> userDetails = userService.getUserDetails();
//
//        //2.获取缓存中的用户数据
//        List<User> users = userService.getUsers();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //3.遍历详情集合，从缓存中获取用户名，生成VO进行填充
//        ArrayList<UserVO> userVOS = new ArrayList<>();
//        for (UserDetails userDetail : userDetails) {
//            UserVO userVO = new UserVO();
//            //可以使用BeanUtils对象拷贝
//            userVO.setId(userDetail.getId());
//            userVO.setRegister(simpleDateFormat.format(userDetail.getRegister2()));
//            //填充name
//            for (User user : users) {
//                if(user.getId().equals(userDetail.getId())){
//                    userVO.setName(user.getName());
//                }
//            }
//            //加入集合
//            userVOS.add(userVO);
//        }
//
//        return userVOS;
//
//    }
//
//
//    //使用Map进行优化
//    public List<UserVO> user2(){
//        //1.获取前端需要的详情数据
//        List<UserDetails> userDetails = userService.getUserDetails();
//
//        //2.获取缓存中的用户数据
//        List<User> users = userService.getUsers();
//        Map<Long, String> userNames = users.stream().collect(Collectors.toMap(User::getId, User::getName));
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //3.遍历详情集合，从缓存中获取用户名，生成VO进行填充
//        ArrayList<UserVO> userVOS = new ArrayList<>();
//        for (UserDetails userDetail : userDetails) {
//            UserVO userVO = new UserVO();
//            //可以使用BeanUtils对象拷贝
//            userVO.setId(userDetail.getId());
//            userVO.setRegister(simpleDateFormat.format(userDetail.getRegister2()));
//            userVO.setName(userNames.get(userDetail.getId()));
//            //加入集合
//            userVOS.add(userVO);
//        }
//
//        return userVOS;
//
//    }
//
//    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    //优化时间处理
//    public List<UserVO> user3(){
//        //1.获取前端需要的详情数据
//        List<UserDetails> userDetails = userService.getUserDetails();
//
//        //2.获取缓存中的用户数据
//        List<User> users = userService.getUsers();
//        Map<Long, String> userNames = users.stream().collect(Collectors.toMap(User::getId, User::getName));
//        //3.遍历详情集合，从缓存中获取用户名，生成VO进行填充
//        ArrayList<UserVO> userVOS = new ArrayList<>();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (UserDetails userDetail : userDetails) {
//            UserVO userVO = new UserVO();
//            //可以使用BeanUtils对象拷贝
//            userVO.setId(userDetail.getId());
//            userVO.setRegister(userDetail.getRegister().format(formatter));
//            userVO.setName(userNames.get(userDetail.getId()));
//            //加入集合
//            userVOS.add(userVO);
//        }
//
//        return userVOS;
//
//    }
//
//
//
//}
