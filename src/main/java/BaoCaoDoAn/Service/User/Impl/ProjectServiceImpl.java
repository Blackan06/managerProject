package BaoCaoDoAn.Service.User.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ProjectDAO;
import BaoCaoDoAn.Dto.group_Account_Project;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Service.User.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private ProjectDAO projectDao;

	public List<Project> getProject(int id) {

		return projectDao.getProjectByGroup_id(id);
	}

	public List<group_Account_Project> getAllProject() {

		return projectDao.getAllProject();
	}
	public List<Project> getAllProjectSimple() {
		return projectDao.getAllProjectSimple();
	}
	public int addProject(Project project) {

		return projectDao.addProject(project);
	}

	public int deleteProject(int id) {

		return projectDao.deleteProject(id);
	}

	public Project getProjectById(int id) {

		return projectDao.getProjectByid(id);
	}

	public int editProject(int id ,Project project) {

		return projectDao.editProject(id ,project);
	}

	public List<Project> getProjectByTeacherId(int teacherId) {
		return projectDao.getProjectByTeacherId(teacherId);
	}
	public Project getProjectByGroupId(int groupId) {
		
		return projectDao.getProjectByGroupId(groupId);
	}
	
	public int getCountGroupId(int groupId) {
		return projectDao.getCountGroupId(groupId);
	}
	
	public int getCountTeacherId(int teacherId) {
		return projectDao.getCountTeacherId(teacherId);
	}
}
