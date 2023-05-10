package com.hut.hutserver.common;

import java.beans.ConstructorProperties;
import java.io.Serializable;


public class Result<T> implements Serializable {
    private static final long serialVersionUID = 3497586246759262910L;
    private int code;
    private T data;
    private String msg;

    public static <T> Result ok(T t) {
        return new Result(200, t, "");
    }

    public static Result err(int errorCode, Object t) {
        return new Result(errorCode, t, "");
    }

    public static Result err(int errorCode, Object t, String msg) {
        return new Result(errorCode, t, msg);
    }

    public static Result err(HutServerErrorCode errorCode) {
        return new Result(errorCode.getCode(), (Object)null, errorCode.getMessage());
    }

    public T unwrap() {
        return this.data == null ? null : this.data;
    }

    public boolean success() {
        return this.code == 200;
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Result;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getCode();
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        return result;
    }

    public String toString() {
        return "Result(code=" + this.getCode() + ", data=" + this.getData() + ", msg=" + this.getMsg() + ")";
    }

    @ConstructorProperties({"code", "data", "msg"})
    public Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
