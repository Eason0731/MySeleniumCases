# MySeleniumCase

Current Version:

Selenium: 3.11.0 --- Update date: Mar 16, 2018

IE Driver: 3.11.1 --- Update date: Mar 15, 2018

Chrome Driver: 2.38 --- Update date: May 9, 2018

Gecko Driver: 0.20.1 --- Update date: Apr 12, 2018

Edge Driver: Release 17134 --- Update date: May 8, 2018

Changes between selenium 2 and 3 as I know:
=======================================================================================================
1. Remove one selenium RC (Remote Control) case on this project. As it has been removed by selenium offical.
2. Firefox browser has been isolated on selenium 3.0. Geckodriver is an isolate driver for Firefox whihc used as same as chromedriver and IEServerDriver.
E.g.: How to use Geckodriver on selenium 3.0:

    System.setProperty("webdriver.gecko.driver","path of geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    


Update:
=======================================================================================================
20170109:Add the selenium webdriver 3.0 jar files and html files in the same project. Both Windows and Mac OS X can run these cases well.
20170115:1. Use Geckodriver 32bits to repalce the 64bits one for running on x86 system well.
         2. If cannot run well on IE11 that can roll back to IE9 then it works well.
         3. If cannot launch IE browser that add below statements:
          DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
          ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
          WebDriver driver = new InternetExplorerDriver(ieCapabilities);
20170503: 1. Update the selenium webdrvier version from 3.0.1 beta to 3.4.0
          2. Update the Geckodriver version to 0.16.1
          3. Update the IEDriverServer version to 3.4.0
          4. Update the Chromedriver version to 2.29.0
          
          
Tips after version update:
=======================================================================================================
On 20170503 that I've updated the selenium webdriver version from 3.0.1 to 3.4.0 then ran occured the error massage as "Error communicating with the remote browser. It may have died".

How to solve this?
1. Create a new test case based on TestNG.
2. Write some sample statement, such as open a website then close
3. Ended with "driver.quit()"
4. Run with TestNG

Finally you will find it's OK to run all the test cases as it should match the newest version.

Migration:
=======================================================================================================
After 2017/07/11 that will use this new repertory which reduced some spaces.

Maintainence
=======================================================================================================
The selenium cases will switch to develop on Python which included on repository named MyPython.

For this selenium repository based on Java language that just do the maintainence work.

Such as update the version of jar packages,IE driver,Chrome  driver and Gecko(Firefox) driver.

As to add and create new selenium cases that will switch to Python repository and won't on Java.

Develop and use the core functions of selenium only on Python start from 2018.

Thanks Java lead me the way from beginer to middle of selenium level.
