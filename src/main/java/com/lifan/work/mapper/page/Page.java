package com.lifan.work.mapper.page;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/17 20:02
 */
@Data
@AllArgsConstructor
public class Page {
    private Integer page = 1;

    private Integer rows = 10;

    private String orderBy;

    public Page(int start, int size,String orderBy) {
        this.page=start;
        this.rows=size;
        this.orderBy=orderBy;
    }

    public static Page getPageRequest(HttpServletRequest request) {
        String preFixField = "columns[";
        String suffixField = "][name]";
        Map<String, String[]> requestMap = request.getParameterMap();
        if(requestMap.size()==0){
            return new Page(0,10,"id");
        }
        String start = requestMap.get("start")[0];
        String length = requestMap.get("length")[0];
        String columnNumber = requestMap.get("order[0][column]")[0];
        String columnDesc = preFixField + columnNumber + suffixField;
        String orderField = requestMap.get(columnDesc)[0];
        String orderSeq = requestMap.get("order[0][dir]")[0];
        return new Page(Integer.parseInt(start),Integer.parseInt(length),orderField);
    }
}
