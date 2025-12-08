package org.owasp.benchmark.testcode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Sample Benchmark Test Class
 * Tạo thêm các file tương tự (BenchmarkTest00002, 00003, ...) nếu cần
 * Đặt vào folder: benchmark/src/main/java/org/owasp/benchmark/testcode/
 */
public class BenchmarkTest00001 {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        doPost(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String param = request.getParameter("input");
        if (param == null) {
            param = "";
        }
        
        // Test case 1: SQL Injection vulnerability (example)
        String sql = "SELECT * FROM users WHERE name = '" + param + "'";
        System.out.println("Executing SQL: " + sql);
        
        // Test case 2: XSS vulnerability (example)
        response.getWriter().println("<html><body>");
        response.getWriter().println("Hello " + param); // Potential XSS
        response.getWriter().println("</body></html>");
        
        // Test case 3: Path traversal (example)
        if (param.contains("..")) {
            System.out.println("Potential path traversal detected!");
        }
    }
}