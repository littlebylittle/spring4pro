package dao.jdbc.xml;
import dao.ContactDao;
import javax.sql.DataSource;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

public class JDBCContactDao implements ContactDao, InitializingBean {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(null == dataSource) {
			throw new BeanCreationException("Must set `dataSource` in JDBCContactDao");
		}
	}
}
