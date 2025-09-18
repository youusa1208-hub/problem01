package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;

import beans.PtypeBean;

/**
 * Servlet implementation class PokemonList
 */
@WebServlet("/PokemonList")
public class Srv24_PokemonList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv24_PokemonList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;	
		try{
			InitialContext initCtx = new InitialContext();
			ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/Servlet");
				
		}catch(NamingException e){
			throw new ServletException(e);
		}
		
		try(Connection conn = ds.getConnection()){	
			String sql = "SELECT pid,pname,pimg,"
						+"pokemon.ptid pkptid,ptype.ptid ptptid,"
						+"ptname,ptimg FROM　pokemon JOIN ptype"
						+" ON pokemon.ptid=ptype.ptid"
						+" ORDER BY pid";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			List<String> list = new ArrayList<>();
			while(rs.next()){
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				String pimg = rs.getString("pimg");
				int pkptid = rs.getInt("pkptid");
				int ptptid = rs.getInt("ptptid");
				String ptname = rs.getString("ptname");
				String ptimg = rs.getString("ptimg");
				String str = pid+":"+pname+":"+pimg+":"+pkptid+":"+ptptid+":"+ptname+":"+ptimg;
				list.add(str);
			}
			request.setAttribute("li", list);
		}catch(SQLException e){
			throw new ServletException(e);
		}
		String url="Srv24_PokemonList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
