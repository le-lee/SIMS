package com.neo.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerificationCodeServlet
 */
@WebServlet("/VerificationCodeServlet")
public class VerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//图片高度
    private static final int IMG_HEIGHT = 100;
    //图片宽度
    private static final int IMG_WIDTH = 30;
    //验证码长度
    private static final int CODE_LEN = 4;
	
    public VerificationCodeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bi = new BufferedImage(IMG_HEIGHT, IMG_WIDTH, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = bi.getGraphics();
		graphics.setColor(new Color(100,230,200));
		graphics.fillRect(0, 0, 100, 30);
		// 验证码中所使用到的字符
        char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456".toCharArray();
        String captcha = ""; // 存放生成的验证码
        long currentTime = System.currentTimeMillis();
        
        Random random = new Random(currentTime);
        for (int i = 0; i < CODE_LEN; i++) {
        	int index = random.nextInt(codeChar.length);
        	//随机生成验证码颜色
        	graphics.setColor(new Color(random.nextInt(15), random.nextInt(200), random.nextInt(255)));
        	// 将一个字符绘制到图片上，并制定位置（设置x,y坐标）
            graphics.drawString(codeChar[index] + "", (i * 20) + 15, 20);
            captcha += codeChar[index];
        }
        //将生成的验证码放入session
        request.getSession().setAttribute("code", captcha);
        //通过ImageIO将图片输出
        ImageIO.write(bi, "JPG", response.getOutputStream());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
