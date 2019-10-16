package com.yao.jqr.dto;

public class JsonRootBean {

    private String anonymous;
    private long font;
    private long group_id;
    private String message;
    private int message_id;
    private String message_type;
    private String post_type;
    private String raw_message;
    private long self_id;
    private Sender sender;
    private String sub_type;
    private long time;
    private long user_id;
    public void setAnonymous(String anonymous) {
         this.anonymous = anonymous;
     }
     public String getAnonymous() {
         return anonymous;
     }

    public void setFont(long font) {
         this.font = font;
     }
     public long getFont() {
         return font;
     }

    public void setGroup_id(long group_id) {
         this.group_id = group_id;
     }
     public long getGroup_id() {
         return group_id;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setMessage_id(int message_id) {
         this.message_id = message_id;
     }
     public int getMessage_id() {
         return message_id;
     }

    public void setMessage_type(String message_type) {
         this.message_type = message_type;
     }
     public String getMessage_type() {
         return message_type;
     }

    public void setPost_type(String post_type) {
         this.post_type = post_type;
     }
     public String getPost_type() {
         return post_type;
     }

    public void setRaw_message(String raw_message) {
         this.raw_message = raw_message;
     }
     public String getRaw_message() {
         return raw_message;
     }

    public void setSelf_id(long self_id) {
         this.self_id = self_id;
     }
     public long getSelf_id() {
         return self_id;
     }

    public void setSender(Sender sender) {
         this.sender = sender;
     }
     public Sender getSender() {
         return sender;
     }

    public void setSub_type(String sub_type) {
         this.sub_type = sub_type;
     }
     public String getSub_type() {
         return sub_type;
     }

    public void setTime(long time) {
         this.time = time;
     }
     public long getTime() {
         return time;
     }

    public void setUser_id(long user_id) {
         this.user_id = user_id;
     }
     public long getUser_id() {
         return user_id;
     }

}