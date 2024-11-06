package utilities;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Component;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import net.rcarz.jiraclient.Component.FluentCreate;

public class JiraServiceProvider {
	
	public JiraClient jira;
	public String project;
	
	public JiraServiceProvider(String jiraurl, String username, String password, String project) {
		BasicCredentials creds = new BasicCredentials(username, password);
		jira = new JiraClient(jiraurl, creds);
		this.project = project;
	}
	
	public void createJiraTicket(String issueType, String summary, String description, String reporterName) {
			
			try {
				FluentCreate fleuntCreate = jira.createIssue(project, issueType);
				
				FluentCreate.field(Field.SUMMARY, summary);
				
				FluentCreate.field(Field.DESCRIPTION, description);
				
				Component newIssue = fleuntCreate.execute();
			}
			catch(JiraException e) {
				
				e.printStackTrace();
			}
		}

}
