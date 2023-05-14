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
 * 
 * </p>
 *
 * @author HandleX
 * @since 2023-05-15
 */
@TableName("hut_chat_message")
@ApiModel(value = "HutChatMessageEntity对象", description = "")
public class HutChatMessageEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String sendUserId;

    @ApiModelProperty("接收者的user_id")
    private String receiveUserId;

    @ApiModelProperty("只有纯文本类型才会直接展示，其他类型消息都是存储OSS的url")
    private String content;

    @ApiModelProperty("发送消息的类型")
    private String msgType;

    @ApiModelProperty("文件大小，使用 INT UNSIGNED 类型存储")
    private Integer size;

    @ApiModelProperty("表示时间长度的数据类型，通常用于记录音频、视频等媒体文件的播放时间")
    private Integer duration;

    @ApiModelProperty("指的是文件的格式或扩展名，例如：常见的文件格式包括JPEG、PNG、GIF、MP3、MP4等")
    private String format;

    private String chatType;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ApiModelProperty("未读、已读、撤回")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HutChatMessageEntity{" +
            "id = " + id +
            ", sendUserId = " + sendUserId +
            ", receiveUserId = " + receiveUserId +
            ", content = " + content +
            ", msgType = " + msgType +
            ", size = " + size +
            ", duration = " + duration +
            ", format = " + format +
            ", chatType = " + chatType +
            ", createdAt = " + createdAt +
            ", updatedAt = " + updatedAt +
            ", status = " + status +
        "}";
    }
}
