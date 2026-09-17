package com.task.tracker.app;


import java.sql.SQLOutput;

/*
    BannerAndLogs - Initializes when the application starts and
    echoes application info-on the screen
 */
public class BannerAndLogs {

    Thread thread = new Thread(()->{
        System.out.println("\n\ninitializing application, please wait...");
        try{
            Thread.sleep(2000);

            System.out.println("\napplication initiated, loading...");

            Thread.sleep(1000);

            System.out.println("\napplication is ready...");

            Thread.sleep(2000);
            System.out.println("\n=========================================================");
            System.out.println("\n<<COMMANDS>> to use application\n");
            System.out.println("add ==> to add new task");
            System.out.println("eg: add <task desc>\n");
            System.out.println("update ==> to update existing task");
            System.out.println("eg: update <task id>\n");
            System.out.println("delete ==> to delete task");
            System.out.println("eg: delete <task id>\n");
            System.out.println("show-all ==> to show all tasks\n");
            System.out.println("show-todo ==> to show all todo tasks\n" );
            System.out.println("show-in-prog ==> to show all in progress tasks\n");
            System.out.println("show-done ==> to show completed tasks\n");
            System.out.println("\nquit / exit ==> to exit from application\n");
            System.out.println("\n=========================================================");

        }catch (InterruptedException e){
            System.out.println("thread crashed...rerun your application");
        }
    });

    BannerAndLogs(){
        thread.start();
    }

}
