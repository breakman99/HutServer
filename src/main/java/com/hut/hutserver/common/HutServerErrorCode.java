package com.hut.hutserver.common;

import java.beans.ConstructorProperties;

public class HutServerErrorCode {
    private int code;
    private String message;

    public static HutServerErrorCode BID_USER_NOT_FOUND = new HutServerErrorCode(40001, "未找到此bid用户");
    public static HutServerErrorCode XH_OR_PASSWORD_ERROR = new HutServerErrorCode(40002, "学号或密码错误");

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
        } else if (!(o instanceof HutServerErrorCode)) {
            return false;
        } else {
            HutServerErrorCode other = (HutServerErrorCode)o;
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
        return other instanceof HutServerErrorCode;
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
    public HutServerErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

