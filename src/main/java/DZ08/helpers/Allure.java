package DZ08.helpers;

import cucumber.api.Result;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestStepFinished;
import io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm;

public class Allure extends AllureCucumber3Jvm {
    @Override
    public void setEventPublisher(final EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, testStepFinished -> {
            if (testStepFinished.result.is(Result.Type.FAILED)) {
                ReportHelper.addTextAttach("Ошибка");
            }
        });
        super.setEventPublisher(publisher);
    }


}
