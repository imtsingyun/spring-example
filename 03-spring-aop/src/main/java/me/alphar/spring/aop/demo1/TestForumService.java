package me.alphar.spring.aop.demo1;

public class TestForumService {

    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(222);
    }
}
