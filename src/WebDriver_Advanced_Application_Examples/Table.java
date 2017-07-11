package WebDriver_Advanced_Application_Examples;

import java.util.List;

//This class used for Example 11.17
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Table {
	private WebElement _table; //声明一个WebElement元素，用于存储页面的表格元素对象
	
	public Table(WebElement table){ 
		//为构造函数传入页面表格元素对象参数，调用Table类的setTable方法
		//将页面表格元素赋值给Table类的_table成员变量
		setTable(table);
	}
	
	public WebElement getTable(){
		//获取页面表格对象的方法getTable()
		return _table;
	}
	
	public void setTable(WebElement _table){
		//将页面表格元素赋给Table类中_table成员变量的方法
		this._table = _table;
	}
	
	public int getRowCount(){
		//获取表格中有多少行的函数，通过查找tr元素，就可以知道表格有多少行了
		List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.size();
	}
	
	public int getColumnCount()
	{
		//获取表格中有多少列的函数，通过查找td元素，就可以知道表格有多少列了
		List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.get(0).findElements(By.tagName("td")).size();
	}
	
	public WebElement getCell (int rowNo,int colNo) throws NoSuchElementException
	{
		//获取某行某列的单元格对象
		try{
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			System.out.println("行总数"+ tableRows.size());
			System.out.println("行号"+ rowNo);
			WebElement currentRow = tableRows.get(rowNo-1);
			List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
			System.out.println("列总数"+ tableCols.size());
			WebElement cell = tableCols.get(colNo-1);
			System.out.println("列号"+ colNo);
			return cell;
		}
		catch(NoSuchElementException e)
		{
			throw new NoSuchElementException("没有找到相关的元素");
		}
		
	}
	
	public WebElement getinCell (int rowNo,int colNo,By by) throws NoSuchElementException
	{
		//获取某行某列的单元格对象，by参数用于定位某个表
		try{
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			
			WebElement currentRow = tableRows.get(rowNo-1);
			
			List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
			
			WebElement cell = tableCols.get(colNo-1);
			
			return cell.findElement(by);
		}
		
		catch(NoSuchElementException e)
		{
			throw new NoSuchElementException("没有找到相关的元素");
		}
		
	}
}
