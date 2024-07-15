package com.gorest.constants;

public class EndPoints {

    /**
     * This is Endpoints of users api
     */
    public static final String GET_ALL_USERS = Path.USERS;
    public static final String GET_SINGLE_USER_BY_ID = Path.USERS + "/{id}";
    public static final String UPDATE_USER_BY_ID = Path.USERS+ "/{id}";
    public static final String DELETE_USER_BY_ID = Path.USERS+ "/{id}";


    /**
     * This is Endpoints of posts api
     */
    public static final String GET_ALL_POSTS = "/posts";
    public static final String GET_SINGLE_POST_BY_ID = "/posts/{id}";
    public static final String UPDATE_POST_BY_ID = "/posts/{id}";
    public static final String DELETE_POST_BY_ID = "/posts/{id}";



}
