package BaoCaoDoAn.Dto;

import java.util.List;

import BaoCaoDoAn.Entity.Account;

public class group_Account {
	private String accountName;
	private String groupName;
	private int accountgroup_id;
	
	private List<Account> account;
	
	
	
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
