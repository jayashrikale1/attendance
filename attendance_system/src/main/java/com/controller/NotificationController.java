package com.controller;

import com.entity.Notification;
import com.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // List all notifications
    @GetMapping
    public String listNotifications(Model model) {
        model.addAttribute("notifications", notificationService.getAllNotifications());
        return "notification/list"; // Corresponds to notification/list.html
    }

    // View a specific notification
    @GetMapping("/{id}")
    public String viewNotification(@PathVariable Long id, Model model) {
        Notification notification = notificationService.getNotificationById(id);
        model.addAttribute("notification", notification);
        return "notification/view"; // Corresponds to notification/view.html
    }


    // Show Add Notification Form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("notification", new Notification());
        return "notification/add"; // Corresponds to notification/add.html
    }

    // Save Notification (Add or Edit)
    @PostMapping("/save")
    public String saveNotification(@ModelAttribute("notification") Notification notification) {
        notificationService.saveNotification(notification);
        return "redirect:/notification"; // Redirect back to list view
    }

    // Show Edit Notification Form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Notification notification = notificationService.getNotificationById(id);
        model.addAttribute("notification", notification);
        return "notification/edit"; // Corresponds to notification/edit.html
    }

    // Delete Notification
    @GetMapping("/delete/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return "redirect:/notification"; // Redirect back to list view
    }
     
}
