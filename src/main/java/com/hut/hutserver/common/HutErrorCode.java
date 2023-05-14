package com.hut.hutserver.common;

import java.beans.ConstructorProperties;

public class HutErrorCode {
    private int code;
    private String message;

    public static final HutErrorCode USER_ALREADY_EXISTED = new HutErrorCode(10001, "user already existed");
    public static final HutErrorCode REGISTER_FAILED = new HutErrorCode(10002, "学号或密码错误");
    public static final HutErrorCode USER_NOT_EXIST_OR_ERROR_PASSWORD = new HutErrorCode(10003, "账号或密码错误");
    public static final HutErrorCode USER_NOT_EXIST = new HutErrorCode(10004, "用户不存在");

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HutErrorCode)) {
            return false;
        } else {
            HutErrorCode other = (HutErrorCode)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof HutErrorCode;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getCode();
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    public String toString() {
        return "HutServerErrorCode(code=" + this.getCode() + ", message=" + this.getMessage() + ")";
    }

    @ConstructorProperties({"code", "message"})
    public HutErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

