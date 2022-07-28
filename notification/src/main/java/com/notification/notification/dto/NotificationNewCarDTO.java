package com.notification.notification.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.bcel.Const;

import java.io.Serializable;
@Setter
@Getter
public class NotificationNewCarDTO implements Serializable {

    private String notification;

    public NotificationNewCarDTO(String notification) {
        this.notification = notification;
    }
}
