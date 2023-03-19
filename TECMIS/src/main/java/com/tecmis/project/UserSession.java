package com.tecmis.project;

public final class UserSession {

    private static UserSession instance;

    private static String userName;
    private static String userId;

    private UserSession( String userName,String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public static UserSession getInstance( String userName,String userId) {
        if(instance == null) {
            instance = new UserSession(userName,userId);
        }
        return instance;
    }


    public static String getUserName() {
        return userName;
    }

    public static String getUserId(){
        return userId;
    }

    public static void cleanUserSession() {
        userName = null;
        userId = null;
    }

    @Override
    public String toString() {
        return "UserSession{";
    }
}

