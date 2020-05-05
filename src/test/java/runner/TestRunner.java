package runner;

import newsTest.FailedInvalidSearch;
import newsTest.FailedViewNewsAfter1MounthFromCurrentDate;
import newsTest.SuccessfulGettingNews;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)

@Suite.SuiteClasses({
        FailedViewNewsAfter1MounthFromCurrentDate.class , SuccessfulGettingNews.class, FailedInvalidSearch.class
})

public class TestRunner {



}