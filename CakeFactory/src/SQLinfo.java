
public class SQLinfo {

	private String server;
	private String username;
	private String password;
	
	public String getServer() {
		return server;
	}
	public void setServer(String serverName) {
		server = serverName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String usernameName) {
		username = usernameName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwordName) {
		password = passwordName;
	}
	public void copy(SQLinfo info) {
		this.setServer(info.getServer());
		this.setUsername(info.getUsername());
		this.setPassword(info.getPassword());
	}	
}
