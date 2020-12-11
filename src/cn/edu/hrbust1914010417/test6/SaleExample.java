package cn.edu.hrbust1914010417.test6;

class TicketSeller            // 负责卖票的类
{
    int fiveNumber=1,tenNumber=0,twentyNumber=0;
    public synchronized void  sellTicket(int receiveMoney,int buyNumber)
    {
        if(receiveMoney==5)
        {
            fiveNumber=fiveNumber+1;
            System.out.printf("\n%s给我5元钱，这是您的1张入场卷",Thread.currentThread().getName());
        }
        else if(receiveMoney==10&&buyNumber==2)
        {
            tenNumber=tenNumber+1;
            System.out.printf("\n%s给我10元钱，这是您的2张入场卷",Thread.currentThread().getName());
        }
        else if(receiveMoney==10&&buyNumber==1)
        {
            while((fiveNumber<3&&tenNumber==0)||fiveNumber==0)   // 给出线程需等待的条件
            {
                try {
                    System.out.printf("\n%30s靠边等",Thread.currentThread().getName());
                    this.wait();   // 线程进入等待状态
                    System.out.printf("\n%30s结束等待\n",Thread.currentThread().getName());
                }
                catch(InterruptedException e)
                {
                }
            }
            fiveNumber=fiveNumber-1;
            tenNumber=tenNumber+1;
            System.out.printf("\n%s给我10元钱，找您5元，这是您的1张入场卷",Thread.currentThread().getName());
        }
        else if(receiveMoney==20&&buyNumber==1)
        {
            while((fiveNumber<3&&tenNumber==0)||fiveNumber==0)   // 给出线程需等待的条件
            {
                try {
                    System.out.printf("\n%30s靠边等",Thread.currentThread().getName());
                    this.wait();   // 线程进入等待状态
                    System.out.printf("\n%30s结束等待",Thread.currentThread().getName());
                }
                catch(InterruptedException e)
                {
                }
            }
            fiveNumber=fiveNumber-1;
            tenNumber=tenNumber-1;
            twentyNumber=twentyNumber+1;
            System.out.printf("\n%s给20元钱，找您一张5元和一张10元，这是您的1张入场卷",Thread.currentThread().getName());
        }
        else if(receiveMoney==20&&buyNumber==2)
        {
            while(fiveNumber<2&&tenNumber==0)   // 给出线程需等待的条件
            {
                try {
                    System.out.printf("\n%30s靠边等\n",Thread.currentThread().getName());
                    this.wait();   // 线程进入等待状态
                    System.out.printf("\n%30s结束等待",Thread.currentThread().getName());
                }
                catch(InterruptedException e)
                {
                }
            }
            tenNumber=tenNumber-1;
            twentyNumber=twentyNumber+1;
            System.out.printf("\n%s给20元钱，找您一张10元，这是您的2张入场卷",Thread.currentThread().getName());
        }
        notifyAll();   // 通知等待的线程结束等待
    }
}
class Cinema implements Runnable         // 实现Runnable接口的类
{
    Thread zhao,qian,sun,li,zhou;           // 电影院中买票的线程
    TicketSeller seller;                    // 电影院的售票员
    Cinema()
    {
        zhao=new Thread(this);
        qian=new Thread(this);
        sun=new Thread(this);
        li=new Thread(this);
        zhou=new Thread(this);
        zhao.setName("赵");
        qian.setName("钱");
        sun.setName("孙");
        li.setName("李");
        zhou.setName("周");
        seller=new TicketSeller();
    }
    public void run()
    {
        if(Thread.currentThread()==zhao)
        {
            seller.sellTicket(20,2);
        }
        else if(Thread.currentThread()==qian)
        {
            seller.sellTicket(20,1);
        }
        else if(Thread.currentThread()==sun)
        {
            seller.sellTicket(10,1);
        }
        else if(Thread.currentThread()==li)
        {
            seller.sellTicket(10,2);
        }
        else if(Thread.currentThread()==zhou)
        {
            seller.sellTicket(5,1);
        }
    }
}
public class SaleExample
{
    public static void main(String args[])
    {
        Cinema cinema=new Cinema();
        cinema.zhao.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
        }
        cinema.qian.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
        }
        cinema.sun.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
        }
        cinema.li.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
        }
        cinema.zhou.start();
    }
}