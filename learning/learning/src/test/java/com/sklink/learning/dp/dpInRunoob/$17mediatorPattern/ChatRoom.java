package com.sklink.learning.dp.dpInRunoob.$17mediatorPattern;

import java.util.Date;


public class ChatRoom {
	public static void showMessage(User user, String message) {
		System.out.println(String.format("%s [%s]: %s", new Date().toString(), user.getName(), message));
	}
}
