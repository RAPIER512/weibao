package ccu.CrudController;


import ccu.model.basicData.AreaInfo;
import ccu.model.system.*;
import ccu.springDataDao.basicData.AreaInfoRepo;
import ccu.springDataDao.system.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Courage on 2015/10/28.
 */
@RestController
@Transactional
public class LoginCtr {

    @Autowired
    AreaInfoRepo areaInfoRepo;

    @Autowired
    UserReRoleRepo userReRoleRepo;

    @Autowired
    RoleReMenuRepo roleReMenuRepo;

    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    private HttpServletRequest request;

    /**
     * 根据用户的的账户和密码查询客户的DI
     *
     * 数据数据：account  password
     * 输出数据：用户的DI
     * @param str
     * @return
     * @throws JsonProcessingException
     */
    
    @RequestMapping(value = "getUserInfo", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String greeting(@RequestBody String str) throws JsonProcessingException {
        JSONObject jsonObject = JSON.parseObject(str);
        UserInfo user1 = null;
        try {
            user1 = userInfoRepo.findByAccountAndPassword(jsonObject.getString("username"), jsonObject.getString("password"));
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("shi zhe de cuo wu ");
        if(user1 == null)
        {
            System.out.println("    null");
            return "null";
        }
        else
        {
            return user1.getId();
        }
    }
    
    
    
    
    
    
    
    
//    @RequestMapping(value = "getUserInfo", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    public String greeting(@RequestBody String str) throws JsonProcessingException {
//
//        JSONObject jsonObject = JSON.parseObject(str);
//
//        System.out.println("        "+str);
//        System.out.println(jsonObject.getString("username")+"---1---"+ jsonObject.getString("password"));
//        UserInfo user1 = null;
//        try {
//            user1 = userInfoRepo.findByAccountAndPassword(jsonObject.getString("username"), jsonObject.getString("password"));
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("shi zhe de cuo wu ");
//        if(user1 == null)
//        {
//            System.out.println("    null");
//            return "null";
//        }
//        else
//        {
//        	UsernamePasswordToken token = new UsernamePasswordToken(user1.getAccount(), user1.getPassword());  
//            token.setRememberMe(true);  
//            System.out.println("为了验证登录用户而封装的token为" );  
//            //获取当前的Subject  
//            Subject currentUser = SecurityUtils.getSubject();
//        	
//            System.out.println("对用户[" + user1.getAccount() + "]进行登录验证..验证开始");  
//            currentUser.login(token);  
//            System.out.println("对用户[" + user1.getAccount() + "]进行登录验证..验证通过");  
//            return user1.getId();
//        }
//
//    }


//    @RequestMapping(value = "getSysmenu/{UserInfoId}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//    public String getSysmenu(@PathVariable("UserInfoId") String UserInfoId) throws JsonProcessingException {
//        User user = userRepo.findOne(UserInfoId);
//        Role role = roleRepo.findOne(user.getRoleId());
//
//        ObjectMapper om = new ObjectMapper();
//        String s = om.writeValueAsString(role.getSysMenus());
//        System.out.println(s);
//        return request.getParameter("callback") + "(" + s + ")";
//    }


//    @RequestMapping(value = "getSysmenus", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    public String getSysmenu(@RequestBody String str) {
////        JSONObject j = JSON.parseObject(str);
////        UserReRole userReRole = userReRoleRepo.findByUserId(j.getString("id"));
//        System.out.println(str);
//        UserReRole userReRole = userReRoleRepo.findByUserId(str);
//
//        System.out.println(userReRole.getRoleId());
//
//        List<RoleReMenu> list = roleReMenuRepo.findByRoleId(userReRole.getRoleId());
//
//
//        List<String> menus = new ArrayList<String>();
//
//        System.out.println("ddddddddddddddddddddd");
//
//        for (RoleReMenu roleReMenu : list) {
//            menus.add(roleReMenu.getSysMenu().getMenuName());
//        }
//        System.out.println(JSON.toJSONString(menus));
//        return JSON.toJSONString(menus);
//    }

    /**
     * 根据用户的Id查询
     * @param str
     * @return
     */
    @RequestMapping(value = "getSysmenus", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String getSysmenu(@RequestBody String str) {
        System.out.println(str);
        UserReRole userReRole = null;
        try {
            userReRole = userReRoleRepo.findByUserId(str);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(userReRole.getRoleId());
        Role role =null;
        try {
            role = roleRepo.findOne(userReRole.getRoleId());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("         "+role.getRoleName());
        return role.getRoleName();
    }


    @RequestMapping(value = "getUserInfos" ,method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getUserInfos(@RequestBody String str) throws  JsonProcessingException{

        UserInfo userInfo = userInfoRepo.findOne(str);

        return userInfo.getUserName();

    }
}
