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
 * system notification table: 好友请求、系统公告、未读消息等
 * </p>
 *
 * @author HandleX
 * @since 2023-05-10
 */
@TableName("hut_notifications")
@ApiModel(value = "HutNotificationsEntity对象", description = "system notification table: 好友请求、系统公告、未读消息等")
public class HutNotificationsEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long senderId;

    private Long receiverId;

    private String content;

    private Byte type;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    private Boolean isRead;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "HutNotificationsEntity{" +
            "id = " + id +
            ", senderId = " + senderId +
            ", receiverId = " + receiverId +
            ", content = " + content +
            ", type = " + type +
            ", createdAt = " + createdAt +
            ", isRead = " + isRead +
        "}";
    }
}
