package com.nootfoods.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nootfoods.userService.model.User;
import java.util.List;
import com.nootfoods.userService.model.User.userType;



public interface UserRepository extends JpaRepository<User, Integer>{
	 
	public  List<User> findByUserName(String userName); 
	
	public User findByEmailAdd(String emailAdd);
	
	public List<User> findByUllu(userType ullu);
	
	public void deleteByUserId(int userId);
	
	public void deleteByEmailAdd(String emailAdd);
	
	@Modifying
    @Transactional
    @Query(value = "insert into \"user\" (email_add, ullu, user_name) values (:email, :ullu, :userName)", nativeQuery = true)
    public void insertUser(@Param("email") String email, @Param("ullu") userType ullu, @Param("userName") String userName);

}
