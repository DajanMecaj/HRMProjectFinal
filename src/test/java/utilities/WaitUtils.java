package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {
    private BaseInformation baseInformation;
    private Duration defaultDuration;
    private WebDriver driver = BaseInformation.getDriver();

    public WaitUtils(BaseInformation baseInformation, Duration defaultDuration) {
        this.baseInformation = baseInformation;
        this.defaultDuration = defaultDuration;
    }

    public static void waitFor(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException var3) {
            System.out.println("ERROR in waitForMethod");
        }

    }
    public void waitForTextToBePresentInElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public WebElement waitForElementVisibleWithCustomTime(long mills, By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        return (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementVisibleWithCustomTime(long mills, WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        return (WebElement)wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementclicableWithCustomTime(long mills, WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        return (WebElement)wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementClickable(WebElement element) {
        return this.waitForElementclicableWithCustomTime(this.defaultDuration.toMillis(), element);
    }

    public WebElement waitForElementVisible(WebElement element) {
        return this.waitForElementVisibleWithCustomTime(this.defaultDuration.toMillis(), element);
    }

    public WebElement waitForElementVisible(By locator) {
        return this.waitForElementVisibleWithCustomTime(this.defaultDuration.toMillis(), locator);
    }

    public void waitForAttributePresentWithCustomWaitTime(long mills, WebElement element, String nameOfAttribute) {
        int milsWaitStep = 500;
        long numberOfLoops = mills / (long)milsWaitStep;

        for(int i = 0; (long)i < numberOfLoops; ++i) {
            try {
                element.getAttribute(nameOfAttribute);
            } catch (Exception var10) {
                waitFor((long)milsWaitStep);
            }
        }

    }

    public void waitForAttributePresent(WebElement element, String nameOfAttribute) {
        this.waitForAttributePresentWithCustomWaitTime(this.defaultDuration.toMillis(), element, nameOfAttribute);
    }

    public List<WebElement> waitForAllElementsVisible(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(this.driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    public void waitForElementAbsent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementPresent(long mills, WebElement element) {
        int milsWaitStep = 500;
        long numberOfLoops = mills / (long)milsWaitStep;
        int i = 0;

        while((long)i < numberOfLoops) {
            try {
                element.getLocation();
                return;
            } catch (Exception var9) {
                waitFor((long)milsWaitStep);
                ++i;
            }
        }

        throw new AssertionError("Target element absent");
    }

    public WebElement waitForElementPresent(WebElement element) {
        this.waitForElementPresent(30000L, element);
        waitFor(1000L);
        return element;
    }
}

