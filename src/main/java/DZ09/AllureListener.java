package DZ09;

import cucumber.api.Result;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestStepFinished;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class AllureListener extends io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm {

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) Init.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void setEventPublisher(final EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, testStepFinished -> {
            if (testStepFinished.result.is(Result.Type.FAILED)) {
                takeScreenshot();
            }
        });
        super.setEventPublisher(publisher);
    }

}