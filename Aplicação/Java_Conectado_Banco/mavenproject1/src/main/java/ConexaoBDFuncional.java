import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoBDFuncional {
    // novo objeto da dependência BasicDataSource yay
    
    private BasicDataSource con = new BasicDataSource();
    //private final String url = "jdbc:mysql://127.0.0.1:3306/TESTE?useTimezone=true&serverTimezone=UTC";
//    private final String url = "";
//    private final String jdbcDriver = ;

    public BasicDataSource getConnection() {
        //con.setDriverClassName(aqui tu coloca a url da dependência do driver)
        //con.setUrl(aqui tu define qual a url da sua rota do banco de dados)
        //con.setUsername(aqui tu coloca o username do adm do servidor do Azure nesse caso)
        //con.setPassword(aqui tu coloca a senha do servidor do Azure)
        
        try {
            con.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con.setUrl("jdbc:sqlserver://01191065.database.windows.net:1433;"
                    + "database=mineHash;user=fabi_canedo@01191065;password=Mavibifa2019;"
                    + "encrypt=true;trustServerCertificate=false;"
                    + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            con.setUsername("fabi_canedo");
            con.setPassword("Mavibifa2019");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public JdbcTemplate template() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(con);
        return jdbcTemplate;
    }
}
