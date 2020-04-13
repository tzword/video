package com.tzword.demo.action;

import com.tzword.demo.dto.UserDto;
import com.tzword.demo.util.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aa")
public class VideoController {

    /**
     * 传入实体
     * @return
     */
    @RequestMapping(value = "/bb",method = RequestMethod.GET)
    public String getResult(){
        UserDto userDto = new UserDto();
        userDto.setName("张三");
        userDto.setAge(1);
        return ResponseUtil.getResult("200","查询成功","200107","用户名错误",userDto);
    }

    /**
     * 传入集合
     * @return
     */
    @RequestMapping(value = "/cc",method = RequestMethod.GET)
    public String getResultList(){
        UserDto userDto = new UserDto();
        userDto.setName("王五");
        userDto.setAge(1);

        UserDto userDto2 = new UserDto();
        userDto2.setName("李四");
        userDto2.setAge(2);

        List<UserDto> list = new ArrayList<>();
        list.add(userDto);
        list.add(userDto2);

        return ResponseUtil.getResult("200","查询成功","200107","用户名错误",list);
    }
}
