/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-05-19 15:19:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.model.vo.Board;
import java.util.ArrayList;
import board.model.vo.BoardPageData;
import member1.model.vo.Member;

public final class boardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1558269211000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member1.model.vo.Member");
    _jspx_imports_classes.add("board.model.vo.BoardPageData");
    _jspx_imports_classes.add("board.model.vo.Board");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");

    	BoardPageData bpd = (BoardPageData)request.getAttribute("bpd");
    	ArrayList<Board> list = bpd.getList();
    
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      out.write("\n");
      out.write("\n");
      out.write("    ");

    	/* 세션이 있는 한 항상 불러오는 객체  */
    	Member m = (Member)session.getAttribute("member1");
    
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-3.3.1.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/bootstrap.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/header/style.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/header/responsive.css\">\n");
      out.write("<script type=\"text/javascript\" src=\"/js/bootstrap.js\"></script>\n");
      out.write("\n");
      out.write("<header class=\"header_area\">\n");
      out.write("\t<div class=\"main_menu\">\n");
      out.write("\t\t<nav class=\"navbar navbar-expand-lg navbar-light\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<a class=\"navbar-brand logo h\" href=\"/index.jsp\"><img src=\"/img/logo.png\" width=\"165\" height=\"80\"></a>\n");
      out.write("\t\t\t\t<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expaneded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t\t<div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav menu_nav ml-auto\">\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/noticeList\">공지사항</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/boardList\">자유게시판</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/photoList\">사진게시판</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/views/api/apiTest.jsp\">API테스트</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/views/ajax/ajaxTest.jsp\">AJAX test</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"right-button\">\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t");
 if(m==null) {
      out.write("\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><button class=\"btn btn-danger\" onclick=\"location.href='/views/member1/login.jsp'\">로그인</button></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><button class=\"btn btn-danger\" onclick=\"location.href='/views/member1/join.jsp'\">회원가입</button></li>\n");
      out.write("\t\t\t\t\t\t");
 }else { 
      out.write("\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><button class=\"btn btn-danger\" onclick=\"location.href='/myInfo?memberId=");
      out.print(m.getMemberId() );
      out.write('\'');
      out.write('"');
      out.write('>');
      out.print(m.getMemberName() );
      out.write("</button></li> <!-- get방식으로 서블릿에 전달 -->\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><button class=\"btn btn-danger\" onclick=\"location.href='/logout'\">로그아웃</button></li>\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</div>\n");
      out.write("</header>");
      out.write("\n");
      out.write("\t<section>\n");
      out.write("\t\t<div class=\"table-wrapper\" style=\"text-align:center; width:80%; margin:0 auto;\">\n");
      out.write("\t\t\t<div style=\"text-align:left;\">\n");
      out.write("\t\t\t\t<a class=\"btn btn-outline-primary btn-sm\" href=\"/boardWrite\">글쓰기 </a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<table class=\"table table-striped\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th colspan=\"6\" style=\"font-size:20px; font-weight:bold;\">자유게시판 목록</th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th>번호</th><th>카테고리</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t");
 for(Board b : list) { 
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(b.getBoardNo() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(b.getCategory() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td><a href=\"/boardView?boardNo=");
      out.print(b.getBoardNo() );
      out.write('"');
      out.write('>');
      out.print(b.getBoardTitle() );
      out.write("</a></td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(b.getBoardAuthor() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(b.getViewcount() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(b.getBoardDate() );
      out.write("</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<div id=\"pageNavi\">\n");
      out.write("\t\t\t\t");
      out.print(bpd.getPageNavi() );
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\t\n");
      out.write("\t</section>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
