package com.podio.search;

public class Counts {
    
	private Integer item;
        
	private Integer task;
        
	private Integer conversation;
        
	private Integer app;
        
	private Integer status;
        
	private Integer file;
        
	private Integer profile;

        public Integer getItem() {
                return item;
        }

        public void setItem(Integer item) {
                this.item = item;
        }

        public Integer getTask() {
                return task;
        }

        public void setTask(Integer task) {
                this.task = task;
        }

        public Integer getConversation() {
                return conversation;
        }

        public void setConversation(Integer conversation) {
                this.conversation = conversation;
        }

        public Integer getApp() {
                return app;
        }

        public void setApp(Integer app) {
                this.app = app;
        }

        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
        }

        public Integer getFile() {
                return file;
        }

        public void setFile(Integer file) {
                this.file = file;
        }

        public Integer getProfile() {
                return profile;
        }

        public void setProfile(Integer profile) {
                this.profile = profile;
        }

        @Override
        public String toString() {
                return "Counts[item=" + item + ", task=" + task + ", conversation=" + 
                        conversation + ", app=" + app + ", status=" + status + ", file=" + 
                        file + ", profile=" + profile + ']';
        }
        
}
