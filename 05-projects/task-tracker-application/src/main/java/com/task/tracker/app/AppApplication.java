package com.task.tracker.app;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/*
	AppApplication - entry point to the application that initializes the app
 */
public class AppApplication {

	public static void main(String[] args) throws IOException {

		try{
			new BannerAndLogs();
			Thread.sleep(9000);
		}catch (InterruptedException e){
			System.out.println("exception occurred");
		}

		LocalDateTime localDateTime;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yy hh:mm:ss a");

		System.out.println("\n*************** | terminal activated | **************\n\n");
		while(true){
			Scanner sc = new Scanner(System.in);

			TaskJSONUpload taskJSONUpload;
			TaskJSONDelete taskJSONDelete;
			TaskJSONUpdate taskJSONUpdate;
			ShowAllTasks showAllTasks;

			System.out.print("task-cli$ ");
			String cmd = sc.next();
			String taskDesc = sc.nextLine().trim();

			switch (cmd){
				case "add":
					taskJSONUpload = new TaskJSONUpload();
					TaskSeqGenerator seqGenerator = new TaskSeqGenerator();
					Task addTask = new Task(seqGenerator.generateSeqId(), taskDesc, TaskStatus.TODO,
							LocalDateTime.now().format(dateTimeFormatter), LocalDateTime.now().format(dateTimeFormatter));
					taskJSONUpload.createNewTask(addTask);
					break;
				case "delete":
					taskJSONDelete = new TaskJSONDelete();
					Long rID = Long.parseLong(taskDesc);
					taskJSONDelete.deleteTask(rID);
					break;
				case "update":
					taskJSONUpdate = new TaskJSONUpdate();
					Long mID = Long.parseLong(taskDesc);
					System.out.print("update task desc: ");
					String updateTaskDesc = sc.nextLine();
					System.out.print("\nwant to update task status (y/n)? ");

					char flag = sc.next().charAt(0);

					TaskStatus taskStatus = null;

					if(flag == 'y' || flag == 'Y'){
						System.out.print("\n1. TODO | 2. IN_PROGRESS | 3. DONE\n");
						System.out.print("choose your option: ");
						int opt = sc.nextInt();
						switch (opt){
							case 1:
								taskStatus = TaskStatus.TODO;
								break;
							case 2:
								taskStatus = TaskStatus.IN_PROGRESS;
								break;
							case 3:
								taskStatus = TaskStatus.DONE;
								break;
							default:
								System.out.println("no option selected, applying existing status!");
						}
					}

					Task modTask = new Task(mID, updateTaskDesc, taskStatus, null, LocalDateTime.now().format(dateTimeFormatter));
					taskJSONUpdate.updateTask(mID, modTask);
					break;
				case "show-all":
					showAllTasks = new ShowAllTasks();
					showAllTasks.showAllTasks();
					break;
				case "show-todo":
					showAllTasks = new ShowAllTasks();
					showAllTasks.showAllToDo();
					break;
				case "show-in-prog":
					showAllTasks = new ShowAllTasks();
					showAllTasks.showInProgress();
					break;
				case "show-done":
					showAllTasks = new ShowAllTasks();
					showAllTasks.showDone();
					break;
				default:
					System.exit(0);
			}
		}
	}
}
