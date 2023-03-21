import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class LinkParserApplication {
    private static final Pattern GITHUB_PATTERN = Pattern.compile("https://github.com/([\\w-]+)/([\\w-]+).*");
    private static final Pattern STACKOVERFLOW_PATTERN = Pattern.compile("https://stackoverflow.com/questions/(\\d+).*");

    public void parseLink(String url) {
        String result = null;
        Matcher githubMatcher = GITHUB_PATTERN.matcher(url);
        if (githubMatcher.matches()) {
            String user = githubMatcher.group(1);
            String repository = githubMatcher.group(2);
            result = user + "/" + repository;
        } else {
            Matcher stackOverflowMatcher = STACKOVERFLOW_PATTERN.matcher(url);
            if (stackOverflowMatcher.matches()) {
                String id = stackOverflowMatcher.group(1);
                result = id;
            }
        }

        if (result != null) {
            return result;
        }
        return null;
    }
}
