package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       1. 获取要下载的文件名
        String download = "1.jpeg";

//        2. 读取要下载的文件内容(通过ServletContext对象可以获取)
        ServletContext servletContext = getServletContext();

//      获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/1.jpeg");
        System.out.println("下载的文件类型:"+mimeType);
//        4. 在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

//        5. 还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
//        Content-Disposition响应头，表示收到的数据怎么处理
//        attachment表示附件，filename表示指定的文件名（这里的指定的文件名不一定要和上面的文件名一致，可以自己设置）
        resp.setHeader("Content-Disposition","attachment;filename=1.jpeg");

//        第一个斜杠表示工程路径
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/1.jpeg");
//         获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
//        3. 把下载的文件回传给客户端
        IOUtils.copy(resourceAsStream,outputStream);





    }

}
