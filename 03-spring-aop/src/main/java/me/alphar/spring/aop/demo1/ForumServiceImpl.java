package me.alphar.spring.aop.demo1;

public class ForumServiceImpl implements ForumService {

    public void removeTopic(int topicId) {
//        PerformanceMonitor.begin("me.alphar.spring.aop.demo1.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        PerformanceMonitor.end();
    }

    public void removeForum(int forumId){
//        PerformanceMonitor.begin("me.alphar.spring.aop.demo1.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录:" + forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        PerformanceMonitor.end();
    }
}
