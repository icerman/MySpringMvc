package com.zsx.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class verode  {

		
	    /**
	     * 验证码图片的宽度。
	     */
		private  int width = 100;
		/**
	     *  验证码图片的高度。
	     */
		private  int hight = 35;
		  /**
	     * 验证码字体高度
	     */
		private int codeHeight = 25;
		
		@RequestMapping("/checkcode.do" )
		public void getcode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//通过spring请求方式，生成验证码，并且通过流的方式返回至页面
			response.setContentType("img/jgp");
			//创建一个内存影响对象（类似一个画布）
			BufferedImage image = new BufferedImage(width, hight, BufferedImage.TYPE_INT_RGB);
			Random  rand = new Random();
			//获得画笔
			Graphics gd = image.createGraphics();
			//给画布设置一个背景颜色
			gd.setColor(Color.GRAY);
			gd.fillRect(0, 0, width, hight);
			Font font = new Font("Fixedsys", Font.BOLD, codeHeight);
			//给画布设置画笔、颜色
			gd.setFont(font);
			gd.setColor(Color.black);
			gd.drawRect(0, 0, width-1, hight-1);
			gd.setColor(Color.green);
			//添加干扰线
			for(int i = 0; i < 16; i++){
				int x = rand.nextInt(width);
				int y = rand.nextInt(hight);
				int x1 = rand.nextInt(12);
				int y1 = rand.nextInt(12);
				gd.drawLine(x, y, x+x1, y+y1);
			}
			String RandNumber = GetRandNumber(4);
			for (int i = 0; i < RandNumber.length(); i++) {
				gd.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
				int h = (int) (20+10*rand.nextDouble());
				gd.drawString(String.valueOf(RandNumber.charAt(i)),15*i+18, h);
			}
			HttpSession session = request.getSession();
			session.setAttribute("randNumber", RandNumber);
			  //将图像输出的servlet输出流中
			ServletOutputStream os = response.getOutputStream();
			ImageIO.write(image,"jpeg",os);
			os.close();
		}

		private String GetRandNumber(int CodeCount) {
			
			Random rand = new Random();
			
			String Code1 = "abbcdefghijklmnopqrstuvwxyz"+"0123456789";
			
			String Code2 = "ABBCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			String Number ="";
			
			for (int i = 0; i < CodeCount; i++) {
				
				switch (rand.nextInt(2)) {
				case 0:
					Number += Code1.charAt(rand.nextInt(Code1.length()));
					break;
				case 1:
					Number += Code2.charAt(rand.nextInt(Code2.length()));
					break;
				default:
					break;
				}
			}
			return Number;
		}
		
		
		
	}
