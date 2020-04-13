package com.tzword.demo.util;

import com.alibaba.fastjson.JSON;
import com.tzword.demo.dto.ResponseBusinessDto;
import com.tzword.demo.dto.ResponseDto;

public class ResponseUtil {
    /**
     * 返沪json报文
     * @param resultCode
     * @param resultMessage
     * @param code
     * @param message
     * @param o
     * @return
     */
    public static String getResult(String resultCode,String resultMessage,String code,String message,Object o){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResultCode(resultCode);
        responseDto.setResultMessage(resultMessage);
        responseDto.setTimestamp(Long.valueOf(123132131));
        if (null != responseDto.getResultCode() && "200".equals(responseDto.getResultCode())){
            ResponseBusinessDto responseBusinessDto = new ResponseBusinessDto();
            responseBusinessDto.setCode(code);
            responseBusinessDto.setMessage(message);
            responseBusinessDto.setData(o);
            responseDto.setResultData(responseBusinessDto);
        }
        return JSON.toJSONString(responseDto);
    }
}
