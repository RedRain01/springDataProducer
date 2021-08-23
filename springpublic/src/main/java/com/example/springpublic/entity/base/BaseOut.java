package com.example.springpublic.entity.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标准输出
 *
 * @author 刘有根 2018年9月10日
 */
public class BaseOut implements Serializable{
    private static final long serialVersionUID = -2865530035201778291L;

    private String msg; //返回值
    private String status;//返回
    private Map<String, Object> data;
    private List<?> list;

    public BaseOut() {
    }

    public BaseOut(ResultCode result) {
        this.status = result.getCode();
        this.msg = result.getDescribe();
    }

    public BaseOut(ResultCode result, String msg) {
        this.status = result.getCode();
        this.msg = msg;
    }

    public BaseOut(ResultCode result, Map<String, Object> data) {
        this.status = result.getCode();
        this.data = data;
    }

    public BaseOut(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    public void addData(String key,Object value){
        if(this.data == null) {
            this.data = new HashMap<String, Object>();
        }
        this.data.put(key, value);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatus(ResultCode result) {
        this.status = result.getCode();
        this.msg = result.getDescribe();
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Object get(String key){
        return this.data.get(key);
    }

    @Override
    public String toString() {
        return "BaseOut [msg=" + msg + ", status=" + status + ", data=" + data + ", list=" + list + "]";
    }

}
