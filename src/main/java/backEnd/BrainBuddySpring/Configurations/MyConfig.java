package backEnd.BrainBuddySpring.Configurations;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MyConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	//@Bean
	//public BCryptPasswordEncoder passwordEncoder() {
	//	return new BCryptPasswordEncoder();
	//}
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource =  new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		return dataSource;
	}
}
