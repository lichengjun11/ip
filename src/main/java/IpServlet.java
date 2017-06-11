import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by lichengjun on 2017/6/11.
 */
@WebServlet(urlPatterns = "/index")
public class IpServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip = req.getParameter("ip");
        try {
            new Driver();
            Connection connection = DriverManager.getConnection("jdbc:mysql:///?user=root&password=system");
            String sql = "SELECT * FROM db_1702.iptest WHERE inet_aton(?) BETWEEN inet_aton(start) AND inet_aton(stop)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,ip);
            ResultSet ResultSet = statement.executeQuery();
            if (ResultSet.next()){
                req.setAttribute("message",ResultSet.getString("loc"));
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else {
                req.setAttribute("message","输入错误，请重新输入");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
            connection.close();
            statement.close();
            ResultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
