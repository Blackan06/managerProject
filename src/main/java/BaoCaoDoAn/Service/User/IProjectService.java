package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dto.group_Account_Project;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;

@Service
public interface IProjectService {
	@Autowired
	public List<Project> getProject(int id) ;
	
	@Autowired
	public List<group_Account_Project> getAllProject() ;
	
	@Autowired
	public Project getProjectById(int id) ;
	
	@Autowired
	public int addProject(Project project);
	
	@Autowired
	public int deleteProject(int id);
	
	@Autowired
	public int editProject(int id,Project project) ;
	
	@Autowired
	public Project getProjectByGroupId(int groupId);

}
