package com.eob.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "notification_id")
private int notificationId;

@ManyToOne
@JoinColumn(name="user_id",nullable=false)
private User user;


@Column(name = "message",columnDefinition="Text",nullable=false)
private String message;

@Column(name = "is_read",nullable=false)
private boolean isRead;

@Column(name="created_at",nullable=false,updatable = false)
private LocalDateTime createdAt;

public int getNotificationId() {
	return notificationId;
}

public void setNotificationId(int notificationId) {
	this.notificationId = notificationId;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public boolean isRead() {
	return isRead;
}

public void setRead(boolean isRead) {
	this.isRead = isRead;
}

public LocalDateTime getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}


}
