package MyTestItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Case1 {
public static void main(String[] args) {
   System.setProperty("webdriver.ie.driver",
     "D:\\Selenium\\2.48.2\\IEDriverServer.exe");//ע������IEDriverServer.exe���ļ����·��
   /*
    * DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
   
   ieCapabilities
     .setCapability(
       InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
       true);
       
     */
 //DesiredCapabilities were not recommend on Selenium 4.0 , disable it!
   
//newһ��webdriver����
   WebDriver driver = new InternetExplorerDriver();
//������һ�����������IE��ȫ������ʾ��
//ͨ��webdriver��get�������������������ҳ��http://www.baidu.com
   driver.get("http://www.sogou.com/");
    //ͨ��ҳ��Ԫ�ص�name=wd��λ����ѯ�����

   WebElement element = driver.findElement(By.id("query")); //�ٶ������������
  //����������롮hello Selenium!��
   element.sendKeys("hello Selenium!");
  //�ύ��ѯ
   element.submit();
//�ȴ�����ʱ���׳�����
   try {
    Thread.sleep(3000);
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
//�����ǰҳ���title
   System.out.println("Page title is: " + driver.getTitle());
//�ر�����webdriver���̣��˳�
   driver.quit();
  }
 }