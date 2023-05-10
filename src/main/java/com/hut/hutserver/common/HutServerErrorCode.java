package com.hut.hutserver.common;

import java.beans.ConstructorProperties;

public class HutServerErrorCode {
    private int code;
    private String message;
    public static HutServerErrorCode ILLGEL_MALL_BID = new HutServerErrorCode(40402, "商品bid无效");
    public static HutServerErrorCode PARAMS_ERROR = new HutServerErrorCode(400, "参数错误");
    public static HutServerErrorCode SERVER_ERROR = new HutServerErrorCode(500, "服务器端错误");
    public static HutServerErrorCode AUTH_NOT_ALLOW = new HutServerErrorCode(404, "你无对此bid操作的权限");
    public static HutServerErrorCode BID_USER_NOT_FOUND = new HutServerErrorCode(40001, "未找到此bid用户");
    public static HutServerErrorCode XH_OR_PASSWORD_ERROR = new HutServerErrorCode(40002, "学号或密码错误");
    public static HutServerErrorCode WX_LOGIN_FAIL = new HutServerErrorCode(40003, "微信登录获取openid失败");
    public static HutServerErrorCode UPDATE_USER_INFO_FAIL = new HutServerErrorCode(40004, "个人信息修改失败");
    public static HutServerErrorCode XH_ADD_USER_FAIL = new HutServerErrorCode(40005, "通过学号新增用户失败");
    public static HutServerErrorCode GET_USER_ATTENS_FAIL = new HutServerErrorCode(40006, "获取用户关注失败");
    public static HutServerErrorCode UPDATE_ATTEN_FAIL = new HutServerErrorCode(40101, "修改关注关系失败");
    public static HutServerErrorCode ILLEGAL_TALK_TYPE = new HutServerErrorCode(40201, "非法的ugc类型，仅 'talk' 'comment' 有效");
    public static HutServerErrorCode TALK_NOT_FOUND = new HutServerErrorCode(40202, "说说获取失败");
    public static HutServerErrorCode INVAILD_TALK_BID = new HutServerErrorCode(40203, "说说bid无效");
    public static HutServerErrorCode INVAILD_COMMENT_BID = new HutServerErrorCode(40204, "评论bid无效");
    public static HutServerErrorCode ADD_TALK_FAIL = new HutServerErrorCode(40205, "新增说说失败");
    public static HutServerErrorCode ADD_TAG_FAIL = new HutServerErrorCode(40206, "新增说说tag");
    public static HutServerErrorCode COLLECT_ERROR = new HutServerErrorCode(40207, "说说收藏错误");
    public static HutServerErrorCode HOT_TALK_ERROR = new HutServerErrorCode(40208, "缓存获取热门说说失败");
    public static HutServerErrorCode ILLEGAL_TALK_TYPE_DIFF = new HutServerErrorCode(40209, "非法的talk type，0 普通说说， 1 投票");
    public static HutServerErrorCode VOTE_FAIL = new HutServerErrorCode(40210, "vote fail");
    public static HutServerErrorCode VOTE_SECTION_ERROR = new HutServerErrorCode(40210, "vote section 不存在");
    public static HutServerErrorCode VOTE_REPEAT = new HutServerErrorCode(40211, "不可重复投票");
    public static HutServerErrorCode VOTE_EXPIRE = new HutServerErrorCode(40212, "投票过期");
    public static HutServerErrorCode VOTE_MUTIPART = new HutServerErrorCode(40211, "此投票非mutipart类型，不可投多张票");
    public static HutServerErrorCode GET_ELETRI_FAIL = new HutServerErrorCode(40301, "获取电费信息失败");
    public static HutServerErrorCode ADD_MALL_FAIL = new HutServerErrorCode(40401, "新增商品失败");
    public static HutServerErrorCode ADD_ACTIVITY_FAIL = new HutServerErrorCode(40501, "新增活动失败");
    public static HutServerErrorCode ACTIVITY_NOT_EXIST = new HutServerErrorCode(40502, "活动不存在");
    public static HutServerErrorCode UPDATE_ACTIVITY_FAIL = new HutServerErrorCode(40503, "更新活动失败");
    public static HutServerErrorCode ACTIVITY_LIMIT = new HutServerErrorCode(40504, "活动报名人数已达上限");
    public static HutServerErrorCode TOKEN_NOT_FOUND = new HutServerErrorCode(41000, "未找到token，请在header/params中提供");
    public static HutServerErrorCode INVAILD_TOKEN = new HutServerErrorCode(41001, "token已失效，请重新登录");
    public static HutServerErrorCode ILLEGAL_TEXT = new HutServerErrorCode(41100, "敏感的文本内容");
    public static HutServerErrorCode ILLEGAL_IMAGE = new HutServerErrorCode(41101, "敏感的图片内容");
    public static HutServerErrorCode BLANK_TEXT = new HutServerErrorCode(41102, "请多发布些内容吧。不可发布空内容");
    public static HutServerErrorCode ADD_MESSAGE_TEAM_FAIL = new HutServerErrorCode(42000, "新增MessageTeam失败");
    public static HutServerErrorCode UPDATE_MESSAGE_STATUS_ERROR = new HutServerErrorCode(42001, "更新消息状态失败");
    public static HutServerErrorCode NOT_EXIST_MESSAGE_BID = new HutServerErrorCode(42002, "无效的messagebid");
    public static HutServerErrorCode NOT_EXIST_MESSAGE_STATUS = new HutServerErrorCode(42003, "无效的message状态");
    public static HutServerErrorCode IS_NOT_FREEMAN = new HutServerErrorCode(43000, "不是自由状态");
    public static HutServerErrorCode NULL_SEX_ERROR = new HutServerErrorCode(43001, "请先设置性别");
    public static HutServerErrorCode ME_ALREADY_MATCHED = new HutServerErrorCode(43002, "你已经有对象了，不可以当海王哦");
    public static HutServerErrorCode SOMEONE_ALREADY_MATCHED = new HutServerErrorCode(43002, "手速慢啦，对方已经被选走了");
    public static HutServerErrorCode NULL_LIST_ERROR = new HutServerErrorCode(43003, "匹配池还没有人噢");
    public static HutServerErrorCode NOT_IN_POOL = new HutServerErrorCode(43004, "你不在匹配池中");
    public static HutServerErrorCode MATCH_FAILED = new HutServerErrorCode(43005, "匹配失败");
    public static HutServerErrorCode ME_NOT_IN_MATCH = new HutServerErrorCode(43006, "你不在匹配组内");
    public static HutServerErrorCode SOMEONE_NOT_IN_MATCH = new HutServerErrorCode(43007, "你不在Cp组内");
    public static HutServerErrorCode NO_OBJECT_ERROR = new HutServerErrorCode(43008, "你还没有对象哦");

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

