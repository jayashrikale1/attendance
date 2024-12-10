package com.service;


import com.entity.Notification;
import com.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Notification saveNotification(Notification notification) {
        return repository.save(notification);
    }

    public void deleteNotification(Long id) {
        repository.deleteById(id);
    }
     
}
