package com.hut.hutserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 群组的成员表
 * </p>
 *
 * @author HandleX
 * @since 2023-05-15
 */
@TableName("hut_group_member")
@ApiModel(value = "HutGroupMemberEntity对象", description = "群组的成员表")
public class HutGroupMemberEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("群组id")
    private String groupId;

    @ApiModelProperty("成员，用户的user_id")
    private String memberUserId;

    @ApiModelProperty("群头衔、群称号、可由管理员赋予")
    private String tag;

    @ApiModelProperty("权限：群主、管理、普通成员等")
    private String role;

    @ApiModelProperty("封禁截止时间,小于当前时间则表示没有封禁")
    private LocalDateTime banned;

    @ApiModelProperty("逻辑删除")
    private Boolean isDelete;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMemberUserId() {
        return memberUserId;
    }

    public void setMemberUserId(String memberUserId) {
        this.memberUserId = memberUserId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getBanned() {
        return banned;
    }

    public void setBanned(LocalDateTime banned) {
        this.banned = banned;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "HutGroupMemberEntity{" +
            "id = " + id +
            ", groupId = " + groupId +
            ", memberUserId = " + memberUserId +
            ", tag = " + tag +
            ", role = " + role +
            ", banned = " + banned +
            ", isDelete = " + isDelete +
            ", createdAt = " + createdAt +
            ", updatedAt = " + updatedAt +
        "}";
    }
}
