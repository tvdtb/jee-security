package com.trivadis.jee.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "*.info")
public class SecurityInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String userName = req.getRemoteUser();
		PrintWriter writer = resp.getWriter();
		writer.append("<html>\n<body>\n");

		if (userName != null) {

			writer.append("requested path: ")//
					.append(req.getPathInfo())//
					.append("<p>");

			writer.append("\t<p>user=") //
					.append(userName) //
					.append("</p>\n");

			Arrays.asList("AllAuthenticatedUsers", "users", "admins",
					"developers").stream().forEach(roleName -> {
				if (req.isUserInRole(roleName)) {
					writer.append("<p>Role: ") //
							.append(roleName)//
							.append("<p>\n");
				}

			});

			writer.append(String.format("\n%1$tH:%1$tM:%1$tS.%1$tL\n",
					new Date()));

			writer.append("</body></html>");
		} else {
			writer.append("UNAUTHENTICATED\n");
		}

	}
}
