package com.example.tugasku;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;
    private TaskDatabase database;

    public TaskRepository(Application application) {
        database = TaskDatabase.getInstance(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public void insert(Task task) {
        new InsertTasksAsyncTask(taskDao).execute(task);
    }


    private static class InsertTasksAsyncTask extends AsyncTask<Task, Void, Void> {

        private TaskDao taskDao;

        private InsertTasksAsyncTask(TaskDao taskDao){
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.insert(tasks[0]);
            return null;
        }
    }

//    public void update(Task task) {
//        new UpdateTaskAsyncTask(taskDao).execute(task);
//    }
//
//    public void delete(Task task) {
//        new DeleteTaskAsyncTask(taskDao).execute(task);
//    }
//
//    public void deleteAllTask() {
//        new DeleteAllTasksAsyncTask(taskDao).execute();
//    }

//    private static class UpdateTaskAsyncTask extends AsyncTask<Task, Void, Void> {
//
//        private TaskDao taskDao;
//
//        private UpdateTaskAsyncTask(TaskDao taskDao){
//            this.taskDao = taskDao;
//        }
//
//        @Override
//        protected Void doInBackground(Task... tasks) {
//            taskDao.update(tasks[0]);
//            return null;
//        }
//    }
//
//    private static class DeleteTaskAsyncTask extends AsyncTask<Task, Void, Void> {
//
//        private TaskDao taskDao;
//
//        private DeleteTaskAsyncTask(TaskDao taskDao){
//            this.taskDao = taskDao;
//        }
//
//        @Override
//        protected Void doInBackground(Task... tasks) {
//            taskDao.delete(tasks[0]);
//            return null;
//        }
//    }
//
//    private static class DeleteAllTasksAsyncTask extends AsyncTask<Void, Void, Void> {
//
//        private TaskDao taskDao;
//
//        private DeleteAllTasksAsyncTask(TaskDao taskDao){
//            this.taskDao = taskDao;
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            taskDao.deleteAllTasks();
//            return null;
//        }
//    }
}
