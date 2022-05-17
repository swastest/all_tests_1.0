package cloud.autotests.tests;

import cloud.autotests.config.Project;
import cloud.autotests.helpers.AllureAttachments;
import cloud.autotests.helpers.DriverSettings;
import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
 //       String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
        AllureAttachments.addBrowserConsoleLogs();
        AllureAttachments.addVideo();
        // Selenide.closeWebDriver();

//        if (Project.isVideoOn()) {
//            AllureAttachments.addVideo(sessionId);
//        }
        Selenide.closeWebDriver();

    }
}

/*
        Github repository created: github.com/autotests-cloud/AUTO-978
        Autotests code generated: github.com/.../tests/GeneratedTests.java
        Code stack: Java, Gradle, JUnit5, AssertJ, Owner, Rest-Assured, Selenide, Allure

        Jenkins job created: jenkins.autotests.cloud/job/AUTO-978
        Jenkins job launched, autotests are running (~1 min): /1/console
        Infrastructure stack: Github, Jenkins, Docker, Selenoid
        Jenkins job finished: /1/allure
        Report available with test details, screenshots, logs, videos


        What's next?
        Congratulations! Now you have a ready test automation project: // todo FAQ
        QA.GURU engineers can automate your tests (Web, Android, iOS, API).
        Discuss details and payment: t.me/autotests_cloud/1328?comment=3167 👈 */
