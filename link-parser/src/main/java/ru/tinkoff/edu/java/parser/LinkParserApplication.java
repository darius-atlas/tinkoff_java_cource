package ru.tinkoff.edu.java.parser;

import ru.tinkoff.edu.java.parser.parsers.LinkParser;
import ru.tinkoff.edu.java.parser.responses.Response;

public class LinkParserApplication {

    public Response parseLink(String link) {
        Class<? extends LinkParser>[] parserClasses = (Class<? extends LinkParser>[]) LinkParser.class.getPermittedSubclasses();

        if (parserClasses == null) {
            return null;
        }

        Response response = null;

        for (Class<? extends LinkParser> parserClass : parserClasses) {
            try {
                response = parserClass.getDeclaredConstructor().newInstance().parseLink(link);

                if (response != null) {
                    break;
                }
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }

        return response;
    }
}
