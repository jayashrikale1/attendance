package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    long count();  // This should return the count of notifications
}
