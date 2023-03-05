package com.laljisingh.test0533.repository;

import com.laljisingh.test0533.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findStudentByfirstName(String firstName);

    @Query(value = "select * from student where active = 1;", nativeQuery = true)
    public List<Student> getActiveStudent();


    @Query(value = "select * from tbl_user where user_id = :userId and status_id = 1", nativeQuery = true)
    List<Student> getUserByUserId(Integer userId);

}
