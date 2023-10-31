package utils.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public static String localDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }
    public synchronized static ExtentReports createExtentReports() {
        String currentDate = localDate();
        ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/FMA-report" + currentDate +".html");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setReportName("TAAS: FMA REGRESSION REPORT");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author1", "Olawale Olapetan");
        extentReports.setSystemInfo("Author2", "Robertson Akpan");
        extentReports.setSystemInfo("Author3", "Tomiwa Olawale");
        extentReports.setSystemInfo("Platform", "Android");
        return extentReports;
    }
}
