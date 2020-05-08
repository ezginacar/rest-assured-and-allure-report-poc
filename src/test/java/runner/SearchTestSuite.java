package runner;



import newsTest.FailedViewNewsAfter1MounthFromCurrentDate;
import newsTest.SuccessfulGettingNews;
import newsTest.SuccessfulInvalidSearch;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({FailedViewNewsAfter1MounthFromCurrentDate.class, SuccessfulGettingNews.class, SuccessfulInvalidSearch.class })
public class SearchTestSuite {




}