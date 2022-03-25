package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Dto.MapperGroup_Account_Project;
import BaoCaoDoAn.Dto.group_Account_Project;
import BaoCaoDoAn.Entity.MapperProject;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;

@Repository

public class ProjectDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Project> getProjectByGroup_id(int id) {
		List<Project> list = new ArrayList<Project>();
		String sql = "Select * from project where group_id = " + id;
		list = jdbcTemplate.query(sql, new MapperProject());
		return list;

	}
	
	public Project getProjectByid(int id) {
		Project result = null;
		List<Project> list = new ArrayList<Project>();
		String sql = "Select * from project where id = " + id ;
		list  =  jdbcTemplate.query(sql, new MapperProject()) ;
		if (!list.isEmpty()) {
			result = list.get(0);
		}
		return result;
		

	}
	
	public List<group_Account_Project> getAllProject() {
		List<group_Account_Project> list = new ArrayList<group_Account_Project>();
		String sql = "SELECT p.id , p.project_name , p.urlProject  , p.createTime  ,p.group_id , p.teacher_id , g.group_name , a.account_name\r\n" + 
				"			FROM project AS p\r\n" + 
				"			INNER JOIN \r\n" + 
				"			account AS a \r\n" + 
				"			ON p.teacher_id = a.id \r\n" + 
				"			 INNER JOIN \r\n" + 
				"				 group_student AS g\r\n" + 
				"		 ON p.group_id = g.id ";
		list= jdbcTemplate.query(sql ,  new MapperGroup_Account_Project()) ;
	
		return list;
	}
	public List<Project> getAllProjectSimple() {
		List<Project> list = new ArrayList<Project>();
		String sql = "SELECT * FROM baocaodoan.project;";
		list = jdbcTemplate.query(sql, new MapperProject());
		return list;

	}

	public int deleteProject(int id) {

		String sql = "DELETE FROM project WHERE id = " + id + " ";
		int result = jdbcTemplate.update(sql);
		return result;

	}
	public int addProject(Project project) {

		String sql = "INSERT INTO project (project_name,urlProject,createTime,group_id, teacher_id) VALUES (?,?,?,?,?)" ;
		
		int count  = jdbcTemplate.update(sql , new Object[] {
				project.getName() , project.getUrlProject() ,project.getCreateTime(), project.getGroup_id() ,project.getTeacherId()
		}) ; 		
		return count;
	}

	
	public int editProject(int id , Project project) {
		
		String sql ="UPDATE project SET project_name = ?, urlProject = ? , createTime = ? , group_Id = ? , teacher_id = ? WHERE id = ?";	

		int count = jdbcTemplate.update(sql,  new Object[] {project.getName() , project.getUrlProject() , project.getCreateTime(),
				project.getGroup_id() , project.getTeacherId(), id }) ; 		
		return count;
	}
	
//	public void updateAndSave (Project project) {
//		if(project.getId() > 0) {
//			String sql ="UPDATE project SET project_name = '?', urlProject = '?' , createTime = '?' , group_Id = ? , teacher_id = ? WHERE id = ?";
//		 jdbcTemplate.update(sql.toString() , project.getName() , project.getUrlProject() , project.getCreateTime(),
//					project.getGroup_id() , project.getTeacherId(), project.getId() ) ; 
//			
//		}
//		else {
//			String sql = "INSERT INTO project (project_name,urlProject,createTime,group_id, teacher_id) VALUES('?','?','?',?,?)" ;
//			jdbcTemplate.update(sql, project.getName() , project.getUrlProject() , project.getCreateTime(),
//					project.getGroup_id() , project.getTeacherId(), project.getId()) ; 		
//		}
//	}
	
	
	
	
	
	public List<Project> getProjectByTeacherId(int teacherId) {
		List<Project> list = new ArrayList<Project>();
		String sql = "Select * from project where teacher_id = " + teacherId;
		list = jdbcTemplate.query(sql, new MapperProject());
		return list;
	}

	public Project getProjectByGroupId(int id) {
		try {
		Project project;
		String sql = "SELECT * FROM project where group_id = " + id;
		project = jdbcTemplate.queryForObject(sql, new MapperProject());
		if (project != null) {
			return project;
		}
	} catch (EmptyResultDataAccessException e) {

		return null;
	}
	return null;
		
	}
	
	public int getCountGroupId(int groupId) {
		int result =-1;
		String sql = "SELECT COUNT(group_id) FROM `project` WHERE group_id = " + groupId ;	
		result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}
	
	public int getCountTeacherId(int teacherId) {
		int result =-1;
		String sql = "SELECT COUNT(teacher_id) FROM `project` WHERE teacher_id = " + teacherId ;	
		result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}

}
