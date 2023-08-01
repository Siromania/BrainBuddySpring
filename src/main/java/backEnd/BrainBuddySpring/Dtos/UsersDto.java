package backEnd.BrainBuddySpring.Dtos;

public class UsersDto {
    
    
    private String email;
    private String password;

    public UsersDto() {}

    
    
    public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
