package cn.edu.hrbust1914010417.test5;
class Tortoise extends Thread
{
    int sleepTime=0,liveLength=0;
    Tortoise(int sleepTime,String name,int liveLength)
    {
        this.sleepTime=sleepTime;
        this.liveLength=liveLength;
        setName(name);   // 设置线程的名字为name
    }
    public void run()
    {
        while(true)
        {
            liveLength--;
            System.out.printf("@");
            try
            {
                sleep(sleepTime);  // 让线程调用 sleep方法进入中断状态，sleepTime毫秒后线程
// 重新排队，等待CUP资源
            }
            catch(InterruptedException e)
            {
            }
            if(liveLength<=0)
            {
                System.out.printf(getName()+"进入死亡状态\n");
                return;  // 结束run方法的语句
            }
        }
    }
}
class Rabbit extends Thread
{
    int sleepTime=0,liveLength;
    Rabbit(int sleepTime,String name,int liveLength)
    {
        this.sleepTime=sleepTime;
        this.liveLength=liveLength;
        setName(name);   // 设置线程的名字为name
    }
    public void run()
    {
        while(true)
        {
            liveLength--;
            System.out.printf("*");
            try
            {
                sleep(sleepTime);  // 让线程调用 sleep方法进入中断状态，sleepTime毫秒后
// 线程重新排队，等待CUP资源
            }
            catch(InterruptedException e)
            {
            }
            if(liveLength<=0)
            {
                System.out.printf(getName()+"进入死亡状态\n");
                return;  // 结束run方法的语句
            }
        }
    }
}
public class ThreadExample
{
    public static void main(String args[ ])
    {
        Rabbit  rabit;
        rabit=new Rabbit(500,"ra",4);    // 新建线程rabit
        Tortoise tortoise;
        tortoise=new Tortoise(650,"to",5);  // 新建线程tortoise
        tortoise.start();         // 启动线程tortoise
        rabit.start();        // 启动线程rabit
    }
}