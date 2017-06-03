package com.arms.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.arms.rs.model.Todo;


@Component
public class TodoDao {
	
	public static AtomicLong atomicLomg = new AtomicLong(1);
	public static List<Todo> todos;
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	{
		todos = new ArrayList<Todo>();
		String contents[]={
				"I am interest in this interest book",
				"Have you been abord",
				"I find a book intersting",
				"Sorry for my late reply",
				"She interests me"
				
		};
	Calendar c = Calendar.getInstance();
	Random r = new Random();
	for(int i = 0;i<contents.length;i++){
		c.add(Calendar.DATE, r.nextInt(3));
		String formattedDate = sdf.format(c.getTime());
		todos.add(new Todo(atomicLomg.getAndIncrement(),"phase" , contents[i], formattedDate,formattedDate));
		
	}
	
			
	}
	
public List<Todo> list(){
		
		return todos;
		
	}

public Todo get(Long id){
	for(Todo c :todos){
		if(c.getId().equals(id)){
			return c;
		}
	}
	return null;
}
public Todo create(Todo todo){
	
	todo.setId(atomicLomg.getAndIncrement());
	todo.setCreateAt(sdf.format(new Date()));
	todo.setUpdateAt(sdf.format(new Date()));
	todos.add(todo);
	return todo ;
	
}
public Todo update(Long id,Todo todo){
	for(Todo c :todos){
		if(c.getId().equals(id)){
			todo.setId(c.getId());
			todo.setCreateAt(c.getCreateAt());
			todo.setUpdateAt(sdf.format(new Date()));
			todos.remove(c);
			todos.add(todo);
			return todo ;
		}
	}
	return null;

	
}
public Long delete(Long id){
	for(Todo c :todos){
		if(c.getId().equals(id)){
			todos.remove(c);
			return id;
		}
	}
	return null;
}	
	

}
