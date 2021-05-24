package tw.group5.subarashiiproject.action.nick;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.nick.UsersService;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class HomeWorkAction {



	public static void main(String[] args) {
		
		System.out.println("目前為訪客狀態 , 請進行會員驗證,");
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入您的帳號 : ");
		String user = scanner.next();
		
		System.out.println("接著請輸入您的密碼 : ");
		String pwd = scanner.next();

			HomeWorkAction action1 = new HomeWorkAction();		
				action1.processAction(user,pwd);
	
			
		}
		
		public void processAction(String user, String pwd) {
			SessionFactory factory =  HibernateUtil.getSessionFactory();		
			Session session = factory.getCurrentSession();
		
			try {
				session.beginTransaction();				
				UsersService uService = new UsersService(session);
				
				boolean status = uService.checkLoginAccess(user, pwd);
				
				while(true) {
				if(status != false) {
					System.out.println("登入成功 , 歡迎會員 : " + user + " 進入系統 .");
					
					Scanner scanner = new Scanner(System.in);
					System.out.println("請輸入欲使用的功能代碼: (指令: 1進行樂透統計功能 2退出程式)");
					String z = scanner.next();
				
				
				   if(z.equals("1")) {
					System.out.println("請輸入1~42數字內 , 欲產生的號碼組數");
					String x = scanner.next();
					int xint = Integer.parseInt(x); 
					 int[] random = new int[xint];

					  for(int i=0;i<xint;i++){

					   random[i]=(int) Math.floor(Math.random()*42+1);   

					   for(int j=0;j<i;j++){//檢查有無重覆

					    if(random[i]==random[j]){//有重覆重抽一次
					     i--;
					     break;
					    }   					    
					   }   
					  }

					  System.out.println("號碼抽選結果:");

					  for(int s=0;s<xint;s++){

					   System.out.print(random[s]+" ");
					  					   
					  }
					  break;
				}
				
				else if(z != "1") {	
					
					System.out.println("已成功登出系統 !");
					break;
				}
									
				}
					
				
			else if (status == false) {
					System.out.println("登入失敗 .");
					break;
				}
					
						
				session.getTransaction().commit();
				}
			}catch(Exception e) {
				session.getTransaction().rollback();
				e.printStackTrace();
			}
			
			HibernateUtil.closeSessionFactory();
		}

	}
