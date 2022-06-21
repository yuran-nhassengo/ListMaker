package com.lamarck.listmaker

import android.content.Context
import android.preference.PreferenceManager
import java.util.HashSet

class ListDataManager(private val context:Context) {

    fun saveList(list: TaskList){

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()

        sharedPreferences.putStringSet(list.name,list.tasks.toHashSet())

        sharedPreferences.apply()


    }

    fun readLists(): ArrayList<TaskList>{

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        val sharedPreferencesContents = sharedPreferences.all

        val taskLists = ArrayList<TaskList>()

        for(taskList in sharedPreferencesContents){

            val itemHashSet = ArrayList(taskList.value as HashSet<String>)
            val list = TaskList(taskList.key, itemHashSet)

            taskLists.add(list)
        }

        return  taskLists
    }
}