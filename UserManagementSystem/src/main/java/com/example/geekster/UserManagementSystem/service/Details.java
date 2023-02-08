package com.example.geekster.UserManagementSystem.service;


import com.example.geekster.UserManagementSystem.model.Management;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class Details {

    private static List<Management> manages = new ArrayList<>();
    private static int countUserId = 0;

    static {
        manages.add(new Management(++countUserId,"Mustafa","Mustataf123","Lucknow",7024745876L));
        manages.add(new Management(++countUserId,"Sanaya","sanaya123","Bengaluru",7012455876L));
        manages.add(new Management(++countUserId,"Abhishek","Abhishek123","Hyderabad",8544745876L));
        manages.add(new Management(++countUserId,"Manya","Manya123","Bhopal",9854745876L));
        manages.add(new Management(++countUserId,"Adil","Adil786","Delhi",6584745876L));
    }
    public List<Management> findAll(){
        return manages;
    }

    public Management findByUserId(int userId){
        Predicate<? super Management> predicate = todo -> todo.getUserId() == userId;
        Management manage = manages.stream().filter(predicate).findFirst().get();
        return manage;
    }

    public void deleteManagemaent(int userId){
        Predicate<? super Management> predicate = manages -> manages.getUserId() == userId;
        manages.removeIf(predicate);
    }

    public void addManagement(Management manage) {
        manages.add(manage);
    }
    public void updateManagement(int userId,Management newManagement){

        Management manage = findByUserId(userId);

        manage.setUserId(newManagement.getUserId());
        manage.setName(newManagement.getName());
        manage.setUserName(newManagement.getUserName());
        manage.setAddress(newManagement.getAddress());
        manage.setPhoneNumber(newManagement.getPhoneNumber());

    }

}