package cn.siggy.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.siggy.dao.BookDao;
import cn.siggy.dao.CategoryDao;
import cn.siggy.entity.Book;
import cn.siggy.entity.Category;
import cn.siggy.util.PageUtil;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private BookDao bookDao = new BookDao();
	private CategoryDao categoryDao = new CategoryDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ��ȡ�����Ĳ��� �ò���ָ���������еĲ���
		/*
		 * op=list���в�ѯȫ�� =add��� op=delete ɾ�� op=update �޸� op=getById��ѯ����
		 * op=toAdd �����ҳ��
		 */
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String action = req.getParameter("op");
		if (action == null || "list".equals(action)) {
			list(req, resp);
		} else if ("toAdd".equals(action)) {
			toAdd(req, resp);
		} else if ("add".equals(action)) {
			add(req, resp);
		} else if ("delete".equals(action)) {
			delete(req, resp);
		} else if ("getById".equals(action)) {
			getById(req, resp);
		} else if("update".equals(action)) {
			update(req,resp);
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = 0;
		if(req.getParameter("id") != null) {
			id = Integer.parseInt(req.getParameter("id"));
		}
		String bookName = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String author = req.getParameter("author");
		Date pubDate = null;
		try {
			pubDate = new SimpleDateFormat("yyyy-MM-dd").parse(req
					.getParameter("pubDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		Book book = new Book(id, bookName, price, author, pubDate,categoryId);
		System.out.println(book.toString());
		if (bookDao.update(book) > 0) {
			 resp.sendRedirect("book?op=list");
		} else {
			resp.getWriter().print("�޸�ʧ��222");
		}
	}

	private void getById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡid
		int id = 0;
		if (req.getParameter("id") != null) {
			id = Integer.parseInt(req.getParameter("id"));
		}
		// ����id��ѯ��Ӧ�ļ�¼
		Book book = bookDao.getById(id);
		List<Category> clist = categoryDao.getList();
		req.setAttribute("book", book);
		req.setAttribute("clist", clist);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int id = 0;
		if (req.getParameter("id") != null) {
			id = Integer.parseInt(req.getParameter("id"));
		}
		if (bookDao.delete(id) > 0) {
			resp.sendRedirect("book?op=list");
		} else {
			resp.getWriter().print("ɾ��ʧ��");
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String bookName = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String author = req.getParameter("author");
		Date pubDate = null;
		try {
			pubDate = new SimpleDateFormat("yyyy-MM-dd").parse(req
					.getParameter("pubDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		Book book = new Book(bookName, price, author, pubDate, categoryId);
		if (bookDao.add(book) > 0) {
			resp.sendRedirect("book?op=list");
		} else {
			resp.getWriter().print("�޸�ʧ��-_-");
		}
	}

	private void toAdd(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Category> clist = categoryDao.getList();
		req.setAttribute("clist", clist);
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}

	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PageUtil pageUtil = new PageUtil();
		//�����ܼ�¼��
		pageUtil.setTotalCount(bookDao.count());
		//����ÿҳ��ʾ��¼��
		pageUtil.setPageSize(3);
		//��ȡ��ǰҳ--Ĭ��Ϊ��һҳ
		int currentPage = 1;
		if(req.getParameter("currentPage") != null) {
			currentPage=Integer.parseInt(req.getParameter("currentPage"));
		}
		pageUtil.setCurrentPage(currentPage);
		// ����daoֱ�Ӳ�ѯ
		List<Book> list = bookDao.getAll(pageUtil);
		List<Category> clist = categoryDao.getList();
		req.setAttribute("list", list);
		req.setAttribute("clist", clist);
		req.setAttribute("page", pageUtil);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
