package pl.coderslab;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

public class AuthorConverter implements Converter<String, Author> {
private AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        return authorDao.findById(Long.parseLong(source));
    }
}
