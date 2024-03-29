package cn.zzq.bean;


public class JsonResult {

    private String code;

    private String msg;

    private Object data;

    private int totalPage;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


    public void success() {
        this.code = "200";
        this.msg = "请求成功！";
    }

    public void success(Object data) {
        success();
        this.data = data;
    }

    public void success(String msg) {
        success();
        this.msg = msg;
    }

    public void failure() {
        this.code = "500";
        this.msg = "请求失败！";
    }

    public void failure(String msg) {
        failure();
        this.msg = msg;
    }

    public void setFailure(Integer code, String msg) {
        this.code = code + "";
        this.msg = msg;
    }
}
